package com.banque.app;
import com.banque.controlers.Client_controller;
import com.banque.models.Client;
import com.banque.models.Employe;

import java.util.UUID;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Client_controller cc = new Client_controller();
		cc.Connexion();
		Client c;
		//Employe p = new Employe("Hanchi","Ahmed","hanchi.ahmed@yahoo.fr","hanchi123");
	//	Client c = new Client("sticky bit","ben romdhan",24651253,"ariana corona",p); 
//		cc.Add_Client(c);
		c = cc.Get_One_Client("ab1b5f37-3e39-4e04-95f8-15a12cc7936d");
		c.toString();
	}

}
