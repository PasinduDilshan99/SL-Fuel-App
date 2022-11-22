package adminGovernment;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.AdminLoginMainpage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGovernmentPasswordChange extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGovernmentPasswordChange frame = new AdminGovernmentPasswordChange();
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
			 
		}}
	
	public AdminGovernmentPasswordChange() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Password Change - Admin Government");
		ImageIcon icon;
	    icon = new ImageIcon("images/8.png");
	    setIconImage(icon.getImage());
		
		JLabel lblNicNumber = new JLabel("NIC");
		lblNicNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber.setBounds(132, 168, 188, 45);
		contentPane.add(lblNicNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(365, 173, 305, 37);
		contentPane.add(textField);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblChangePassword.setBounds(295, 11, 538, 103);
		contentPane.add(lblChangePassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 AdminGovernmentMenuPage  p1 = new AdminGovernmentMenuPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(119, 553, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnPasswordChange = new JButton("Password Change");
		btnPasswordChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (passwordField_1.getText().equals(passwordField_2.getText())) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField.getText();
					String password = passwordField.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from admingovernment where ad_nic = '"+username+"'and ad_password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						
						try {
							String id = textField.getText();
						   String new_password = passwordField_1.getText();
							pst = con.prepareStatement("update admingovernment set ad_password=? where ad_nic=?");
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
								AdminLoginMainpage alp1 = new AdminLoginMainpage();
								alp1.show();

				
							}else {
								JOptionPane.showMessageDialog(null, "passwordfaild");
							}
							
						} catch (Exception e2) {

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
					System.out.println(e2.getMessage());
				}
				
				}else {
					
	            	 JOptionPane.showMessageDialog(null, "Please check the new Password", "Password Error", JOptionPane.ERROR_MESSAGE);
	               
			}
				
			}
		});
		btnPasswordChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPasswordChange.setBounds(791, 348, 198, 45);
		contentPane.add(btnPasswordChange);
		
		JLabel lblNicNumber_1 = new JLabel("Current Password");
		lblNicNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1.setBounds(132, 224, 188, 45);
		contentPane.add(lblNicNumber_1);
		
		JLabel lblNicNumber_2 = new JLabel("New Password");
		lblNicNumber_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_2.setBounds(132, 291, 188, 45);
		contentPane.add(lblNicNumber_2);
		
		JLabel lblNicNumber_3 = new JLabel("Re-Enter New Password");
		lblNicNumber_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_3.setBounds(108, 347, 212, 45);
		contentPane.add(lblNicNumber_3);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				 if (textField.getText().equals("")) {
	            	 JOptionPane.showMessageDialog(null, "First enter your User Name", "User Name Error", JOptionPane.INFORMATION_MESSAGE);
	                }
			}
		});
		passwordField.setBounds(365, 234, 305, 33);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (textField.getText().equals("")) {
	            	 JOptionPane.showMessageDialog(null, "First enter your User Name", "User Name Error", JOptionPane.INFORMATION_MESSAGE);
	                }else {
	                	 if (passwordField.getText().equals("")) {
	    	            	 JOptionPane.showMessageDialog(null, "First enter your Current Password", "Password Error", JOptionPane.INFORMATION_MESSAGE);
	    	                }
					}
			}
		});
		passwordField_1.setBounds(365, 296, 305, 33);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(365, 357, 305, 33);
		contentPane.add(passwordField_2);
	}

}
