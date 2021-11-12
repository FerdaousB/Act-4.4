package com.thp.project.vintud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.thp.project.vintud.dao.AnnonceDAO;
import com.thp.project.vintud.db.ConnectionUtil;
import com.thp.project.vintud.entity.Announcement;



public class AnnonceDAOImpl implements AnnonceDAO{
	
	@Override
	 public List<Announcement> findAnnouncementsById() {
		Statement stm= null;
        List<Announcement> myListe = new ArrayList<>();
        String req = "select * from vintud.announcement Order BY id";
        try {
            Connection co = ConnectionUtil.getInstance().getConnection();
            stm=co.createStatement();           
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {

                Announcement a = new Announcement();
                a.setId(rs.getInt(1));
                a.setTitle(rs.getString(2));
                a.setDescription(rs.getString(3));
                a.setCategory_id(rs.getInt(4));
                a.setPrice(rs.getFloat(5));
                a.setPicture(rs.getBytes(6));
                a.setPublication_date(rs.getString(7));
                a.setIs_available(rs.getBoolean(8));
                a.setLocalisation(rs.getString(10));
                a.setUser_id(rs.getInt(11));       
                myListe.add(a);
            }
            

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }


        return myListe;

    }

	
	@Override
	public List<Announcement> findAnnonceByNomCategoryPrice(String p, int b) {
		 List<Announcement> list = new ArrayList<>();
		 String req = "select * from vintud.announcement WHERE title=? and price=? ";
        try {
            Connection co = ConnectionUtil.getInstance().getConnection();
		    PreparedStatement  preparedStatement = co.prepareStatement(req);
            preparedStatement.setString(1, p);
            preparedStatement.setInt(2, b);            
            ResultSet rs = preparedStatement.executeQuery();
            

            while (rs.next()) {
            	
                Announcement a = new Announcement();
                a.setId(rs.getInt(1));
                a.setTitle(rs.getString(2));
                a.setDescription(rs.getString(3));
                a.setCategory_id(rs.getInt(4));
                a.setPrice(rs.getDouble(5));
                a.setPicture(rs.getBytes(6));
                a.setPublication_date(rs.getString(7));
                a.setIs_available(rs.getBoolean(8));
                a.setLocalisation(rs.getString(10));
                a.setUser_id(rs.getInt(11));
                list.add(a);
            }
            

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

     return list;

		
	}

	@Override
	public Announcement findAnnonceByPrice(String p) {
		Announcement annonce = null;
		 String req = "select * from vintud.announcement ORDER BY price ";
	        try {
	            Connection co = ConnectionUtil.getInstance().getConnection();
			    PreparedStatement  preparedStatement = co.prepareStatement(req);
			    preparedStatement.setString(1, p);            
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	
	                Announcement a = new Announcement();
	                a.setId(rs.getInt(1));
	                a.setTitle(rs.getString(2));
	                a.setDescription(rs.getString(3));
	                a.setCategory_id(rs.getInt(4));
	                a.setPrice(rs.getDouble(5));
	                a.setPicture(rs.getBytes(6));
	                a.setPublication_date(rs.getString(7));
	                a.setIs_available(rs.getBoolean(8));
	                a.setLocalisation(rs.getString(10));
	                a.setUser_id(rs.getInt(11));
	                
	            }
	            
	        } catch (SQLException e) {

	            System.err.println(e.getMessage());
	        }

	    return annonce;

		
	}

	@Override
	public Announcement findAnnonceByLocation(String l) {
		Announcement annonce = null;
		 String req = "select * from vintud.announcement ORDER BY localisation ";
	        try {
	            Connection co = ConnectionUtil.getInstance().getConnection();
			    PreparedStatement  preparedStatement = co.prepareStatement(req);
			    preparedStatement.setString(1, l);                         
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	
	                Announcement a = new Announcement();
	                a.setId(rs.getInt(1));
	                a.setTitle(rs.getString(2));
	                a.setDescription(rs.getString(3));
	                a.setCategory_id(rs.getInt(4));
	                a.setPrice(rs.getDouble(5));
	                a.setPicture(rs.getBytes(6));
	                a.setPublication_date(rs.getString(7));
	                a.setIs_available(rs.getBoolean(8));
	                a.setLocalisation(rs.getString(10));
	                a.setUser_id(rs.getInt(11));
	                
	               }	            
	               } catch (SQLException e) {
 
	                System.err.println(e.getMessage());
	        }

	    return annonce;
	}

	@Override
	public void InsertAnnonce(Announcement annonce){
		try {		
			  
		       Connection co = ConnectionUtil.getInstance().getConnection();
				
		           String  sql1 = "INSERT INTO vintud.announcement (id, title, description, category_id, price, picture, publication_date, is_available, view_number, localisation, user_id)" +  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			       PreparedStatement  preparedStatement = co.prepareStatement(sql1);
			       preparedStatement.setInt(1,  annonce.getId());
	               preparedStatement.setString(2,  annonce.getTitle());
	               preparedStatement.setString(3, annonce.getDescription());
			       preparedStatement.setInt(4,  annonce.getCategory_id());	
			       preparedStatement.setFloat(5,  (float) annonce.getPrice());	
			       preparedStatement.setBytes(6,  annonce.getPicture());			   
			       preparedStatement.setString(7,  annonce.getPublication_date());			   
			       preparedStatement.setBoolean(8,  annonce.getIs_available());			   
			       preparedStatement.setInt(9,  annonce.getView_number());			   
			       preparedStatement.setString(10,  annonce.getLocalisation());			   
			       preparedStatement.setInt(11,  annonce.getUser_id());
	               preparedStatement.executeUpdate();
		     
	        	   System.out.println("Inserted Annonce into the table..."); 
	         
		       } 
		       catch (SQLException e) 
		       {
		    	   e.printStackTrace();		       
		   }   	}
		


	@Override
	public Announcement findByNombtrView(int nb_V) {
		Announcement annonce = null;
		 String req = "select * from vintud.announcement ORDER BY view_number ";
	        try {
	            Connection co = ConnectionUtil.getInstance().getConnection();
			    PreparedStatement  preparedStatement = co.prepareStatement(req);
			    preparedStatement.setInt(1, nb_V);                         
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	
	                Announcement a = new Announcement();
	                a.setId(rs.getInt(1));
	                a.setTitle(rs.getString(2));
	                a.setDescription(rs.getString(3));
	                a.setCategory_id(rs.getInt(4));
	                a.setPrice(rs.getDouble(5));
	                a.setPicture(rs.getBytes(6));
	                a.setPublication_date(rs.getString(7));
	                a.setIs_available(rs.getBoolean(8));
	                a.setLocalisation(rs.getString(10));
	                a.setUser_id(rs.getInt(11));
	                
	               }	            
	               } catch (SQLException e) {

	                System.err.println(e.getMessage());
	        }

	    return annonce;		
	}

	@Override
	public void UpdateAnnonce(Announcement annonce) {
		
		String sql2 ="UPDATE vintud.announcement SET title=?, description=?, category_id=?, price=?, picture=?, publication_date=?, is_available=?, view_number=?, localisation=?, user_id=? WHERE ID="+annonce.getId();
		try {
			    
		        Connection con = ConnectionUtil.getInstance().getConnection();
			
			      PreparedStatement  preparedStatement = con.prepareStatement(sql2);
	              preparedStatement.setString(1,  annonce.getTitle());
	              preparedStatement.setString(2, annonce.getDescription());
			      preparedStatement.setInt(3,  annonce.getCategory_id());	
			      preparedStatement.setFloat(4,  (float) annonce.getPrice());	
			      preparedStatement.setBytes(5,  annonce.getPicture());			   
			      preparedStatement.setString(6,  annonce.getPublication_date());			   
			      preparedStatement.setBoolean(7,  annonce.getIs_available());			   
			      preparedStatement.setInt(8,  annonce.getView_number());			   
			      preparedStatement.setString(9,  annonce.getLocalisation());			   
			      preparedStatement.setInt(10,  annonce.getUser_id());
	              preparedStatement.executeUpdate();
	        	  System.out.println("Updated Annonce into the table..."); 

			
		          } catch (SQLException e) {
		       	 System.out.println("Error to update user ...");
			     e.printStackTrace();
		          }		
		
	}

	@Override
	 public void DeleteAnnonce(Announcement annonce) {

		try {
			    
		        Connection con = ConnectionUtil.getInstance().getConnection();
			    String sql3="DELETE FROM vintud.announcement WHERE ID=?";
		        PreparedStatement  preparedStatement = con.prepareStatement(sql3);

		        preparedStatement.setInt(1,  annonce.getId());
		        preparedStatement.executeUpdate();
	        	System.out.println("Deleted Annonce from the table..."); 

			  
		} catch (SQLException e) {
			System.out.println("Error to delete annonce...");
			e.printStackTrace();
		}		
		
		
	}

}
