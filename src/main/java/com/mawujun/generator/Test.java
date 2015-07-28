package com.mawujun.generator;

import java.io.File;
import java.util.List;

import com.mawujun.utils.file.FileUtils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test=new Test();
		List<File> files=FileUtils.findFiles(FileUtils.getCurrentClassPath(test)+"/templates/ftl1", "*.ftl");
		for(File file:files){
			System.out.println(file.getAbsolutePath());
		}
	}

}
