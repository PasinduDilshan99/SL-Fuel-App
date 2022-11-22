package vehicle;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customer.CustomerLoginAccountPage3;

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

public class DeleteVehiclePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
					DeleteVehiclePage frame = new DeleteVehiclePage();
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
			 
		}}
	
	
	public DeleteVehiclePage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1262, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Update Vehicle Page");
		ImageIcon icon;
	    icon = new ImageIcon("images/27.png");
	    setIconImage(icon.getImage());
		
		
		JLabel lblDeleteVehicle = new JLabel("Delete Vehicle");
		lblDeleteVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteVehicle.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblDeleteVehicle.setBounds(377, 22, 459, 65);
		contentPane.add(lblDeleteVehicle);
		
		JLabel lblNicNumber_1_2 = new JLabel("NIC Number");
		lblNicNumber_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2.setBounds(64, 258, 213, 34);
		contentPane.add(lblNicNumber_1_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(321, 256, 376, 34);
		contentPane.add(textField);
		
		JLabel lblNicNumber_1 = new JLabel("Vehicle Number");
		lblNicNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1.setBounds(64, 127, 213, 34);
		contentPane.add(lblNicNumber_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				String id = textField_1.getText();
				try {
					pst =  con.prepareStatement("select * from vehicle where v_number=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						String a = rs.getString(9);
						textField_4.setText(rs.getString(5));
						textField_5.setText(rs.getString(7));

						try {
							pst =  con.prepareStatement("select * from customer where idnumber=?");
							pst.setString(1, a);
							rs = pst.executeQuery();
							if (rs.next()==true) {
								textField_3.setText(rs.getString(4));
							}
						
						} catch (Exception e2) {
						
						}	

					}
				
				} catch (Exception e2) {
				
				}	
				
			}
		});
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(321, 125, 376, 34);
		contentPane.add(textField_1);
		
		JLabel lblNicNumber_1_1_2 = new JLabel("Mobile Number");
		lblNicNumber_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_2.setBounds(64, 374, 213, 34);
		contentPane.add(lblNicNumber_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(321, 372, 376, 34);
		contentPane.add(textField_2);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerLoginAccountPage3 page1 = new CustomerLoginAccountPage3();
				page1.show();
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack_1.setBounds(64, 622, 146, 45);
		contentPane.add(btnBack_1);
		
		JButton btnAddVehicle = new JButton("Delete");
		btnAddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				   int a = textField_1.getText().length();
					
					if (a>0) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
						String username1 = textField.getText();
						String password1 = textField_1.getText();
				         Statement stm = con.createStatement();
				         String sql = "select * from vehicle where v_nic = '"+username1+"'and v_number='"+password1+"'";
						ResultSet rs = stm.executeQuery(sql);
						   if(rs.next()) {
							
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
							String username = textField.getText();
							String password = passwordField.getText();
					         Statement stm1 = con.createStatement();
					         String sql1 = "select * from customer where idnumber = '"+username+"'and c_password='"+password+"'";
							ResultSet rs1 = stm1.executeQuery(sql1);
							if(rs1.next()) {
								
								try {
									String id = textField_1.getText();
									pst = con.prepareStatement("delete from vehicle where v_number=?");
									pst.setString(1,id);
									int k = pst.executeUpdate();
									if (k == 1) {
										JOptionPane.showMessageDialog(null, "record deleted");
										textField_2.setText("");
										
										dispose();
										CustomerLoginAccountPage3 fap3 = new CustomerLoginAccountPage3();
										fap3.show();
									}else {
										JOptionPane.showMessageDialog(null, "Faild");
									}
									
									} catch (Exception e2) {
								
									}
									
								
								
								
							}else {
								JOptionPane.showMessageDialog(null, "NIC and Password do not match", "Verify Error", JOptionPane.INFORMATION_MESSAGE);
								textField_1.setText("");
								textField_2.setText("");
								textField_3.setText("");
								textField_4.setText("");
								textField_5.setText("");
								textField.setText("");
								passwordField.setText("");
							}
							con.close();
						} 
						
						else {
							JOptionPane.showMessageDialog(null, "NIC and vehicle number do not match", "Verify Error", JOptionPane.INFORMATION_MESSAGE);
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField.setText("");
							passwordField.setText("");
						}
						con.close();
					} catch (Exception e2) {
						
					}
			
					}else {
						JOptionPane.showMessageDialog(null, "Please enter the Vehicle Number", "Verify Error", JOptionPane.INFORMATION_MESSAGE);
					}
			}
		});
		btnAddVehicle.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddVehicle.setBounds(681, 433, 163, 45);
		contentPane.add(btnAddVehicle);
		
		JLabel lblNicNumber_1_2_1 = new JLabel("First we need to verify your details");
		lblNicNumber_1_2_1.setForeground(Color.RED);
		lblNicNumber_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_1.setBounds(92, 197, 579, 34);
		contentPane.add(lblNicNumber_1_2_1);
		
		JLabel lblNicNumber_1_2_2 = new JLabel("Password");
		lblNicNumber_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_2.setBounds(64, 317, 213, 34);
		contentPane.add(lblNicNumber_1_2_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(321, 317, 376, 31);
		contentPane.add(passwordField);
		
		JLabel lblNicNumber_1_2_3 = new JLabel("Owner");
		lblNicNumber_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3.setBounds(842, 167, 163, 34);
		contentPane.add(lblNicNumber_1_2_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(1037, 168, 182, 34);
		contentPane.add(textField_3);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(810, 121, 2, 257);
		contentPane.add(separator);
		
		JLabel lblNicNumber_1_2_3_1 = new JLabel("Vehicle Details");
		lblNicNumber_1_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_1.setBounds(949, 106, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(1037, 213, 182, 34);
		contentPane.add(textField_4);
		
		JLabel lblNicNumber_1_2_3_2 = new JLabel("Chassi Number");
		lblNicNumber_1_2_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_2.setBounds(842, 212, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(1037, 258, 182, 34);
		contentPane.add(textField_5);
		
		JLabel lblNicNumber_1_2_3_3 = new JLabel("Liters Per Week");
		lblNicNumber_1_2_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_3.setBounds(842, 257, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_3);
	}
}
