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
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletePomperAccountPage extends JFrame {

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
					DeletePomperAccountPage frame = new DeletePomperAccountPage();
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
	
	public DeletePomperAccountPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 707);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Delete Pomper Account");
		ImageIcon icon;
	    icon = new ImageIcon("images/12.png");
	    setIconImage(icon.getImage());
		
		JLabel lblPomperDetails = new JLabel("Delete Pomper");
		lblPomperDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPomperDetails.setBounds(255, 11, 422, 58);
		contentPane.add(lblPomperDetails);
		
		JLabel lblPomperUserId = new JLabel("Pomper User ID");
		lblPomperUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPomperUserId.setBounds(149, 121, 213, 39);
		contentPane.add(lblPomperUserId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				String id2 = textField.getText();
				try {
					pst =  con.prepareStatement("select * from pomper where p_id=?");
					pst.setString(1, id2);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_3.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));				
						textField_1.setText(rs.getString(4));	
						
					}
				
				} catch (Exception e2) {
				
				}
				
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(399, 122, 280, 39);
		contentPane.add(textField);
		
		JLabel lblPoliceStationId_1 = new JLabel("Pomper Name");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(147, 259, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Contact Number");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(147, 310, 213, 39);
		contentPane.add(lblPoliceStationId_2);
		
		JLabel lblPoliceStationId_3 = new JLabel("NIC");
		lblPoliceStationId_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3.setBounds(147, 363, 213, 39);
		contentPane.add(lblPoliceStationId_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(397, 364, 280, 39);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(397, 311, 280, 39);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(397, 260, 280, 39);
		contentPane.add(textField_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminManagerPomperDetailsPage p1 = new AdminManagerPomperDetailsPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(63, 559, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnDeletePomper = new JButton("Delete Pomper");
		btnDeletePomper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id = textField.getText();
					pst = con.prepareStatement("delete from pomper where p_id=?");
					pst.setString(1,id);
					int k = pst.executeUpdate();
					if (k == 1) {
						JOptionPane.showMessageDialog(null, "record deleted");
						textField.setText("");
					
					}else {
						JOptionPane.showMessageDialog(null, "Faild");
					}
					
					} catch (Exception e2) {
				
					}
			}
		});
		btnDeletePomper.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeletePomper.setBounds(670, 442, 175, 45);
		contentPane.add(btnDeletePomper);
		
		JLabel lblPoliceStationId_1_1 = new JLabel("Pomper Details");
		lblPoliceStationId_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPoliceStationId_1_1.setBounds(44, 196, 213, 39);
		contentPane.add(lblPoliceStationId_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(267, 217, 608, 2);
		contentPane.add(separator);
	}
}
