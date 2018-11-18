package com.mawujun.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class SubjectRoot {
	//private String dbName;
	private String tableName;//表名
	private String simpleClassName;//类名，不带包名的
	private String uncapitalizeSimpleClassName;
	private String className;
	
	private String alias;//别名，主要用于mybatis。如果指定胃，就使用指定胡，否则就使用类名，并且全部小写
	
	private String basepackage;//包名
	private String idType;
	//private String idColumnName;
	//private String idPropertyName;
	//private String idGeneratorStrategy="";
	//private String sequenceName;
	//private boolean hasResultMap;//是组件关联的时候
	
	//private String jsPackage;//用于用表生成的时候指定的
	//private Map<Object,Object> extenConfig=new HashMap<Object,Object>();
	//private Object extenConfig=new Object();
	
	//private ExtenConfig extenConfig=new ExtenConfig();

	List<PropertyColumn> propertyColumns=new ArrayList<PropertyColumn>();
	Map<String,PropertyColumn> propertyColumns_map=new HashMap<String,PropertyColumn>();
	//List<PropertyColumn> baseTypePropertyColumns=new ArrayList<PropertyColumn>();
	//存放需要产生查询条件的属性
	List<PropertyColumn> queryProperties =new ArrayList<PropertyColumn>();
	
	public void setSimpleClassName(String simpleClassName) {
		this.simpleClassName = simpleClassName;
		this.uncapitalizeSimpleClassName=StringUtils.uncapitalize(this.getSimpleClassName());;
	}
	
	public PropertyColumn getPropertyColumn(String property) {
		return this.propertyColumns_map.get(property);
	}
	
	public void addPropertyColumn(PropertyColumn pc) {
		this.propertyColumns.add(pc);
		this.propertyColumns_map.put(pc.getProperty(), pc);
	}
	
	public String getUncapitalizeSimpleClassName() {
		return this.uncapitalizeSimpleClassName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSimpleClassName() {
		return simpleClassName;
	}

	public String getBasepackage() {
		return basepackage;
	}

	public void setBasepackage(String basepackage) {
		this.basepackage = basepackage;
	}

	public List<PropertyColumn> getPropertyColumns() {
		return propertyColumns;
	}

	public void setPropertyColumns(List<PropertyColumn> propertyColumns) {
		this.propertyColumns = propertyColumns;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public List<PropertyColumn> getQueryProperties() {
		return queryProperties;
	}

	public void setQueryProperties(List<PropertyColumn> queryProperties) {
		this.queryProperties = queryProperties;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}





}
