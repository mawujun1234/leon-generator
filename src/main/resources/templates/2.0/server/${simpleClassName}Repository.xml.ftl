
<#assign simpleClassNameFirstLower = simpleClassName?uncap_first>   
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN"
"http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">

<#macro mapperEl value>${r"#{"}${value}}</#macro>
<#macro printDollar value>${r"${"}${value}}</#macro>
<#macro namespace>${basepackage}</#macro>
<!-- mawujun qq:16064988 e-mail:16064988@qq.com-->
<mapper namespace="<@namespace/>.${simpleClassName}Repository">

    <sql id="BaseColumns">
		id as id,name as name,age as age,price as price,create_date as createDate,sex as sex
	</sql>
	<sql id="WhereColumns">
		<where>
			<if test="id != null">
				id = #{id}
			</if>
			<if test=" name!= null">
				and name= #{name}
			</if>
			<if test=" age!= null">
				and age= #{age}
			</if>
			<if test=" price!= null">
				and price= #{price}
			</if>
			<if test=" createDate!= null">
				and create_date= #{createDate}
			</if>
			<if test=" sex!= null">
				and sex= #{sex}
			</if>
		</where>
	</sql>
	<!-- 查询语句，会自动分页-->
	<select id="listPageByMybatis" resultType="${alias}" >
        select * from ${tableName}
        <include refid="WhereColumns" />
		order by id
    </select>
    <!-- 名称模式为：****_count,也可以不写，但如果查询叫复杂的话，自己写有助于控制查询性能-->
    <select id="listPageByMybatis1" resultType="${alias}" >
    	select * from ${tableName} order by id
    </select>
    <select id="listPageByMybatis1_count" resultType="long" >
    	select count(id) from ${tableName}
    </select>
    
	
    <select id="getById__" resultType="${alias}" >
        select
		<include refid = "BaseColumns" />
		from ${tableName} where id = #{id}
    </select>
    <select id="getMapById__" resultType="beanmap">
       select
		<include refid = "BaseColumns" />
		from ${tableName} where id = #{id}
    </select>
    
    <select id="listByParams__" resultType="${alias}" >
        select
		<include refid="BaseColumns" />
		from ${tableName}
		<include refid="WhereColumns" />
    </select>
</mapper>

