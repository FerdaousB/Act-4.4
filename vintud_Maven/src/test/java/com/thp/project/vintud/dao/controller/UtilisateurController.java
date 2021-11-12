package com.thp.project.vintud.dao.controller;

import java.util.ArrayList;
import java.util.List;

import com.thp.project.vintud.dao.UtilisateurDAO;
import com.thp.project.vintud.dao.factory.FactoryDAO;
import com.thp.project.vintud.entity.User;

public class UtilisateurController {
	

	
	List<User> Utilisateurs = new ArrayList<User>();		
    User U = new User();
    
    UtilisateurDAO U1 = FactoryDAO.getUserDAO();
    
 
	
	public UtilisateurController(){
		
	}
	
		
	public List<User> getAllUsers(){
				
		return  U1.getAllUsers();
		
	}
	
	
	
	
}
