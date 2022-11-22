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
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import vehicle.AddVehiclePage;
import vehicle.DeleteVehiclePage;
import vehicle.UpdateVehiclePage1;

import javax.swing.JScrollPane;

public class CustomerLoginAccountPage3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLoginAccountPage3 frame = new CustomerLoginAccountPage3();
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
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
		} catch (ClassNotFoundException ex) {
		
		}catch (Exception ex) {
			 
		}
	}
	
	public CustomerLoginAccountPage3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1354, 798);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Account");
		ImageIcon icon;
	    icon = new ImageIcon("images/6.png");
	    setIconImage(icon.getImage());
		
		JLabel lblYourFuelAccount = new JLabel("Your Fuel Account");
		lblYourFuelAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourFuelAccount.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblYourFuelAccount.setBounds(319, 11, 538, 103);
		contentPane.add(lblYourFuelAccount);
		
		JLabel lblIdNumber = new JLabel("ID number");
		lblIdNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIdNumber.setBounds(52, 109, 203, 45);
		contentPane.add(lblIdNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(286, 114, 354, 37);
		contentPane.add(textField);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a= textField.getText();	
				String abc = "b";
				if (textField.getText().equals("")) {
					table.setModel(new DefaultTableModel(null,new String[] {"Vehicle ID","Type","Model","Vehicle Number","Chassi Number","Police Report","Fuel Amount ","Remaining Fuel","NIC"}));		
					textField_1.setText("");
				}else {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String sql = "select * from vehicle WHERE v_nic LIKE '"+a+"'";
					pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (ClassNotFoundException ex) {
				
				}catch (Exception ex) {
					 
				}finally {
					try {
						if (pst!=null) {
							rs.close();
							pst.close();
						}
					} catch (Exception e2) {
						
					}
				}
				
				}
				
				
				try {
					pst =  con.prepareStatement("select * from customer where idnumber=?");
					pst.setString(1, a);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(2));
						abc = rs.getString(2);
					}
					if (a.length()>0) {
						if (abc.equals("b")) {
							JOptionPane.showMessageDialog(null, "There is no such a NIC number", "Invalid NIC number", JOptionPane.ERROR_MESSAGE);
							table.setModel(new DefaultTableModel(null,new String[] {"Vehicle ID","Type","Model","Vehicle Number","Chassi Number","Police Report","Fuel Amount ","Remaining Fuel","NIC"}));		
							textField_1.setText("");
							textField.setText("");
						}}
				} catch (Exception e2) {
				textField_1.setText("");
				}
				
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOk.setBounds(685, 110, 74, 45);
		contentPane.add(btnOk);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerLoginAccountPage2 p2 = new CustomerLoginAccountPage2();
				p2.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(52, 675, 146, 45);
		contentPane.add(btnBack);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(286, 170, 354, 37);
		contentPane.add(textField_1);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNumber.setBounds(52, 165, 203, 45);
		contentPane.add(lblMobileNumber);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1092, 80, 203, 2);
		contentPane.add(separator);
		
		JLabel lblUpdateDetails = new JLabel("Update Details");
		lblUpdateDetails.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUpdateDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateDetails.setBounds(912, 56, 170, 45);
		contentPane.add(lblUpdateDetails);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(894, 55, 2, 189);
		contentPane.add(separator_1);
		
		JButton btnUpdatePersonalDetails = new JButton("Update  Personal Details");
		btnUpdatePersonalDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerUpdatePage up = new CustomerUpdatePage();
				up.show();
			}
		});
		btnUpdatePersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdatePersonalDetails.setBounds(980, 110, 282, 45);
		contentPane.add(btnUpdatePersonalDetails);
		
		JButton btnPasswordmChange = new JButton("Password Change");
		btnPasswordmChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerPasswordChangePage pc = new CustomerPasswordChangePage();
				pc.show();
			}
		});
		btnPasswordmChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPasswordmChange.setBounds(980, 170, 282, 45);
		contentPane.add(btnPasswordmChange);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 275, 1211, 236);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Vehicle ID", "Type", "Model", "Number", "Chassi Number", "Police Report", "Fuel Amount", "Remaining Fuel", "NIC"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnAddVehicle = new JButton("Add Vehicle");
		btnAddVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddVehiclePage page1 = new AddVehiclePage();
				page1.show();
			}
		});
		btnAddVehicle.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddVehicle.setBounds(141, 544, 182, 45);
		contentPane.add(btnAddVehicle);
		
		JButton btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.setToolTipText("You can add the Police Report");
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdateVehiclePage1 page1 = new UpdateVehiclePage1();
				page1.show();
			}
		});
		btnUpdateDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdateDetails.setBounds(577, 544, 182, 45);
		contentPane.add(btnUpdateDetails);
		
		JButton btnDeleteVehicle = new JButton("Delete Vehicle");
		btnDeleteVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeleteVehiclePage page1 = new DeleteVehiclePage();
				page1.show();
			}
		});
		btnDeleteVehicle.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeleteVehicle.setBounds(952, 544, 182, 45);
		contentPane.add(btnDeleteVehicle);
	}
}
