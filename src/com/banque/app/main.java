package com.banque.app;
import com.banque.controlers.Client_controller;
import com.banque.controlers.Compte_controller;
import com.banque.controlers.Employe_controller;
import com.banque.controlers.Transaction_controller;
import com.banque.models.Client;
import com.banque.models.Compte;
import com.banque.models.Employe;
import com.banque.models.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

public class main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date today = new Date();
		Client_controller cc = new Client_controller();
		Compte_controller cp = new Compte_controller();
		Transaction_controller tc = new Transaction_controller();
		Employe_controller ec = new Employe_controller();
		ec.Connexion();
		cp.Connexion();
		cc.Connexion();
		tc.Connexion();
		
		Client c;
		Employe p;
		Compte compte1,compte2;
		Transaction tr,tr2;
		

		ArrayList<Transaction> tarray2 = new ArrayList<Transaction>();
		
		tarray2 = tc.Get_Client_Transaction("1050010");

		//tarray2 = tc.Get_Client_Transaction_by_date("1050011","2020-05-02","2020-05-06");
		for(int i = 0 ; i < tarray2.size();i++) {
			System.out.println(tarray2.get(i).getBeneficiaire() +" "+tarray2.get(i).getEmetteur() );
		}
		
		
		
		/*			
		Login l = new Login();
		
	
		p = ec.Get_One_Employe("d32cad42-a7ab-4e93-9fb5-9afd58efa5ca");
		tc.Get_transaction();
		compte1 = cp.Get_One_Compte("2316510");
		compte2 = cp.Get_One_Compte("1062349");
	 	int mnt = 250;
		tr = new Transaction("virement",compte1,compte2,mnt,p);
		tc.virement(tr);
		
		ArrayList<Transaction> arc = new ArrayList<Transaction>();
		arc = tc.Get_Ver_transaction();
		
		
		Iterator<Transaction> itc = arc.iterator(); 
		while (itc.hasNext()) { 
           System.out.print(itc.next()); 
        }
		
		//p = new Employe("Hanchi","Mohamed","mohamed@gmail.com","med987");
		//ec.Add_Employe(p);
		
		
		// SELECT t.t_type ,t,montant t.c_emetteur as em_num , t.c_beneficiaire as bn_num , cl1.c_nom AS em_nom ,cl1.c_prenom AS em_pre ,cl2.c_nom AS bn_nom , cl2.c_prenom AS bn_pre FROM transaction as t JOIN compte as c1 ON t.c_emetteur = c1.num_compte JOIN client AS cl1 ON C1.titulaire = cl1.c_id JOIN compte as c2 ON t.c_beneficiaire = c2.num_compte JOIN client AS cl2 ON c2.titulaire = cl2.c_id WHERE t.t_type = "virement"		
			

		System.out.println("------------------ AVANT  --------------------");
		System.out.println(compte1.toString());
		System.out.println("----------------------------------------------");

		int mnt1 = 25;
		
		tc.Retrait(tr);
		System.out.println("------------------ APRES Retrait -------------");
		compte1 = cp.Get_One_Compte("1076231");
		System.out.println(compte1.toString());

		System.out.println("--------------------------*********************************--------------------------");
		System.out.println(compte2.toString());
		int mnt2 = 50;
		
		tr2 = new Transaction("versement",compte2,mnt2,p);
		
		tc.Versement(tr2);
		
		System.out.println("------------------ APRES Versement ------------");
		compte2 = cp.Get_One_Compte("1063050");
		System.out.println(compte2.toString());
		
		

		tr = new Transaction("virement",compte2,compte1,mnt1,p);
		tc.virement(tr);
		
		System.out.println("------------------ APRES VIRMETNT -------------");
		
		compte1 = cp.Get_One_Compte("1076231");
		compte2 = cp.Get_One_Compte("1063050");
		
		System.out.println(compte1.toString());
		System.out.println(compte2.toString());


		c = new Client("Ahmed","Oun",21658435,"Hamem l'inf ",p); 
		
		cc.Add_Client(c);
		
		Compte mycompte = new Compte("1076231",c,3500,today.toString());
		cp.Add_Compte(mycompte);
	
		System.out.println(compte);
		ArrayList<Compte> arc = new ArrayList<Compte>();
		
		arc = cp.Get_Comptes();
		
		Iterator<Compte> itc = arc.iterator(); 
		while (itc.hasNext()) { 
           System.out.print(itc.next()); 
        }*/
	}
}
