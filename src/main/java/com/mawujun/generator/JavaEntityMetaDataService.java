package com.mawujun.generator;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

import com.mawujun.generator.model.PropertyColumn;
import com.mawujun.generator.model.SubjectRoot;
import com.mawujun.generator.other.DefaultNameStrategy;
import com.mawujun.generator.other.NameStrategy;
import com.mawujun.utils.ReflectUtils;
import com.mawujun.utils.properties.PropertiesUtils;
import com.mawujun.utils.string.StringUtils;

/**
 * 用于从领域模型中读取 meta信息的
 * 
 * @author mawujun qq:16064988 e-mail:16064988@qq.com
 */
public class JavaEntityMetaDataService {

	NameStrategy nameStrategy=new DefaultNameStrategy();
	
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
		try {
			return initClassProperty(clazz);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public SubjectRoot initClassProperty(Class clazz) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(cache.containsKey(clazz.getName())){
			return cache.get(clazz.getName());
		}
		SubjectRoot root=new SubjectRoot();
		//ll
		Table tableAnnotation=(Table)clazz.getAnnotation(Table.class);
		if(tableAnnotation!=null){
			if(StringUtils.hasText(tableAnnotation.name())) {
				root.setTableName(tableAnnotation.name());
			} else {
				//throw new RuntimeException("@Table注解的表名需要设置");
				root.setTableName(nameStrategy.classToTableName(clazz.getSimpleName()));
			}
			
		} else {
			throw new RuntimeException("没有在实体类上添加@Table注解");
		}
		Entity entityAnnotation=(Entity)clazz.getAnnotation(Entity.class);
		if(entityAnnotation!=null){
			//root.setTableName(entityAnnotation.name());
		} else {
			throw new RuntimeException("没有在实体类上添加@Entity注解");
		}
		Alias aliasAnnotation=(Alias)clazz.getAnnotation(Alias.class);
		if(aliasAnnotation!=null){
			root.setAlias(aliasAnnotation.value());
		} else {
			throw new RuntimeException("@Alias注解需要设置，因为现在使用mybatis");
			//root.setAlias(nameStrategy.classToAlias(clazz.getSimpleName()));
		}
		
		//root.setTableName(nameStrategy.classToTableName(clazz.getSimpleName().toLowerCase()));

		root.setSimpleClassName(clazz.getSimpleName());
		root.setClassName(clazz.getName());
		root.setBasepackage(clazz.getPackage().getName());
		//root.setIdType("String");//默认是String
		//root.setIdType(idClass.getSimpleName());
		
		
		Field[] fields=ReflectUtils.getAllDeclaredFields(clazz);
		//List<PropertyColumn> propertyColumns =new ArrayList<PropertyColumn>();
		//存放需要产生查询条件的属性
		//List<PropertyColumn> queryProperties =new ArrayList<PropertyColumn>();
		for(Field field:fields){
			boolean isStatic = Modifier.isStatic(field.getModifiers());
			if(isStatic) {
				continue;
			}
			PropertyColumn propertyColumn=new PropertyColumn();
			propertyColumn.setProperty(field.getName());
			propertyColumn.setLabel(field.getName());
//			FieldDefine fieldDefine=field.getAnnotation(FieldDefine.class);
//			if(fieldDefine!=null){
//				if(fieldDefine.title()==null || "".equals(fieldDefine.title())){
//					propertyColumn.setLabel(field.getName());
//				} else {
//					propertyColumn.setLabel(fieldDefine.title());
//				}
//				propertyColumn.setHidden(fieldDefine.hidden());
//				propertyColumn.setSort(fieldDefine.sort());
//				propertyColumn.setShowType(fieldDefine.showType().toString());
//				if(fieldDefine.showType()!=ShowType.none){
//					//如果是枚举类型，就反射获取枚举值，作为数据的内容，如果不是枚举类型，就弄成一个从后台获取内容的combobox
//					if(field.getType().isEnum()){
//						propertyColumn.setIsEnum(true);
//						//field.get
//						Class clz =field.getType();
//						Method toName = clz.getMethod("getName");
//						//Map<String,String> showTypeValues=new HashMap<String,String>();
//						for (Object obj : clz.getEnumConstants()) {
//							propertyColumn.addShowType_value(obj.toString(), toName.invoke(obj).toString());
//							//System.out.println(obj);
//							//System.out.println(toName.invoke(obj));
//						}
//					}
//				}
//				propertyColumn.setGenQuery(fieldDefine.genQuery());
//			}
			//不准为空的判断
			Column column=field.getAnnotation(Column.class);
			if(column!=null){
				propertyColumn.setNullable(column.nullable());
				propertyColumn.setUnique(column.unique());
				propertyColumn.setInsertable(column.insertable());
				propertyColumn.setUpdatable(column.updatable());
				if(StringUtils.hasText(column.name())) {
					propertyColumn.setColumn(column.name());
				} else {
					propertyColumn.setColumn(nameStrategy.propertyToColumnName(propertyColumn.getProperty()));
				}
				propertyColumn.setLength(column.length());
				propertyColumn.setScale(column.scale());
				propertyColumn.setPrecision(column.precision());
				
			} else {
				propertyColumn.setColumn(nameStrategy.propertyToColumnName(propertyColumn.getProperty()));
			}
			propertyColumn.setClazz(field.getType());
			
			Id id=field.getAnnotation(Id.class);
			if(id!=null){
				propertyColumn.setNullable(false);
				propertyColumn.setUnique(true);
				propertyColumn.setInsertable(true);
				propertyColumn.setUpdatable(false);
				
				propertyColumn.setId(true);
				//复核主键怎么办？还要测试下
				root.setIdColumn(propertyColumn.getColumn());
				root.setIdProperty(propertyColumn.getProperty());
				root.setIdClass(field.getType());
				//
				GeneratedValue generatedValue=field.getAnnotation(GeneratedValue.class);
				if(generatedValue!=null) {
					GenerationType strategy=generatedValue.strategy();
					if(strategy==GenerationType.SEQUENCE) {
						propertyColumn.setIdGenEnum(IDGenEnum.sequence);
						root.setIdGenEnum(propertyColumn.getIdGenEnum());
						SequenceGenerator sequenceGenerator=field.getAnnotation(SequenceGenerator.class);
						root.setIdSequenceName(sequenceGenerator.sequenceName());
					} else if(strategy==GenerationType.IDENTITY) {
						propertyColumn.setIdGenEnum(IDGenEnum.identity);
						root.setIdGenEnum(propertyColumn.getIdGenEnum());
					} else if(strategy==GenerationType.TABLE) {
						propertyColumn.setIdGenEnum(IDGenEnum.table);
						root.setIdGenEnum(propertyColumn.getIdGenEnum());
					} else {
						propertyColumn.setIdGenEnum(IDGenEnum.uuid);
						root.setIdGenEnum(propertyColumn.getIdGenEnum());
					}
				} else {
					if(field.getType()==String.class) {
						propertyColumn.setIdGenEnum(IDGenEnum.assigned_str);
						root.setIdGenEnum(propertyColumn.getIdGenEnum());
					} else {
						propertyColumn.setIdGenEnum(IDGenEnum.assigned_long);
						root.setIdGenEnum(propertyColumn.getIdGenEnum());
					} 
					
				}
				
			} else {
				propertyColumn.setIdGenEnum(IDGenEnum.none);
			}
			
			NotNull notNull=field.getAnnotation(NotNull.class);
			if(notNull!=null){
				propertyColumn.setNullable(false);
			}
			NotEmpty notEmpty=field.getAnnotation(NotEmpty.class);
			if(notEmpty!=null){
				propertyColumn.setNullable(false);
			}
			Size size=field.getAnnotation(Size.class);
			if(size!=null){
				if(size.max()!=Integer.MAX_VALUE) {
					propertyColumn.setLength(size.max());
				}
				
			}
			
			//
			//if(field.isEnumConstant()) {
			if(field.getType().isEnum()) {
				propertyColumn.setIsEnum(true);
			}
			
			
			//propertyColumns.add(propertyColumn);
			root.addPropertyColumn(propertyColumn);
			
//			//默认是使用id作为名称
//			if(id_name.equals(propertyColumn.getProperty())){
//				root.setIdType(field.getType().getSimpleName());
//			}
			
//			if(propertyColumn.getGenQuery()){
//				queryProperties.add(propertyColumn);
//			}
		}

		//对属性显示的时候进行排序
		//propertyColumns.sort(new PropertyColumnComparator());
		
		
		//root.setPropertyColumns(propertyColumns);
		//root.setQueryProperties(queryProperties);
		cache.put(clazz.getName(), root);
		return root;
	}
	

}
