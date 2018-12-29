package com.eoims.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.eoims.domain.Resources;
import com.eoims.domain.User;
import com.eoims.service.ResourcesService;
import com.eoims.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
@Component("myUserDetailService")
public class MyUserDetailServiceImpl implements UserDetailsService{

	@Resource
	private UserService userService;
	
	@Resource
	private ResourcesService resourcesService;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userService.findUserByName(username);
		if(user ==null)
            throw new UsernameNotFoundException(username+" not exist!");  
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		Resources resources = new Resources();
		resources.setUsername(username);
		List<Resources> list = resourcesService.loadMenu(resources);
		for (Resources r : list) {
			authSet.add(new SimpleGrantedAuthority("ROLE_" +r.getResKey()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(), 
				user.getEnable()==1?true:false, 
				true, 
				true,
				true,
				authSet);
	}

}
