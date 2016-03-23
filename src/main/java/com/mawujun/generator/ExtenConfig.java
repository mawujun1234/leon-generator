package com.mawujun.generator;

/**
 * 用来做额外配置的
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public class ExtenConfig {
	/***
	 * 生成的extjs类的前缀名，Ext，Ems，y.等这些
	 */
	public String extjs_packagePrefix="";
	
	/**
	 * 如果设置>=1,就表示使用表格布局，是layout:{type:'table',columns:columns}
	 * columns的数值就是分几列
	 */
	public Integer extjs_form_layoutColumns=-1;

	public String getExtjs_packagePrefix() {
		return extjs_packagePrefix;
	}

	public void setExtjs_packagePrefix(String extjs_packagePrefix) {
		this.extjs_packagePrefix = extjs_packagePrefix;
	}

	public Integer getExtjs_form_layoutColumns() {
		return extjs_form_layoutColumns;
	}

	public void setExtjs_form_layoutColumns(Integer extjs_form_layoutColumns) {
		this.extjs_form_layoutColumns = extjs_form_layoutColumns;
	}


	
	 
	
//	public static final class Extjs{
//		/***
//		 * 生成的extjs类的前缀名，Ext，Ems，y.等这些
//		 */
//		public static String package_prefix="";
//		public static final class Form{
//			
//			public static Integer columns=-1;
//		}
//	}
//	//boolean rowediting=false;
//	//boolean editable=false;
//	//boolean pageable=true;
//	boolean extjs_userModel=true;
//	boolean extjs_createDelUpd=true;
//	public boolean getExtjs_userModel() {
//		return extjs_userModel;
//	}
//	public void setExtjs_userModel(boolean extjs_userModel) {
//		this.extjs_userModel = extjs_userModel;
//	}
//	public boolean getExtjs_createDelUpd() {
//		return extjs_createDelUpd;
//	}
//	public void setExtjs_createDelUpd(boolean extjs_createDelUpd) {
//		this.extjs_createDelUpd = extjs_createDelUpd;
//	}
//	
	

}
