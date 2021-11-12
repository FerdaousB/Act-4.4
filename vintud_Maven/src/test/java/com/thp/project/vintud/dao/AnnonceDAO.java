package com.thp.project.vintud.dao;

import java.util.List;

import com.thp.project.vintud.entity.Announcement;


public interface AnnonceDAO {
	
	 public List<Announcement> findAnnouncementsById();
	 public List<Announcement> findAnnonceByNomCategoryPrice(String p, int b);
	 public Announcement findAnnonceByPrice(String p);
	 public Announcement findAnnonceByLocation(String l);
     public void InsertAnnonce(Announcement annonce);
     public Announcement findByNombtrView(int nb_V);
	 public void UpdateAnnonce(Announcement annonce);
	 public void DeleteAnnonce(Announcement annonce);

}
