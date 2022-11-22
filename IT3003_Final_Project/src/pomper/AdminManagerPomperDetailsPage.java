package pomper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminfuelStationManager.AdminFuelStationManagerMenu;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminManagerPomperDetailsPage extends JFrame {

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
					AdminManagerPomperDetailsPage frame = new AdminManagerPomperDetailsPage();
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
	
	public AdminManagerPomperDetailsPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Pomper Details");
		ImageIcon icon;
	    icon = new ImageIcon("images/22.png");
	    setIconImage(icon.getImage());
		
		JLabel lblPomperDetails = new JLabel("Pomper Details");
		lblPomperDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPomperDetails.setBounds(256, 39, 422, 58);
		contentPane.add(lblPomperDetails);
		
		JLabel lblPomperUserId = new JLabel("Pomper User ID");
		lblPomperUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPomperUserId.setBounds(80, 160, 213, 39);
		contentPane.add(lblPomperUserId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				String id = textField.getText();
				try {
					pst =  con.prepareStatement("select * from pomper where p_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						textField_4.setText(rs.getString(5));
						textField_5.setText(rs.getString(6));
					}
				
				} catch (Exception e2) {
				
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(330, 161, 280, 39);
		contentPane.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFuelStationManagerMenu p1 = new AdminFuelStationManagerMenu();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(51, 638, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnAddPomper = new JButton("Add Pomper");
		btnAddPomper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreatePomperAccountPage p1 = new CreatePomperAccountPage();
				p1.show();
			}
		});
		btnAddPomper.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddPomper.setBounds(118, 491, 146, 45);
		contentPane.add(btnAddPomper);
		
		JLabel lblPoliceStationId_1 = new JLabel("Full Name");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(80, 210, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(330, 211, 280, 39);
		contentPane.add(textField_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Contact Number");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(80, 261, 213, 39);
		contentPane.add(lblPoliceStationId_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(330, 262, 280, 39);
		contentPane.add(textField_2);
		
		JLabel lblPoliceStationId_3 = new JLabel("NIC");
		lblPoliceStationId_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3.setBounds(80, 314, 213, 39);
		contentPane.add(lblPoliceStationId_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(330, 315, 280, 39);
		contentPane.add(textField_3);
		
		JLabel lblPoliceStationId_4 = new JLabel("Address");
		lblPoliceStationId_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_4.setBounds(80, 364, 213, 39);
		contentPane.add(lblPoliceStationId_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(330, 365, 280, 39);
		contentPane.add(textField_4);
		
		JLabel lblPoliceStationId_5 = new JLabel("Fuel Station");
		lblPoliceStationId_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5.setBounds(64, 415, 229, 39);
		contentPane.add(lblPoliceStationId_5);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(330, 416, 280, 39);
		contentPane.add(textField_5);
		
		JButton btnUpdatePomper = new JButton("Update Pomper");
		btnUpdatePomper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdatePomperAccountPage p1 = new UpdatePomperAccountPage();
				p1.show();
			}
		});
		btnUpdatePomper.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdatePomper.setBounds(379, 491, 182, 45);
		contentPane.add(btnUpdatePomper);
		
		JButton btnDeletePomper = new JButton("Delete Pomper");
		btnDeletePomper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeletePomperAccountPage p1 = new DeletePomperAccountPage();
				p1.show();
			}
		});
		btnDeletePomper.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeletePomper.setBounds(631, 491, 182, 45);
		contentPane.add(btnDeletePomper);
	}
}
