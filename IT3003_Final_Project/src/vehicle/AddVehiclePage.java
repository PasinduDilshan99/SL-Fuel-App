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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class AddVehiclePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
					AddVehiclePage frame = new AddVehiclePage();
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
	private JTable table;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
		} catch (ClassNotFoundException ex) {
		
		}catch (Exception ex) {
			 
		}
	}
	
	public AddVehiclePage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1306, 779);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Add Vehicle");
		ImageIcon icon;
	    icon = new ImageIcon("images/23.png");
	    setIconImage(icon.getImage());
		
		
		JLabel lblNicNumber_1 = new JLabel("NIC Number");
		lblNicNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1.setBounds(61, 116, 213, 34);
		contentPane.add(lblNicNumber_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(318, 114, 376, 34);
		contentPane.add(textField);
		
		JLabel lblLogInTo = new JLabel("Add a Vehicle");
		lblLogInTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogInTo.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblLogInTo.setBounds(374, 11, 459, 65);
		contentPane.add(lblLogInTo);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerLoginAccountPage3 page1 = new CustomerLoginAccountPage3();
				page1.show();
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack_1.setBounds(61, 611, 146, 45);
		contentPane.add(btnBack_1);
		
		JButton btnLogin = new JButton("OK");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String abc = "";
			
				  try {
				         Statement st = con.createStatement();
				         String query = ("SELECT * FROM vehicle ORDER BY v_id DESC LIMIT 1;");
				         rs = st.executeQuery(query);
				         if (rs.next()) {
				           abc = rs.getString(1);
				         }
				      } catch (Exception ex) {
				         ex.printStackTrace();
				      }
				  if (abc.equals("")) {
					abc = "0";
				}
				  int d = Integer.parseInt(abc);
				  int f = d+1;
				  textField_1.setText(f+"");
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.setBounds(735, 116, 68, 35);
		contentPane.add(btnLogin);
		
		JLabel lblNicNumber_1_1 = new JLabel("Vehicle ID");
		lblNicNumber_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1.setBounds(61, 163, 213, 34);
		contentPane.add(lblNicNumber_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(318, 161, 376, 34);
		contentPane.add(textField_1);
		
		JLabel lblNicNumber_1_1_1 = new JLabel("Vehicle Type");
		lblNicNumber_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_1.setBounds(61, 212, 213, 34);
		contentPane.add(lblNicNumber_1_1_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Tractor", "Motor Cycle", "Scooter", "Three Wheel", "Car", "Jeep", "Van", "Bus", "JCB", "Lorry", "Container Truck"}));
		comboBox.setSelectedIndex(0);
		comboBox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
			}
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(318, 212, 287, 34);
		contentPane.add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textField_5.setText("0");
				double b = Double.parseDouble(textField_5.getText());
				comboBox_1.removeAllItems();
				String a = (String)comboBox.getSelectedItem();
				if (a == "Tractor") {
				 double  c = b + 15; 
					textField_5.setText(c + "");
					comboBox_1.addItem("Two-Wheel Tractors");
					comboBox_1.addItem("Compact Tractors");
					comboBox_1.addItem("Two-Wheel Drive Tractors");
					comboBox_1.addItem("4 Wheel Drive Tractors");
					comboBox_1.addItem("Row Crop Tractors");
					comboBox_1.addItem("Track Tractors");
					comboBox_1.addItem("Industrial Tractors");
					comboBox_1.addItem("Combine Harvester");
					comboBox_1.addItem("Pickup Truck");
					comboBox_1.addItem("Tree Shaker");
					
				}
				if (a == "Motor Cycle") {
					double  c = b + 7; 
					textField_5.setText(c + "");
					comboBox_1.addItem("Honda");comboBox_1.addItem("Yamaha");comboBox_1.addItem("Bajaj");
					comboBox_1.addItem("Suzuki");comboBox_1.addItem("kawasaki");comboBox_1.addItem("TVS");
					comboBox_1.addItem("Hero");comboBox_1.addItem("KTM");comboBox_1.addItem("Mahindra");
					comboBox_1.addItem("Demak");comboBox_1.addItem("Ducati");
				}
				
				if (a == "Scooter") {
				double c = b + 5; 
					textField_5.setText(c + "");
					comboBox_1.addItem("Honda");comboBox_1.addItem("Yamaha");comboBox_1.addItem("Bajaj");
					comboBox_1.addItem("Suzuki");comboBox_1.addItem("TVS");
					comboBox_1.addItem("Hero");
				}
				if (a == "Three Wheel") {
		           double c = b + 7.5; 
					textField_5.setText(c + "");
		           comboBox_1.addItem("Bajaj");
					comboBox_1.addItem("TVS");
			}
				if (a == "Car") {
					double  c = b + 22; 
					textField_5.setText(c + "");
					comboBox_1.addItem("Honda");comboBox_1.addItem("Toyota");comboBox_1.addItem("Nissan");
					comboBox_1.addItem("BMW");comboBox_1.addItem("Hyundai");comboBox_1.addItem("KIA");
					comboBox_1.addItem("Ford");comboBox_1.addItem("Jaguar");comboBox_1.addItem("Subaru");
					comboBox_1.addItem("Mazda");comboBox_1.addItem("Mclaren");   comboBox_1.addItem("Mini Cars");
					comboBox_1.addItem("Dodge Cars");
				}
				
				if (a == "Jeep") {
					double  c = b + 30; 
					textField_5.setText(c + "");
					comboBox_1.addItem("Nissan");comboBox_1.addItem("Suzuki");
					comboBox_1.addItem("Jeep");
					
				}
				if (a == "Van") {
					double  c = b + 40; 
					textField_5.setText(c + "");
					comboBox_1.addItem("Nissan");comboBox_1.addItem("Suzuki");
					comboBox_1.addItem("Honda");comboBox_1.addItem("Mitsubishi");
					comboBox_1.addItem("Toyota");comboBox_1.addItem("Daihatsu");
				}
				
				if (a == "Bus") {
					double  c = b + 60; 
					textField_5.setText(c + "");
					comboBox_1.addItem("Tata");comboBox_1.addItem("Mitsubishi");
					comboBox_1.addItem("Micro Golden Dragon"); comboBox_1.addItem("isuzu journey");	comboBox_1.addItem("Nissan");comboBox_1.addItem("Eicher");
				}
				if (a == "JCB") {
					double  c = b + 40; 
					textField_5.setText(c + "");
					comboBox_1.addItem("JCB 2CX");comboBox_1.addItem("JCB 3CX");
					comboBox_1.addItem("JCB 3DX Eco 4WD");comboBox_1.addItem("3DX ECOXCELLENCE");
					comboBox_1.addItem("JCB 3CX ECO 4WD");comboBox_1.addItem("Hydraulic Powerpack");
				}
				if (a == "Lorry") {
					double  c = b + 45; 
					textField_5.setText(c + "");
					comboBox_1.addItem("Tata");comboBox_1.addItem("Mitsubishi");comboBox_1.addItem("Toyota");comboBox_1.addItem("isuzu journey");
				}
				
				if (a =="Container Truck") {
					double  c = b + 100; 
					textField_5.setText(c + "");
					comboBox_1.addItem("Tata");comboBox_1.addItem("Eicher");comboBox_1.addItem("Nissan");
				}
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(318, 257, 287, 34);
		contentPane.add(comboBox_1);
		
		
		
		JLabel lblNicNumber_1_1_1_1 = new JLabel("Vehicle Model");
		lblNicNumber_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_1_1.setBounds(61, 257, 213, 34);
		contentPane.add(lblNicNumber_1_1_1_1);
		
		
		
		JLabel lblNicNumber_1_1_2 = new JLabel("Chassi Number");
		lblNicNumber_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_2.setBounds(61, 351, 213, 34);
		contentPane.add(lblNicNumber_1_1_2);
		
		JLabel lblNicNumber_1_2 = new JLabel("Vehicle Number");
		lblNicNumber_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2.setBounds(61, 304, 213, 34);
		contentPane.add(lblNicNumber_1_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(318, 302, 376, 34);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(318, 349, 376, 34);
		contentPane.add(textField_3);
		
		JLabel lblNicNumber_1_1_2_1 = new JLabel("Police Report ID");
		lblNicNumber_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_2_1.setBounds(61, 472, 213, 34);
		contentPane.add(lblNicNumber_1_1_2_1);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(318, 470, 376, 34);
		contentPane.add(textField_4);
		
		JLabel lblNicNumber_1_1_2_1_1 = new JLabel("If you are renting a vehicle or have a taxi please enter your police report ID which you get from the police station.");
		lblNicNumber_1_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_2_1_1.setBounds(85, 407, 1117, 34);
		contentPane.add(lblNicNumber_1_1_2_1_1);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setBounds(723, 483, 35, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnVerify = new JButton("verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField_2.getText();
					String password = textField_4.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from police_report where  pr_v_number= '"+username+"'and pr_id='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						chckbxNewCheckBox.setSelected(true);
						double pr = Double.parseDouble(textField_4.getText());
						double fuel = Double.parseDouble(textField_2.getText());
						
							
							if (textField_4.getText() != null) {
								fuel += 10;
								textField_2.setText(fuel + "");
							}else {pr = 0;}
						
					}else {
						JOptionPane.showInternalMessageDialog(null,"you do not have police report");
						textField_4.setText("");
				
					}
					
					con.close();
				} catch (Exception e2) {
					
				}
				
				
				
				
				
			}
		});
		btnVerify.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVerify.setBounds(810, 473, 115, 35);
		contentPane.add(btnVerify);
		
		JLabel lblNicNumber_1_3 = new JLabel("Valid Fuel Liters");
		lblNicNumber_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_3.setBounds(999, 163, 213, 34);
		contentPane.add(lblNicNumber_1_3);
		
		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(999, 212, 222, 34);
		contentPane.add(textField_5);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(923, 98, 2, 217);
		contentPane.add(separator);
		
		JButton btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nic1 = textField.getText();
				String nic2 ="";
				try {
					pst =  con.prepareStatement("select * from nic_login where nic_id=?");
					pst.setString(1, nic1);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						nic2 = rs.getString(1);
					}
				
				} catch (Exception e2) {
				
				}	
				
	
				if (nic1.equals(nic2)) {
				
	            String id = textField_1.getText();
				String v_type = (String)comboBox.getSelectedItem();
				String v_model = (String) comboBox_1.getSelectedItem();
				String v_number = textField_2.getText();
				String c_number = textField_3.getText();
				String pr1 = textField_4.getText();
				String fuel1 = textField_5.getText();
				String re_fuel1 = fuel1;
				String v_nic1 = textField.getText();
				
				int pr = Integer.parseInt(pr1);
	            double fuel = Double.parseDouble(fuel1);
	            double re_fuel= Double.parseDouble(re_fuel1);
				int v_nic = Integer.parseInt(v_nic1);
						
						
				try {
					pst = con.prepareStatement("insert into vehicle(v_id,v_type,v_model,v_number,v_ch,v_pr,fuel,re_fuel,v_nic)values(?,?,?,?,?,?,?,?,?)");
		            pst.setString(1, id);
					pst.setString(2, v_type);
					pst.setString(3, v_model);
					pst.setString(4, v_number);
					pst.setString(5, c_number);
					pst.setInt(6, pr);
					pst.setDouble(7, fuel);
					pst.setDouble(8, re_fuel);
					pst.setInt(9, v_nic);
					
					pst.executeLargeUpdate();
					JOptionPane.showInternalMessageDialog(null,"Successfully created....... ");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			  comboBox.setSelectedIndex(0);
			  comboBox_1.setSelectedIndex(0);
		 
			     dispose();
				CustomerLoginAccountPage3 clp = new CustomerLoginAccountPage3();
				clp.show();
				} catch (Exception e2) {
					JOptionPane.showInternalMessageDialog(null,"Unuccessfully created....... ");
				}
				
				}else {
					JOptionPane.showMessageDialog(null, "Please check your NIC number", "Invalid NIC", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		btnAddVehicle.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddVehicle.setBounds(1033, 611, 163, 45);
		contentPane.add(btnAddVehicle);
		
	
	}
}
