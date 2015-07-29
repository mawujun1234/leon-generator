package com.mawujun.generator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mawujun.generator.model.PropertyColumn;
import com.mawujun.generator.model.SubjectRoot;
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
	
	private static Map<String,SubjectRoot> cache=new HashMap<String,SubjectRoot>();
	public SubjectRoot getClassProperty(Class clazz){
		if(cache.containsKey(clazz.getName())){
			return cache.get(clazz.getName());
		}
		return null;
	}
	public SubjectRoot initClassProperty(Class clazz,Class idClass){
		if(cache.containsKey(clazz.getName())){
			return cache.get(clazz.getName());
		}
		SubjectRoot root=new SubjectRoot();
		root.setTableName(namingStrategy.classToTableName(clazz.getSimpleName().toLowerCase()));
		root.setSimpleClassName(clazz.getSimpleName());
		root.setBasepackage(clazz.getPackage().getName());
		root.setIdType(idClass.getSimpleName());
		
		
		Field[] fields=ReflectUtils.getAllDeclaredFields(clazz);
		List<PropertyColumn> propertyColumns =new ArrayList<PropertyColumn>();
		for(Field field:fields){
			PropertyColumn propertyColumn=new PropertyColumn();
			propertyColumn.setProperty(field.getName());
			propertyColumn.setColumn(namingStrategy.propertyToColumnName(propertyColumn.getColumn()));
			propertyColumn.setJavaType(field.getClass());
			propertyColumns.add(propertyColumn);
		}
		cache.put(clazz.getName(), root);
		return root;
	}
}
