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
import com.banque.models.Transaction;

public class Transaction_controller {
	String url="jdbc:mysql://localhost/java_banque";
	String Utilisateur="root";
	String motDepasse="";
	
	Connection con;
	Statement stmt , stmt1 , stmt2;
	ResultSet rs , rs1 , rs2 ;
	PreparedStatement pstmt;
	
	Client clE , clR;
	Compte cpE;
	Compte cpR;
	Employe ep;
	Transaction tr;
	int mnt;
	String type;
	int id;

//	ArrayList<Compte> mylist;
	public void Connexion(){
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection(url , Utilisateur, motDepasse);
    	}catch(ClassNotFoundException c) {
    		System.out.println("Probleme de pilote de base de donnée");
    	} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void virement(Transaction tr){
		try {
			pstmt = con.prepareStatement("SELECT * FROM compte WHERE num_compte = ?");
			pstmt.setString(1, tr.getEmetteur().getNumcompte());
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt("solde") < tr.getMontant()){
					System.out.println("impossible");
				}else{
					int nsolde = rs.getInt("solde") - tr.getMontant();
					PreparedStatement pstmt2 = con.prepareStatement("UPDATE compte SET solde = ? WHERE num_compte = ? ");
					pstmt2.setInt(1, nsolde);
					pstmt2.setString(2, tr.getEmetteur().getNumcompte());
					pstmt2.executeUpdate();

					PreparedStatement pstmt3 = con.prepareStatement("SELECT * FROM compte WHERE num_compte = ?");
					pstmt3.setString(1, tr.getBeneficiaire().getNumcompte());
					ResultSet rs2 = pstmt3.executeQuery();
					while(rs2.next()){
						int nsolde2 = rs2.getInt("solde") + tr.getMontant();
						PreparedStatement pstmt4 = con.prepareStatement("UPDATE compte SET solde = ? Where num_compte = ? ");
						pstmt4.setInt(1, nsolde2);
						pstmt4.setString(2, tr.getBeneficiaire().getNumcompte());
						pstmt4.executeUpdate();
						
						PreparedStatement pstmt5 = con.prepareStatement("INSERT INTO transaction (t_type,c_emetteur,c_beneficiaire,montant,e_id) VALUES (?,?,?,?,?)");
						pstmt5.setString(1,tr.getType());
						pstmt5.setString(2, tr.getEmetteur().getNumcompte());
						pstmt5.setString(3, tr.getBeneficiaire().getNumcompte());
						pstmt5.setInt(4, tr.getMontant());
						pstmt5.setString(5, tr.getResponsable().getId());
						pstmt5.executeUpdate();
					}
				}
			}
    	}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void Retrait(Transaction tr){
		try{
			pstmt = con.prepareStatement("SELECT * FROM compte WHERE num_compte = ?");
			pstmt.setString(1, tr.getEmetteur().getNumcompte());
			rs = pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt("solde") < tr.getMontant()){
					System.out.println("impossible");
				}else{	
					int nv = rs.getInt("solde") - tr.getMontant();
					PreparedStatement pstmt2 = con.prepareStatement("UPDATE compte SET solde = ? WHERE num_compte = ? ");
					pstmt2.setInt(1, nv);
					pstmt2.setString(2,tr.getEmetteur().getNumcompte());
					pstmt2.executeUpdate();

					PreparedStatement pstmt3 = con.prepareStatement("INSERT INTO transaction (t_type,c_emetteur,montant,e_id) VALUES (?,?,?,?)");
					pstmt3.setString(1,tr.getType());
					pstmt3.setString(2, tr.getEmetteur().getNumcompte());
					pstmt3.setInt(3, tr.getMontant());
					pstmt3.setString(4, tr.getResponsable().getId());
					pstmt3.executeUpdate();
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void Versement(Transaction tr){
		try{
			System.out.println(tr);
			pstmt = con.prepareStatement("SELECT * FROM compte WHERE num_compte = ?");
			pstmt.setString(1, tr.getBeneficiaire().getNumcompte());
			rs = pstmt.executeQuery();
			while(rs.next()){
				int nv = rs.getInt("solde") + tr.getMontant();
				PreparedStatement pstmt0 = con.prepareStatement("UPDATE compte SET solde = ? WHERE num_compte = ? ");
				pstmt0.setInt(1, nv);
				pstmt0.setString(2,tr.getBeneficiaire().getNumcompte());
				pstmt0.executeUpdate();
				
				PreparedStatement pstmt1 = con.prepareStatement("INSERT INTO transaction (t_type,c_emetteur,montant,e_id) VALUES (?,?,?,?)");
				pstmt1.setString(1,tr.getType());
				pstmt1.setString(2, tr.getBeneficiaire().getNumcompte());
				pstmt1.setInt(3, tr.getMontant());
				pstmt1.setString(4, tr.getResponsable().getId());
				pstmt1.executeUpdate();
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	 public void Get_transactions(){
		try {
			ArrayList<Transaction> mylist = new ArrayList<Transaction>();
			stmt = con.createStatement();
			String sql = "SELECT t.t_type , t.montant, t.c_emetteur as em_num , t.c_beneficiaire as bn_num , cl1.c_nom AS em_nom ,cl1.c_prenom AS em_pre ,cl2.c_nom AS bn_nom , cl2.c_prenom AS bn_pre , ep.e_nom,ep.e_prenom FROM transaction as t JOIN employe as ep ON ep.e_id = t.e_id JOIN compte as c1 ON t.c_emetteur = c1.num_compte JOIN client AS cl1 ON C1.titulaire = cl1.c_id JOIN compte as c2 ON t.c_beneficiaire = c2.num_compte JOIN client AS cl2 ON c2.titulaire = cl2.c_id WHERE t.t_type = 'virement'";
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()){
				System.out.println("type : " + rs.getString("t_type" ) + "montant : "+rs.getInt("montant")+"" );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 public Transaction Get_transaction(){
			try {
				ArrayList<Transaction> mylist = new ArrayList<Transaction>();
				
				stmt = con.createStatement();
				String sql = "SELECT * FROM transaction INNER JOIN employe ON transaction.e_id = employe.e_id WHERE transaction.t_type = 'virement'";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					ep = new Employe(rs.getString("e_id"),rs.getString("e_nom"),rs.getString("e_prenom"),rs.getString("e_mail"));
					type = rs.getString("t_type");
					mnt = rs.getInt("montant");
					id = rs.getInt("t_id");
				}
				stmt1 = con.createStatement();
				String sql1 = "SELECT * FROM transaction JOIN compte ON transaction.c_emetteur = compte.num_compte JOIN client ON compte.titulaire = client.c_id WHERE transaction.t_type = 'virement'";
				rs1 = stmt1.executeQuery(sql1);
				while(rs1.next()){
					clE = new Client(rs1.getString("c_id"),rs1.getString("c_nom"),rs1.getString("c_prenom"),rs1.getInt("c_tel"),rs1.getString("c_adress"));
					cpE = new Compte(rs1.getString("id"),rs1.getString("num_compte"),clE,rs1.getInt("solde"),rs1.getString("created_at"));
				}
				stmt2 = con.createStatement();
				String sql2 = "SELECT * FROM transaction JOIN compte ON transaction.c_beneficiaire = compte.num_compte JOIN client ON compte.titulaire = client.c_id WHERE transaction.t_type = 'virement'";
				rs2 = stmt2.executeQuery(sql2);
				while(rs2.next()){
					clR = new Client(rs2.getString("c_id"),rs2.getString("c_nom"),rs2.getString("c_prenom"),rs2.getInt("c_tel"),rs2.getString("c_adress"));
					cpR = new Compte(rs2.getString("id"),rs2.getString("num_compte"),clR,rs2.getInt("solde"),rs2.getString("created_at"));
				}
				
				tr = new Transaction("virement", cpE, cpR , mnt, ep);
				return tr;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	 public ArrayList<Transaction> Get_Ver_transaction(){
			try {
				ArrayList<Transaction> mylist = new ArrayList<Transaction>();
				stmt = con.createStatement();
				String sql = "SELECT * FROM transaction WHERE t_type = 'virement'";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					Statement stmt = con.createStatement();
					String sql5 = "SELECT * FROM transaction JOIN employe ON transaction.e_id = employe.e_id WHERE transaction.t_type = 'virement'";
					ResultSet rs5 = stmt.executeQuery(sql5);
					while(rs5.next()){
						ep = new Employe(rs5.getString("e_id"),rs5.getString("e_nom"),rs5.getString("e_prenom"),rs5.getString("e_mail"));
						type = rs5.getString("t_type");
						mnt = rs5.getInt("montant");
						id = rs5.getInt("t_id");
					}
					stmt1 = con.createStatement();
					String sql1 = "SELECT * FROM transaction JOIN compte ON transaction.c_emetteur = compte.num_compte JOIN client ON compte.titulaire = client.c_id WHERE transaction.t_type = 'virement'";
					rs1 = stmt1.executeQuery(sql1);
					while(rs1.next()){
						clE = new Client(rs1.getString("c_id"),rs1.getString("c_nom"),rs1.getString("c_prenom"),rs1.getInt("c_tel"),rs1.getString("c_adress"));
						cpE = new Compte(rs1.getString("id"),rs1.getString("num_compte"),clE,rs1.getInt("solde"),rs1.getString("created_at"));
					}
					stmt2 = con.createStatement();
					String sql2 = "SELECT * FROM transaction JOIN compte ON transaction.c_beneficiaire = compte.num_compte JOIN client ON compte.titulaire = client.c_id WHERE transaction.t_type = 'virement'";
					rs2 = stmt2.executeQuery(sql2);
					while(rs2.next()){
						clR = new Client(rs2.getString("c_id"),rs2.getString("c_nom"),rs2.getString("c_prenom"),rs2.getInt("c_tel"),rs2.getString("c_adress"));
						cpR = new Compte(rs2.getString("id"),rs2.getString("num_compte"),clR,rs2.getInt("solde"),rs2.getString("created_at"));
					}
					
					tr = new Transaction("virement", cpE, cpR , mnt, ep);
					mylist.add(tr);
				}
				return mylist;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
}
