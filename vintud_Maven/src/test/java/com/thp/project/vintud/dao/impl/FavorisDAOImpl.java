package com.thp.project.vintud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.thp.project.vintud.dao.FavorisDao;
import com.thp.project.vintud.db.ConnectionUtil;
import com.thp.project.vintud.entity.Favoris;

public class FavorisDAOImpl implements FavorisDao{

	@Override
	public List<Favoris> getAllFavoris() {
		Statement stm= null;
        List<Favoris> listF = new ArrayList<Favoris>();
        String req = "select * from vintud.favoris";
        try {
            Connection co = ConnectionUtil.getInstance().getConnection();
            stm=co.createStatement();           
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {

            	Favoris f = new Favoris();
                f.setId(rs.getInt(1));
                f.setAnnouncement_id(rs.getInt(2));
                f.setUser_id(rs.getInt(3));
                f.setDateAjout(rs.getString(4));
                listF.add(f);
            }
            

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }


        return listF;
	}

	@Override
	public void createFavoris(Favoris favoris) {
		
		try {
		
		       ResultSet rs = null;   
	           Connection co = ConnectionUtil.getInstance().getConnection();
			
	           String  sql1 = "INSERT INTO vintud.favoris (id, announcement_id, user_id, dateajout)" +  "VALUES (?, ?, ?, ?);";
		       PreparedStatement  preparedStatement = co.prepareStatement(sql1);
		       preparedStatement.setInt(1,  favoris.getId());
               preparedStatement.setInt(2,  favoris.getAnnouncement_id());
		       preparedStatement.setInt(3,  favoris.getUser_id());
               preparedStatement.setString(4, favoris.getDateAjout());	   
               preparedStatement.executeUpdate();
	     
      	       System.out.println("Inserted favoris into the table..."); 
       
	       } 
	       catch (SQLException e) 
	       {
	    	   e.printStackTrace();		       
	   }   	
		
	}


	@Override
	public void UpdateFavoris(Favoris favoris) {
		
		String sql2 ="UPDATE vintud.favoris SET  announcement_id=?, user_id=?, dateajout=? WHERE ID="+favoris.getId();
		try {
			    ResultSet rs = null;   
		        Statement stm= null;
		        Connection con = ConnectionUtil.getInstance().getConnection();
			
			    PreparedStatement  preparedStatement = con.prepareStatement(sql2);
	            preparedStatement.setInt(1,  favoris.getAnnouncement_id());
			    preparedStatement.setInt(2,  favoris.getUser_id());
	            preparedStatement.setString(3, favoris.getDateAjout());	   
	            preparedStatement.executeUpdate();
	        	System.out.println("Updated favoris into the table..."); 

			
		          } catch (SQLException e) {
		       	 System.out.println("Error to update user ...");
			     e.printStackTrace();
		          }		
		
	}

	@Override
	public boolean DeleteFavoris(Favoris favoris) {
	           boolean DeleteFavoris= false;

		try {   
		        ResultSet rs = null;   
	            Connection con = ConnectionUtil.getInstance().getConnection();
		        String sql3="DELETE FROM vintud.favoris WHERE ID=?";
	            PreparedStatement  preparedStatement = con.prepareStatement(sql3);
	            preparedStatement.setInt(1,  favoris.getId());
	            preparedStatement.executeUpdate();
              	System.out.println("Deleted favoris from the table..."); 
              	DeleteFavoris = true;
		  
	            } catch (SQLException e) {
	          	System.out.println("Error to delete favoris...");
		        e.printStackTrace();
	            }
		
		        return DeleteFavoris;		
	
		
	}

}