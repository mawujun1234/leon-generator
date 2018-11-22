package test.mawujun.generator.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mawujun.generator.model.ColDefinition;
import com.mawujun.repository.identity.UUIDEntityValidate;

/**
 * 1：时间映射,@Temporal注解
 *  CreationTimestamp创建时的默认值，UpdateTimestamp在更新的时候会生成默认值
 * 2：枚举映射,@Enumerated
 * 3：生成默认值的注解：
 * 
	@org.hibernate.annotations.ColumnDefault("1.00")
	@org.hibernate.annotations.Generated(
	org.hibernate.annotations.GenerationTime.INSERT
	)
 * 4：二进制和大型值类型映射，使用@Lob注解，可注解的类型包括
 *  byte[],Byte[]--VARBINARY;String--CLOB,java.sql.Clob--CLOB,java.sql.Blob--BLOB,java.io.Serializable--VARBINARY
 *  
 * @author Administrator
 *
 */
@Alias("city")//用于mybatis
@Entity
@Table(name="t_city")
public class City extends UUIDEntityValidate{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3172844311839975513L;
	@Column(length=30)
	@ColDefinition(comment="名称注释",label="名称")
	private String name;
	
	@ColDefinition(label="年龄",defaultValue="1")
	private Integer age;
	
	@Column(precision = 10,scale = 2)
	@ColDefinition(defaultValue="1.1")
	private Double price;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	//@CreationTimestamp
	//@UpdateTimestamp
	private Date createDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Sex sex=Sex.Man;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}

}


