package com.mawujun.generator.model;

import java.util.ArrayList;
import java.util.List;

public class SubjectRoot {
	//private String dbName;
	private String tableName;//表名
	private String simpleClassName;//类名，不带报名的
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

	List<PropertyColumn> propertyColumns=new ArrayList<PropertyColumn>();
	//List<PropertyColumn> baseTypePropertyColumns=new ArrayList<PropertyColumn>();

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSimpleClassName() {
		return simpleClassName;
	}

	public void setSimpleClassName(String simpleClassName) {
		this.simpleClassName = simpleClassName;
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

}
