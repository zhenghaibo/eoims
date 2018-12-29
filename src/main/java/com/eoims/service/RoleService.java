package com.eoims.service;

import com.eoims.domain.Role;
import com.eoims.domain.RoleResources;
import com.eoims.domain.URole;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {

	
	public PageInfo<Role> selectByPage(Role role, int start, int length);

	/**
	 * 查询所有角色，并且包含当前用户是否选中
	 * @param id
	 * @return
	 */
	public List<URole> queryRoleListWithUser(Integer id);
	
	public void saveRoleResources(RoleResources roleResources);
	
	public void addRole(Role role);
	
	public void delRole(Integer id);
	
}
