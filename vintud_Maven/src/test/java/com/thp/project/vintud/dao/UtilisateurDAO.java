package com.thp.project.vintud.dao;

import java.util.List;

import com.thp.project.vintud.entity.Role;
import com.thp.project.vintud.entity.User;

public interface UtilisateurDAO {
	
	public List<User> getAllUsers();
	public boolean Register(User user);
	public boolean ConnecteUser(User user);
	public void UpdateUser(User user);
	public List<Role> getAllRoles();
	 
}