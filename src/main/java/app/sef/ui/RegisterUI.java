package app.sef.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegisterUI implements ActionListener {
	private JFrame frameRegister = new JFrame();
	private JPanel panelRegister = new JPanel();
	private JLabel imageRegister = new JLabel();
	private JLabel titleRegister = new JLabel("Register");
	private JLabel introductionRegister = new JLabel();
	private JLabel usernameRegister = new JLabel("Username:");
	private JTextField usernameRegisterText = new JTextField();
	private JLabel passwordRegister = new JLabel("Password:");
	private JPasswordField passwordRegisterText = new JPasswordField();
	private JLabel country = new JLabel("Country:");
	private JTextField countryText = new JTextField();
	private JLabel key = new JLabel("Key(0 or a):");
	private JTextField keyText = new JTextField();
	private JButton buttonCreateAcc = new JButton("CREATE ACCOUNT");
	
	public void registration() {
		frameRegister.setTitle("Register");
		frameRegister.setSize(1366,750);
		frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRegister.add(panelRegister);
		   
		panelRegister.setBackground(Color.black);
		panelRegister.setLayout(null);
		   
		   imageRegister.setBounds(0,0,1000,480);
		   ImageIcon imgrg = new ImageIcon("stock2.png");
		   imageRegister.setIcon(imgrg);
		   panelRegister.add(imageRegister);
			
		   titleRegister.setFont(new Font("Serif", Font.BOLD, 40));
		   titleRegister.setForeground(Color.white);
		   titleRegister.setBounds(900,0,200,50);
		   panelRegister.add(titleRegister);
		   
		   introductionRegister.setText("Welcome to our stock app!Are you interested in stock market?Well...Here you will get everything you need to know!");
		   introductionRegister.setForeground(Color.white);
		   introductionRegister.setFont(new Font("Serif", Font.BOLD, 25));
		   introductionRegister.setBounds(50,500,1300,150);
		   panelRegister.add(introductionRegister);
          
		   usernameRegister.setBounds(634, 80, 150, 80);
		   usernameRegister.setForeground(Color.white);
		   usernameRegister.setFont(new Font("Serif", Font.BOLD, 22));
		   panelRegister.add(usernameRegister);
		   usernameRegisterText.setBounds(747, 102, 234, 34);
		   usernameRegisterText.setFont(new Font("Serif", Font.BOLD, 20));
		   panelRegister.add(usernameRegisterText);
		   
		   passwordRegister.setBounds(634, 134, 150, 80);
		   passwordRegister.setForeground(Color.white);
		   passwordRegister.setFont(new Font("Serif", Font.BOLD, 22));
		   panelRegister.add(passwordRegister);
		   passwordRegisterText.setBounds(747, 156, 234, 34);
		   passwordRegisterText.setFont(new Font("Serif", Font.BOLD, 20));
		   panelRegister.add(passwordRegisterText);
		   
		   country.setBounds(634, 188, 150, 80);
		   country.setForeground(Color.white);
		   country.setFont(new Font("Serif", Font.BOLD, 22));
		   panelRegister.add(country);
		   countryText.setBounds(747, 210, 234, 34);
		   countryText.setFont(new Font("Serif", Font.BOLD, 20));
		   panelRegister.add(countryText);
		   
		   key.setBounds(634, 245, 150, 80);
		   key.setForeground(Color.white);
		   key.setFont(new Font("Serif", Font.BOLD, 22));
		   panelRegister.add(key);
		   keyText.setBounds(747, 267, 234, 34);
		   keyText.setFont(new Font("Serif", Font.BOLD, 20));
		   panelRegister.add(keyText);
		   
		   buttonCreateAcc.setBounds(700, 345, 150, 70);
		   buttonCreateAcc.setBackground(Color.orange);
		   panelRegister.add(buttonCreateAcc);
		   
		   buttonCreateAcc.addActionListener(new ActionListener() {
			   
				 public void actionPerformed(ActionEvent ev) {
					 LoginUI crtacc = new LoginUI();
					 crtacc.login();
					 crtacc.setVisible(true);
					 frameRegister.setVisible(false);
				 }
			   });
	}
	
	 public void setVisible(boolean visible) {
		 frameRegister.setVisible(true);
	}

//	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	   
}
