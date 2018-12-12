package com.mawujun.generator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.mawujun.generator.IDGenEnum;

public class SubjectRoot {
	//private String dbName;
	private String tableName;//表名
	private String simpleClassName;//类名，不带包名的
	private String uncapitalizeSimpleClassName;
	private String className;
	
	private String alias;//别名，主要用于mybatis。如果指定胃，就使用指定胡，否则就使用类名，并且全部小写
	
	private String basepackage;//包名
	//private String idType;
	//private String idColumnName;
	//private String idPropertyName;
	//private String idGeneratorStrategy="";
	//private String sequenceName;
	//private boolean hasResultMap;//是组件关联的时候
	
	private IDGenEnum idGenEnum=IDGenEnum.none;
	private Class<?> idClass;
	private String idClassName;//自动
	private String idSimpleClassName;//自动
	private boolean isCompositeId=false;//判断是否是复合主键
	private String[] idColumns;
	private String[] idPropertys;
	private String idSequenceName;//序列化的时候的名字,如oralce、DB、SAP DB、PostgerSQL、McKoi中的sequence。MySQL这种不支持sequence的数据库则不行（可以使用identity）。

	List<PropertyColumn> propertyColumns=new ArrayList<PropertyColumn>();
	Map<String,PropertyColumn> propertyColumns_map=new HashMap<String,PropertyColumn>();
	//List<PropertyColumn> baseTypePropertyColumns=new ArrayList<PropertyColumn>();
	//存放需要产生查询条件的属性
	List<PropertyColumn> queryProperties =new ArrayList<PropertyColumn>();
	
	public void setSimpleClassName(String simpleClassName) {
		this.simpleClassName = simpleClassName;
		this.uncapitalizeSimpleClassName=StringUtils.uncapitalize(this.getSimpleClassName());;
	}
	
	public void setIdClass(Class<?> idClass) {
		this.idClass = idClass;
		this.idSimpleClassName=idClass.getSimpleName();
		this.idClassName=idClass.getName();
	}

	
	public void addIdColumn(String idColumn) {
		if(this.idColumns==null) {
			this.idColumns=new String[]{idColumn};
			return;
		}
		this.idColumns=ArrayUtils.add(this.idColumns, idColumn);
	}
	public void addIdProperty(String idProperty) {
		if(this.idPropertys==null) {
			this.idPropertys=new String[]{idProperty};
			return;
		}
		this.idPropertys=ArrayUtils.add(this.idPropertys, idProperty);
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

	public boolean getIsCompositeId() {
		return isCompositeId;
	}

	public void setIsCompositeId(boolean isIcompositeId) {
		this.isCompositeId = isIcompositeId;
	}

	public String[] getIdColumns() {
		return idColumns;
	}

	public void setIdColumns(String[] idColumns) {
		this.idColumns = idColumns;
	}

	public String[] getIdPropertys() {
		return idPropertys;
	}

	public void setIdPropertys(String[] idPropertys) {
		this.idPropertys = idPropertys;
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

	public IDGenEnum getIdGenEnum() {
		return idGenEnum;
	}

	public void setIdGenEnum(IDGenEnum idGenEnum) {
		this.idGenEnum = idGenEnum;
	}
	

	public String getIdClassName() {
		return idClassName;
	}

	public String getIdSimpleClassName() {
		return idSimpleClassName;
	}

	public Map<String, PropertyColumn> getPropertyColumns_map() {
		return propertyColumns_map;
	}

	public void setPropertyColumns_map(Map<String, PropertyColumn> propertyColumns_map) {
		this.propertyColumns_map = propertyColumns_map;
	}

	public void setUncapitalizeSimpleClassName(String uncapitalizeSimpleClassName) {
		this.uncapitalizeSimpleClassName = uncapitalizeSimpleClassName;
	}

	public String getIdSequenceName() {
		return idSequenceName;
	}

	public void setIdSequenceName(String idSequenceName) {
		this.idSequenceName = idSequenceName;
	}

	

	public Class<?> getIdClass() {
		return idClass;
	}

	




}
