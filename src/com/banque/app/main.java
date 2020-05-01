package com.banque.app;
import com.banque.controlers.Client_controller;
import com.banque.controlers.Compte_controller;
import com.banque.controlers.Transaction_controller;
import com.banque.models.Client;
import com.banque.models.Compte;
import com.banque.models.Employe;

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
		cp.Connexion();
		cc.Connexion();
		tc.Connexion();
		
		Client c;
		Employe p;
		Compte compte1,compte2;
		
		compte1 = cp.Get_One_Compte("1076231");
		compte2 = cp.Get_One_Compte("1063050");
		
		System.out.println("------------------ AVANT VIRMETNT -------------");
		System.out.println(compte1.toString());
		System.out.println(compte2.toString());
		
		tc.Virment(compte2,compte1,650);
		System.out.println("------------------ APRES VIRMETNT -------------");
		compte1 = cp.Get_One_Compte("1076231");
		compte2 = cp.Get_One_Compte("1063050");
		System.out.println(compte1.toString());
		System.out.println(compte2.toString());

		/*
		p = new Employe("Hanchi","Ahmed","hanchi.ahmed@yahoo.fr","hanchi123");
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
