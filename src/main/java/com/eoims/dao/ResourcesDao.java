package com.eoims.dao;

import com.eoims.domain.RResources;
import com.eoims.domain.Resources;

import java.util.List;

public interface ResourcesDao extends BaseDao{
	
	public List<RResources> resourcesListWithRole(Integer rid);
	
	public List<Resources> findAllResourcesWithRoles();
	
	public List<Resources> loadMenu(Resources resources);

	public List<Resources> getById(Integer id);
	
}
