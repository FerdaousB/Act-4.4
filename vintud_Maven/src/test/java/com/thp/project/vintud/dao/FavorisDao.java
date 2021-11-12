package com.thp.project.vintud.dao;

import java.util.List;

import com.thp.project.vintud.entity.Favoris;

public interface FavorisDao {
  
	public List<Favoris> getAllFavoris();
	public void createFavoris(Favoris favoris);
	public void UpdateFavoris(Favoris favoris);
	public boolean DeleteFavoris(Favoris favoris);

}
