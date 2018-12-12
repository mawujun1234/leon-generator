  
<#assign simpleClassNameFirstLower = simpleClassName?uncap_first> 
package ${basepackage}.controller;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mawujun.mvc.R;
import com.mawujun.repository.utils.PageInfo;
import com.mawujun.repository.utils.Params;

import ${basepackage}.${simpleClassName};
import ${basepackage}.service.${simpleClassName}Service;

<#if isCompositeId==true>
	import ${idSimpleClassName};
</#if>
<#include "/java_copyright.include"/>

@Controller
//@RequestMapping("/${simpleClassNameFirstLower}")
public class ${simpleClassName}Controller {

	@Resource
	private ${simpleClassName}Service ${simpleClassNameFirstLower}Service;


	/**
	 * 请按自己的需求修改
	 * @author mawujun email:16064988@163.com qq:16064988
	 * @param id 是父节点的id
	 * @return
	 */
	@RequestMapping("/${simpleClassNameFirstLower}/list")
	@ResponseBody
	public R list() {//括号里面写参数
		Params params=Params.of();//Params.of().like(M.${simpleClassName}.name, "test");
		List<${simpleClassName}> ${simpleClassNameFirstLower}es=${simpleClassNameFirstLower}Service.listByMap(params);
		return R.ok(${simpleClassNameFirstLower}es);
	}

	/**
	 * 这是基于分页的几种写法,的例子，请按自己的需求修改
	 * @author mawujun email:16064988@163.com qq:16064988
	 * @param start
	 * @param limit
	 * @param userName
	 * @return
	 */
	@RequestMapping("/${simpleClassNameFirstLower}/listPage")
	@ResponseBody
	public R listPage(Integer start,Integer limit){
		//PageInfo<${simpleClassName}> pageinfo=PageInfo.of(start,limit).eq(M.${simpleClassName}.name, "宁波");
		PageInfo<${simpleClassName}> pageinfo=PageInfo.of(start,limit);
		${simpleClassNameFirstLower}Service.listPageByPageInfo(pageinfo);
		return R.ok().data(pageinfo);
	}

	@RequestMapping("/${simpleClassNameFirstLower}/listAll")
	@ResponseBody
	public R listAll() {	
		List<${simpleClassName}> ${simpleClassNameFirstLower}es=${simpleClassNameFirstLower}Service.listAll();
		return R.ok().data(${simpleClassNameFirstLower}es);
	}
	

	@RequestMapping("/${simpleClassNameFirstLower}/get")
	@ResponseBody
	public R get(${idClassName} id) {
		${simpleClassName} ${simpleClassNameFirstLower}=${simpleClassNameFirstLower}Service.getById(id);
		return R.ok().data(${simpleClassNameFirstLower});
	}
	
	@RequestMapping("/${simpleClassNameFirstLower}/create")
	@ResponseBody
	public R create(@RequestBody ${simpleClassName} ${simpleClassNameFirstLower}) {
		${simpleClassNameFirstLower}Service.create(${simpleClassNameFirstLower});
		return R.ok().data(${simpleClassNameFirstLower});
	}
	
	@RequestMapping("/${simpleClassNameFirstLower}/update")
	@ResponseBody
	public  R update(@RequestBody ${simpleClassName} ${simpleClassNameFirstLower}) {
		${simpleClassNameFirstLower}Service.update(${simpleClassNameFirstLower});
		return R.ok().data(${simpleClassNameFirstLower});
	}
	
	@RequestMapping("/${simpleClassNameFirstLower}/removeById")
	@ResponseBody
	public R removeById(${idClassName} id) {
		${simpleClassNameFirstLower}Service.removeById(id);
		return R.ok().data(id);
	}
	
	@RequestMapping("/${simpleClassNameFirstLower}/removeByIds")
	@ResponseBody
	public R removeByIds(String[] ids) {
		${simpleClassNameFirstLower}Service.removeByIds(ids);
		return R.ok().data(ids);
	}
	
	@RequestMapping("/${simpleClassNameFirstLower}/remove")
	@ResponseBody
	public ${simpleClassName} remove(@RequestBody ${simpleClassName} ${simpleClassNameFirstLower}) {
		${simpleClassNameFirstLower}Service.remove(${simpleClassNameFirstLower});
		return ${simpleClassNameFirstLower};
	}
	
	
}
