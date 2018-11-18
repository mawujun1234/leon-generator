package test.mawujun.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mawujun.generator.JavaEntityMetaDataService;
import com.mawujun.generator.model.PropertyColumn;
import com.mawujun.generator.model.SubjectRoot;

import test.mawujun.generator.model.City;



public class JavaEntityMetaDataServiceTest {
	JavaEntityMetaDataService javaEntityMetaDataService=new JavaEntityMetaDataService();
	//id属性的情况没有搜集
	//枚举类型没有判断
	@Test
	public void test1 (){
		SubjectRoot root=javaEntityMetaDataService.getClassProperty(City.class);
		Assert.assertEquals("t_city", root.getTableName());
		Assert.assertEquals("City", root.getSimpleClassName());
		Assert.assertEquals("city", root.getUncapitalizeSimpleClassName());
		Assert.assertEquals("test.mawujun.generator.model.City", root.getClassName());
		Assert.assertEquals("city", root.getAlias());
		Assert.assertEquals("test.mawujun.generator.model", root.getBasepackage());
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
		assertEquals(255, id.getLength());
		assertEquals(0, id.getPrecision());
		assertEquals(0, id.getScale());
		assertEquals(true, id.isUnique());
		assertEquals(false, id.isNullable());
		assertEquals(true, id.isInsertable());
		assertEquals(false, id.isUpdatable());
		
		assertEquals(false, id.getIsEnum());
		
		assertEquals("test.mawujun.generator.model", id.getBasepackage());
		assertEquals("java.lang.String", id.getClassName());
		assertEquals("id", id.getSimpleClassName());
		assertEquals("id", id.getLabel());





	}
	
	@Test
	public void test2 (){
		//创建City2进行测试一些其他注解，非常规或者没写的时候
	}

}
