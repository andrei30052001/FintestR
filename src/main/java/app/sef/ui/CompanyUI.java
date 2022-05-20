package app.sef.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import app.sef.entities.Company;
import app.sef.entities.User;

public class CompanyUI {
	private JFrame frameCompany = new JFrame();
	private JPanel panelCompany = new JPanel();
	private JLabel companyTicker = new JLabel("Ticker:");
	private JLabel companyName = new JLabel("Name:");
	private JLabel companyIndustry = new JLabel("Industry:");
	private JLabel companyPE = new JLabel("PE:");
	private JLabel companyDIV = new JLabel("Dividend Yield:");
	private JLabel companyROIC = new JLabel("ROIC:");

	private JTextField Ticker = new JTextField();
	private JTextField Name = new JTextField();
	private JTextField Industry = new JTextField();
	private JTextField PE = new JTextField();
	private JTextField Div = new JTextField();
	private JTextField Roic = new JTextField();

	static JButton buttonDelete1 = new JButton("Delete");
	static JButton buttonDelete2 = new JButton("Delete");
	static JButton buttonAdd = new JButton("Add");

	public void seeCompany() {

		frameCompany.setTitle("Companies");
		frameCompany.setSize(1366, 750);
		frameCompany.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCompany.add(panelCompany);

		panelCompany.setBackground(Color.black);
		panelCompany.setLayout(null);

		companyTicker.setBounds(50, 20, 150, 80);
		companyTicker.setForeground(Color.white);
		companyTicker.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(companyTicker);

		companyName.setBounds(250, 20, 150, 80);
		companyName.setForeground(Color.white);
		companyName.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(companyName);

		companyIndustry.setBounds(450, 20, 150, 80);
		companyIndustry.setForeground(Color.white);
		companyIndustry.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(companyIndustry);

		companyPE.setBounds(650, 20, 150, 80);
		companyPE.setForeground(Color.white);
		companyPE.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(companyPE);

		companyDIV.setBounds(850, 20, 150, 80);
		companyDIV.setForeground(Color.white);
		companyDIV.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(companyDIV);

		companyROIC.setBounds(1100, 20, 150, 80);
		companyROIC.setForeground(Color.white);
		companyROIC.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(companyROIC);

		Ticker.setBounds(50, 75, 100, 65);
		Ticker.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(Ticker);
		

		Name.setBounds(250, 75, 100, 65);
		Name.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(Name);

		Industry.setBounds(450, 75, 120, 65);
		Industry.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(Industry);

		PE.setBounds(650, 75, 100, 65);
		PE.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(PE);

		Div.setBounds(850, 75, 100, 65);
		Div.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(Div);

		Roic.setBounds(1100, 75, 100, 65);
		Roic.setFont(new Font("Serif", Font.BOLD, 22));
		panelCompany.add(Roic);

		//if (isAdmin) {
			buttonDelete1.setBounds(1235, 75, 100, 65);
			buttonDelete1.setBackground(Color.orange);
			panelCompany.add(buttonDelete1);

			buttonAdd.setBounds(500, 300, 300, 250);
			buttonAdd.setBackground(Color.orange);
			buttonAdd.setFont(new Font("Serif", Font.BOLD, 22));
			panelCompany.add(buttonAdd);

			buttonAdd.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent ev) {

					String ticker = Ticker.getText(); // for saving in json
					String name = Name.getText(); // for saving in json
					String industry = Industry.getText(); // for saving in json
					String pe = PE.getText(); // for saving in json
					String div = Div.getText(); // for saving in json
					String roic = Roic.getText(); // for saving in json

					List<Company> existingCompanies = getExistingCompanies();
					if (existingCompanies == null) {
						JOptionPane.showMessageDialog(null, "Error Occured While fetching");
						return;
					}

					Company newCompany = new Company();
					newCompany.setTicker(ticker);
					newCompany.setName(name);
					newCompany.setIndustry(industry);
					newCompany.setPe(pe);
					newCompany.setDiv(div);
					newCompany.setRoic(roic);

					existingCompanies.add(newCompany);

					updateExistingCompanies(existingCompanies);

					JOptionPane.showMessageDialog(null, "Company added: " + newCompany.getName());
				}
			});

			buttonDelete1.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent evv) {

					String ticker = Ticker.getText(); // for saving in json

					List<Company> existingCompanies = getExistingCompanies();
					if (existingCompanies == null) {
						JOptionPane.showMessageDialog(null, "Error Occured While fetching");
						return;
					}

					Company currentCompany = null;

					Iterator<Company> it = existingCompanies.iterator();

					while (it.hasNext()) {
						Company company = it.next();

						if (ticker.equals(company.getTicker())) {
							currentCompany = company;
							it.remove();
							break;
						}
					}

					if (currentCompany == null) {
						JOptionPane.showMessageDialog(null, "The Company does not exist!");
					} else {
						updateExistingCompanies(existingCompanies);
						JOptionPane.showMessageDialog(null, "Data Removed");
					}

				}

			});
		}

	//}

	public void setVisible(boolean visible) {
		frameCompany.setVisible(true);
	}

	private ObjectMapper getObjectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return om;
	}

	private List<Company> getExistingCompanies() {
		try {
			String location = "C:\\Users\\Andrei\\.p2\\Desktop\\SEF\\Project AndreiSerban\\fintest\\src\\main\\resources\\data\\Company.json";
			String companiesJson = FileUtils.readFileToString(new File(location), Charset.defaultCharset());
			return getObjectMapper().readValue(companiesJson, new TypeReference<List<Company>>() {
			});
		} catch (Exception ex) {
			// TODO report error
			return null;
		}
	}

	private void updateExistingCompanies(List<Company> companies) {
		try {
			String location = "C:\\Users\\Andrei\\.p2\\Desktop\\SEF\\Project AndreiSerban\\fintest\\src\\main\\resources\\data\\Company.json";
			FileUtils.write(new File(location), getObjectMapper().writeValueAsString(companies),
					Charset.defaultCharset());
		} catch (Exception ex) {
			// TODO report error
		}
	}

}