package com.mawujun.generator;

import java.io.IOException;

import freemarker.template.TemplateException;
/**
 * 生成代码的主类，以ExtenConfig_开头的类，是用来控制代码生成的，因为可能存在在不同的情况下，生成的代码会不一样，有个性化的需求，但大部分一样。
 * 如果大部分都不样的话，就自己重写ftl文件
 * @author mawujun email:16064988@163.com qq:16064988
 *
 */
public class GeneratorMain {
	static GeneratorService generatorService=new GeneratorService();

	public static void main(String[] args) throws TemplateException, IOException, ClassNotFoundException {	
		//init();

			
		
		//generatorService.generatorFile(OrgType.class,FtlFile.JsGridQuery.toString(),"D:",new ExtenConfig());	
		
		//String str="";
		//str=generatorService.generatorToString(MenuItem.class,FtlFile.JsModel.toString(),null);	
        //System.out.println(str);
		
		generatorService.generatorAllFile(EntityTest.class,String.class);
		
		
		
	}

}
