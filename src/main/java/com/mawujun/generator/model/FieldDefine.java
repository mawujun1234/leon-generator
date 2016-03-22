package com.mawujun.generator.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) 
public @interface FieldDefine {
	//×Ö¶ÎÃû³Æ  
    String title();  
  
    //Ë³ĞòºÅ  £¬ÖØÒªĞÔÅÅĞò
    int number() default 0;  
  
    //×Ö¶Î±¸×¢  
    String remark() default "";  
      
    //ÊÇ·ñÊÇÒş²Ø×Ö¶Î  
    boolean hidden() default false;  
}
