package com.eoims.dao;

import com.eoims.domain.RoleResources;
import com.eoims.domain.URole;

import java.util.List;

public interface RoleDao extends BaseDao{

	
	public List<URole> queryRoleListWithUser(Integer id);
	
	public void deleteRoleResources(Integer id);
	
	public void addRoleResources(RoleResources roleResources);
}
