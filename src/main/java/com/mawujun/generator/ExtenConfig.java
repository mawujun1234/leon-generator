package com.mawujun.generator;

/**
 * 用来做额外配置的
 * @author mawujun email:16064988@qq.com qq:16064988
 *
 */
public class ExtenConfig {
	//boolean rowediting=false;
	//boolean editable=false;
	//boolean pageable=true;
	boolean extjs_userModel=true;
	boolean extjs_createDelUpd=true;
	public boolean getExtjs_userModel() {
		return extjs_userModel;
	}
	public void setExtjs_userModel(boolean extjs_userModel) {
		this.extjs_userModel = extjs_userModel;
	}
	public boolean getExtjs_createDelUpd() {
		return extjs_createDelUpd;
	}
	public void setExtjs_createDelUpd(boolean extjs_createDelUpd) {
		this.extjs_createDelUpd = extjs_createDelUpd;
	}
	
	

}
