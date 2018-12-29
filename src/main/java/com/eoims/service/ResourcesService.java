package com.eoims.service;

import java.util.List;

import com.eoims.domain.RResources;
import com.eoims.domain.Resources;
import com.github.pagehelper.PageInfo;

public interface ResourcesService {
	
	public List<RResources> resourcesListWithRole(Integer rid);
	
	public PageInfo<Resources> selectByPage(Resources resources, int start, int length);
	
	public void addResources(Resources resources);

	public void editResources(Resources resources);
	
	public void delResources(Integer id);
	
	public List<Resources> loadMenu(Resources resources);

	public List<Resources>queryAll();

	public List<Resources> getById(Integer id);
}
