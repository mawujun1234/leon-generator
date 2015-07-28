package com.mawujun.generator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.mawujun.generator.other.DefaultNamingStrategy;
import com.mawujun.generator.other.NamingStrategy;
import com.mawujun.utils.ReflectUtils;

/**
 * 用于从领域模型中读取 meta信息的
 * 
 * @author mawujun qq:16064988 e-mail:16064988@qq.com
 */
public class JavaEntityMetaDataService {

	NamingStrategy namingStrategy=new DefaultNamingStrategy();
	
	public SubjectRoot initPropertyColumn(Class clazz){
		SubjectRoot root=new SubjectRoot();
		root.setTableName(namingStrategy.classToTableName(clazz.getSimpleName().toLowerCase()));
		root.setSimpleClassName(clazz.getSimpleName());
		root.setBasepackage(clazz.getPackage().getName());
		
		
		Field[] fields=ReflectUtils.getAllDeclaredFields(clazz);
		List<PropertyColumn> propertyColumns =new ArrayList<PropertyColumn>();
		for(Field field:fields){
			PropertyColumn propertyColumn=new PropertyColumn();
			propertyColumn.setProperty(field.getName());
			propertyColumn.setColumn(namingStrategy.propertyToColumnName(propertyColumn.getColumn()));
			propertyColumn.setJavaType(field.getClass());
			propertyColumns.add(propertyColumn);
		}
		
		return root;
	}
}
