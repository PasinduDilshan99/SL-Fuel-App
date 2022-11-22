package pomper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminfuelStationManager.AdminFuelStationManagerMenu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdatePomperAccountPage extends JFrame {

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
					UpdatePomperAccountPage frame = new UpdatePomperAccountPage();
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
	
	public UpdatePomperAccountPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1096, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("update Pomper Account Page");
		ImageIcon icon;
	    icon = new ImageIcon("images/15.jpg");
	    setIconImage(icon.getImage());
		
		JLabel lblUpdatePomperDetails = new JLabel("Update Pomper Details");
		lblUpdatePomperDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdatePomperDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblUpdatePomperDetails.setBounds(351, 11, 422, 58);
		contentPane.add(lblUpdatePomperDetails);
		
		JLabel lblPomperUserId = new JLabel("Pomper User ID");
		lblPomperUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPomperUserId.setBounds(191, 80, 213, 39);
		contentPane.add(lblPomperUserId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				String id1 = textField.getText();
				try {
					pst =  con.prepareStatement("select * from pomper where p_id=?");
					pst.setString(1, id1);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));				
						textField_3.setText(rs.getString(4));	
						textField_4.setText(rs.getString(5));	
					}
				
				} catch (Exception e2) {
				
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(441, 81, 280, 39);
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
		btnBack.setBounds(52, 643, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String id = textField.getText();
					String tele = textField_5.getText();
					pst = con.prepareStatement("update pomper set p_tele=? where p_id=?");
					pst.setString(1, tele);
					pst.setString(2, id);
					int k = pst.executeUpdate();
					if (k ==1) {
						JOptionPane.showMessageDialog(null, "Record updated");
						textField_5.setText("");
						textField_4.setText("");
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_6.setText("");
		
					}else {
						JOptionPane.showMessageDialog(null, "Record faild");
					}
					
				} catch (Exception e2) {
					
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(763, 446, 146, 45);
		contentPane.add(btnUpdate);
		
		JLabel lblPoliceStationId_1 = new JLabel("Pomper Name");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(191, 182, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(441, 183, 280, 39);
		contentPane.add(textField_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Contact Number");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(191, 233, 213, 39);
		contentPane.add(lblPoliceStationId_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(441, 234, 280, 39);
		contentPane.add(textField_2);
		
		JLabel lblPoliceStationId_3 = new JLabel("NIC");
		lblPoliceStationId_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3.setBounds(191, 286, 213, 39);
		contentPane.add(lblPoliceStationId_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(441, 287, 280, 39);
		contentPane.add(textField_3);
		
		JLabel lblPoliceStationId_4 = new JLabel("Address");
		lblPoliceStationId_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_4.setBounds(191, 336, 213, 39);
		contentPane.add(lblPoliceStationId_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(441, 337, 280, 39);
		contentPane.add(textField_4);
		
		JLabel lblPoliceStationId_5_1 = new JLabel("New Mobile Number");
		lblPoliceStationId_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5_1.setBounds(175, 448, 229, 39);
		contentPane.add(lblPoliceStationId_5_1);
		
		JLabel lblPoliceStationId_5_1_1 = new JLabel("New Address");
		lblPoliceStationId_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5_1_1.setBounds(152, 498, 252, 39);
		contentPane.add(lblPoliceStationId_5_1_1);
		
		JLabel lblPomperDetails = new JLabel("Pomper Details");
		lblPomperDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPomperDetails.setBounds(52, 130, 213, 39);
		contentPane.add(lblPomperDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(275, 149, 775, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(275, 405, 775, 2);
		contentPane.add(separator_1);
		
		JLabel lblUpdateDetails = new JLabel("Update Details");
		lblUpdateDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUpdateDetails.setBounds(52, 386, 213, 39);
		contentPane.add(lblUpdateDetails);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(441, 448, 280, 39);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(441, 511, 280, 39);
		contentPane.add(textField_6);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = textField.getText();	
					String address = textField_6.getText();
					pst = con.prepareStatement("update pomper set p_address=? where p_id=?");
					pst.setString(1, address);
					pst.setString(2, id);
					int k = pst.executeUpdate();
					if (k ==1) {
						JOptionPane.showMessageDialog(null, "Record updated");
						textField_5.setText("");
						textField_4.setText("");
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_6.setText("");
						textField_3.setText("");
		
					}else {
						JOptionPane.showMessageDialog(null, "Record faild");
					}
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate_1.setBounds(763, 510, 146, 45);
		contentPane.add(btnUpdate_1);
	}
}
