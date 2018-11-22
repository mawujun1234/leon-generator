package com.mawujun.generator.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) 
public @interface ColDefinition {
	/**
	 * 注释
	 * @return
	 */
    String comment() default "";  
  
   /**
    * 中文标签,如果没有comment的话，默认为添加到comment中
    * @return
    */
    String label() default "";  
  
    /**
     * 默认值
     * @return
     */
    String defaultValue() default "";  
      
  
    
    
}
