package com.mawujun.generator.other;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

//http://hanxuedog.iteye.com/blog/1825723
//http://blog.csdn.net/hfhwfw/article/details/7266957
//https://www.cnblogs.com/0616--ataozhijia/p/4094952.html  逆向读取jar中的内容
//https://blog.csdn.net/sinat_34620530/article/details/54093862 解压文件
public class JarFileSearch {
	/**
	 * 解压指定后缀的文件
	 * @param dir
	 * @param suffix
	 * @return 解压出来的文件的目录
	 */
	public static List<String> unzipJarFile(String dir,List<String> list, String suffix,String targetDir) {  
		if(list==null){
    		list=new ArrayList<String>();
    	}
    	
        try {  
            File d = new File(dir);  
            File[] files = null;
            if (!d.isDirectory()) {  
                 if(d.getName().endsWith(".jar")||d.getName().endsWith(".zip")){
                	 files=new File[]{d};
                 } 
            }  else {
            	 files =d.listFiles(); 
            }
            
            for (int i = 0; i < files.length; i++) {  
                if (files[i].isDirectory()) {  
                	JarFileSearch.unzipJarFile(files[i].getAbsolutePath(), list,suffix,targetDir);  
                } else {  
                    String filename = files[i].getAbsolutePath();  
                    if (filename.endsWith(".jar")||filename.endsWith(".zip")) {  
                        ZipFile zip = new ZipFile(filename);  
                        Enumeration entries = zip.entries();  
                        while (entries.hasMoreElements()) {  
                            ZipEntry entry = (ZipEntry) entries.nextElement();  
                            String entry_name = entry.getName();  
                              
                            //不搜索扩展名为.class的文件  
                            if(entry_name.lastIndexOf(suffix)!=-1){
                            	//InputStream inputStream=zip.getInputStream(entry);
                            	list.add(targetDir+entry.getName());
 //                               BufferedReader r = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));  
//                                while(r.read()!=-1){  
//                                    String tempStr = r.readLine();  
//                                    if(null!=tempStr && tempStr.indexOf(condition)>-1){  
//                                        this.jarFiles.add(filename + "  --->  " + thisClassName);  
//                                        break;  
//                                    }  
//                                }  
                            }  
                              
 
                        }  
                    }  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        return null;
	}
	/**
	 * 
	 * @param dir 搜索的jar目录 或者 jar文件
	 * @param suffix
	 * @return
	 */
	public static List<ZipEntry> searchFile(String dir, String suffix) {  
		List<ZipEntry> list=new ArrayList<ZipEntry>();
		
		searchFile( dir,list, suffix.indexOf('.')!=-1?suffix:("."+suffix));
		return list;
	}
	
    protected static void searchFile(String dir, List<ZipEntry> list,String suffix) {  
    	if(list==null){
    		list=new ArrayList<ZipEntry>();
    	}
    	
        try {  
            File d = new File(dir);  
            File[] files = null;
            if (!d.isDirectory()) {  
                 if(d.getName().endsWith(".jar")||d.getName().endsWith(".zip")){
                	 files=new File[]{d};
                 } 
            }  else {
            	 files =d.listFiles(); 
            }
            
            for (int i = 0; i < files.length; i++) {  
                if (files[i].isDirectory()) {  
                	JarFileSearch.searchFile(files[i].getAbsolutePath(), list,suffix);  
                } else {  
                    String filename = files[i].getAbsolutePath();  
                    if (filename.endsWith(".jar")||filename.endsWith(".zip")) {  
                        ZipFile zip = new ZipFile(filename);  
                        Enumeration entries = zip.entries();  
                        while (entries.hasMoreElements()) {  
                            ZipEntry entry = (ZipEntry) entries.nextElement();  
                            String entry_name = entry.getName();  
                              
                            //不搜索扩展名为.class的文件  
                            if(entry_name.lastIndexOf(suffix)!=-1){
                            	//InputStream inputStream=zip.getInputStream(entry);
                            	list.add(entry);
 //                               BufferedReader r = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));  
//                                while(r.read()!=-1){  
//                                    String tempStr = r.readLine();  
//                                    if(null!=tempStr && tempStr.indexOf(condition)>-1){  
//                                        this.jarFiles.add(filename + "  --->  " + thisClassName);  
//                                        break;  
//                                    }  
//                                }  
                            }  
                              
 
                        }  
                    }  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  

    }  

}
