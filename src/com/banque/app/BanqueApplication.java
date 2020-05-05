package com.banque.app;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.banque.controlers.Client_controller;
import com.banque.controlers.Compte_controller;
import com.banque.controlers.Employe_controller;
import com.banque.controlers.Transaction_controller;
import com.banque.models.Client;
import com.banque.models.Compte;
import com.banque.models.Employe;
import com.banque.models.Transaction;

import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Component;

public class BanqueApplication {
	private Compte cEmetteur,cBenef,compte;
	private Compte_controller cc;
	private Employe_controller ec;
	private Employe employe;
	private Transaction_controller tc;
	private Transaction transaction; 
	private Client_controller CCli;
	private Client client, Newclient;
	private ArrayList<Client> arc ;
	private ArrayList<Client> titulairesArray ;
	private ArrayList<Compte> list;
	private ArrayList<Transaction> TransactionArray , TransactionArrayRecherche;
	private int numCompte;
	private String type;
	
	
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panel_transaction;
	private JLayeredPane layeredPane;
	private JTextField emetteur;
	private ButtonGroup G1;
	private JRadioButton versement,virement,retrait; 
	private JLabel Client_description,benef_text,message;
	private JPanel panel_emetteur,panel_benef,panel_solde,panel_compte,panel_Client,panel_1 ;
	private JTextField benef;
	private JTextField solde;


	private JTable table_3 , table_transaction;
	private JTextField NameTextfield;
	private JTextField lastnametextfield;
	private JTextField phonetextfield;
	private JTextField adressetextfield;
	private JScrollPane scrollPane,scrollPane_compte;
	private JTable jTable,mytable;
	private JPanel panel_5;
	private JComboBox titulaire ;
	private DefaultListModel<String> modelComboBox;
	private DefaultTableModel contactTableModel;
	private JLabel lblNewLabel_8;
	private JTextField numcompteTextField;
	private JLabel lblNewLabel_9;
	private JTextField newCompteSolde;
	private JPanel CreateTransactionHolder;
	private JButton addtransaction;
	private JButton btnListeTransaction;
	private JPanel TransactionListHolder;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_10;
	private JTextField recherchenum;
	private JLabel lblNewLabel_11;
	private JTextField rechergebegin;
	private JLabel lblNewLabel_12;
	private JTextField rechercheend;
	private JScrollPane transactionScrollPan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanqueApplication window = new BanqueApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BanqueApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Banque JAVA ");
		frame.setBounds(100, 100, 770, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 49, 754, 506);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_176753858122200");
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(34, 45, 65));
		panel.add(panel_3, "name_177190634784400");
		
		
        
        panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBounds(0, 0, 754, 45);
        frame.getContentPane().add(panel_1);
		panel_1.setVisible(false);
		
		
		JButton button = new JButton("VALIDER");
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusPainted(false);
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String login = textField.getText();
				String mdp = passwordField.getText();
				ec = new Employe_controller();
				ec.Connexion();
				employe = ec.Login(login, mdp);
				if(employe != null ) {
					JOptionPane.showMessageDialog(null, " Bienvenue "+employe.getNom() +" "+employe.getMotdepasse() +" :D <3  " );	
					panel_1.setVisible(true);
					layeredPane.removeAll();
					layeredPane.add(panel_transaction);
					layeredPane.repaint();
					layeredPane.revalidate();
					
				}else {
					JOptionPane.showMessageDialog(null, " Login ou mot de passe incorrecte " );	
				}
			}
		});
		button.setMargin(new Insets(10, 14, 10, 14));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		button.setBackground(new Color(93, 211, 195));
		button.setBounds(432, 380, 167, 40);
		panel_3.add(button);
		
		textField = new JTextField();
		textField.setToolTipText("Your email adresse\r\n");
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textField.setBackground(new Color(34, 45, 65));
		textField.setBounds(432, 208, 250, 29);
		panel_3.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setDisabledTextColor(new Color(51, 102, 204));
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBackground(new Color(34, 45, 65));
		passwordField.setBounds(432, 301, 250, 29);
		panel_3.add(passwordField);
		
		JLabel label = new JLabel("Email");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		label.setBounds(432, 174, 160, 23);
		panel_3.add(label);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe ");
		lblMotDePasse.setForeground(Color.WHITE);
		lblMotDePasse.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lblMotDePasse.setBounds(432, 267, 228, 23);
		panel_3.add(lblMotDePasse);
		
		JLabel lblJavaBanqueApplication = new JLabel("Banque Application");
		lblJavaBanqueApplication.setHorizontalTextPosition(SwingConstants.CENTER);
		lblJavaBanqueApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblJavaBanqueApplication.setForeground(Color.WHITE);
		lblJavaBanqueApplication.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 25));
		lblJavaBanqueApplication.setBounds(432, 26, 276, 78);
		panel_3.add(lblJavaBanqueApplication);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(95, 210, 195));
		panel_4.setBounds(-15, 0, 418, 544);
		panel_3.add(panel_4);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\ahmed\\Desktop\\images\\kisspng-financial-services-finance-business-computer-icons-services-5ac0b676a4fb93.0520531715225790626758.png"));
		label_4.setBounds(-37, -12, 467, 529);
		panel_4.add(label_4);
		
		panel_transaction = new JPanel();
		layeredPane.add(panel_transaction, "name_176994971202900");
		panel_transaction.setLayout(null);
		
        G1 = new ButtonGroup(); 
				/*
				 *	AJOUTER   TRANSACTION ----------------------------------------------------------
				 */
				
		CreateTransactionHolder = new JPanel();
		CreateTransactionHolder.setBounds(20, 52, 712, 337);
		panel_transaction.add(CreateTransactionHolder);
		CreateTransactionHolder.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cr\u00E9e une nouvelle Transaction");
		lblNewLabel.setBounds(23, 11, 381, 38);
		CreateTransactionHolder.add(lblNewLabel);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setFocusable(false);
		lblNewLabel.setFocusTraversalKeysEnabled(false);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		
		virement = new JRadioButton("Virement");
		virement.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		virement.setBounds(23, 63, 109, 23);
		CreateTransactionHolder.add(virement);
		G1.add(virement);
				
						
		versement = new JRadioButton("Versement");
		versement.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		versement.setBounds(134, 63, 109, 23);
		CreateTransactionHolder.add(versement);
		G1.add(versement);
						
								
		retrait = new JRadioButton("Retrait");
		retrait.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		retrait.setBounds(245, 63, 109, 23);
		CreateTransactionHolder.add(retrait);
		G1.add(retrait);
		
		JButton button_2 = new JButton("Valider");
		button_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		button_2.setBounds(461, 63, 89, 23);
		CreateTransactionHolder.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				if (virement.isSelected()) { 
					type = "virement";
					panel_emetteur.setVisible(true);
		
				}else if (versement.isSelected()) {
					type = "versement";
					emetteur.setEnabled(false);
					panel_benef.setVisible(true);
				}else { 
					type = "retrait";
					panel_benef.setVisible(true);
				} 		
			}
		});
		button_2.setFocusable(false);
		
		panel_emetteur = new JPanel();
		panel_emetteur.setBounds(10, 93, 574, 62);
		CreateTransactionHolder.add(panel_emetteur);
		panel_emetteur.setVisible(false);
		panel_emetteur.setLayout(null);

		
		JLabel lblNewLabel_1 = new JLabel("Numero du compte du emetteur :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(22, 11, 228, 14);
		panel_emetteur.add(lblNewLabel_1);
		
		emetteur = new JTextField();
		emetteur.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		emetteur.setBounds(239, 8, 201, 23);
		panel_emetteur.add(emetteur);
		emetteur.setColumns(10);
		
		Client_description = new JLabel("");
		Client_description.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		Client_description.setBounds(22, 37, 517, 14);
		panel_emetteur.add(Client_description);
		
		JButton val_emetteur = new JButton("Valider");
		val_emetteur.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		val_emetteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( emetteur.getText() != null) {
					cc = new Compte_controller();
					cc.Connexion();
					cEmetteur = cc.Get_One_Compte(emetteur.getText());
					if(cEmetteur != null ) {
						Client_description.setText("Le compte : "+cEmetteur.getNumcompte()+", client : "+cEmetteur.getTitulaire().getNom()+" "+cEmetteur.getTitulaire().getPrenom()+" , solde : "+cEmetteur.getSolde()+" DT ");
						panel_benef.setVisible(true);	
					}else {
						JOptionPane.showMessageDialog(null, " Numero de compte incorrecte " );
					}
				}else {
					JOptionPane.showMessageDialog(null, " Champ vide " );
				}
			}
		});
		val_emetteur.setFocusable(false);
		val_emetteur.setBounds(450, 7, 89, 23);
		panel_emetteur.add(val_emetteur);
		
		panel_benef = new JPanel();
		panel_benef.setBounds(10, 161, 574, 62);
		CreateTransactionHolder.add(panel_benef);
		panel_benef.setVisible(false);
		panel_benef.setLayout(null);
		
		JLabel label_5 = new JLabel("Numero du compte du beneficiaire :");
		label_5.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		label_5.setBounds(22, 11, 207, 14);
		panel_benef.add(label_5);
		
		benef = new JTextField();
		benef.setColumns(10);
		benef.setBounds(239, 7, 201, 23);
		panel_benef.add(benef);
		
		benef_text = new JLabel("");
		benef_text.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		benef_text.setBounds(22, 36, 517, 14);
		panel_benef.add(benef_text);
		
		JButton button_4 = new JButton("Valider");
		button_4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( benef.getText()!= null) {
					cc = new Compte_controller();
					cc.Connexion();
					cBenef = cc.Get_One_Compte(benef.getText());
					if(cBenef != null) {
						benef_text.setText("Le compte : "+cBenef.getNumcompte()+", client : "+cBenef.getTitulaire().getNom()+" "+cBenef.getTitulaire().getPrenom()+" , solde : "+cBenef.getSolde()+" DT ");
						panel_solde.setVisible(true);

					}else {
						JOptionPane.showMessageDialog(null, " Numero de compte incorrecte " );
					}
				}else {
					JOptionPane.showMessageDialog(null, " Champ vide !" );
				}
			}
		});
		button_4.setFocusable(false);
		button_4.setBounds(450, 7, 89, 23);
		panel_benef.add(button_4);
		
		
		
		//---------------------------------------------------------------------------Validate Transaction -----------------
		panel_solde = new JPanel();
		panel_solde.setBounds(10, 234, 574, 103);
		CreateTransactionHolder.add(panel_solde);
		panel_solde.setVisible(false);
		panel_solde.setLayout(null);
		JButton btnValiderTransaction = new JButton("Valider Transaction");
		btnValiderTransaction.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		btnValiderTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(solde.getText()!= null) {
					int mnt = Integer.parseInt(solde.getText());
					tc = new Transaction_controller();
					tc.Connexion();
					if( type == "virement") {
						transaction = new Transaction(type, cEmetteur, cBenef,mnt,employe);
						tc.virement(transaction);
						int CompteEmetteurIndex = 0 , CompteBenfIndex = 0;
						int EmetteurSolde = 0 , BenefSold = 0;
						for(int i = 0; i < list.size();i++) {
							if( cEmetteur.getNumcompte().equals(list.get(i).getNumcompte()) ) {
								CompteEmetteurIndex = i;
								EmetteurSolde = cEmetteur.getSolde() - mnt ;
							}
							if( cBenef.getNumcompte().equals(list.get(i).getNumcompte()) ) {
								CompteBenfIndex = i;
								BenefSold = cBenef.getSolde() + mnt ;
							}
						}
						DefaultTableModel ChangeSoldeEmetteurAndBenf = (DefaultTableModel) jTable.getModel();
					    jTable.setModel(ChangeSoldeEmetteurAndBenf);
					    ChangeSoldeEmetteurAndBenf.setValueAt(EmetteurSolde+"",CompteEmetteurIndex , 3);
					    ChangeSoldeEmetteurAndBenf.setValueAt(BenefSold+"",CompteBenfIndex , 3);

					}else if(type == "versement"){
						transaction = new Transaction(type,cBenef,mnt,employe);
						tc.Versement(transaction);
						int CompteBenfIndex = 0;
						int BenefSold = 0;
						for(int i = 0; i < list.size();i++) {
							if( cBenef.getNumcompte().equals(list.get(i).getNumcompte()) ) {
								CompteBenfIndex = i;
								BenefSold = cBenef.getSolde() + mnt ;
							}
						}
						DefaultTableModel ChangeSoldeEmetteurAndBenf = (DefaultTableModel) jTable.getModel();
					    jTable.setModel(ChangeSoldeEmetteurAndBenf);
					    ChangeSoldeEmetteurAndBenf.setValueAt(BenefSold+"",CompteBenfIndex , 3);
						
					}else {
						transaction = new Transaction(type,cBenef,mnt,employe);
						tc.Retrait(transaction);
						int CompteBenfIndex = 0;
						int BenefSold = 0;
						for(int i = 0; i < list.size();i++) {
							if( cBenef.getNumcompte().equals(list.get(i).getNumcompte()) ) {
								CompteBenfIndex = i;
								BenefSold = cBenef.getSolde() - mnt ;
							}
						}
						DefaultTableModel ChangeSoldeEmetteurAndBenf = (DefaultTableModel) jTable.getModel();
					    jTable.setModel(ChangeSoldeEmetteurAndBenf);
					    ChangeSoldeEmetteurAndBenf.setValueAt(BenefSold+"",CompteBenfIndex , 3);
					}
					JOptionPane.showMessageDialog(null, " Transaction effectuer " );
					resetForm();
				}
			}
		});
		

		btnValiderTransaction.setFocusable(false);
		btnValiderTransaction.setBounds(22, 47, 161, 23);
		panel_solde.add(btnValiderTransaction);
		
		JLabel lblMontantDeLa = new JLabel("Montant de la transaction");
		lblMontantDeLa.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		lblMontantDeLa.setBounds(22, 11, 228, 14);
		panel_solde.add(lblMontantDeLa);
		
		solde = new JTextField();
		solde.setColumns(10);
		solde.setBounds(239, 8, 201, 23);
		panel_solde.add(solde);
		
		JButton button_3 = new JButton("R�initialiser");
		button_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		button_3.setBounds(210, 47, 161, 23);
		panel_solde.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emetteur.setEnabled(true);
				panel_benef.setVisible(false);
				panel_solde.setVisible(false);
				resetForm();
			}
		});
		button_3.setFocusable(false);
		
		message = new JLabel("");
		message.setBounds(22, 78, 317, 14);
		panel_solde.add(message);
		
		addtransaction = new JButton("Ajouter transaction");
		addtransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionListHolder.setVisible(false);
				CreateTransactionHolder.setVisible(true);
			}
		});
		addtransaction.setFocusPainted(false);
		addtransaction.setFocusTraversalKeysEnabled(false);
		addtransaction.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(255, 255, 255)));
		addtransaction.setBackground(new Color(34, 45, 65));
		addtransaction.setFocusable(false);
		addtransaction.setForeground(Color.WHITE);
		addtransaction.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		addtransaction.setBounds(20, 0, 348, 41);
		panel_transaction.add(addtransaction);
		
		btnListeTransaction = new JButton("Liste Transaction");
		btnListeTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateTransactionHolder.setVisible(false);
				TransactionListHolder.setVisible(true);
			}
		});
		btnListeTransaction.setFocusPainted(false);
		btnListeTransaction.setFocusTraversalKeysEnabled(false);
		btnListeTransaction.setFocusable(false);
		btnListeTransaction.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(255, 255, 255)));
		btnListeTransaction.setBackground(new Color(34, 45, 65));
		btnListeTransaction.setForeground(Color.WHITE);
		btnListeTransaction.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		btnListeTransaction.setBounds(367, 0, 365, 41);
		panel_transaction.add(btnListeTransaction);
		
		TransactionListHolder = new JPanel();
		TransactionListHolder.setBounds(10, 55, 734, 428);
		panel_transaction.add(TransactionListHolder);
		TransactionListHolder.setVisible(false);
		TransactionListHolder.setLayout(null);
		
		btnNewButton_1 = new JButton("Recherche");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(recherchenum.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Champ vide !" );	
				}else {
					
					tc =  new Transaction_controller();
					tc.Connexion();						
					TransactionArrayRecherche = new ArrayList<Transaction>();
					TransactionArrayRecherche = tc.Get_Client_Transaction(recherchenum.getText());
					if (rechergebegin.getText().isEmpty() && rechercheend.getText().isEmpty()) {
						if(TransactionArrayRecherche.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Compte introuvable" );	
						}else {
							DefaultTableModel tableModelCompte = (DefaultTableModel) table_transaction.getModel();
							while (tableModelCompte.getRowCount()>0){
								tableModelCompte.removeRow(0);
							}
							table_transaction.setModel(tableModelCompte);
							for(int i = 0 ; i < TransactionArrayRecherche.size();i++ ) {
								System.out.println(TransactionArrayRecherche.get(i));
					           	String fullname = " ";
					            String emet = " ";
					            if(TransactionArrayRecherche.get(i).getBeneficiaire() != null) {
					            	fullname =  TransactionArrayRecherche.get(i).getBeneficiaire().getTitulaire().getNom()+" "+TransactionArrayRecherche.get(i).getBeneficiaire().getTitulaire().getPrenom();
					            	emet = TransactionArrayRecherche.get(i).getBeneficiaire().getNumcompte();	
					            }
					 		   	String transaction = TransactionArrayRecherche.get(i).getType();
					 		   	String montant = TransactionArrayRecherche.get(i).getMontant()+" ";
					 		   	String emetteur = TransactionArrayRecherche.get(i).getEmetteur().getTitulaire().getNom()+" "+TransactionArrayRecherche.get(i).getEmetteur().getTitulaire().getPrenom();
					 		   	String EmCompte = TransactionArrayRecherche.get(i).getEmetteur().getNumcompte();
					 		   	String solde = TransactionArrayRecherche.get(i).getEmetteur().getSolde()+" ";
					 		   	String Responsable = TransactionArrayRecherche.get(i).getResponsable().getMail();
					 		   	String date = TransactionArrayRecherche.get(i).getDate_transaction();								
							    tableModelCompte.addRow(new Object[]{emetteur ,EmCompte,transaction,fullname,emet,montant,solde,Responsable,date});						
							}
						}
					}else if(!rechergebegin.getText().isEmpty() && rechercheend.getText().isEmpty() ) {
						if(rechergebegin.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
							TransactionArrayRecherche = tc.Get_Client_Transaction_by_date_Only_Begin(recherchenum.getText(),rechergebegin.getText());
							DefaultTableModel tableModelCompte = (DefaultTableModel) table_transaction.getModel();
							while (tableModelCompte.getRowCount()>0){
								tableModelCompte.removeRow(0);
							}
							table_transaction.setModel(tableModelCompte);
							for(int i = 0 ; i < TransactionArrayRecherche.size();i++ ) {
								System.out.println(TransactionArrayRecherche.get(i));
					           	String fullname = " ";
					            String emet = " ";
					            if(TransactionArrayRecherche.get(i).getBeneficiaire() != null) {
					            	fullname =  TransactionArrayRecherche.get(i).getBeneficiaire().getTitulaire().getNom()+" "+TransactionArrayRecherche.get(i).getBeneficiaire().getTitulaire().getPrenom();
					            	emet = TransactionArrayRecherche.get(i).getBeneficiaire().getNumcompte();	
					            }
					 		   	String transaction = TransactionArrayRecherche.get(i).getType();
					 		   	String montant = TransactionArrayRecherche.get(i).getMontant()+" ";
					 		   	String emetteur = TransactionArrayRecherche.get(i).getEmetteur().getTitulaire().getNom()+" "+TransactionArrayRecherche.get(i).getEmetteur().getTitulaire().getPrenom();
					 		   	String EmCompte = TransactionArrayRecherche.get(i).getEmetteur().getNumcompte();
					 		   	String solde = TransactionArrayRecherche.get(i).getEmetteur().getSolde()+" ";
					 		   	String Responsable = TransactionArrayRecherche.get(i).getResponsable().getMail();
					 		   	String date = TransactionArrayRecherche.get(i).getDate_transaction();								
							    tableModelCompte.addRow(new Object[]{emetteur ,EmCompte,transaction,fullname,emet,montant,solde,Responsable,date});						
							}
						}else {
							JOptionPane.showMessageDialog(null, "Date Format Annee-mois-jour exemple 2020-05-01" );	
						}
					}else {
						System.out.println(" begin - end ");
						if(rechergebegin.getText().matches("\\d{4}-\\d{2}-\\d{2}") && rechercheend.getText().matches("\\d{4}-\\d{2}-\\d{2}")) {
							TransactionArrayRecherche = tc.Get_Client_Transaction_by_date(recherchenum.getText(),rechergebegin.getText(),rechercheend.getText());
							DefaultTableModel tableModelCompte = (DefaultTableModel) table_transaction.getModel();
							while (tableModelCompte.getRowCount()>0){
								tableModelCompte.removeRow(0);
							}
							table_transaction.setModel(tableModelCompte);
							for(int i = 0 ; i < TransactionArrayRecherche.size();i++ ) {
								System.out.println(TransactionArrayRecherche.get(i));
					           	String fullname = " ";
					            String emet = " ";
					            if(TransactionArrayRecherche.get(i).getBeneficiaire() != null) {
					            	fullname =  TransactionArrayRecherche.get(i).getBeneficiaire().getTitulaire().getNom()+" "+TransactionArrayRecherche.get(i).getBeneficiaire().getTitulaire().getPrenom();
					            	emet = TransactionArrayRecherche.get(i).getBeneficiaire().getNumcompte();	
					            }
					 		   	String transaction = TransactionArrayRecherche.get(i).getType();
					 		   	String montant = TransactionArrayRecherche.get(i).getMontant()+" ";
					 		   	String emetteur = TransactionArrayRecherche.get(i).getEmetteur().getTitulaire().getNom()+" "+TransactionArrayRecherche.get(i).getEmetteur().getTitulaire().getPrenom();
					 		   	String EmCompte = TransactionArrayRecherche.get(i).getEmetteur().getNumcompte();
					 		   	String solde = TransactionArrayRecherche.get(i).getEmetteur().getSolde()+" ";
					 		   	String Responsable = TransactionArrayRecherche.get(i).getResponsable().getMail();
					 		   	String date = TransactionArrayRecherche.get(i).getDate_transaction();								
							    tableModelCompte.addRow(new Object[]{emetteur ,EmCompte,transaction,fullname,emet,montant,solde,Responsable,date});						
							}
						}else {
							JOptionPane.showMessageDialog(null, "Date Format Annee-mois-jour exemple 2020-05-01" );	
						}
					}
				}
			}
		});
		btnNewButton_1.setFocusTraversalKeysEnabled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		btnNewButton_1.setBounds(10, 61, 126, 23);
		TransactionListHolder.add(btnNewButton_1);
		
		lblNewLabel_10 = new JLabel("Numero de compte :");
		lblNewLabel_10.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		lblNewLabel_10.setBounds(10, 11, 126, 14);
		TransactionListHolder.add(lblNewLabel_10);
		
		recherchenum = new JTextField();
		recherchenum.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		recherchenum.setBounds(146, 8, 139, 20);
		TransactionListHolder.add(recherchenum);
		recherchenum.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Date debut recherche :");
		lblNewLabel_11.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(10, 36, 131, 14);
		TransactionListHolder.add(lblNewLabel_11);
		
		rechergebegin = new JTextField();
		rechergebegin.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 11));
		rechergebegin.setBounds(146, 33, 139, 20);
		TransactionListHolder.add(rechergebegin);
		rechergebegin.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Date fin recherche : ");
		lblNewLabel_12.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		lblNewLabel_12.setBounds(321, 36, 131, 14);
		TransactionListHolder.add(lblNewLabel_12);
		
		rechercheend = new JTextField();
		rechercheend.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 11));
		rechercheend.setBounds(444, 33, 119, 20);
		TransactionListHolder.add(rechercheend);
		rechercheend.setColumns(10);
		
		LoadTransaction();
		transactionScrollPan = new JScrollPane(table_transaction);
		transactionScrollPan.setBounds(0, 104, 734, 324);
		TransactionListHolder.add(transactionScrollPan);
		
		JButton btnNewButton_4 = new JButton("Annuler");
		btnNewButton_4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		btnNewButton_4.setBounds(146, 62, 139, 23);
		TransactionListHolder.add(btnNewButton_4);
			    
		panel_compte = new JPanel();
		layeredPane.add(panel_compte, "name_176997634846200");
		panel_compte.setLayout(null);
	
		loadComptesTable();
		scrollPane_compte = new JScrollPane(jTable);
		scrollPane_compte.setBounds(10, 191, 734, 291);
        panel_compte.add(scrollPane_compte);
        
        panel_5 = new JPanel();
        panel_5.setBounds(20, 11, 642, 141);
        panel_compte.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblNewLabel_7 = new JLabel("Nom et prenom du client :");
        lblNewLabel_7.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNewLabel_7.setBounds(10, 11, 163, 14);
        panel_5.add(lblNewLabel_7);
        
        titulaire = new JComboBox();
        loadTitulairComboBox();
        titulaire.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
            	int index = titulaire.getSelectedIndex(); 
            	Newclient = titulairesArray.get(index);
            	cc = new Compte_controller();
            	cc.Connexion();
            	numCompte = cc.new_Compte_num();
            	numcompteTextField.setText(numCompte+"");
            }
        });
		

        titulaire.setBounds(194, 8, 352, 20);
        panel_5.add(titulaire);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(0, 36, 632, 105);
        panel_5.add(panel_6);
        panel_6.setLayout(null);
        
        lblNewLabel_8 = new JLabel("Numero de nouveau compte :");
        lblNewLabel_8.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNewLabel_8.setBounds(10, 11, 175, 14);
        panel_6.add(lblNewLabel_8);
        
        numcompteTextField = new JTextField();
        numcompteTextField.setEnabled(false);
        numcompteTextField.setBounds(195, 8, 351, 20);
        panel_6.add(numcompteTextField);
        numcompteTextField.setColumns(10);
        
        lblNewLabel_9 = new JLabel("Solde :");
        lblNewLabel_9.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNewLabel_9.setBounds(10, 39, 46, 14);
        panel_6.add(lblNewLabel_9);
        
        newCompteSolde = new JTextField();
        newCompteSolde.setBounds(195, 36, 351, 20);
        panel_6.add(newCompteSolde);
        newCompteSolde.setColumns(10);
        
        JButton btnNewButton = new JButton("Valider");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(newCompteSolde.getText() != "" || Newclient != null ) {
                	cc = new Compte_controller();
                	cc.Connexion();
                	compte = new Compte(numCompte+"",Newclient,Integer.parseInt(newCompteSolde.getText())); 
                	cc.Add_Compte(compte);
                	
					JOptionPane.showMessageDialog(null, " Le Compte � �t� ajouter " );

				    DefaultTableModel tableModelCompte = (DefaultTableModel) jTable.getModel();
				    jTable.setModel(tableModelCompte);
				    tableModelCompte.addRow(new Object[]{compte.getTitulaire().getNom() +" "+compte.getTitulaire().getPrenom() ,compte.getTitulaire().getTel()+"" ,compte.getNumcompte(), compte.getSolde()+"DT", "aujourd'hui"});
					
        		}
        	}
        });
        btnNewButton.setBounds(10, 71, 131, 23);
        panel_6.add(btnNewButton);
		
		panel_Client = new JPanel();
		layeredPane.add(panel_Client, "name_195965575302300");        

		loadClientTable();
        scrollPane = new JScrollPane(table_3);        
        scrollPane.setBounds(10, 191, 734, 291);
        panel_Client.add(scrollPane);
        
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 25, 734, 153);
        panel_Client.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Nom :");
        lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(10, 39, 61, 14);
        panel_2.add(lblNewLabel_3);
        
        JLabel lblNewLabel_2 = new JLabel("Ajouter Client");
        lblNewLabel_2.setBounds(10, 0, 133, 24);
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
        panel_2.add(lblNewLabel_2);
        
        NameTextfield = new JTextField();
        NameTextfield.setBounds(91, 36, 171, 20);
        panel_2.add(NameTextfield);
        NameTextfield.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Prenom :");
        lblNewLabel_4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(296, 39, 51, 14);
        panel_2.add(lblNewLabel_4);
        
        lastnametextfield = new JTextField();
        lastnametextfield.setBounds(357, 36, 171, 20);
        panel_2.add(lastnametextfield);
        lastnametextfield.setColumns(10);
        
        phonetextfield = new JTextField();
        phonetextfield.setBounds(91, 72, 171, 20);
        panel_2.add(phonetextfield);
        phonetextfield.setColumns(10);
        
        adressetextfield = new JTextField();
        adressetextfield.setBounds(357, 72, 171, 20);
        panel_2.add(adressetextfield);
        adressetextfield.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Telephone :");
        lblNewLabel_5.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(10, 75, 71, 14);
        panel_2.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Adresse :");
        lblNewLabel_6.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(296, 75, 72, 14);
        panel_2.add(lblNewLabel_6);
        
        JButton btnNewButton_2 = new JButton("Ajouter");
        btnNewButton_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
           		String name = NameTextfield.getText();
        		String lastname = lastnametextfield.getText();
        		int tel = Integer.parseInt(phonetextfield.getText());
        		String adress = adressetextfield.getText();
        		if( adress == "" || name == "" || lastname == "" || phonetextfield.getText() == "" ) {
					JOptionPane.showMessageDialog(null, " Les champs sont obligatoire " );
        		}else {
    				client = new Client(name,lastname,tel,adress,employe);
					CCli = new Client_controller();
					CCli.Connexion();
					CCli.Add_Client(client);
					JOptionPane.showMessageDialog(null, " Client � �t� ajouter " );

				    DefaultTableModel tableModel = (DefaultTableModel) table_3.getModel();
				    table_3.setModel(tableModel);
				    tableModel.addRow(new Object[]{client.getNom() +" "+client.getPrenom() ,client.getTel()+"" ,client.getAdress(), employe.getNom()+" "+employe.getPernom()});
					titulaire.addItem(client.getPrenom()+" "+client.getNom()+" ");
					titulairesArray.add(client);
	           		NameTextfield.setText("");
	        		lastnametextfield.setText("");
	        		phonetextfield.setText("");
	        		adressetextfield.setText("");
        		}
        	}
        });
        btnNewButton_2.setBounds(91, 103, 96, 23);
        panel_2.add(btnNewButton_2);
        JButton btnNewButton_3 = new JButton("R\u00E9initialiser");
        btnNewButton_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
           		NameTextfield.setText("");
        		lastnametextfield.setText("");
        		phonetextfield.setText("");
        		adressetextfield.setText("");	
        	}
        });
        btnNewButton_3.setBounds(197, 103, 110, 23);
        panel_2.add(btnNewButton_3);

        
        JButton button_1 = new JButton("Clients");
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(panel_Client);
				layeredPane.repaint();
				layeredPane.revalidate();
        	}
        });
        button_1.setForeground(Color.WHITE);
        button_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
        button_1.setFocusable(false);
        button_1.setFocusTraversalKeysEnabled(false);
        button_1.setFocusPainted(false);
        button_1.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(255, 255, 255)));
        button_1.setBackground(new Color(34, 45, 65));
        button_1.setBounds(486, 2, 268, 45);
        panel_1.add(button_1);
        
        JButton button_8 = new JButton("Compte");
        button_8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(panel_compte);
				layeredPane.repaint();
				layeredPane.revalidate();
        	}
        });
        button_8.setForeground(Color.WHITE);
        button_8.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
        button_8.setFocusable(false);
        button_8.setFocusTraversalKeysEnabled(false);
        button_8.setFocusPainted(false);
        button_8.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(255, 255, 255)));
        button_8.setBackground(new Color(34, 45, 65));
        button_8.setBounds(0, 2, 251, 45);
        panel_1.add(button_8);
        
        JButton button_9 = new JButton("Transaction");
        button_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				layeredPane.removeAll();
				layeredPane.add(panel_transaction);
				layeredPane.repaint();
				layeredPane.revalidate();
        	}
        });
        button_9.setForeground(Color.WHITE);
        button_9.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
        button_9.setFocusTraversalKeysEnabled(false);
        button_9.setFocusPainted(false);
        button_9.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(255, 255, 255)));
        button_9.setBackground(new Color(34, 45, 65));
        button_9.setBounds(248, 2, 240, 45);
        panel_1.add(button_9);
		


	}


	public void loadTitulairComboBox() {
		CCli = new Client_controller();
		CCli.Connexion();
		titulairesArray = new ArrayList<Client>();
		titulairesArray = CCli.Get_Client();    
		for (int i = 0; i < titulairesArray.size(); i++){
			titulaire.addItem(titulairesArray.get(i).getPrenom()+" "+titulairesArray.get(i).getNom()+" ");
		}

	}

	public void loadComptesTable() {
    	cc = new Compte_controller();
    	cc.Connexion();
	    list = new ArrayList<Compte>();
        list = cc.Get_Comptes();
        
        Vector<String> header = new Vector<String>();
        
        header.add("NOM ET PRENOM"); 
        header.add("TELEPHONE");
        header.add("COMPTE");
        header.add("SOLDE");
        header.add("DATE DE CREATION" );

        Vector<Vector<Object>> data = new  Vector<Vector<Object>>();
		for (int i = 0; i < list.size(); i++){

           Vector<Object> row = new Vector<Object>();
 		   String fullname = list.get(i).getTitulaire().getNom()+" "+list.get(i).getTitulaire().getPrenom();
 		   String tel = list.get(i).getTitulaire().getTel()+"";
 		   String numcompte = list.get(i).getNumcompte();
 		   String solde = list.get(i).getSolde()+" DT ";
 		   String creation = list.get(i).getDate_creation();

            row.add(fullname);
            row.add(tel); 
            row.add(numcompte); 
            row.add(solde);
            row.add(creation);
            data.add(row);
        }		
		
		
        panel_compte.setLayout(null);	
        jTable = new JTable(data,header);

	}

	
	
	public void loadClientTable() {
		CCli = new Client_controller();
		CCli.Connexion();
    	arc = new ArrayList<Client>();
        arc = CCli.Get_Client();       
        Vector<String> header = new Vector<String>();
        header.add("NOM ET PRENOM"); 
        header.add("TELEPHONE");
        header.add("ADRESSE");
        header.add("RESPONSABLE");
        Vector<Vector<Object>> data = new  Vector<Vector<Object>>();
		for (int i = 0; i < arc.size(); i++){

            Vector<Object> row = new Vector<Object>();
 		   	String fullname = arc.get(i).getNom()+" "+arc.get(i).getPrenom();
 		   	String tel = arc.get(i).getTel()+"";
 		   	String adress = arc.get(i).getAdress();
 		   	String Responsable = arc.get(i).getEmploye().getNom()+" "+arc.get(i).getEmploye().getPernom();
            row.add(fullname);
            row.add(tel); 
            row.add(adress); 
            row.add(Responsable);
            data.add(row);
        }
        panel_Client.setLayout(null);	
        table_3 = new JTable(data,header);
	}
	public void LoadTransaction() {
		tc =  new Transaction_controller();
		tc.Connexion();
    	TransactionArray = new ArrayList<Transaction>();
    	TransactionArray = tc.Get_transactions();
        Vector<String> header = new Vector<String>();
        
        header.add("EMETTERUR");
        header.add("COMPTE");
        header.add("TYPE");
        header.add("BENEFICIAIRE"); 
        header.add("COMPTE ");
        header.add("MONTANT");
        header.add("SOLDE");
        header.add("Responsable");
        header.add("DATE");
        Vector<Vector<Object>> data = new  Vector<Vector<Object>>();

    	TransactionArray = tc.Get_transactions();
		for (int i = 0; i < TransactionArray.size(); i++){
			System.out.println(TransactionArray.get(i).getResponsable());
            Vector<Object> row = new Vector<Object>();
            String fullname = " ";
            String emet = " ";
            if(TransactionArray.get(i).getBeneficiaire() != null) {
            	fullname =  TransactionArray.get(i).getBeneficiaire().getTitulaire().getNom()+" "+TransactionArray.get(i).getBeneficiaire().getTitulaire().getPrenom();
            	emet = TransactionArray.get(i).getBeneficiaire().getNumcompte();	
            }
 		   	String transaction = TransactionArray.get(i).getType();
 		   	String montant = TransactionArray.get(i).getMontant()+" ";
 		   	String emetteur = TransactionArray.get(i).getEmetteur().getTitulaire().getNom()+" "+TransactionArray.get(i).getEmetteur().getTitulaire().getPrenom();
 		   	String EmCompte = TransactionArray.get(i).getEmetteur().getNumcompte();
 		   	String solde = TransactionArray.get(i).getEmetteur().getSolde()+" ";
 		   	String Responsable = TransactionArray.get(i).getResponsable().getMail();
 		   	String date = TransactionArray.get(i).getDate_transaction();
            row.add(emetteur);
            row.add(EmCompte);
            row.add(transaction); 
            row.add(fullname);
            row.add(emet); 
            row.add(montant); 
            row.add(solde); 
            row.add(Responsable);
            row.add(date);

            data.add(row);
        }
        panel_transaction.setLayout(null);	
        table_transaction = new JTable(data,header);

	}
	
	public void resetForm() {
		Client_description.setText("");
		benef_text.setText("");
		solde.setText("");
		benef.setText("");
		emetteur.setText("");
    	emetteur.setEnabled(true);
		panel_emetteur.setVisible(false);
		panel_benef.setVisible(false);
		panel_solde.setVisible(false);	
	}
}
