package com.banque.controlers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.banque.models.Client;
import com.banque.models.Compte;
import com.banque.models.Employe;

public class Transaction_controller {
	String url="jdbc:mysql://localhost/java_banque";
	String Utilisateur="root";
	String motDepasse="";
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	
	Compte cpE;
	Compte cpR;
	Employe ep;
	

//	ArrayList<Compte> mylist;
	public void Connexion(){
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection(url , Utilisateur, motDepasse);
    		System.out.println("connected");
    	}catch(ClassNotFoundException c) {
    		System.out.println("Probleme de pilote de base de donnée");
    	} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void Virment(Compte cpE , Compte cpR ,float mnt){
		try {
			pstmt = con.prepareStatement("SELECT * FROM compte WHERE num_compte = ?");
			pstmt.setString(1, cpE.getNumcompte());
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt("solde") < mnt){
					System.out.println("impossible");
				}else{
					int nsolde = rs.getInt("solde") - (int) mnt;
					System.out.println("mois solde = "+nsolde);
					PreparedStatement pstmt2 = con.prepareStatement("UPDATE compte SET solde = ? WHERE num_compte = ? ");
					pstmt2.setInt(1, nsolde);
					pstmt2.setString(2, cpE.getNumcompte());
					pstmt2.executeUpdate();

					PreparedStatement pstmt3 = con.prepareStatement("SELECT * FROM compte WHERE num_compte = ?");
					pstmt3.setString(1, cpR.getNumcompte());
					ResultSet rs2 = pstmt3.executeQuery();
					while(rs2.next()){
						int nsolde2 = rs2.getInt("solde") + (int) mnt;
						System.out.println("PLUS solde = "+nsolde2);

						PreparedStatement pstmt4 = con.prepareStatement("UPDATE compte SET solde = ? Where num_compte = ? ");
						pstmt4.setInt(1, nsolde2);
						pstmt4.setString(2, cpR.getNumcompte());
						pstmt4.executeUpdate();
					}
				}
			}
    	}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	


}
