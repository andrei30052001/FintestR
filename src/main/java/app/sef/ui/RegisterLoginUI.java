package app.sef.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class RegisterLoginUI implements ActionListener{
   static  JFrame frame = new JFrame();
   static JPanel panel = new JPanel();
   static JLabel messageRegister = new JLabel();
   static JLabel messageLogin = new JLabel();
   static JLabel imageLabel = new JLabel();
   static JLabel title = new JLabel("StockApp");
   static JLabel introduction = new JLabel();
   static JButton buttonRegister = new JButton("REGISTER");
   static JButton buttonLogin = new JButton("LOGIN"); 
   
   public static void main(String[] args) {
	   frame.setTitle("StockApp-Register/Login");
	   frame.setSize(1366,750);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.add(panel);
	   
	   panel.setBackground(Color.black);
	   panel.setLayout(null);
	   
	   imageLabel.setBounds(0,0,1000,480);
	   ImageIcon img = new ImageIcon("stock2.png");
	   imageLabel.setIcon(img);
	   panel.add(imageLabel);
		
	   title.setFont(new Font("Serif", Font.BOLD, 40));
	   title.setForeground(Color.white);
	   title.setBounds(900,0,200,50);
	   panel.add(title);
	   
	   introduction.setText("Welcome to our stock app!Are you interested in stock market?Well...Here you will get everything you need to know!");
	   introduction.setForeground(Color.white);
	   introduction.setFont(new Font("Serif", Font.BOLD, 25));
	   introduction.setBounds(50,500,1300,150);
	   panel.add(introduction);
	   
	   messageRegister.setText("New to stock market?Please register here:");
	   messageRegister.setForeground(Color.white);
	   messageRegister.setFont(new Font("Serif", Font.BOLD, 25));
	   messageRegister.setBounds(634,95,500,70);
	   panel.add(messageRegister);
	   buttonRegister.setBounds(800, 165, 150, 70);
	   buttonRegister.setBackground(Color.orange);
	   panel.add(buttonRegister);
	   
	   messageLogin.setText("Already have an account?Please login here:");
	   messageLogin.setForeground(Color.white);
	   messageLogin.setFont(new Font("Serif", Font.BOLD, 25));
	   messageLogin.setBounds(634,265,500,70);
	   panel.add(messageLogin);
	   buttonLogin.setBounds(800, 345, 150, 70);
	   buttonLogin.setBackground(Color.orange);
	   panel.add(buttonLogin);
	   
	   buttonRegister.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 RegisterUI reg = new RegisterUI();
			 reg.registration();
			 reg.setVisible(true);
			 frame.setVisible(false);
		 }
	   });
	   
	   buttonLogin.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 LoginUI lg = new LoginUI();
				 lg.login();
				 lg.setVisible(true);
				 frame.setVisible(false);
			 }
		   });
	   
	   frame.setVisible(true);
	   
 }

  
   public void actionPerformed(ActionEvent e) {
	   
   }
   
}



