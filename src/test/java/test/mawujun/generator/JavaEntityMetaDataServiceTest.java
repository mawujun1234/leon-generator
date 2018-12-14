package test.mawujun.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mawujun.generator.IDGenEnum;
import com.mawujun.generator.JavaEntityMetaDataService;
import com.mawujun.generator.PropertyColumn;
import com.mawujun.generator.SubjectRoot;

import test.mawujun.generator.model.City;
import test.mawujun.generator.model.City2;
import test.mawujun.generator.model.CoplxId1;
import test.mawujun.generator.model.CoplxId1Entity;
import test.mawujun.generator.model.CoplxId2;
import test.mawujun.generator.model.CoplxId2Entity;



public class JavaEntityMetaDataServiceTest {
	JavaEntityMetaDataService javaEntityMetaDataService=new JavaEntityMetaDataService();
	//id属性的情况没有搜集
	//枚举类型没有判断
	@Test
	public void test1 (){
		//System.out.println(Sex.class.isEnum());
		SubjectRoot root=javaEntityMetaDataService.getClassProperty(City.class);
		Assert.assertEquals("t_city", root.getTableName());
		Assert.assertEquals("City", root.getSimpleClassName());
		Assert.assertEquals("city", root.getUncapitalizeSimpleClassName());
		Assert.assertEquals("test.mawujun.generator.model.City", root.getClassName());
		Assert.assertEquals("city", root.getAlias());
		Assert.assertEquals("test.mawujun.generator", root.getBasepackage());
		//Assert.assertEquals("", root.getIdType());
		
		
		//测试属性，列名注解
		List<PropertyColumn> lpc=root.getPropertyColumns();
		Assert.assertEquals(6, lpc.size());
		PropertyColumn id=root.getPropertyColumn("id");
		assertNotNull(id);
		assertEquals("id", id.getProperty());
		assertEquals("id", id.getColumn());
		assertEquals("id", id.getLabel());
		assertEquals(null, id.getComment());
		assertEquals(null, id.getDefaultValue());
		assertEquals(36, id.getLength());
		assertEquals(0, id.getPrecision());
		assertEquals(0, id.getScale());
		assertEquals(true, id.isUnique());
		assertEquals(false, id.isNullable());
		assertEquals(true, id.isInsertable());
		assertEquals(false, id.isUpdatable());
		assertEquals(false, id.getIsEnum());
		assertEquals("java.lang", id.getBasepackage());
		assertEquals("java.lang.String", id.getClassName());
		assertEquals("String", id.getSimpleClassName());
		assertEquals(true,id.getIsId());
		assertEquals(IDGenEnum.uuid,id.getIdGenEnum());
		
		assertEquals(String.class,root.getIdClass());
		assertEquals("id", root.getIdPropertys()[0]);
		assertEquals("id", root.getIdColumns()[0]);
		assertEquals(null, root.getIdSequenceName());

		
		PropertyColumn name=root.getPropertyColumn("name");
		assertNotNull(name);
		assertEquals("name", name.getProperty());
		assertEquals("name", name.getColumn());
		assertEquals("名称", name.getLabel());
		assertEquals("名称注释", name.getComment());
		assertEquals(null, name.getDefaultValue());
		assertEquals(30, name.getLength());
		assertEquals(0, name.getPrecision());
		assertEquals(0, name.getScale());
		assertEquals(false, name.isUnique());
		assertEquals(true, name.isNullable());
		assertEquals(true, name.isInsertable());
		assertEquals(true, name.isUpdatable());
		assertEquals(false, name.getIsEnum());
		assertEquals("java.lang", name.getBasepackage());
		assertEquals("java.lang.String", name.getClassName());
		assertEquals("String", name.getSimpleClassName());
		assertEquals(false,name.getIsId());
		assertEquals(IDGenEnum.none,name.getIdGenEnum());
		
		
		PropertyColumn age=root.getPropertyColumn("age");
		assertNotNull(age);
		assertEquals("age", age.getProperty());
		assertEquals("age", age.getColumn());
		assertEquals("年龄", age.getLabel());
		assertEquals("年龄", age.getComment());
		assertEquals("1", age.getDefaultValue());
		assertEquals(255, age.getLength());
		assertEquals(0, age.getPrecision());
		assertEquals(0, age.getScale());
		assertEquals(false, age.isUnique());
		assertEquals(true, age.isNullable());
		assertEquals(true, age.isInsertable());
		assertEquals(true, age.isUpdatable());
		assertEquals(false, age.getIsEnum());
		assertEquals("java.lang", age.getBasepackage());
		assertEquals("java.lang.Integer", age.getClassName());
		assertEquals("Integer", age.getSimpleClassName());
		assertEquals(false,age.getIsId());
		assertEquals(IDGenEnum.none,age.getIdGenEnum());
		


		PropertyColumn price=root.getPropertyColumn("price");
		assertNotNull(price);
		assertEquals("price", price.getProperty());
		assertEquals("price", price.getColumn());
		assertEquals("price", price.getLabel());
		assertEquals(null, price.getComment());
		assertEquals("1.1", price.getDefaultValue());
		assertEquals(255, price.getLength());
		assertEquals(10, price.getPrecision());
		assertEquals(2, price.getScale());
		assertEquals(false, price.isUnique());
		assertEquals(true, price.isNullable());
		assertEquals(true, price.isInsertable());
		assertEquals(true, price.isUpdatable());
		assertEquals(false, price.getIsEnum());
		assertEquals("java.lang", price.getBasepackage());
		assertEquals("java.lang.Double", price.getClassName());
		assertEquals("Double", price.getSimpleClassName());
		assertEquals(false,price.getIsId());
		assertEquals(IDGenEnum.none,price.getIdGenEnum());
		
		
		PropertyColumn createDate=root.getPropertyColumn("createDate");
		assertNotNull(createDate);
		assertEquals("createDate", createDate.getProperty());
		assertEquals("create_date", createDate.getColumn());
		assertEquals("createDate", createDate.getLabel());
		assertEquals(null, createDate.getComment());
		assertEquals(null, createDate.getDefaultValue());
		assertEquals(255, createDate.getLength());
		assertEquals(0, createDate.getPrecision());
		assertEquals(0, createDate.getScale());
		assertEquals(false, createDate.isUnique());
		assertEquals(true, createDate.isNullable());
		assertEquals(true, createDate.isInsertable());
		assertEquals(true, createDate.isUpdatable());
		assertEquals(false, createDate.getIsEnum());
		assertEquals("java.util", createDate.getBasepackage());
		assertEquals("java.util.Date", createDate.getClassName());
		assertEquals("Date", createDate.getSimpleClassName());
		assertEquals(false,createDate.getIsId());
		assertEquals(IDGenEnum.none,createDate.getIdGenEnum());
		
		PropertyColumn sex=root.getPropertyColumn("sex");
		assertNotNull(sex);
		assertEquals("sex", sex.getProperty());
		assertEquals("sex", sex.getColumn());
		assertEquals("sex", sex.getLabel());
		assertEquals(null, sex.getComment());
		assertEquals(null, sex.getDefaultValue());
		assertEquals(10, sex.getLength());
		assertEquals(0, sex.getPrecision());
		assertEquals(0, sex.getScale());
		assertEquals(false, sex.isUnique());
		assertEquals(true, sex.isNullable());
		assertEquals(true, sex.isInsertable());
		assertEquals(true, sex.isUpdatable());
		assertEquals(true, sex.getIsEnum());
		assertEquals("test.mawujun.generator.model", sex.getBasepackage());
		assertEquals("test.mawujun.generator.model.Sex", sex.getClassName());
		assertEquals("Sex", sex.getSimpleClassName());
		assertEquals(false,sex.getIsId());
		assertEquals(IDGenEnum.none,sex.getIdGenEnum());
		
		
	}
	
	@Test
	public void test2 (){
		SubjectRoot root=javaEntityMetaDataService.getClassProperty(City2.class);
		Assert.assertEquals("t_city2", root.getTableName());
		Assert.assertEquals("City2", root.getSimpleClassName());
		Assert.assertEquals("city2", root.getUncapitalizeSimpleClassName());
		Assert.assertEquals("test.mawujun.generator.model.City2", root.getClassName());
		Assert.assertEquals("city2", root.getAlias());
		Assert.assertEquals("test.mawujun.generator", root.getBasepackage());
		//Assert.assertEquals("", root.getIdType());
		
		
		//测试属性，列名注解
		List<PropertyColumn> lpc=root.getPropertyColumns();
		Assert.assertEquals(6, lpc.size());
		PropertyColumn id=root.getPropertyColumn("id");
		assertNotNull(id);
		assertEquals("id", id.getProperty());
		assertEquals("id", id.getColumn());
		assertEquals("id", id.getLabel());
		assertEquals(null, id.getComment());
		assertEquals(null, id.getDefaultValue());
		assertEquals(36, id.getLength());
		assertEquals(0, id.getPrecision());
		assertEquals(0, id.getScale());
		assertEquals(true, id.isUnique());
		assertEquals(false, id.isNullable());
		assertEquals(true, id.isInsertable());
		assertEquals(false, id.isUpdatable());
		assertEquals(false, id.getIsEnum());
		assertEquals("java.lang", id.getBasepackage());
		assertEquals("java.lang.String", id.getClassName());
		assertEquals("String", id.getSimpleClassName());
		assertEquals(true,id.getIsId());
		assertEquals(IDGenEnum.uuid,id.getIdGenEnum());
		
		assertEquals(String.class,root.getIdClass());
		assertEquals("id", root.getIdPropertys()[0]);
		assertEquals("id", root.getIdColumns()[0]);
		assertEquals(null, root.getIdSequenceName());

		
		PropertyColumn name=root.getPropertyColumn("name");
		assertNotNull(name);
		assertEquals("name", name.getProperty());
		assertEquals("name", name.getColumn());
		assertEquals("name", name.getLabel());
		assertEquals(null, name.getComment());
		assertEquals(null, name.getDefaultValue());
		assertEquals(255, name.getLength());
		assertEquals(0, name.getPrecision());
		assertEquals(0, name.getScale());
		assertEquals(false, name.isUnique());
		assertEquals(true, name.isNullable());
		assertEquals(true, name.isInsertable());
		assertEquals(true, name.isUpdatable());
		assertEquals(false, name.getIsEnum());
		assertEquals("java.lang", name.getBasepackage());
		assertEquals("java.lang.String", name.getClassName());
		assertEquals("String", name.getSimpleClassName());
		assertEquals(false,name.getIsId());
		assertEquals(IDGenEnum.none,name.getIdGenEnum());
		


		PropertyColumn price=root.getPropertyColumn("price");
		assertNotNull(price);
		assertEquals("price", price.getProperty());
		assertEquals("price", price.getColumn());
		assertEquals("price", price.getLabel());
		assertEquals(null, price.getComment());
		assertEquals(null, price.getDefaultValue());
		assertEquals(255, price.getLength());
		assertEquals(10, price.getPrecision());
		assertEquals(2, price.getScale());
		assertEquals(false, price.isUnique());
		assertEquals(true, price.isNullable());
		assertEquals(true, price.isInsertable());
		assertEquals(true, price.isUpdatable());
		assertEquals(false, price.getIsEnum());
		assertEquals("java.lang", price.getBasepackage());
		assertEquals("java.lang.Double", price.getClassName());
		assertEquals("Double", price.getSimpleClassName());
		assertEquals(false,price.getIsId());
		assertEquals(IDGenEnum.none,price.getIdGenEnum());
		
		PropertyColumn createDate=root.getPropertyColumn("createDate");
		assertNotNull(createDate);
		assertEquals("createDate", createDate.getProperty());
		assertEquals("create_date", createDate.getColumn());
		assertEquals("createDate", createDate.getLabel());
		assertEquals(null, createDate.getComment());
		assertEquals(null, createDate.getDefaultValue());
		assertEquals(255, createDate.getLength());
		assertEquals(0, createDate.getPrecision());
		assertEquals(0, createDate.getScale());
		assertEquals(false, createDate.isUnique());
		assertEquals(true, createDate.isNullable());
		assertEquals(true, createDate.isInsertable());
		assertEquals(true, createDate.isUpdatable());
		assertEquals(false, createDate.getIsEnum());
		assertEquals("java.util", createDate.getBasepackage());
		assertEquals("java.util.Date", createDate.getClassName());
		assertEquals("Date", createDate.getSimpleClassName());
		assertEquals(false,createDate.getIsId());
		assertEquals(IDGenEnum.none,createDate.getIdGenEnum());
		
		PropertyColumn sex=root.getPropertyColumn("sex");
		assertNotNull(sex);
		assertEquals("sex", sex.getProperty());
		assertEquals("sex", sex.getColumn());
		assertEquals("sex", sex.getLabel());
		assertEquals(null, sex.getComment());
		assertEquals(null, sex.getDefaultValue());
		assertEquals(10, sex.getLength());
		assertEquals(0, sex.getPrecision());
		assertEquals(0, sex.getScale());
		assertEquals(false, sex.isUnique());
		assertEquals(true, sex.isNullable());
		assertEquals(true, sex.isInsertable());
		assertEquals(true, sex.isUpdatable());
		assertEquals(true, sex.getIsEnum());
		assertEquals("test.mawujun.generator.model", sex.getBasepackage());
		assertEquals("test.mawujun.generator.model.Sex", sex.getClassName());
		assertEquals("Sex", sex.getSimpleClassName());
		assertEquals(false,sex.getIsId());
		assertEquals(IDGenEnum.none,sex.getIdGenEnum());
	}
	/**
	 * 测试复核主键
	 */
	@Test
	public void test3 (){
		//System.out.println(Sex.class.isEnum());
		SubjectRoot root=javaEntityMetaDataService.getClassProperty(CoplxId1Entity.class);
		Assert.assertEquals("t_coplxid1entity", root.getTableName());
		Assert.assertEquals("CoplxId1Entity", root.getSimpleClassName());
		Assert.assertEquals("coplxId1Entity", root.getUncapitalizeSimpleClassName());
		Assert.assertEquals("test.mawujun.generator.model.CoplxId1Entity", root.getClassName());
		Assert.assertEquals("coplxId1Entity", root.getAlias());
		Assert.assertEquals("test.mawujun.generator", root.getBasepackage());
		
		PropertyColumn name=root.getPropertyColumn("name");
		assertNotNull(name);
		assertEquals("name", name.getProperty());
		assertEquals("name", name.getColumn());
		assertEquals("name", name.getLabel());
		assertEquals(null, name.getComment());
		assertEquals(null, name.getDefaultValue());
		assertEquals(255, name.getLength());
		assertEquals(0, name.getPrecision());
		assertEquals(0, name.getScale());
		assertEquals(false, name.isUnique());
		assertEquals(true, name.isNullable());
		assertEquals(true, name.isInsertable());
		assertEquals(true, name.isUpdatable());
		assertEquals(false, name.getIsEnum());
		assertEquals("java.lang", name.getBasepackage());
		assertEquals("java.lang.String", name.getClassName());
		assertEquals("String", name.getSimpleClassName());
		assertEquals(false,name.getIsId());
		assertEquals(IDGenEnum.none,name.getIdGenEnum());
		
		PropertyColumn id=root.getPropertyColumn("id");
		assertNotNull(id);
		assertEquals(true, id.isCompositeId());
		assertEquals(true, id.getIsId());
		assertEquals("id", id.getProperty());
		assertEquals("id", id.getColumn());
		assertEquals("test.mawujun.generator.model.CoplxId1", id.getClassName());
		assertEquals(CoplxId1.class, id.getClazz());
		
		//从root中获取复合主键信息
		assertEquals(CoplxId1.class,root.getIdClass());
		assertEquals(2,root.getIdPropertys().length);
		assertEquals(2,root.getIdColumns().length);
		assertEquals(true, root.getIsCompositeId());
		assertEquals("id1", root.getIdPropertys()[0]);
		assertEquals("id2", root.getIdPropertys()[1]);
		assertEquals("id1", root.getIdColumns()[0]);
		assertEquals("id2", root.getIdColumns()[1]);
		assertEquals(IDGenEnum.none, root.getIdGenEnum());
		assertEquals(null, root.getIdSequenceName());
		
	}
	
	
	@Test
	public void test4 (){
		//System.out.println(Sex.class.isEnum());
		SubjectRoot root=javaEntityMetaDataService.getClassProperty(CoplxId2Entity.class);
		Assert.assertEquals("t_coplxid2entity", root.getTableName());
		Assert.assertEquals("CoplxId2Entity", root.getSimpleClassName());
		Assert.assertEquals("coplxId2Entity", root.getUncapitalizeSimpleClassName());
		Assert.assertEquals("test.mawujun.generator.model.CoplxId2Entity", root.getClassName());
		Assert.assertEquals("coplxId2Entity", root.getAlias());
		Assert.assertEquals("test.mawujun.generator", root.getBasepackage());
		
		PropertyColumn name=root.getPropertyColumn("name");
		assertNotNull(name);
		assertEquals("name", name.getProperty());
		assertEquals("name", name.getColumn());
		assertEquals("name", name.getLabel());
		assertEquals(null, name.getComment());
		assertEquals(null, name.getDefaultValue());
		assertEquals(255, name.getLength());
		assertEquals(0, name.getPrecision());
		assertEquals(0, name.getScale());
		assertEquals(false, name.isUnique());
		assertEquals(true, name.isNullable());
		assertEquals(true, name.isInsertable());
		assertEquals(true, name.isUpdatable());
		assertEquals(false, name.getIsEnum());
		assertEquals("java.lang", name.getBasepackage());
		assertEquals("java.lang.String", name.getClassName());
		assertEquals("String", name.getSimpleClassName());
		assertEquals(false,name.getIsId());
		assertEquals(IDGenEnum.none,name.getIdGenEnum());
		
		PropertyColumn id1=root.getPropertyColumn("id1");
		assertNotNull(id1);
		assertEquals(true, id1.isCompositeId());
		assertEquals(true, id1.getIsId());
		assertEquals("id1", id1.getProperty());
		assertEquals("id1", id1.getColumn());
		assertEquals("java.lang.String", id1.getClassName());
		assertEquals(String.class, id1.getClazz());
		
		PropertyColumn id2=root.getPropertyColumn("id2");
		assertNotNull(id2);
		assertEquals(true, id2.isCompositeId());
		assertEquals(true, id2.getIsId());
		assertEquals("id2", id2.getProperty());
		assertEquals("id2", id2.getColumn());
		assertEquals("java.lang.String", id2.getClassName());
		assertEquals(String.class, id2.getClazz());
		
		//从root中获取复合主键信息
		assertEquals(CoplxId2.class,root.getIdClass());
		assertEquals(2,root.getIdPropertys().length);
		assertEquals(2,root.getIdColumns().length);
		assertEquals(true, root.getIsCompositeId());
		assertEquals("id1", root.getIdPropertys()[0]);
		assertEquals("id2", root.getIdPropertys()[1]);
		assertEquals("id1", root.getIdColumns()[0]);
		assertEquals("id2", root.getIdColumns()[1]);
		assertEquals(IDGenEnum.none, root.getIdGenEnum());
		assertEquals(null, root.getIdSequenceName());
		
	}

}
