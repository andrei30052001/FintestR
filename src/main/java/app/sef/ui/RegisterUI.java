package app.sef.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import app.sef.entities.User;
import org.apache.commons.io.FileUtils;
import javax.swing.JPasswordField;

public class RegisterUI implements ActionListener {
	private JFrame frameRegister = new JFrame();
	private JPanel panelRegister = new JPanel();
	private JLabel imageRegister = new JLabel();
	private JLabel titleRegister = new JLabel("Sign up/Sign in");
	private JLabel introductionRegister = new JLabel();
	private JLabel usernameRegister = new JLabel("Username:");
	private JTextField usernameRegisterText = new JTextField();
	private JLabel passwordRegister = new JLabel("Password:");
	private JPasswordField passwordRegisterText = new JPasswordField();
	private JLabel country = new JLabel("Country:");
	private JTextField countryText = new JTextField();
	private JLabel key = new JLabel("Key(0 or a):");
	private JTextField keyText = new JTextField();
	private JButton buttonUp = new JButton("Sign up");
	private JButton buttonIn = new JButton("Sign in");
	private JLabel accountMessage1 = new JLabel("If you already have an account,please type only");
    private JLabel accountMessage2 = new JLabel("user,pwd,(and key-0 only for costumers),then sign in.");
	
	public void registration() {
		frameRegister.setTitle("Sign up/Sign in");
		frameRegister.setSize(1366, 750);
		frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRegister.add(panelRegister);

		panelRegister.setBackground(Color.black);
		panelRegister.setLayout(null);

		imageRegister.setBounds(0, 0, 1000, 480);
		ImageIcon imgrg = new ImageIcon("stock2.png");
		imageRegister.setIcon(imgrg);
		panelRegister.add(imageRegister);

		titleRegister.setFont(new Font("Serif", Font.BOLD, 40));
		titleRegister.setForeground(Color.white);
		titleRegister.setBounds(900, 0, 450, 50);
		panelRegister.add(titleRegister);

		introductionRegister.setText(
				"Welcome to our stock app!Are you interested in stock market?Well...Here you will get everything you need to know!");
		introductionRegister.setForeground(Color.white);
		introductionRegister.setFont(new Font("Serif", Font.BOLD, 25));
		introductionRegister.setBounds(50, 500, 1300, 150);
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
		
		accountMessage1.setBounds(1008, 80, 400, 80);
		accountMessage1.setForeground(Color.white);
		accountMessage1.setFont(new Font("Serif", Font.BOLD, 14));
		panelRegister.add(accountMessage1);
		accountMessage2.setBounds(1000, 134, 400, 80);
		accountMessage2.setForeground(Color.white);
		accountMessage2.setFont(new Font("Serif", Font.BOLD, 14));
		panelRegister.add(accountMessage2);

		buttonUp.setBounds(670, 345, 150, 70);
		buttonUp.setBackground(Color.orange);
		panelRegister.add(buttonUp);

		buttonIn.setBounds(850, 345, 150, 70);
		buttonIn.setBackground(Color.orange);
		panelRegister.add(buttonIn);

		buttonUp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) {

				String username = usernameRegisterText.getText(); // for saving in json
				String password = new String(passwordRegisterText.getPassword()); // for saving in json
				String country = countryText.getText(); // for saving in json
				String key = keyText.getText(); // for saving in json

				List<User> existingUsers = getExistingUsers();
				if (existingUsers == null) {
					JOptionPane.showMessageDialog(null, "Error Occured While fetching");
					return;
				}

				// TODO check a user with the same username does not exist

				User newUser = new User();
				newUser.setUsername(username);
				newUser.setPassword(password);
				newUser.setCountry(country);
				newUser.setKey(key);

				existingUsers.add(newUser);

				updateExistingUsers(existingUsers);

				JOptionPane.showMessageDialog(null, "User added: " + newUser.getUsername());
			}
		});

		buttonIn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evv) {
				CompanyUI comp = new CompanyUI();

				String username = usernameRegisterText.getText(); // for saving in json
				String password = new String(passwordRegisterText.getPassword()); // for saving in json
				String key = keyText.getText(); // for saving in json

				List<User> existingUsers = getExistingUsers();
				if (existingUsers == null) {
					JOptionPane.showMessageDialog(null, "Error Occured While fetching");
					return;
				}

				User currentUser = null;
				for (User user : existingUsers) {
					if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
						currentUser = user;
						if (user.getKey().equals("a")) {
							comp.seeCompany();
							comp.setVisible(true);
							frameRegister.setVisible(false);
						} else if (key.equals("0")) {

							String path = "C:\\Users\\Andrei\\.p2\\Desktop\\SEF\\Project AndreiSerban\\fintest\\src\\main\\resources\\data\\Company.json";
							File file = new File(path);
							try {
								if (file.exists()) {
									Process pro = Runtime.getRuntime()
											.exec("rundll32 url.dll,FileProtocolHandler " + path);
									pro.waitFor();
								} else {
									System.out.println("file does not exist");
								}
							} catch (Exception e) {
								System.out.println(e);
							}

						}

						// JOptionPane.showMessageDialog(null,"Password matched");
						break;
					}
				}
				if (currentUser == null) {
					JOptionPane.showMessageDialog(null, "Incorrect User/Password!");
				}

			}
		});

	}

	public void setVisible(boolean visible) {
		frameRegister.setVisible(true);
	}

	// @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	private List<User> getExistingUsers() {
		try {
			String location = "C:\\Users\\Andrei\\.p2\\Desktop\\SEF\\Project AndreiSerban\\fintest\\src\\main\\resources\\data\\User.json";
			String usersJson = FileUtils.readFileToString(new File(location), Charset.defaultCharset());
			return new ObjectMapper().readValue(usersJson, new TypeReference<List<User>>() {
			});
		} catch (Exception ex) {
			// TODO report error
			return null;
		}
	}

	private void updateExistingUsers(List<User> users) {
		try {
			String location = "C:\\Users\\Andrei\\.p2\\Desktop\\SEF\\Project AndreiSerban\\fintest\\src\\main\\resources\\data\\User.json";
			FileUtils.write(new File(location), new ObjectMapper().writeValueAsString(users), Charset.defaultCharset());
		} catch (Exception ex) {
			// TODO report error
		}
	}
}
