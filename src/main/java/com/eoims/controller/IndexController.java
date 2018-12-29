package com.eoims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value={"/index.do",""})
	public String index(){
		return "user/userList";
	}
	
	@RequestMapping("roles.do")
	public String roles(){
		return "role/roleList";
	}
	
	@RequestMapping("resources.do")
	public String resources(){
		return "resources/resourceList";
	}

	@RequestMapping("logout.do")
	public String logout(){
		return "logout";
	}

	@RequestMapping("/codeinfo.do")
	public String codeinfo(){
		return "codeinfo/codeinfoList";
	}

	@RequestMapping("/excelImport.do")
	public String excelImport(){
		return "excelImport/excelImport";
	}
}
