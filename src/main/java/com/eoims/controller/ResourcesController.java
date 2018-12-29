package com.eoims.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.eoims.domain.RResources;
import com.eoims.domain.Resources;
import com.eoims.service.ResourcesService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/resources")
public class ResourcesController {
	
	@Resource
	private ResourcesService resourcesService;
	
	
	/**
	 * 查询资源列表，并且返回指定角色是否拥有该资源的权限
	 * @param rid 角色id
	 * @return
	 */
	@RequestMapping("/resourcesListWithRole.do")
	public List<RResources> resourcesListWithRole(Integer rid){
		List<RResources> list = resourcesService.resourcesListWithRole(rid);
		return list;
	}
	
	
	@RequestMapping("/resourcesList.do")
	public Map<String,Object> resourcesList(Resources resources, String draw,
											@RequestParam(required = false, defaultValue = "1") int start,
											@RequestParam(required = false, defaultValue = "10") int length){
		Map<String,Object> map = new HashMap<>();
		PageInfo<Resources> pageInfo = resourcesService.selectByPage(resources, start, length);
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
		return map;
	}
	
	@RequestMapping("/addResources.do")
	public String addResources(Resources resources){
		try {
			if(resources.getId()==null) {
				resourcesService.addResources(resources);
			}else{
				resourcesService.editResources(resources);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	
	
	@RequestMapping("/delResources.do")
	public String delResources(Integer id){
		try {
			resourcesService.delResources(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping("/loadMenu.do")
	public List<Resources> loadMenu(HttpServletRequest request){
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
				.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		String name = securityContextImpl.getAuthentication().getName();
		Resources resources= new Resources();
		resources.setUsername(name);
		resources.setType(1);
		List<Resources> menu = resourcesService.loadMenu(resources);
		return menu;
	}

	@RequestMapping("/getById.do")
	public Map<String,Object> getById(Integer id){
		Map<String,Object> map = new HashMap<>();
		try {
			List<Resources> list =resourcesService.getById(id);
			map.put("data",list);
			map.put("success",true);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success",false);
			return map;
		}
	}
}
