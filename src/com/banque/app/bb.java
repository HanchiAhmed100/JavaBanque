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

public class bb {
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


	private JTable table_3;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bb window = new bb();
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
	public bb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(-19, 49, 672, 506);
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
        panel_1.setBounds(0, 0, 642, 45);
        frame.getContentPane().add(panel_1);
		panel_1.setVisible(false);
		
		
		JButton button = new JButton("VALIDER");
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
		button.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 18));
		button.setBackground(new Color(93, 211, 195));
		button.setBounds(371, 384, 167, 40);
		panel_3.add(button);
		
		textField = new JTextField();
		textField.setToolTipText("Your email adresse\r\n");
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textField.setBackground(new Color(34, 45, 65));
		textField.setBounds(372, 208, 250, 29);
		panel_3.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setDisabledTextColor(new Color(51, 102, 204));
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBackground(new Color(34, 45, 65));
		passwordField.setBounds(372, 303, 250, 29);
		panel_3.add(passwordField);
		
		JLabel label = new JLabel("Email");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
		label.setBounds(372, 174, 160, 23);
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("PASSWORD");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
		label_1.setBounds(372, 269, 228, 23);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("Login ");
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 25));
		label_2.setBounds(346, 68, 88, 78);
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(95, 210, 195));
		panel_4.setBounds(-15, 0, 351, 544);
		panel_3.add(panel_4);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\ahmed\\Desktop\\images\\kisspng-financial-services-finance-business-computer-icons-services-5ac0b676a4fb93.0520531715225790626758.png"));
		label_4.setBounds(-63, -15, 477, 529);
		panel_4.add(label_4);
		
		panel_transaction = new JPanel();
		layeredPane.add(panel_transaction, "name_176994971202900");
		panel_transaction.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cr\u00E9e une nouvelle Transaction");
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setFocusable(false);
		lblNewLabel.setFocusTraversalKeysEnabled(false);
		lblNewLabel.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
		lblNewLabel.setBounds(63, 76, 220, 38);
		panel_transaction.add(lblNewLabel);
		
        G1 = new ButtonGroup(); 
		
		virement = new JRadioButton("Virement");
		virement.setBounds(63, 130, 109, 23);
		G1.add(virement);
		panel_transaction.add(virement);

		
		versement = new JRadioButton("Versment");
		versement.setBounds(174, 130, 109, 23);
		G1.add(versement);
		panel_transaction.add(versement);

		
		retrait = new JRadioButton("Retrait");
		retrait.setBounds(285, 130, 109, 23);
		G1.add(retrait);
		panel_transaction.add(retrait);
		
		JButton button_2 = new JButton("Valider");
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
		button_2.setBounds(496, 130, 89, 23);
		panel_transaction.add(button_2);
		
		panel_emetteur = new JPanel();
		panel_emetteur.setBounds(44, 160, 574, 62);
		panel_emetteur.setVisible(false);
		panel_transaction.add(panel_emetteur);
				panel_emetteur.setLayout(null);
		
				
				JLabel lblNewLabel_1 = new JLabel("Numero du compte du emetteur :");
				lblNewLabel_1.setBounds(22, 11, 228, 14);
				panel_emetteur.add(lblNewLabel_1);
				
				emetteur = new JTextField();
				emetteur.setBounds(239, 8, 201, 23);
				panel_emetteur.add(emetteur);
				emetteur.setColumns(10);
				
				Client_description = new JLabel("");
				Client_description.setBounds(22, 37, 517, 14);
				panel_emetteur.add(Client_description);
				
				JButton val_emetteur = new JButton("Valider");
				val_emetteur.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if( emetteur.getText()!= null) {
							cc = new Compte_controller();
							cc.Connexion();
							cEmetteur = cc.Get_One_Compte(emetteur.getText());
							Client_description.setText("Le compte : "+cEmetteur.getNumcompte()+", client : "+cEmetteur.getTitulaire().getNom()+" "+cEmetteur.getTitulaire().getPrenom()+" , solde : "+cEmetteur.getSolde()+" DT ");
							panel_benef.setVisible(true);		
						}					
					}
				});
				val_emetteur.setFocusable(false);
				val_emetteur.setBounds(450, 7, 89, 23);
				panel_emetteur.add(val_emetteur);
				
				panel_benef = new JPanel();
				panel_benef.setBounds(45, 229, 574, 62);
				panel_benef.setVisible(false);
				panel_transaction.add(panel_benef);
				panel_benef.setLayout(null);
				
				JLabel label_5 = new JLabel("Numero du compte du beneficiaire :");
				label_5.setBounds(22, 11, 207, 14);
				panel_benef.add(label_5);
				
				benef = new JTextField();
				benef.setColumns(10);
				benef.setBounds(239, 7, 201, 23);
				panel_benef.add(benef);
				
				benef_text = new JLabel("");
				benef_text.setBounds(22, 36, 517, 14);
				panel_benef.add(benef_text);
				
				JButton button_4 = new JButton("Valider");
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
								message.setText("Compte introuvable ");
							}
						}
					}
				});
				button_4.setFocusable(false);
				button_4.setBounds(450, 7, 89, 23);
				panel_benef.add(button_4);
				
				panel_solde = new JPanel();
				panel_solde.setVisible(false);
				panel_solde.setLayout(null);
				panel_solde.setBounds(44, 299, 574, 103);
				panel_transaction.add(panel_solde);
				/*
				 *	AJOUTER   TRANSACTION ----------------------------------------------------------
				 */
				JButton btnValiderTransaction = new JButton("Valider Transaction");
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
				lblMontantDeLa.setBounds(22, 11, 228, 14);
				panel_solde.add(lblMontantDeLa);
				
				solde = new JTextField();
				solde.setColumns(10);
				solde.setBounds(239, 8, 201, 23);
				panel_solde.add(solde);
				
				JButton button_3 = new JButton("Réinitialiser");
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
				message.setBounds(63, 408, 317, 14);
				panel_transaction.add(message);
			    
		panel_compte = new JPanel();
		layeredPane.add(panel_compte, "name_176997634846200");
		panel_compte.setLayout(null);
	
		loadComptesTable();
		scrollPane_compte = new JScrollPane(jTable);
		scrollPane_compte.setBounds(35, 191, 608, 291);
        panel_compte.add(scrollPane_compte);
        
        panel_5 = new JPanel();
        panel_5.setBounds(51, 11, 571, 141);
        panel_compte.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblNewLabel_7 = new JLabel("Nom et prenom du client :");
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
		

        titulaire.setBounds(183, 8, 363, 20);
        panel_5.add(titulaire);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(0, 36, 561, 105);
        panel_5.add(panel_6);
        panel_6.setLayout(null);
        
        lblNewLabel_8 = new JLabel("Numero de nouveau compte :");
        lblNewLabel_8.setBounds(10, 11, 142, 14);
        panel_6.add(lblNewLabel_8);
        
        numcompteTextField = new JTextField();
        numcompteTextField.setEnabled(false);
        numcompteTextField.setBounds(183, 8, 363, 20);
        panel_6.add(numcompteTextField);
        numcompteTextField.setColumns(10);
        
        lblNewLabel_9 = new JLabel("Solde :");
        lblNewLabel_9.setBounds(10, 39, 46, 14);
        panel_6.add(lblNewLabel_9);
        
        newCompteSolde = new JTextField();
        newCompteSolde.setBounds(183, 36, 363, 20);
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
                	
					JOptionPane.showMessageDialog(null, " Le Compte à été ajouter " );

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
        scrollPane.setBounds(51, 191, 571, 291);
        panel_Client.add(scrollPane);
        
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(51, 27, 571, 153);
        panel_Client.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Nom :");
        lblNewLabel_3.setBounds(10, 39, 61, 14);
        panel_2.add(lblNewLabel_3);
        
        JLabel lblNewLabel_2 = new JLabel("Ajouter Client");
        lblNewLabel_2.setBounds(209, 1, 133, 24);
        lblNewLabel_2.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
        panel_2.add(lblNewLabel_2);
        
        NameTextfield = new JTextField();
        NameTextfield.setBounds(91, 36, 171, 20);
        panel_2.add(NameTextfield);
        NameTextfield.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Prenom :");
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
        lblNewLabel_5.setBounds(10, 75, 71, 14);
        panel_2.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Adresse :");
        lblNewLabel_6.setBounds(296, 75, 72, 14);
        panel_2.add(lblNewLabel_6);
        
        JButton btnNewButton_2 = new JButton("Ajouter");
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
					JOptionPane.showMessageDialog(null, " Client à été ajouter " );

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
        button_1.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
        button_1.setFocusable(false);
        button_1.setFocusTraversalKeysEnabled(false);
        button_1.setFocusPainted(false);
        button_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
        button_1.setBackground(new Color(34, 45, 65));
        button_1.setBounds(419, 0, 223, 45);
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
        button_8.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
        button_8.setFocusable(false);
        button_8.setFocusTraversalKeysEnabled(false);
        button_8.setFocusPainted(false);
        button_8.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
        button_8.setBackground(new Color(34, 45, 65));
        button_8.setBounds(0, 0, 212, 45);
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
        button_9.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
        button_9.setFocusTraversalKeysEnabled(false);
        button_9.setFocusPainted(false);
        button_9.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
        button_9.setBackground(new Color(34, 45, 65));
        button_9.setBounds(211, 0, 212, 45);
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
