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

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccountForFuelStation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountForFuelStation frame = new CreateAccountForFuelStation();
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
	
	public CreateAccountForFuelStation() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1195, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Create Account For Fuel Station");
		ImageIcon icon;
	    icon = new ImageIcon("images/7.jpg");
	    setIconImage(icon.getImage());
		
		JLabel lblCreateAccountFor = new JLabel("Create Account For Fuel Station");
		lblCreateAccountFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccountFor.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCreateAccountFor.setBounds(293, 31, 538, 81);
		contentPane.add(lblCreateAccountFor);
		
		JLabel lblOwnerName = new JLabel("Owner Name");
		lblOwnerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblOwnerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOwnerName.setBounds(102, 187, 200, 38);
		contentPane.add(lblOwnerName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(337, 138, 341, 38);
		contentPane.add(textField);
		
		JLabel lblStationCode = new JLabel("Station Code");
		lblStationCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblStationCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStationCode.setBounds(102, 138, 200, 38);
		contentPane.add(lblStationCode);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(337, 187, 341, 38);
		contentPane.add(textField_1);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdress.setBounds(102, 285, 200, 38);
		contentPane.add(lblAdress);
		
		final JTextArea textArea = new JTextArea();
		textArea.setRows(3);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(337, 290, 341, 64);
		contentPane.add(textArea);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNumber.setBounds(102, 236, 200, 38);
		contentPane.add(lblContactNumber);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(337, 236, 341, 38);
		contentPane.add(textField_2);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 AdminGovernmentMenuPage  p1 = new AdminGovernmentMenuPage();
				p1.show();
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack_1.setBounds(49, 601, 146, 45);
		contentPane.add(btnBack_1);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a = textField.getText();
				String b = textField_1.getText();
				String c = textField_2.getText();
				String d = textArea.getText();
				String f = textField_3.getText();
	
					if (a.length()>0) {						
                if (b.length() > 1) {
					if (c.length() >1) {
						if (d.length()>1) {
							if (f.length()>1) {
	
				try {
					pst = con.prepareStatement("insert into fuelstation(s_code,s_name,s_tele,s_address,s_town)values(?,?,?,?,?)");
					pst.setString(1, a);
					pst.setString(2, b);
					pst.setString(3, c);
					pst.setString(4, d);
					pst.setString(5, f);
					pst.executeLargeUpdate();
					JOptionPane.showInternalMessageDialog(null,"Successfully created....... ");
				 textField.setText("");
				textField_1.setText("");
				 textField_2.setText("");
				 textArea.setText("");
			 textField_3.setText("");
		 
				} catch (Exception e2) {
				
				}
				
				//////////////////////////////////////////////////////////////
				double li = 0.0;
				String ti = "-";
				boolean yn =  false;
				
				try {
					pst = con.prepareStatement("insert into petrol_92(st_id,p92_litters,p92_time,yesno)values(?,?,?,?)");
					pst.setString(1, a);
					pst.setDouble(2, li);
					pst.setString(3, ti);
					pst.setBoolean(4, yn);
					pst.executeLargeUpdate();
				} catch (Exception e2) {				
				}
				try {
					pst = con.prepareStatement("insert into petrol_95(st_id,p95_litters,p95_time,yesno)values(?,?,?,?)");
					pst.setString(1, a);
					pst.setDouble(2, li);
					pst.setString(3, ti);
					pst.setBoolean(4, yn);
					pst.executeLargeUpdate();
				} catch (Exception e2) {				
				}	try {
					pst = con.prepareStatement("insert into diesel(st_id,di_litters,di_time,yesno)values(?,?,?,?)");
					pst.setString(1, a);
					pst.setDouble(2, li);
					pst.setString(3, ti);
					pst.setBoolean(4, yn);
					pst.executeLargeUpdate();
				} catch (Exception e2) {				
				}	try {
					pst = con.prepareStatement("insert into super_diesel(st_id,sd_litters,sd_time,yesno)values(?,?,?,?)");
					pst.setString(1, a);
					pst.setDouble(2, li);
					pst.setString(3, ti);
					pst.setBoolean(4, yn);
					pst.executeLargeUpdate();
				} catch (Exception e2) {				
				}	try {
					pst = con.prepareStatement("insert into kerosene(st_id,ke_litters,ke_time,yesno)values(?,?,?,?)");
					pst.setString(1, a);
					pst.setDouble(2, li);
					pst.setString(3, ti);
					pst.setBoolean(4, yn);
					pst.executeLargeUpdate();
				} catch (Exception e2) {				
				}
				
				boolean z1 = false;
				String z2 = "-";
				try {
					pst = con.prepareStatement("insert into tomorrow(st_id,p92_av,p92_time,p95_av,p95_time,di_av,di_time,sd_av,sd_time,k_av,k_time)values(?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, a);
					pst.setBoolean(2, z1);
					pst.setString(3, z2);
					pst.setBoolean(4, z1);
					pst.setString(5, z2);
					pst.setBoolean(6, z1);
					pst.setString(7, z2);
					pst.setBoolean(8, z1);
					pst.setString(9, z2);
					pst.setBoolean(10, z1);
					pst.setString(11, z2);
					pst.executeLargeUpdate();
				} catch (Exception e2) {				
				}
				try {
					pst = con.prepareStatement("insert into day_after_tomorrow(st_id,p92_av,p92_time,p95_av,p95_time,di_av,di_time,sd_av,sd_time,k_av,k_time)values(?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, a);
					pst.setBoolean(2, z1);
					pst.setString(3, z2);
					pst.setBoolean(4, z1);
					pst.setString(5, z2);
					pst.setBoolean(6, z1);
					pst.setString(7, z2);
					pst.setBoolean(8, z1);
					pst.setString(9, z2);
					pst.setBoolean(10, z1);
					pst.setString(11, z2);
					pst.executeLargeUpdate();
				} catch (Exception e2) {				
				}
				try {
					pst = con.prepareStatement("insert into next_day(st_id,p92_av,p92_time,p95_av,p95_time,di_av,di_time,sd_av,sd_time,k_av,k_time)values(?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, a);
					pst.setBoolean(2, z1);
					pst.setString(3, z2);
					pst.setBoolean(4, z1);
					pst.setString(5, z2);
					pst.setBoolean(6, z1);
					pst.setString(7, z2);
					pst.setBoolean(8, z1);
					pst.setString(9, z2);
					pst.setBoolean(10, z1);
					pst.setString(11, z2);
					pst.executeLargeUpdate();
					dispose();
					 CreateAccountForFuelStationManager  p1 = new CreateAccountForFuelStationManager();
					p1.show();
				} catch (Exception e2) {				
				}
				
				
				///////////////////////////////////////////////////////////////
				
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
					JOptionPane.showMessageDialog(null, "Please Enter Station Code", "Station Code Error", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCreate.setBounds(763, 368, 146, 45);
		contentPane.add(btnCreate);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setHorizontalAlignment(SwingConstants.CENTER);
		lblTown.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTown.setBounds(102, 371, 200, 38);
		contentPane.add(lblTown);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(337, 371, 341, 38);
		contentPane.add(textField_3);
	}
}
