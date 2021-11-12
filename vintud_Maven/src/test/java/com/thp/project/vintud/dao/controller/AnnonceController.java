package com.thp.project.vintud.dao.controller;

import java.util.List;

import com.thp.project.vintud.dao.AnnonceDAO;
import com.thp.project.vintud.dao.factory.FactoryDAO;
import com.thp.project.vintud.entity.Announcement;

public class AnnonceController {
	
	static AnnonceDAO U2 = FactoryDAO.getAnnoucementDAO();
	
	
	public AnnonceController(){
		
	}
	
		
	public static List<Announcement> findAnnouncementsById(){
				
		return  U2.findAnnouncementsById();
		
	}
	
	 public List<Announcement> findAnnonceByNomCategoryPrice(String p, int b)
	 {
		return U2.findAnnonceByNomCategoryPrice(p, b);
		 
	 }
	
	 public Announcement findAnnonceByPrice(String p)
	 {
		return U2.findAnnonceByPrice(p);
		 
	 }
	    
	 public Announcement findAnnonceByLocation(String l)
	 {
		return null;
		 
	 }
	 
     public Announcement findByNombtrView(int nb_V) {
		return null;
    	 
     }

}