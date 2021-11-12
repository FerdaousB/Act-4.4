package com.thp.project.vintud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.thp.project.vintud.dao.RechercheDao;
import com.thp.project.vintud.db.ConnectionUtil;
import com.thp.project.vintud.entity.Recherche;

public class RechercheDAOImpl implements RechercheDao{

	@Override
	public List<Recherche> getAllRecherche() {
		Statement stm= null;
        List<Recherche> listR = new ArrayList<Recherche>();
        String req = "select * from vintud.recherche";
        try {
            Connection co = ConnectionUtil.getInstance().getConnection();
            stm=co.createStatement();           
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {

            	Recherche R = new Recherche();
                R.setId(rs.getInt(1));
                R.setType_habit(rs.getString(2));
                R.setTaille(rs.getString(3));
                R.setCouleur(rs.getString(4));
                R.setFourchette_prix(rs.getFloat(5));
                R.setUser_id(rs.getInt(6));
                listR.add(R);
            }
            

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }


        return listR;
	}

	@Override
	public void createRecherche(Recherche recherche) {
		try {
			
		       ResultSet rs = null;   
	           Connection co = ConnectionUtil.getInstance().getConnection();
			
	           String  sql1 = "INSERT INTO vintud.recherche (id, type_habit, taille, couleur, fourchette_prix, user_id)" +  "VALUES (?, ?, ?, ?, ?, ?);";
		       PreparedStatement  preparedStatement = co.prepareStatement(sql1);
		       preparedStatement.setInt(1, recherche.getId());
               preparedStatement.setString(2, recherche.getType_habit());
		       preparedStatement.setString(3, recherche.getTaille());
		       preparedStatement.setString(4, recherche.getCouleur());
               preparedStatement.setFloat(5, recherche.getFourchette_prix());
		       preparedStatement.setInt(6, recherche.getUser_id());
               preparedStatement.executeUpdate();
	     
   	           System.out.println("Inserted recherche into the table..."); 
    
	       } 
	       catch (SQLException e) 
	       {
	    	   e.printStackTrace();		       
	   }   	
		
	}

	@Override
	public void UpdateRecherche(Recherche recherche) {
	
		String sql2 ="UPDATE vintud.recherche SET type_habit=?, taille=?, couleur=?, fourchette_prix=?, user_id=? WHERE ID="+recherche.getId();
		try {
			    ResultSet rs = null;   
		        Statement stm= null;
		        Connection con = ConnectionUtil.getInstance().getConnection();
			
			    PreparedStatement  preparedStatement = con.prepareStatement(sql2);
			    preparedStatement.setString(1, recherche.getType_habit());
			    preparedStatement.setString(2, recherche.getTaille());
			    preparedStatement.setString(3, recherche.getCouleur());
	            preparedStatement.setFloat(4, recherche.getFourchette_prix());
			    preparedStatement.setInt(5, recherche.getUser_id());
	            preparedStatement.executeUpdate();
	        	System.out.println("Updated recherche into the table..."); 

			
		          } catch (SQLException e) {
		       	 System.out.println("Error to update recherche ...");
			     e.printStackTrace();
		          }		
		
	}

	@Override
	public boolean DeleteRecherche(Recherche recherche) {
		    boolean DeleteRecherche = false;
		try {
	        ResultSet rs = null;   
            Connection con = ConnectionUtil.getInstance().getConnection();
	        String sql3="DELETE FROM vintud.recherche WHERE ID=?";
            PreparedStatement  preparedStatement = con.prepareStatement(sql3);
            preparedStatement.setInt(1,  recherche.getId());
            preparedStatement.executeUpdate();
          	System.out.println("Deleted recherche from the table..."); 
          	DeleteRecherche = true;
            } catch (SQLException e) {
         	System.out.println("Error to delete recherche...");
         	e.printStackTrace();
            }
		return DeleteRecherche;		
		
	}

	

	
}