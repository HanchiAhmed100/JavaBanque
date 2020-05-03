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
import javax.swing.JLayeredPane;

public class LoginBuilder {

	private JFrame frmJavaBanque;
	private Employe_controller ec;
	private Employe e;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;

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
		
		JLayeredPane layeredPane = new JLayeredPane();
		frmJavaBanque.getContentPane().add(layeredPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(34, 45, 65));
		panel.setBounds(0, 0, 684, 500);
		layeredPane.add(panel);
		
		JButton button = new JButton("V A L I D E R");
		button.setMargin(new Insets(10, 14, 10, 14));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 18));
		button.setBackground(new Color(93, 211, 195));
		button.setBounds(371, 384, 167, 40);
		panel.add(button);
		
		textField = new JTextField();
		textField.setToolTipText("Your email adresse\r\n");
		textField.setForeground(Color.WHITE);
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textField.setBackground(new Color(34, 45, 65));
		textField.setBounds(372, 208, 250, 29);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setDisabledTextColor(new Color(51, 102, 204));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBackground(new Color(34, 45, 65));
		passwordField.setBounds(372, 303, 250, 29);
		panel.add(passwordField);
		
		JLabel label = new JLabel("Email");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
		label.setBounds(372, 174, 160, 23);
		panel.add(label);
		
		JLabel label_1 = new JLabel("PASSWORD");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
		label_1.setBounds(372, 269, 228, 23);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Login ");
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 25));
		label_2.setBounds(359, 71, 88, 78);
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(95, 210, 195));
		panel_1.setBounds(-15, 0, 351, 500);
		panel.add(panel_1);
		
		JLabel label_3 = new JLabel("JAVA BANQUE");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 26));
		label_3.setBounds(95, 77, 198, 58);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(-67, 22, 477, 478);
		panel_1.add(label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(34, 45, 65));
		frmJavaBanque.getContentPane().add(panel_2, BorderLayout.CENTER);
		
		JButton button_1 = new JButton("V A L I D E R");
		button_1.setMargin(new Insets(10, 14, 10, 14));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 18));
		button_1.setBackground(new Color(93, 211, 195));
		button_1.setBounds(371, 384, 167, 40);
		panel_2.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Your email adresse\r\n");
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		textField_1.setBackground(new Color(34, 45, 65));
		textField_1.setBounds(372, 208, 250, 29);
		panel_2.add(textField_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(Color.WHITE);
		passwordField_1.setDisabledTextColor(new Color(51, 102, 204));
		passwordField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField_1.setBackground(new Color(34, 45, 65));
		passwordField_1.setBounds(372, 303, 250, 29);
		panel_2.add(passwordField_1);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
		label_5.setBounds(372, 174, 160, 23);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("PASSWORD");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("PMingLiU-ExtB", Font.PLAIN, 18));
		label_6.setBounds(372, 269, 228, 23);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("Login ");
		label_7.setHorizontalTextPosition(SwingConstants.CENTER);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 25));
		label_7.setBounds(346, 68, 88, 78);
		panel_2.add(label_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(95, 210, 195));
		panel_3.setBounds(-15, 0, 351, 500);
		panel_2.add(panel_3);
		
		JLabel label_8 = new JLabel("JAVA BANQUE");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 26));
		label_8.setBounds(95, 77, 198, 58);
		panel_3.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(-67, 22, 477, 478);
		panel_3.add(label_9);
		
		
	}
}
