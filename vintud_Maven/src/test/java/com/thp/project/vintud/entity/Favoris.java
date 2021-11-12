package com.thp.project.vintud.entity;

import com.thp.project.vintud.entity.impl.FavorisImpl;

public class Favoris implements FavorisImpl{
		
		private int id;
		private int announcement_id; 
		private int user_id ; 
		private String dateAjout;
		
		
		public Favoris() {
		}


		public Favoris(int id, int announcement_id, int user_id, String dateAjout) {
			this.id = id;
			this.announcement_id = announcement_id;
			this.user_id = user_id;
			this.dateAjout = dateAjout;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public int getAnnouncement_id() {
			return announcement_id;
		}


		public void setAnnouncement_id(int announcement_id) {
			this.announcement_id = announcement_id;
		}


		public int getUser_id() {
			return user_id;
		}


		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}


		public String getDateAjout() {
			return dateAjout;
		}


		public void setDateAjout(String dateAjout) {
			this.dateAjout = dateAjout;
		}


		@Override
		public String toString() {
			return "Favoris [id=" + id + ", announcement_id=" + announcement_id + ", user_id=" + user_id + ", dateAjout="
					+ dateAjout + "]";
		}
		
		
		

	}

