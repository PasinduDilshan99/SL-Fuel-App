package vehicle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customer.CustomerLoginAccountPage3;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateVehiclePage2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateVehiclePage2 frame = new UpdateVehiclePage2();
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
	
	public UpdateVehiclePage2() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1295, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Update Vehicle Page");
		ImageIcon icon;
	    icon = new ImageIcon("images/32.png");
	    setIconImage(icon.getImage());
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(906, 109, 2, 217);
		contentPane.add(separator);
		
		JLabel lblNicNumber_1 = new JLabel("Vehicle Number");
		lblNicNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1.setBounds(44, 127, 213, 34);
		contentPane.add(lblNicNumber_1);
		
		JLabel lblNicNumber_1_1 = new JLabel("Vehicle Type");
		lblNicNumber_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1.setBounds(44, 174, 213, 34);
		contentPane.add(lblNicNumber_1_1);
		
		JLabel lblNicNumber_1_1_1 = new JLabel("Vehicle Model");
		lblNicNumber_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_1.setBounds(44, 223, 213, 34);
		contentPane.add(lblNicNumber_1_1_1);
		
		JLabel lblNicNumber_1_1_1_1 = new JLabel("NIC Number");
		lblNicNumber_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_1_1.setBounds(44, 268, 213, 34);
		contentPane.add(lblNicNumber_1_1_1_1);
		
		JLabel lblNicNumber_1_2 = new JLabel("Chassi Number");
		lblNicNumber_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2.setBounds(44, 315, 213, 34);
		contentPane.add(lblNicNumber_1_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(301, 313, 376, 34);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(301, 172, 376, 34);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				textField_1.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField.setText("");
				
				String id = textField_2.getText();
				try {
					pst =  con.prepareStatement("select * from vehicle where v_number=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(2));
						textField_5.setText(rs.getString(3));
						textField_6.setText(rs.getString(9));
						textField.setText(rs.getString(5));
						textField_4.setText(rs.getString(7));
			
					}
				
				} catch (Exception e2) {
				
				}
				
			}
		});
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(301, 125, 376, 34);
		contentPane.add(textField_2);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdateVehiclePage1 page1 = new UpdateVehiclePage1();
				page1.show();
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack_1.setBounds(44, 622, 146, 45);
		contentPane.add(btnBack_1);
		
		JLabel lblNicNumber_1_1_2_1_1 = new JLabel("If you are renting a vehicle or have a taxi please enter your police report ID which you get from the police station.");
		lblNicNumber_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_2_1_1.setBounds(68, 418, 1117, 34);
		contentPane.add(lblNicNumber_1_1_2_1_1);
		
		JLabel lblNicNumber_1_1_2_1 = new JLabel("Police Report ID");
		lblNicNumber_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_2_1.setBounds(44, 483, 213, 34);
		contentPane.add(lblNicNumber_1_1_2_1);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setBounds(707, 483, 33, 23);
		contentPane.add(chckbxNewCheckBox);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setText("0");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(301, 481, 376, 34);
		contentPane.add(textField_3);
		
		JButton btnVerify = new JButton("verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField_2.getText();
					String password = textField_3.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from police_report where  pr_v_number= '"+username+"'and pr_id='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						chckbxNewCheckBox.setSelected(true);
					}else {
						JOptionPane.showInternalMessageDialog(null,"You do not have any report");
						textField_2.setText("");
						textField_3.setText("");
				
					}
					
					con.close();
				} catch (Exception e2) {
					
				}
			}
		});
		btnVerify.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVerify.setBounds(793, 484, 115, 35);
		contentPane.add(btnVerify);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setText("0");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(1016, 224, 163, 34);
		contentPane.add(textField_4);
		
		JLabel lblNicNumber_1_3 = new JLabel("Valid Fuel Liters");
		lblNicNumber_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_3.setBounds(982, 174, 213, 34);
		contentPane.add(lblNicNumber_1_3);
		
		JButton btnAddVehicle = new JButton("Update");
		btnAddVehicle.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {

				 
				 String id = textField_2.getText();
					double vpr1 = 0.0;
					try {
						pst =  con.prepareStatement("select * from vehicle where v_number=?");
						pst.setString(1, id);
						rs = pst.executeQuery();
						if (rs.next()==true) {
							String vpr = rs.getString(9);
						vpr1 = Double.parseDouble(vpr);
						}
					
					} catch (Exception e2) {
					
					}	
					
					if (chckbxNewCheckBox.isSelected() == true) {
						try {		
							String pr = textField_3.getText();
							if (vpr1 < 1) {
		
							double li1 = Double.parseDouble(textField_4.getText());
							double li = li1 +10;
							pst = con.prepareStatement("update vehicle set v_pr=?, fuel=? where v_number=?");
							pst.setString(1, pr);
							pst.setDouble(2, li);
							pst.setString(3, id);
							int k = pst.executeUpdate();
							if (k ==1) {
								JOptionPane.showMessageDialog(null, "Record updated");
								textField_3.setText("");
								textField_4.setText("");
				
							}else {
								JOptionPane.showMessageDialog(null, "Record faild");
							}}else {
								JOptionPane.showMessageDialog(null, "alread exists");
							}
							
						} catch (Exception e2) {
							
						}
					}else {
						JOptionPane.showMessageDialog(null, "You can't access it");
						textField_3.setText("");
						textField_4.setText("");
						
					}
					textField.setText("");
					textField_2.setText("");textField_5.setText("");
					textField_3.setText("");textField_6.setText("");
					textField_4.setText("");textField_1.setText("");
				 
			}
		});
		btnAddVehicle.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddVehicle.setBounds(1022, 610, 163, 45);
		contentPane.add(btnAddVehicle);
		
		JLabel lblAddAVehicle = new JLabel("Update Police Report");
		lblAddAVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAVehicle.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblAddAVehicle.setBounds(391, 22, 459, 65);
		contentPane.add(lblAddAVehicle);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(301, 223, 376, 34);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(301, 268, 376, 34);
		contentPane.add(textField_6);
		
	
	}

}
