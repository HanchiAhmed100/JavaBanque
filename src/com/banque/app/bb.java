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
import java.util.Iterator;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class bb {
	private Compte cEmetteur,cBenef;
	private Compte_controller cc;
	private Employe_controller ec;
	private Employe employe;
	private Transaction_controller tc;
	private Transaction transaction; 
	private Client_controller CCli;
	private Client client;
	ArrayList<Client> arc ;

	
	
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel panel_transaction;
	private JLayeredPane layeredPane;
	private JTextField emetteur;
	private ButtonGroup G1;
	private JRadioButton versement,virement,retrait; 
	private JLabel Client_description,benef_text,message;
	private JPanel panel_emetteur,panel_benef,panel_solde,panel_compte,panel_Client;
	private JTextField benef;
	private JTextField solde;
	private String type;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField NameTextfield;
	private JTextField lastnametextfield;
	private JTextField phonetextfield;
	private JTextField adressetextfield;
	private JScrollPane scrollPane;
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
		layeredPane.setBounds(-19, 0, 672, 555);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_176753858122200");
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(34, 45, 65));
		panel.add(panel_3, "name_177190634784400");
		
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
		label_4.setBounds(-60, 11, 477, 529);
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
							}else if(type == "versement"){
								transaction = new Transaction(type,cBenef,mnt,employe);
								tc.Versement(transaction);
							}else {
								transaction = new Transaction(type,cBenef,mnt,employe);
								tc.Retrait(transaction);
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
				
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(20, 11, 642, 45);
				panel_transaction.add(panel_1);
				panel_1.setLayout(null);
				JButton button_1 = new JButton("Clients");
				button_1.setBounds(419, 0, 223, 45);
				panel_1.add(button_1);
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						layeredPane.removeAll();
						layeredPane.add(panel_Client);
						layeredPane.repaint();
						layeredPane.revalidate();
					}
				});
				button_1.setFocusPainted(false);
				button_1.setFocusTraversalKeysEnabled(false);
				button_1.setFocusable(false);
				button_1.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
				button_1.setForeground(new Color(255, 255, 255));
				button_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
				button_1.setBackground(new Color(34, 45, 65));
				
				JButton btnNewButton = new JButton("Compte");
				btnNewButton.setBounds(0, 0, 212, 45);
				panel_1.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						layeredPane.removeAll();
						layeredPane.add(panel_compte);
						layeredPane.repaint();
						layeredPane.revalidate();
					}
				});
				btnNewButton.setFocusable(false);
				btnNewButton.setFocusPainted(false);
				btnNewButton.setFocusTraversalKeysEnabled(false);
				btnNewButton.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
				btnNewButton.setBackground(new Color(34, 45, 65));
				
				JButton btnNewButton_1 = new JButton("Transaction");
				btnNewButton_1.setBounds(211, 0, 212, 45);
				panel_1.add(btnNewButton_1);
				btnNewButton_1.setFocusTraversalKeysEnabled(false);
				btnNewButton_1.setFocusPainted(false);
				btnNewButton_1.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
				btnNewButton_1.setForeground(new Color(255, 255, 255));
				btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
				btnNewButton_1.setBackground(new Color(34, 45, 65));
		

		
		panel_compte = new JPanel();
		layeredPane.add(panel_compte, "name_176997634846200");
		panel_compte.setLayout(null);
		
		JList list = new JList();
		list.setBounds(336, 159, -186, -154);
		panel_compte.add(list);
		
		table = new JTable();
		table.setBounds(174, 110, 118, 50);
		panel_compte.add(table);
		
		panel_Client = new JPanel();
		layeredPane.add(panel_Client, "name_195965575302300");
		



		
        

		loadClientTable();
        scrollPane = new JScrollPane(table_3);        
        scrollPane.setBounds(51, 207, 571, 326);
        panel_Client.add(scrollPane);
        
        
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(51, 56, 571, 153);
        panel_Client.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("Nom :");
        lblNewLabel_3.setBounds(10, 39, 61, 14);
        panel_2.add(lblNewLabel_3);
        
        JLabel lblNewLabel_2 = new JLabel("Ajouter Client");
        lblNewLabel_2.setBounds(164, 1, 133, 24);
        lblNewLabel_2.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 18));
        panel_2.add(lblNewLabel_2);
        
        NameTextfield = new JTextField();
        NameTextfield.setBounds(91, 36, 140, 20);
        panel_2.add(NameTextfield);
        NameTextfield.setColumns(10);
        
        JLabel lblNewLabel_4 = new JLabel("Prenom");
        lblNewLabel_4.setBounds(251, 39, 46, 14);
        panel_2.add(lblNewLabel_4);
        
        lastnametextfield = new JTextField();
        lastnametextfield.setBounds(321, 36, 158, 20);
        panel_2.add(lastnametextfield);
        lastnametextfield.setColumns(10);
        
        phonetextfield = new JTextField();
        phonetextfield.setBounds(91, 72, 140, 20);
        panel_2.add(phonetextfield);
        phonetextfield.setColumns(10);
        
        adressetextfield = new JTextField();
        adressetextfield.setBounds(321, 72, 158, 20);
        panel_2.add(adressetextfield);
        adressetextfield.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Telephone :");
        lblNewLabel_5.setBounds(10, 75, 71, 14);
        panel_2.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Adresse :");
        lblNewLabel_6.setBounds(249, 75, 72, 14);
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
					reloadClientPage("");
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
        
        JPanel panel_5 = new JPanel();
        panel_5.setLayout(null);
        layeredPane.add(panel_5, "name_207137801625900");
        
        JButton button_5 = new JButton("Clients");
        button_5.setForeground(Color.WHITE);
        button_5.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
        button_5.setFocusable(false);
        button_5.setFocusTraversalKeysEnabled(false);
        button_5.setFocusPainted(false);
        button_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
        button_5.setBackground(new Color(34, 45, 65));
        button_5.setBounds(419, 0, 223, 45);
        panel_5.add(button_5);
        
        JButton button_6 = new JButton("Compte");
        button_6.setForeground(Color.WHITE);
        button_6.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
        button_6.setFocusable(false);
        button_6.setFocusTraversalKeysEnabled(false);
        button_6.setFocusPainted(false);
        button_6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
        button_6.setBackground(new Color(34, 45, 65));
        button_6.setBounds(0, 0, 212, 45);
        panel_5.add(button_6);
        
        JButton button_7 = new JButton("Transaction");
        button_7.setForeground(Color.WHITE);
        button_7.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
        button_7.setFocusTraversalKeysEnabled(false);
        button_7.setFocusPainted(false);
        button_7.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
        button_7.setBackground(new Color(34, 45, 65));
        button_7.setBounds(211, 0, 212, 45);
        panel_5.add(button_7);
		

	}
	public void reloadClientPage(String panne) {
		
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
