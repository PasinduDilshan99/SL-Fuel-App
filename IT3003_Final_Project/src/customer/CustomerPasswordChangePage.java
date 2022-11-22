package customer;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class CustomerPasswordChangePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPasswordChangePage frame = new CustomerPasswordChangePage();
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
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
		} catch (ClassNotFoundException ex) {
		
		}catch (Exception ex) {
			 
		}}
	
	public CustomerPasswordChangePage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1203, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Password Change");
		ImageIcon icon;
	    icon = new ImageIcon("images/15.jpg");
	    setIconImage(icon.getImage());
		
		JLabel lblPasswordChange = new JLabel("Password Change");
		lblPasswordChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordChange.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPasswordChange.setBounds(327, 22, 538, 81);
		contentPane.add(lblPasswordChange);
		
		JLabel lblUserName = new JLabel("NIC Number");
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserName.setBounds(115, 128, 200, 38);
		contentPane.add(lblUserName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(345, 128, 280, 38);
		contentPane.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerLoginAccountPage3 p3 = new CustomerLoginAccountPage3();
				p3.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(57, 591, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a1 = passwordField_1.getText();
				String a2 = passwordField_2.getText();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField.getText();
					String password = passwordField.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from customer where idnumber = '"+username+"'and c_password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						
						if (a1.equals(a2)) {
							try {
								String id = textField.getText();
							   String new_password = passwordField_1.getText();
								pst = con.prepareStatement("update customer set c_password=? where idnumber=?");
								pst.setString(1, new_password);
								pst.setString(2, id);
								int k = pst.executeUpdate();
								if (k ==1) {
									JOptionPane.showMessageDialog(null, "password updated");
								  passwordField.setText("");
									passwordField_1.setText("");
									passwordField_2.setText("");
									textField.setText("");
									dispose();
									CustomerLoginAccountPage3 pl = new CustomerLoginAccountPage3();
									pl.show();
					
								}else {
									JOptionPane.showMessageDialog(null, "passwordfaild");
								}
								
							} catch (Exception e2) {
								
							}
						}else {
							JOptionPane.showInternalMessageDialog(null,"Your Password and re enter password does not match");
						}
						
					}else {
						JOptionPane.showInternalMessageDialog(null,"username or password wrong");
						textField.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						passwordField_2.setText("");
					}
					con.close();
				} catch (Exception e2) {
				
				}
				
			}
		});
		btnChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnChange.setBounds(724, 319, 146, 45);
		contentPane.add(btnChange);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentPassword.setBounds(115, 177, 200, 38);
		contentPane.add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewPassword.setBounds(115, 267, 200, 38);
		contentPane.add(lblNewPassword);
		
		JLabel lblReenterNewPassword = new JLabel("Re-Enter New Password");
		lblReenterNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblReenterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReenterNewPassword.setBounds(115, 322, 200, 38);
		contentPane.add(lblReenterNewPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(94, 240, 977, 2);
		contentPane.add(separator);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(345, 183, 280, 32);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(345, 273, 280, 32);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(345, 319, 280, 32);
		contentPane.add(passwordField_2);
	}
}
