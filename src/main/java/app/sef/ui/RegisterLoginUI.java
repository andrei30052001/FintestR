package app.sef.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class RegisterLoginUI implements ActionListener{
   static JFrame frame = new JFrame();
   static JPanel panel = new JPanel();
   static JLabel messageSign = new JLabel();
   static JLabel imageLabel = new JLabel();
   static JLabel title = new JLabel("StockApp");
   static JLabel introduction = new JLabel();
   static JButton buttonSign = new JButton("Sign in/Sign up");
 
   
   public void setRegisterLogin() {
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
	   
	   messageSign.setText("Sign in/Sign up for an account:");
	   messageSign.setForeground(Color.white);
	   messageSign.setFont(new Font("Serif", Font.BOLD, 25));
	   messageSign.setBounds(634,175,500,70);
	   panel.add(messageSign);
	   buttonSign.setBounds(800, 260, 150, 70);
	   buttonSign.setBackground(Color.orange);
	   panel.add(buttonSign);
	   
	   
	   buttonSign.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
			 RegisterUI reg = new RegisterUI();
			 reg.registration();
			 reg.setVisible(true);
			 frame.setVisible(false);
			 
			 
		 }
	   });
	   	
	   
	   frame.setVisible(true);
	   
 }

  
   public void actionPerformed(ActionEvent e) {
	   
   }
   
   public static void main(String[] args) {
	   RegisterLoginUI regLog = new RegisterLoginUI();
	   RegisterUI REG = new RegisterUI();
	   
	   regLog.setRegisterLogin();
	   
   }

   
}



