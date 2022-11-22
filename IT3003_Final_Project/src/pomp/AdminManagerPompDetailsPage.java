package pomp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminfuelStationManager.AdminFuelStationManagerMenu;
import pomper.CreatePomperAccountPage;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminManagerPompDetailsPage extends JFrame {

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
					AdminManagerPompDetailsPage frame = new AdminManagerPompDetailsPage();
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
	public AdminManagerPompDetailsPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 753);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Pomp Details");
		ImageIcon icon;
	    icon = new ImageIcon("images/3.jpg");
	    setIconImage(icon.getImage());
		
		JLabel lblPompeDetails = new JLabel("Pomp Details");
		lblPompeDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPompeDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPompeDetails.setBounds(295, 24, 422, 58);
		contentPane.add(lblPompeDetails);
		
		JLabel lblPompeId = new JLabel("Pomp ID");
		lblPompeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPompeId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPompeId.setBounds(152, 132, 213, 39);
		contentPane.add(lblPompeId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String id = textField.getText();
				try {
					pst =  con.prepareStatement("select * from pomp where po_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(4));
						textField_3.setText(rs.getString(5));				
					}
				
				} catch (Exception e2) {
				
				}
				
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(402, 133, 280, 39);
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
		btnBack.setBounds(60, 576, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnAddPompe = new JButton("Add Pomp");
		btnAddPompe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddPompPage p1 = new AddPompPage();
				p1.show();
			}
		});
		btnAddPompe.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddPompe.setBounds(157, 398, 146, 45);
		contentPane.add(btnAddPompe);
		
		JLabel lblPoliceStationId_1 = new JLabel("Fuel Type");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(152, 182, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(402, 183, 280, 39);
		contentPane.add(textField_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Fuel Litters Count");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(152, 233, 213, 39);
		contentPane.add(lblPoliceStationId_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(402, 234, 280, 39);
		contentPane.add(textField_2);
		
		JLabel lblPoliceStationId_3 = new JLabel("Remaining Fuel Litters");
		lblPoliceStationId_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3.setBounds(152, 286, 213, 39);
		contentPane.add(lblPoliceStationId_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(402, 287, 280, 39);
		contentPane.add(textField_3);
		
		JButton btnUpdatePompe = new JButton("Update Pomp");
		btnUpdatePompe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UpdatePompPage p1 = new UpdatePompPage();
				p1.show();
			}
		});
		btnUpdatePompe.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdatePompe.setBounds(427, 398, 189, 45);
		contentPane.add(btnUpdatePompe);
		
		JButton btnDeletePompe = new JButton("Delete Pomp");
		btnDeletePompe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DeletePompPage p1 = new DeletePompPage();
				p1.show();
			}
		});
		btnDeletePompe.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeletePompe.setBounds(737, 398, 167, 45);
		contentPane.add(btnDeletePompe);
	}

}
