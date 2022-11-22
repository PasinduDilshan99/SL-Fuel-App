package main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage2 frame = new MainPage2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1296, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("User Agreements");
		ImageIcon icon;
	    icon = new ImageIcon("images/6.png");
	    setIconImage(icon.getImage());
		
		JLabel lblUserAgreements = new JLabel("User Agreements");
		lblUserAgreements.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserAgreements.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblUserAgreements.setBounds(361, 11, 454, 82);
		contentPane.add(lblUserAgreements);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage1 p1 = new MainPage1();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(38, 667, 146, 45);
		contentPane.add(btnBack);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Read");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rdbtnNewRadioButton.setForeground(Color.black);
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(361, 667, 132, 37);
		contentPane.add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnAgree = new JRadioButton("Agree");
		rdbtnAgree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rdbtnAgree.setForeground(Color.black);
			}
		});
		rdbtnAgree.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAgree.setBounds(613, 667, 132, 37);
		contentPane.add(rdbtnAgree);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(78, 97, 1144, 503);
		contentPane.add(scrollPane);
		
		JTextArea txtrLoginAccount = new JTextArea();
		txtrLoginAccount.setText("•  Login account\r\nIt enables the user and admin login through the correct password.\r\n\r\n•  Create account\r\nIt enables the users to create account.\r\nCustomer can create his/her account.\r\nGovernment admin can create the account for fuel station manager.\r\nFuel station manager can create the account for pomper.\r\n\r\n•  Update account\r\nCustomer, Fuel station manager, Pomper can update their accounts.\r\n\r\n•  Delete account\r\nGovernment admin can delete the account of fuel station manager.\r\nFuel station manager can delete the account of pomper.\r\n\r\n•  Add/ Update/ Delete vehicle\r\nCustomer can add one or many vehicles, update the police report (through this police report customers can get more fuel according \r\nto their necessary activities.) and delete vehicle.\r\n\r\n•  Update fuel amount\r\nAfter pomp the fuel to the vehicle, update the amount of the remaining fuel in the pomp, in the fuel station, and the remaining \r\nfuel amount that customer can pomp to the vehicle. \r\n\r\n•  Search and show details of fuel station\r\nAnyone can search the details of any fuel station in the country through search bar (have to insert the city). Anyone can see the \r\ndetails which are important. Examples: whether the fuel station have the fuel or not, if there is not fuel, \r\nwhen the fuel has arrived.\r\n\r\n•  Add/ Update/ Delete fuel station\r\nOnly government admin can add and delete fuel station in the application. \r\nBut both government admin and fuel station manager can update the details of fuel station.\r\n\r\n•  Change password\r\nCustomer, government admin, fuel station manager, pomper can change their passwords.\r\n\r\n•  Create/ Update/ Delete pomp account\r\nOnly fuel station manager can do these operations to the pomp account.\r\n\r\n•  Create/ Update/ Delete pomper account\r\nOnly fuel station manager can create and delete the pomper account.\r\nOnly pomper can update the details of the pomper account.\r\n\r\n•  Create police report\r\nOnly police station can create the police report.\r\n\r\n•  Add police report\r\nOnly customer can add the police report of his/her own vehicle.\r\n");
		scrollPane.setViewportView(txtrLoginAccount);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected() == true) {
					if (rdbtnAgree.isSelected() == true) {
						dispose();
						MainMenuPage p2 = new MainMenuPage();
					     p2.show();
					}else {
						JOptionPane.showMessageDialog(null, "Please agree the user agreement");
						rdbtnAgree.setForeground(Color.red);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Please read the user agreement");
					rdbtnNewRadioButton.setForeground(Color.red);
				}
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOk.setBounds(1060, 653, 146, 45);
		contentPane.add(btnOk);
	}
}
