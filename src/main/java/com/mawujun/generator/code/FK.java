package com.mawujun.generator.code;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) 
public @interface FK {
	/**
	 * 表的名称,可以通过T.xxx.tablename引用
	 * 如果放在字段上，这个就不需要填了
	 * table和entity选一个填写就好
	 * @return
	 */
	String table()  default "";
	/**
	 * 列的名称，可以通过T.xxx.xxx引用
	 * 如果放在字段上，这个就不需要填了
	 * column和field选一个填写就好
	 * @return
	 */
	String column()  default "";
	/**
	 * 实体类,，也可以直接通过City.class
	 * 如果放在字段上，这个就不需要填了
	 * table和entity选一个填写就好
	 * @return
	 */
	Class<?> entity()  default Void.class;
	/**
	 * 实体类对应的字段名称，可以通过M.xxx.yyy应用
	 * 如果放在字段上，这个就不需要填了
	 * column和field选一个填写就好
	 * @return
	 */
	String field() default "";
	
	
	/**
	 * 外键指向的实体类,，也可以直接通过City.class
	 * 必填，refEntity和refTable选一个填写就好
	 * @return
	 */
	Class<?> refEntity()  default Void.class;
	/**
	 * 外键的实体类对应的字段名称，可以通过M.xxx.yyy应用
	 * 必填，refColumn和refField选一个填写就好
	 * @return
	 */
	String refField() default "";
	/**
	 * 表的名称,可以通过T.xxx.tablename引用
	 * 必填，refEntity和refTable选一个填写就好
	 * @return
	 */
	String refTable()  default "";
	/**
	 * 列的名称，可以通过T.xxx.xxx引用
	 * 必填，refColumn和refField选一个填写就好
	 * @return
	 */
	String refColumn()  default "";

}
