package customer;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainMenuPage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomerCreateAccountPage2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCreateAccountPage2 frame = new CustomerCreateAccountPage2();
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
	Connection con;
	PreparedStatement pst;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
		} catch (ClassNotFoundException ex) {
		
		}catch (Exception ex) {
			 
		}
	}
	
	public CustomerCreateAccountPage2() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1178, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Create Account");
		ImageIcon icon;
	    icon = new ImageIcon("images/9.png");
	    setIconImage(icon.getImage());
		
		JLabel lblCreatePersonalAccount = new JLabel("Create  Account");
		lblCreatePersonalAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreatePersonalAccount.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblCreatePersonalAccount.setBounds(323, 11, 538, 81);
		contentPane.add(lblCreatePersonalAccount);
		
		JLabel lblNicNumber = new JLabel("NIC Number");
		lblNicNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNicNumber.setBounds(120, 166, 200, 38);
		contentPane.add(lblNicNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(355, 117, 341, 38);
		contentPane.add(textField);
		
		final JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFullName.setBounds(120, 117, 200, 38);
		contentPane.add(lblFullName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(355, 166, 341, 38);
		contentPane.add(textField_1);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdress.setBounds(120, 215, 200, 38);
		contentPane.add(lblAdress);
		
		final JTextArea textArea = new JTextArea();
		textArea.setRows(3);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(355, 220, 341, 64);
		contentPane.add(textArea);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobileNumber.setBounds(120, 297, 200, 38);
		contentPane.add(lblMobileNumber);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(355, 297, 341, 38);
		contentPane.add(textField_2);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenuPage p3 = new MainMenuPage();
				p3.show();
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack_1.setBounds(67, 580, 146, 45);
		contentPane.add(btnBack_1);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField.getText();
				String tele = textField_2.getText();
				String address = textArea.getText();
				String nic = textField_1.getText();
				String g = passwordField.getText();
				String h = passwordField_1.getText();
			
				if (g.equals(h)) {
                if (name.length() > 0) {
					if (tele.length() >1) {
						if (address.length()>1) {
							if (nic.length()>1) {
								try {
									pst = con.prepareStatement("insert into customer(idnumber,c_tele,c_password,c_name,c_address)values(?,?,?,?,?)");
									pst.setString(1, nic);
									pst.setString(2, tele);
									pst.setString(3, g);
									pst.setString(4, name);
									pst.setString(5, address);
									pst.executeLargeUpdate();
									JOptionPane.showInternalMessageDialog(null,"Successfully created....... ");
								textField.setText("");
								textField_1.setText("");
								textField_2.setText("");
								textArea.setText("");
							    passwordField.setText("");
						        passwordField_1.setText("");
								
						 
						    	dispose();
								CustomerLoginAccountPage1 fap1 =new CustomerLoginAccountPage1();
								fap1.show();
								
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(null, "Faild", "NIC Error", JOptionPane.INFORMATION_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Please Enter Your NIC", "NIC Error", JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Please Enter Your Address", "Address Error", JOptionPane.INFORMATION_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Please Enter Your Mobile Number", "Mobile Number Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Please Enter Your Name", "Name Error", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				}else {
					JOptionPane.showMessageDialog(null, "Password does not match", "Password Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCreate.setBounds(867, 397, 146, 45);
		contentPane.add(btnCreate);
		
		final JLabel lblFullName_1 = new JLabel("");
		lblFullName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFullName_1.setBounds(717, 410, 43, 32);
		contentPane.add(lblFullName_1);
		
		final JLabel lblFullName_1_1 = new JLabel("");
		lblFullName_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFullName_1_1.setBounds(717, 410, 43, 32);
		contentPane.add(lblFullName_1_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(120, 351, 200, 38);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(355, 354, 341, 38);
		contentPane.add(passwordField);
		
		JLabel lblReenterPassword = new JLabel("RE-Enter Password");
		lblReenterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReenterPassword.setBounds(120, 400, 200, 38);
		contentPane.add(lblReenterPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				
				lblFullName_1.setIcon(null);
				lblFullName_1_1.setIcon(null);
				
				String z1 = passwordField.getText();
				String z2 = passwordField_1.getText();
				
				if (z1.equals(z2)) {
					if (z1.length() > 1) {
					ImageIcon dabIcon = new ImageIcon("images/42.png");
					Image dabImage = dabIcon.getImage();
					Image mod = dabImage.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
					dabIcon = new ImageIcon(mod);
					lblFullName_1.setIcon(dabIcon);
					}
					
				}else {
					
					ImageIcon dabIcon1 = new ImageIcon("images/47.png");
					Image dabImage1 = dabIcon1.getImage();
					Image mod1 = dabImage1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
					dabIcon1 = new ImageIcon(mod1);
					lblFullName_1_1.setIcon(dabIcon1);
				}
			}
		});
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField_1.setBounds(355, 403, 341, 38);
		contentPane.add(passwordField_1);
		
		
	}
}
