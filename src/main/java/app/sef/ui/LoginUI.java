package app.sef.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI {
	private JFrame frameLogin = new JFrame();
	private JPanel panelLogin = new JPanel();
	private JLabel imageLogin = new JLabel();
	private JLabel titleLogin = new JLabel("Login");
	private JLabel introductionLogin = new JLabel();
	private JButton buttonLogin2 = new JButton("LOGIN");
	private JLabel usernameLogin = new JLabel("Username:");
	private JTextField usernameLoginText = new JTextField();
	private JLabel passwordLogin = new JLabel("Password:");
	private JPasswordField passwordLoginText = new JPasswordField();
	
	public void login() {
		frameLogin.setTitle("Login");
		frameLogin.setSize(1366,750);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.add(panelLogin);
		   
		panelLogin.setBackground(Color.black);
		panelLogin.setLayout(null);
		   
		   imageLogin.setBounds(0,0,1000,480);
		   ImageIcon imglg = new ImageIcon("stock2.png");
		   imageLogin.setIcon(imglg);
		   panelLogin.add(imageLogin);
			
		   titleLogin.setFont(new Font("Serif", Font.BOLD, 40));
		   titleLogin.setForeground(Color.white);
		   titleLogin.setBounds(900,0,200,50);
		   panelLogin.add(titleLogin);
		   
		   introductionLogin.setText("Welcome to our stock app!Are you interested in stock market?Well...Here you will get everything you need to know!");
		   introductionLogin.setForeground(Color.white);
		   introductionLogin.setFont(new Font("Serif", Font.BOLD, 25));
		   introductionLogin.setBounds(50,500,1300,150);
		   panelLogin.add(introductionLogin);
		   
		   usernameLogin.setBounds(634, 114, 150, 80);
		   usernameLogin.setForeground(Color.white);
		   usernameLogin.setFont(new Font("Serif", Font.BOLD, 22));
		   panelLogin.add(usernameLogin);
		   usernameLoginText.setBounds(747, 136, 234, 34);
		   usernameLoginText.setFont(new Font("Serif", Font.BOLD, 20));
		   panelLogin.add(usernameLoginText);
		   
		   passwordLogin.setBounds(634, 168, 150, 80);
		   passwordLogin.setForeground(Color.white);
		   passwordLogin.setFont(new Font("Serif", Font.BOLD, 22));
		   panelLogin.add(passwordLogin);
		   passwordLoginText.setBounds(747, 190, 234, 34);
		   passwordLoginText.setFont(new Font("Serif", Font.BOLD, 20));
		   panelLogin.add(passwordLoginText);
		   
		   buttonLogin2.setBounds(700, 300, 150, 70);
		   buttonLogin2.setBackground(Color.orange);
		   panelLogin.add(buttonLogin2);
		   
	}
	
	 public void setVisible(boolean visible) {
		 frameLogin.setVisible(true);
	}
}
