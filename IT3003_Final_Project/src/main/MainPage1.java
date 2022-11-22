package main;

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

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.            
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage1 frame = new MainPage1();
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
	
	public MainPage1() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("SL Fuel Application");
		ImageIcon icon;
	    icon = new ImageIcon("images/20.png");
	    setIconImage(icon.getImage());
		
		JLabel lblSlFuelApplication = new JLabel("SL Fuel Application");
		lblSlFuelApplication.setForeground(Color.BLUE);
		lblSlFuelApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlFuelApplication.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblSlFuelApplication.setBounds(319, 30, 538, 103);
		contentPane.add(lblSlFuelApplication);
		
		JLabel lblPleaseEnterThe = new JLabel("Please Enter the your NIC number and press OK button to the open the SL Fuel APP");
		lblPleaseEnterThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPleaseEnterThe.setBounds(64, 154, 1047, 59);
		contentPane.add(lblPleaseEnterThe);
		
		JLabel lblNicNumber = new JLabel("NIC Number");
		lblNicNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber.setBounds(104, 241, 213, 59);
		contentPane.add(lblNicNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(394, 249, 280, 45);
		contentPane.add(textField);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String id1 = textField.getText();
			int b = 1;
			String az = "";
			try {
				pst =  con.prepareStatement("select * from nic_login where nic_id=?");
				pst.setString(1, id1);
				rs = pst.executeQuery();
				if (rs.next()==true) {
				az = rs.getString(1);				
				}
			
			} catch (Exception e2) {
			
			}	
			
			if (id1.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the NIC Number");
			}else {
			if (az.equals("")) {

				try {
					pst = con.prepareStatement("insert into nic_login(nic_id,value)values(?,?)");
					pst.setString(1, id1);
					pst.setInt(2, b);
					pst.executeLargeUpdate();														
				} catch (Exception e2) {						
				}
				
				dispose();
		         MainPage2 p1 = new MainPage2();
		         p1.show();
			}else {
				dispose();
				MainMenuPage p2 = new MainMenuPage();
				p2.show();
			}
			
			}
				
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOk.setBounds(749, 249, 146, 45);
		contentPane.add(btnOk);
		
		JLabel lblPleaseEnterThe_2 = new JLabel("Please enter the numbers of your NIC, without letters");
		lblPleaseEnterThe_2.setForeground(Color.RED);
		lblPleaseEnterThe_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterThe_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPleaseEnterThe_2.setBounds(69, 340, 498, 45);
		contentPane.add(lblPleaseEnterThe_2);
		
		JLabel lblPleaseEnterThe_2_1 = new JLabel("eg: If your NIC number is 992200651v then Enter the nic number 992200651");
		lblPleaseEnterThe_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterThe_2_1.setForeground(Color.BLACK);
		lblPleaseEnterThe_2_1.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		lblPleaseEnterThe_2_1.setBounds(151, 381, 754, 45);
		contentPane.add(lblPleaseEnterThe_2_1);
	}
}
