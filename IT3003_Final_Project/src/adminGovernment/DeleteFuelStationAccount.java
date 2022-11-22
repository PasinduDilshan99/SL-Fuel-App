package adminGovernment;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


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
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteFuelStationAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFuelStationAccount frame = new DeleteFuelStationAccount();
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
	ResultSet rs;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
		} catch (ClassNotFoundException ex) {
		
		}catch (Exception ex) {
			 
		}
	}
	
	public DeleteFuelStationAccount() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1317, 786);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Delete Fuel Station Account");
		ImageIcon icon;
	    icon = new ImageIcon("images/12.png");
	    setIconImage(icon.getImage());
		
		JLabel lblDeleteStation = new JLabel("Delete Station");
		lblDeleteStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteStation.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblDeleteStation.setBounds(352, 42, 459, 65);
		contentPane.add(lblDeleteStation);
		
		JLabel lblNicNumber_1_2 = new JLabel("User");
		lblNicNumber_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2.setBounds(39, 278, 213, 34);
		contentPane.add(lblNicNumber_1_2);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				 if (textField_1.getText().equals("")) {
	            	 JOptionPane.showMessageDialog(null, "First enter your Station Code", "Error", JOptionPane.INFORMATION_MESSAGE);
	                }
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(296, 276, 376, 34);
		contentPane.add(textField);
		
		JLabel lblNicNumber_1 = new JLabel("Station Code");
		lblNicNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1.setBounds(39, 147, 213, 34);
		contentPane.add(lblNicNumber_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String id = textField_1.getText();
				try {
					pst =  con.prepareStatement("select * from fuelstation where s_code=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_3.setText(rs.getString(2));
						textField_4.setText(rs.getString(4));
						textField_5.setText(rs.getString(3));				
					}
				
				} catch (Exception e2) {
				
				}	
				
			}
		});
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(296, 148, 376, 34);
		contentPane.add(textField_1);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 AdminGovernmentMenuPage  p1 = new AdminGovernmentMenuPage();
				p1.show();
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack_1.setBounds(39, 642, 146, 45);
		contentPane.add(btnBack_1);
		
		JButton btnAddVehicle = new JButton("Delete");
		btnAddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField.getText();
					String password = passwordField.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from admingovernment where ad_idgovernment = '"+username+"'and ad_password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						try {
							String id = textField_1.getText();
							pst = con.prepareStatement("delete from fuelstation where s_code=?");
							pst.setString(1,id);
							int k = pst.executeUpdate();
							if (k == 1) {
								JOptionPane.showMessageDialog(null, "record deleted");
								textField_1.setText("");
								
							}else {
								JOptionPane.showMessageDialog(null, "Faild");
							}
							
						
							pst = con.prepareStatement("delete from adminmanager where a_id_stationcode=?");
							pst.setString(1,id);
							int j = pst.executeUpdate();
							if (j == 1) {
								
								textField_1.setText("");
								
							}else {
						
							}
							
							} catch (Exception e2) {
						
							}
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Username and Password do not match", "Verify Error", JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						passwordField.setText("");
					}
					con.close();
				} catch (Exception e2) {
					
				}
				
			}
		});
		btnAddVehicle.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddVehicle.setBounds(597, 391, 163, 45);
		contentPane.add(btnAddVehicle);
		
		JLabel lblNicNumber_1_2_1 = new JLabel("First we need to verify your details");
		lblNicNumber_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_1.setForeground(Color.RED);
		lblNicNumber_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_1.setBounds(67, 217, 579, 34);
		contentPane.add(lblNicNumber_1_2_1);
		
		JLabel lblNicNumber_1_2_2 = new JLabel("Password");
		lblNicNumber_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_2.setBounds(39, 337, 213, 34);
		contentPane.add(lblNicNumber_1_2_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(296, 337, 376, 31);
		contentPane.add(passwordField);
		
		JLabel lblNicNumber_1_2_3 = new JLabel("Owner");
		lblNicNumber_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3.setBounds(817, 187, 163, 34);
		contentPane.add(lblNicNumber_1_2_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(1012, 188, 182, 34);
		contentPane.add(textField_3);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(785, 141, 2, 257);
		contentPane.add(separator);
		
		JLabel lblNicNumber_1_2_3_1 = new JLabel("Station Details");
		lblNicNumber_1_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_1.setBounds(924, 126, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(1012, 233, 182, 34);
		contentPane.add(textField_4);
		
		JLabel lblNicNumber_1_2_3_2 = new JLabel("Address");
		lblNicNumber_1_2_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_2.setBounds(817, 232, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(1012, 278, 182, 34);
		contentPane.add(textField_5);
		
		JLabel lblNicNumber_1_2_3_3 = new JLabel("Contact Number");
		lblNicNumber_1_2_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_3.setBounds(817, 277, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_3);
	}
}
