package com.thp.project.vintud.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.thp.project.vintud.dao.UtilisateurDAO;
import com.thp.project.vintud.db.ConnectionUtil;
import com.thp.project.vintud.entity.Role;
import com.thp.project.vintud.entity.User;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	@Override
	public List<User> getAllUsers() {

		Statement stm= null;
        List<User> list = new ArrayList<User>();
        String req = "select * from vintud.user Order by id";
        try {
               Connection co = ConnectionUtil.getInstance().getConnection();
               stm=co.createStatement();           
               ResultSet rs = stm.executeQuery(req);
               while (rs.next()) {

            	   User U = new User();
            	   U.setId(rs.getInt(1));
				   U.setFirstname(rs.getString(2));
				   U.setName(rs.getString(3));
				   U.setPseudo(rs.getString(4));
				   U.setMail(rs.getString(5));
				   U.setU_password(rs.getString(6));
				   U.setPhone(rs.getString(7));
			       U.setAddress(rs.getString(8));
				   U.setRole_id(rs.getInt(9));
                   list.add(U);
               }    
            } catch (SQLException e) {

                  System.err.println(e.getMessage());
            }
             return list;
	}

	@Override
	public boolean Register(User user) {
	   	 boolean Register = false;
		 String  sql1 = "INSERT INTO vintud.user (id, firstname, name, pseudo, mail, u_password, phone, address, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";   
			try {	
			        Connection con = ConnectionUtil.getInstance().getConnection();
				    PreparedStatement  stm = con.prepareStatement(sql1);
				    stm.setInt(1,  user.getId());
		            stm.setString(2,  user.getFirstname());
		            stm.setString(3, user.getName());
				    stm.setString(4,  user.getPseudo());	
				    stm.setString(5,  user.getMail());	
				    stm.setString(6,  user.getU_password());			   
				    stm.setString(7,  user.getPhone());			   
				    stm.setString(8,  user.getAddress());			   
				    stm.setInt(9,  user.getRole_id());			   
				    
		            stm.executeUpdate();
				    Register=true;
			        System.out.println("user registered ....");

				    stm.close();
				    con.close();
			} catch (SQLException e) {
				    System.out.println("Error to insert user ...");
				    e.printStackTrace();
			} 
			return Register;
	}

	@Override
	public void UpdateUser(User user) {
		
		String sql2 ="UPDATE vintud.user SET firstname=?, name=?, pseudo=?, mail=?, u_password=?, phone=?, address=?, role_id=? WHERE ID="+user.getId();
		   try {

	               Connection con = ConnectionUtil.getInstance().getConnection();
			       PreparedStatement  stm = con.prepareStatement(sql2);
	               stm.setString(1,  user.getFirstname());
	               stm.setString(2, user.getName());
			       stm.setString(3,  user.getPseudo());	
			       stm.setString(4,  user.getMail());	
			       stm.setString(5,  user.getU_password());			   
			       stm.setString(6,  user.getPhone());			   
			       stm.setString(7,  user.getAddress());			   
			       stm.setInt(8,  user.getRole_id());
			       stm.executeUpdate();
			       System.out.println("user updated ....");

		   } catch (SQLException e) {
			       System.out.println("Error to update user ...");
			       e.printStackTrace();
		}
}
	
	@Override
	public List<Role> getAllRoles() {
		Statement stm= null;
		List <Role> listRoles = new ArrayList<Role>();
        String req = "select * from vintud.role";
           try {
           
        	     Connection co = ConnectionUtil.getInstance().getConnection();
                 stm=co.createStatement();           
                 ResultSet rs = stm.executeQuery(req);
                 while (rs.next()) {

                 Role R = new Role();
            	 R.setId(rs.getInt(1));
				 R.setNom(rs.getString(2));
				 listRoles.add(R);
            }
            

        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }


        return listRoles;
		
	}

	@Override
	public boolean ConnecteUser(User user) {
		 boolean ConnecteUser = false;
		 try {
			    Scanner sc = new Scanner(System.in);
				System.out.println("entrez votre pseudo : ");
				String pseudo= sc.nextLine() ;

				Scanner sc2 = new Scanner(System.in);
				System.out.println("entrer votre mot de passe : ");
				String passeword= sc2.nextLine();
				
				String Pseudo = "'"+pseudo+"'" ;
				String Password = "'"+passeword+"'" ;
				
				String requete = "SELECT * FROM vintud.user WHERE pseudo = "+Pseudo+" AND  u_password="+Password +";";
		        Connection con = ConnectionUtil.getInstance().getConnection();
			    Statement tmt = con.createStatement(); 
			    ResultSet  rs = tmt.executeQuery(requete);  
	            ConnecteUser=true;
		       if (rs.next()) {
 	 
		        				   
	        	         System.out.println("Connexion réussie !");}
	        	   else
	        	         {
	        		     System.out.println("Connexion non réussie !");
	        	         }
		        	       	
	          	           
		           rs.close();
		       } 
		       catch (SQLException e) 
		       {
		    	   e.printStackTrace();
		       }   	
		 return ConnecteUser;			        

	}

	
}