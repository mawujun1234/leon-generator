package com.mawujun.generator.code;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) 
public @interface FK {
	/**
	 * 外键表的名称,可以通过T.xxx.tablename__引用
	 * @return
	 */
	String table()  default "";
	/**
	 * 被外键表的列列的名称，可以通过T.xxx.xxx引用
	 * @return
	 */
	String column()  default "";
	/**
	 * 被外键的实体类,，也可以直接通过City.class
	 * @return
	 */
	Class<?> entity()  default Void.class;
//	/**
//	 * 通过M.city.
//	 * @return
//	 */
//	String entityName();
	/**
	 * 被外键的实体类对应的字段名称，可以通过M.xxx.yyy应用
	 * @return
	 */
	String field() default "";

}
