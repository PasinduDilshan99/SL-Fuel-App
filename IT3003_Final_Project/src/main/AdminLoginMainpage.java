package main;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminGovernment.AdminGovernmentMenuPage;

import adminfuelStationManager.AdminFuelStationManagerMenu;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLoginMainpage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginMainpage frame = new AdminLoginMainpage();
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
	public AdminLoginMainpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 720);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Admin Login Page");
		ImageIcon icon;
	    icon = new ImageIcon("images/26.png");
	    setIconImage(icon.getImage());
		
		final JRadioButton rbt1 = new JRadioButton("Fuel Station manager");
		rbt1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rbt1.setForeground(Color.red);
			
			}
		});
		rbt1.setFont(new Font("Tahoma", Font.BOLD, 18));
		rbt1.setBounds(205, 149, 250, 23);
		contentPane.add(rbt1);
		
		final JRadioButton rbt2 = new JRadioButton("Admin Government manager");
		rbt2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				rbt2.setForeground(Color.red);
				rbt1.setForeground(Color.black);
				if (rbt1.isSelected() == true) {
					rbt1.setSelected(false);
					
			
				}
			}
		});
		rbt2.setFont(new Font("Tahoma", Font.BOLD, 18));
		rbt2.setBounds(536, 152, 300, 23);
		contentPane.add(rbt2);

		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(422, 259, 280, 36);
		contentPane.add(textField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(142, 312, 213, 59);
		contentPane.add(lblPassword);
		
		JLabel lblNicNumber = new JLabel("NIC Number");
		lblNicNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber.setBounds(169, 249, 186, 45);
		contentPane.add(lblNicNumber);
		
		JLabel lblAdminAccountLogin = new JLabel("Admin Account Login");
		lblAdminAccountLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminAccountLogin.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblAdminAccountLogin.setBounds(272, 11, 538, 103);
		contentPane.add(lblAdminAccountLogin);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rbt1.isSelected() && rbt2.isSelected()) {
					JOptionPane.showInternalMessageDialog(null,"Please select only correct one");
					rbt1.setSelected(false);
					rbt2.setSelected(false);
				}
				
				
				if (rbt1.isSelected() == false) {
					if (rbt2.isSelected() == false) {
						JOptionPane.showInternalMessageDialog(null,"Please select one");
					}
				}
				
			if (rbt1.isSelected() == true) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField.getText();
					String password = passwordField.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from adminmanager where a_nic = '"+username+"'and a_password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						dispose();
						AdminFuelStationManagerMenu alp2 = new AdminFuelStationManagerMenu();
						alp2.show();
					}else {
						JOptionPane.showMessageDialog(null, "Username and Password incorrect or You can't login account. This account is admins only", "Warning.....!", JOptionPane.WARNING_MESSAGE);
						textField.setText("");
						passwordField.setText("");
					}
					con.close();
				} catch (Exception e2) {
					
				}
			}
			if (rbt2.isSelected() == true) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField.getText();
					String password = passwordField.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from admingovernment where ad_nic = '"+username+"'and ad_password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						dispose();
						AdminGovernmentMenuPage p5 = new AdminGovernmentMenuPage();
						p5.show();
					}else {
						JOptionPane.showMessageDialog(null, "Username and Password incorrect or You can't login account. This account is admins only", "Warning.....!", JOptionPane.WARNING_MESSAGE);
						textField.setText("");
						passwordField.setText("");
					}
					con.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(787, 320, 146, 45);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 MainMenuPage p1 = new MainMenuPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(75, 553, 146, 45);
		contentPane.add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(422, 327, 274, 36);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				rbt2.setForeground(Color.black);
				rbt2.setSelected(false);
			}
		});
		lblNewLabel.setBounds(161, 128, 300, 59);
		contentPane.add(lblNewLabel);
		
		
	}
}
