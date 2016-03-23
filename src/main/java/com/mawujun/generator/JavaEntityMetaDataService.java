package com.mawujun.generator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mawujun.generator.model.FieldDefine;
import com.mawujun.generator.model.PropertyColumn;
import com.mawujun.generator.model.PropertyColumnComparator;
import com.mawujun.generator.model.SubjectRoot;
import com.mawujun.generator.other.NameStrategy;
import com.mawujun.utils.ReflectUtils;
import com.mawujun.utils.properties.PropertiesUtils;

/**
 * 用于从领域模型中读取 meta信息的
 * 
 * @author mawujun qq:16064988 e-mail:16064988@qq.com
 */
public class JavaEntityMetaDataService {

	NameStrategy nameStrategy;
	
	String id_name="id";//默认的id名称
	
	private static Map<String,SubjectRoot> cache=new HashMap<String,SubjectRoot>();
	
	public JavaEntityMetaDataService() {
		
		try {
			PropertiesUtils aa = PropertiesUtils.load("generator.properties");
			String className=aa.getProperty("nameStrategy");
			Class clazz=Class.forName(className);
			nameStrategy=(NameStrategy) clazz.newInstance();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	public SubjectRoot getClassProperty(Class clazz){
		if(cache.containsKey(clazz.getName())){
			return cache.get(clazz.getName());
		}
		return null;
	}
	public SubjectRoot initClassProperty(Class clazz){
		if(cache.containsKey(clazz.getName())){
			return cache.get(clazz.getName());
		}
		SubjectRoot root=new SubjectRoot();
		//ll
		Table tableAnnotation=(Table)clazz.getAnnotation(Table.class);
		if(tableAnnotation!=null){
			root.setTableName(tableAnnotation.name());
		} else {
			Entity entityAnnotation=(Entity)clazz.getAnnotation(Entity.class);
			if(entityAnnotation!=null){
				root.setTableName(entityAnnotation.name());
			} else {
				throw new RuntimeException("没有在实体类上添加@Entity注解");
			}
		}
		//root.setTableName(nameStrategy.classToTableName(clazz.getSimpleName().toLowerCase()));

		
		
		root.setSimpleClassName(clazz.getSimpleName());
		root.setClassName(clazz.getName());
		root.setBasepackage(clazz.getPackage().getName());
		root.setIdType("String");//默认是String
		//root.setIdType(idClass.getSimpleName());
		
		
		Field[] fields=ReflectUtils.getAllDeclaredFields(clazz);
		List<PropertyColumn> propertyColumns =new ArrayList<PropertyColumn>();
		for(Field field:fields){
			PropertyColumn propertyColumn=new PropertyColumn();
			propertyColumn.setProperty(field.getName());
			FieldDefine fieldDefine=field.getAnnotation(FieldDefine.class);
			if(fieldDefine!=null){
				if(fieldDefine.title()==null || "".equals(fieldDefine.title())){
					propertyColumn.setProperty_label(field.getName());
				} else {
					propertyColumn.setProperty_label(fieldDefine.title());
				}
				propertyColumn.setHidden(fieldDefine.hidden());
			}
			//不准为空的判断
			Column column=field.getAnnotation(Column.class);
			if(column!=null){
				propertyColumn.setNullable(column.nullable());
			}
			NotNull notNull=field.getAnnotation(NotNull.class);
			if(notNull!=null){
				propertyColumn.setNullable(false);
			}
			
			propertyColumn.setColumn(nameStrategy.propertyToColumnName(propertyColumn.getColumn()));
			propertyColumn.setJavaType(field.getClass());
			propertyColumns.add(propertyColumn);
			
			//默认是使用id作为名称
			if(id_name.equals(propertyColumn.getProperty())){
				root.setIdType(field.getType().getSimpleName());
			}
		}

		
		propertyColumns.sort(new PropertyColumnComparator());
		root.setPropertyColumns(propertyColumns);
		cache.put(clazz.getName(), root);
		return root;
	}
	

}
