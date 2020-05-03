package com.banque.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.banque.controlers.Employe_controller;
import com.banque.models.Employe;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;

public class LoginBuilder {

	private JFrame frmJavaBanque;
	private JPasswordField passwordField;
	private JTextField textField;
	private Employe_controller ec;
	private Employe e;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginBuilder window = new LoginBuilder();
					window.frmJavaBanque.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public LoginBuilder() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frmJavaBanque = new JFrame();
		frmJavaBanque.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmJavaBanque.setForeground(SystemColor.window);
		frmJavaBanque.setTitle("JAVA Banque");
		frmJavaBanque.setBounds(100, 100, 700, 539);
		frmJavaBanque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 45, 65));
		frmJavaBanque.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("V A L I D E R");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String login = textField.getText();
				String password = passwordField.getText();
				ec = new Employe_controller();
				ec.Connexion();
				e = ec.Login(login, password);
				if(e != null ) {
					JOptionPane.showMessageDialog(null, " Bienvenue "+ e.getNom()+" "+e.getPernom()+" :D <3  " );
				}else {
					JOptionPane.showMessageDialog(null, " Mot de passe et email incorrecte !" );

				}
			}
		});
		btnNewButton.setMargin(new Insets(10, 14, 10, 14));
		btnNewButton.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 18));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBounds(371, 384, 167, 40);
		btnNewButton.setBackground(new Color(93, 211, 195));

		panel.add(btnNewButton);

		
		textField = new JTextField();
		textField.setToolTipText("Your email adresse\r\n");
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(34, 45, 65));
		textField.setBounds(372, 208, 250, 29);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));

		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setDisabledTextColor(new Color(51, 102, 204));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(34, 45, 65));
		passwordField.setBounds(372, 303, 250, 29);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(372, 174, 160, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(372, 269, 228, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 25));
		lblNewLabel_2.setBounds(359, 71, 88, 78);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 210, 195));
		panel_1.setBounds(-15, 0, 351, 500);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("JAVA BANQUE");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 26));
		lblNewLabel_4.setBounds(95, 77, 198, 58);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ahmed\\Desktop\\images\\kisspng-financial-services-finance-business-computer-icons-services-5ac0b676a4fb93.0520531715225790626758.png"));
		lblNewLabel_3.setBounds(-67, 22, 477, 478);
		panel_1.add(lblNewLabel_3);
		
		
	}
}
