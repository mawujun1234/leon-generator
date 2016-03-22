package com.mawujun.generator.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) 
public @interface FieldDefine {
	//�ֶ�����  
    String title();  
  
    //˳���  ����Ҫ������
    int number() default 0;  
  
    //�ֶα�ע  
    String remark() default "";  
      
    //�Ƿ��������ֶ�  
    boolean hidden() default false;  
}
