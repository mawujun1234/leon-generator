package com.mawujun.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.mawujun.generator.model.SubjectRoot;
import com.mawujun.utils.file.FileUtils;
import com.mawujun.utils.properties.PropertiesUtils;
import com.mawujun.utils.string.StringUtils;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.utility.NullArgumentException;

/**
 * 
 * @author mawujun
 *
 */
public class GeneratorService {
	
	private JavaEntityMetaDataService javaEntityMetaDataService=new JavaEntityMetaDataService();
	private Configuration cfg=null;
	List<File> ftl_file_manes=new ArrayList<File>();//ftl文件的名称

	
	public void initConfiguration() throws IOException{
		// TODO Auto-generated method stub
		if(cfg!=null){
			return;
		}
		
////		//加載多個文件
////		FileTemplateLoader ftl1 = new FileTemplateLoader(new File(basePath+"\\extjs4"));
////		FileTemplateLoader ftl2 = new FileTemplateLoader(new File(basePath+"\\java\\controller"));
////		FileTemplateLoader ftl3 = new FileTemplateLoader(new File(basePath+"\\java\\service"));
////		FileTemplateLoader ftl4 = new FileTemplateLoader(new File(basePath+"\\java\\mybatis"));
////		TemplateLoader[] loaders = new TemplateLoader[] { ftl1, ftl2,ftl3,ftl4 };
////		MultiTemplateLoader mtl = new MultiTemplateLoader(loaders);
////		cfg.setTemplateLoader(mtl);
//		
//		PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
//		Resource[] reses= resolver.getResources("classpath:templates/ftl1/**/*.ftl");
////		String basePath=this.getClass().getResource("/").toString();
////		Resource[] reses= resolver.getResources("file:"+1+"/templates/**/*.ftl");
//		if(reses==null || reses.length==0){
//			return ;
//		}
		String classpathftldir=PropertiesUtils.load("generator.properties").getProperty("classpathftldir");
		List<File> files=FileUtils.findFiles(FileUtils.getCurrentClassPath(this)+classpathftldir, "*.ftl");
		ftl_file_manes=files;
		cfg = new Configuration();
		cfg.setEncoding(Locale.CHINA, "UTF-8");
		//cfg.setEncoding(Locale.CHINA, "UTF-8");
		
		//循环出 所有包含ftl的文件夹
		Set<String> list=new HashSet<String>();
		List<TemplateLoader> templateLoaders=new ArrayList<TemplateLoader>();
		for(File file:files){
			//System.out.println(res.getURI().getPath());
			//System.out.println(res.getURL().getPath());
			//String path=file.getAbsolutePath().substring(0,file.getAbsolutePath().lastIndexOf('/'));//SystemUtils.FILE_SEPARATOR
			String path=file.getParent();
			if(!list.contains(path)){
				list.add(path);
				FileTemplateLoader ftl1 = new FileTemplateLoader(new File(path));
				templateLoaders.add(ftl1);
			}
			//ftl_file_manes.add(file.getName());

		}
//		String path=reses[0].getURI().getPath().substring(0,reses[0].getURI().getPath().indexOf("templates")+9);
//		FileTemplateLoader ftl1 = new FileTemplateLoader(new File(path));
//		templateLoaders.add(ftl1);
		
		MultiTemplateLoader mtl = new MultiTemplateLoader(templateLoaders.toArray(new TemplateLoader[templateLoaders.size()]));
		cfg.setTemplateLoader(mtl);
		
		
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		
		
	}
	
//	/**
//	 * 
//	 * @param clazz 要
//	 * @param ftl 模板文件在的地方
//	 * @throws ClassNotFoundException 
//	 * @throws TemplateException
//	 * @throws IOException
//	 */
//	public  String generatorToString(String className,String ftl,Object extenConfig) throws ClassNotFoundException, TemplateException, IOException  {
//		Class clazz=Class.forName(className);
//		return generatorToString(clazz, ftl,extenConfig);
//	}
//	/**
//	 * jsPackagel，默认是class的Leon.uncapitalize(simpleClassName)
//	 * @author mawujun email:16064988@163.com qq:16064988
//	 * @param clazz
//	 * @param ftl
//	 * @param 
//	 * @return
//	 * @throws TemplateException
//	 * @throws IOException
//	 */
//	public  String generatorToString(Class clazz,String ftl,Object extenConfig) throws TemplateException, IOException {
//		if(!StringUtils.hasLength(ftl)) {
//			throw new NullArgumentException("模板文件名称不能为null");
//		}
//
//		//String basePath=System.getProperty("user.dir")+"\\autoCoder\\templates\\";
//		initConfiguration();
//
//		/* 在整个应用的生命周期中，这个工作你可以执行多次 */
//		/* 获取或创建模板 */
//		Template templete = cfg.getTemplate(ftl,"UTF-8");
//		//templete.setEncoding("UTF-8");
//		//templete.setOutputEncoding("UTF-8");
//		/* 创建数据模型 */
//		SubjectRoot root =javaEntityMetaDataService.prepareDate(clazz);
//		if(extenConfig!=null){
//			root.setExtenConfig(extenConfig);
//		}
//		
//		
//		
//		/* 将模板和数据模型合并 */
//		//Writer out = new OutputStreamWriter(System.out);
//		Writer out = new StringWriter();
//
//		templete.process(root, out);
//		out.flush();
//		return out.toString();
//	}
//	private String getJsPackage(Class clazz){
//		return "Leon."+StringUtils.uncapitalize(clazz.getSimpleName());
//	}

//	
//	/**
//	 * 
//	 * @author mawujun 16064988@qq.com 
//	 * @param className 领域类
//	 * @param ftl 模板文件
//	 * @param extenConfig 扩展的属性
//	 * @param writer 要输出的对象，可以使控制面板，文件
//	 * @throws ClassNotFoundException
//	 * @throws TemplateException
//	 * @throws IOException
//	 */
//	public  void generator(String className,String ftl,Writer writer) throws ClassNotFoundException, TemplateException, IOException  {
//		Class clazz=Class.forName(className);
//		generator(clazz,ftl, writer);
//	}
	
//	public  void generator(String className,String ftl,Map extenConfig,Writer writer) throws ClassNotFoundException, TemplateException, IOException  {
//		
//	}
	/**
	 * 根据字符串产生名称
	 * @param clazz
	 * @param ftl
	 * @return
	 * @throws ClassNotFoundException
	 * @throws TemplateException
	 * @throws IOException
	 */
	private  String generatorFileName(Class clazz,Class idClass,String ftl) throws ClassNotFoundException, TemplateException, IOException  {
		
		SubjectRoot root =javaEntityMetaDataService.getClassProperty(clazz);
		if(root==null){
			throw new NullPointerException("SubjectRoot为null");
		}
		
		String fileName=FreemarkerHelper.processTemplateString(ftl,root, cfg);
		fileName=fileName.substring(0,fileName.lastIndexOf('.'));
		return fileName;
	}
//	public  String generatorFileName(String className,String ftl) throws ClassNotFoundException, TemplateException, IOException  {
//		Class clazz=Class.forName(className);
//		return generatorFileName(clazz,ftl);
//	}

	/**
	 * 
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param clazz
	 * @param idClass id的class类型
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws TemplateException
	 */
	public  void generatorAllFile(Class clazz,Class idClass) throws IOException, ClassNotFoundException, TemplateException {
		initConfiguration();
		/* 创建数据模型 */
		SubjectRoot root =javaEntityMetaDataService.initClassProperty(clazz,idClass);
		
		String output=PropertiesUtils.load("generator.properties").getProperty("output");
		FileUtils.createDir(output);

		for (File ftlFile : ftl_file_manes) {	
			this.generatorFile(clazz,idClass,ftlFile,output);	
		}
		//打开文件夹
		Runtime.getRuntime().exec("cmd.exe /c start "+output);
	}
	/**
	 * 
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param clazz 领域类
	 * @param ftl 模板文件的名称
	 * @param dirPath 生成后文件存放的地址
	 * @param extenConfig 额外的属性，用来控制生成的代码的
	 * @throws TemplateException
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	public  void generatorFile(Class clazz,Class idClass,File ftlfile,String dirPath) throws TemplateException, IOException, ClassNotFoundException {
		initConfiguration();
		/* 创建数据模型 */
		SubjectRoot root =javaEntityMetaDataService.initClassProperty(clazz,idClass);
		
		
		String fileName=this.generatorFileName(clazz, idClass, ftlfile.getName());
		//按照模板的目录结构生成
		String classpathftldir=PropertiesUtils.load("generator.properties").getProperty("classpathftldir");
		String parentpath=ftlfile.getParent();
		String ftlfilepath=parentpath.substring(parentpath.indexOf(classpathftldir)+classpathftldir.length());//   .replaceAll(classpathftldir, "");
		
		
		String fileDir=dirPath+ftlfilepath;
		String filePath=dirPath+ftlfilepath+File.separatorChar+fileName;
		
		File dir=new File(fileDir);
		if(!dir.exists()){
			dir.mkdirs();
		}
		File file=new File(filePath);
		if(file.exists()){
//			int i=filePath.lastIndexOf("/");
//			if(i==-1){
//				i=filePath.lastIndexOf("\\");
//			}
//			Runtime.getRuntime().exec("cmd.exe /c start "+filePath.substring(0, i));
//			throw new FileExistsException(file);
			
		} else {
			//filePath.
			//filePath.substring(beginIndex, endIndex)filePath.lastIndexOf(File.separatorChar);
			file.createNewFile();
		}
		FileWriter fileWriter=new FileWriter(filePath);
		generator(clazz, ftlfile.getName(), fileWriter);
	}
	/**
	 * 
	 * @param clazz 要
	 * @param ftl 模板文件在的地方
	 * @throws TemplateException
	 * @throws IOException
	 */
	private  void generator(Class clazz,String ftl,Writer writer) throws TemplateException, IOException {
		if(!StringUtils.hasLength(ftl)) {
			throw new NullArgumentException("模板文件名称不能为null");
		}
		
		//String basePath=System.getProperty("user.dir");
		

		/* 在整个应用的生命周期中，这个工作你可以执行多次 */
		/* 获取或创建模板 */
		Template templete = cfg.getTemplate(ftl,"UTF-8");
		//templete.setEncoding("UTF-8");
		//templete.setOutputEncoding("UTF-8");
		/* 创建数据模型 */
		SubjectRoot root =javaEntityMetaDataService.getClassProperty(clazz);


		templete.process(root, writer);
		//out.flush();
		//return out;
	}

	public JavaEntityMetaDataService getJavaEntityMetaDataService() {
		return javaEntityMetaDataService;
	}

	public void setJavaEntityMetaDataService(
			JavaEntityMetaDataService javaEntityMetaDataService) {
		this.javaEntityMetaDataService = javaEntityMetaDataService;
	}
	

}
