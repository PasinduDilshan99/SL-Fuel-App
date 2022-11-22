package pomper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminfuelStationManager.AdminFuelStationManagerMenu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreatePomperAccountPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePomperAccountPage frame = new CreatePomperAccountPage();
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
			 
		}
	}
	
	public CreatePomperAccountPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Create Pomper Account");
		ImageIcon icon;
	    icon = new ImageIcon("images/19.png");
	    setIconImage(icon.getImage());
		
		JLabel lblPomperDetails = new JLabel("Pomper Details");
		lblPomperDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPomperDetails.setBounds(349, 11, 422, 58);
		contentPane.add(lblPomperDetails);
		
		JLabel lblPomperUserId = new JLabel("Pomper User ID");
		lblPomperUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPomperUserId.setBounds(173, 132, 213, 39);
		contentPane.add(lblPomperUserId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(423, 133, 280, 39);
		contentPane.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			 AdminManagerPomperDetailsPage p1 = new AdminManagerPomperDetailsPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(34, 643, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnAddPomper = new JButton("Add Pomper");
		btnAddPomper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = textField.getText();
				String b = textField_1.getText();
				String c = textField_2.getText();
				String d = textField_3.getText();
				String f = textField_4.getText();
				String g = textField_5.getText();
				String h = passwordField.getText();
				String i = passwordField_1.getText();
				if (h.equals(i)) {
					
				try {
					pst = con.prepareStatement("insert into pomper(p_id,p_name,p_tele,p_nic,p_address,p_station_code,p_password)values(?,?,?,?,?,?,?)");
					pst.setString(1, a);
					pst.setString(2, b);
					pst.setString(3, c);
					pst.setString(4, d);
					pst.setString(5, f);
					pst.setString(6, g);
					pst.setString(7, h);
					pst.executeLargeUpdate();
					JOptionPane.showInternalMessageDialog(null,"Record..........");
			    textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			    textField_4.setText("");
				textField_5.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
					
				
				} catch (Exception e2) {
					JOptionPane.showInternalMessageDialog(null,"unsussesful..........");
				}
			}else {
				JOptionPane.showInternalMessageDialog(null,"Passwords are does not match");
			}
			}
		});
		btnAddPomper.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddPomper.setBounds(773, 620, 146, 45);
		contentPane.add(btnAddPomper);
		
		JLabel lblPoliceStationId_1 = new JLabel("Full Name");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(173, 182, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(423, 183, 280, 39);
		contentPane.add(textField_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Contact Number");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(173, 233, 213, 39);
		contentPane.add(lblPoliceStationId_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(423, 234, 280, 39);
		contentPane.add(textField_2);
		
		JLabel lblPoliceStationId_3 = new JLabel("NIC");
		lblPoliceStationId_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3.setBounds(173, 286, 213, 39);
		contentPane.add(lblPoliceStationId_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(423, 287, 280, 39);
		contentPane.add(textField_3);
		
		JLabel lblPoliceStationId_4 = new JLabel("Address");
		lblPoliceStationId_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_4.setBounds(173, 336, 213, 39);
		contentPane.add(lblPoliceStationId_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(423, 337, 280, 39);
		contentPane.add(textField_4);
		
		JLabel lblPoliceStationId_5 = new JLabel("Fuel Station");
		lblPoliceStationId_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5.setBounds(157, 387, 229, 39);
		contentPane.add(lblPoliceStationId_5);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(423, 388, 280, 39);
		contentPane.add(textField_5);
		
		JLabel lblPoliceStationId_5_1 = new JLabel("Tempory Password");
		lblPoliceStationId_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5_1.setBounds(157, 448, 229, 39);
		contentPane.add(lblPoliceStationId_5_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(423, 448, 280, 33);
		contentPane.add(passwordField);
		
		JLabel lblPoliceStationId_5_1_1 = new JLabel("Re-Enter Tempory Password");
		lblPoliceStationId_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5_1_1.setBounds(134, 498, 252, 39);
		contentPane.add(lblPoliceStationId_5_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(423, 498, 280, 33);
		contentPane.add(passwordField_1);
	}
}
