package com.banque.app;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.banque.controlers.Employe_controller;
import com.banque.models.Employe;

public class Login  extends JFrame implements ActionListener {

	JFrame f;
	JTextField textLogin;
	JButton LoginBtn,AnnulerBtn;
	JLabel LoginLabel,PasswordLabel;
	JPanel TextPanel, BtnPanel;
	JPasswordField TextPassword;
	Employe e;
	Employe_controller ec;
	public Login(){
		InitLogin();
	}
	
	public void InitLogin(){
		f = new JFrame("Authentification");
		
	    setLayout(new GridLayout(2,3));  

		
		TextPanel = new JPanel();
		
		LoginLabel = new JLabel("login");
		TextPanel.add(LoginLabel);
		
		textLogin = new JTextField(15);
		TextPanel.add(textLogin);
		
		PasswordLabel = new JLabel("password");
		TextPanel.add(PasswordLabel);
		
		TextPassword = new JPasswordField(15);
		TextPanel.add(TextPassword);
		
		BtnPanel = new JPanel();

		LoginBtn = new JButton("Valider");
		LoginBtn.addActionListener(this);
		BtnPanel.add(LoginBtn);
		
		AnnulerBtn = new JButton("Annuler");
		AnnulerBtn.addActionListener(this);
		BtnPanel.add(AnnulerBtn);
		
		add(TextPanel);
		add(BtnPanel);
		setSize(700 ,200);
		setVisible( true); 
		setLocation(500 ,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	public void  acceuil() {
		
	}
	

	public void actionPerformed(ActionEvent arg) {
		if( arg.getSource() == LoginBtn ){
			String login = textLogin.getText();
			String password = TextPassword.getText();
			ec = new Employe_controller();
			ec.Connexion();
			e = ec.Login(login, password);
			//JOptionPane.showMessageDialog(null, " login :D <3  " );
			if(e != null ) {
				
			}
		} else if ( arg.getSource() == AnnulerBtn ) {
			textLogin.setText("");
			TextPassword.setText("");
		}
	}
}
