package pomp;

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
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePompPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePompPage frame = new UpdatePompPage();
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
	
	public UpdatePompPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1206, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("pomp Update");
		ImageIcon icon;
	    icon = new ImageIcon("images/15.jpg");
	    setIconImage(icon.getImage());
		
		JLabel lblUpdatePompDetails = new JLabel("Update Pomp Details");
		lblUpdatePompDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdatePompDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblUpdatePompDetails.setBounds(384, 11, 422, 58);
		contentPane.add(lblUpdatePompDetails);
		
		JLabel lblPompD = new JLabel("Pomp ID");
		lblPompD.setHorizontalAlignment(SwingConstants.CENTER);
		lblPompD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPompD.setBounds(187, 130, 213, 39);
		contentPane.add(lblPompD);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Petrol 92", "Petrol 95", "Diesel", "Super Diesel", "Kerosene"}));
		comboBox.setBounds(435, 446, 273, 36);
		contentPane.add(comboBox);
		
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
								
					}
				
				} catch (Exception e2) {
				
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(437, 131, 280, 39);
		contentPane.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminManagerPompDetailsPage p1 = new AdminManagerPompDetailsPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(85, 643, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id = textField.getText();
					String fuel_type = (String)comboBox.getSelectedItem();
	
					pst = con.prepareStatement("update pomp set po_fuel_type=? where po_id=?");
					pst.setString(1, fuel_type);
					pst.setString(2, id);
					int k = pst.executeUpdate();
					if (k ==1) {
						JOptionPane.showMessageDialog(null, "Record updated");
						textField.setText("");
			
		
					}else {
						JOptionPane.showMessageDialog(null, "Record faild");
					}
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(796, 446, 146, 45);
		contentPane.add(btnUpdate);
		
		JLabel lblPoliceStationId_1 = new JLabel("Fuel Type");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(187, 300, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(437, 301, 280, 39);
		contentPane.add(textField_1);
		
		JLabel lblPoliceStationId_5_1 = new JLabel("New Fuel Type");
		lblPoliceStationId_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5_1.setBounds(208, 448, 229, 39);
		contentPane.add(lblPoliceStationId_5_1);
		
		JLabel lblPoliceStationId_5_1_1 = new JLabel("Fuel Litters");
		lblPoliceStationId_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5_1_1.setBounds(185, 498, 252, 39);
		contentPane.add(lblPoliceStationId_5_1_1);
		
		JLabel lblPompDetails = new JLabel("Pomp Details");
		lblPompDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPompDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPompDetails.setBounds(48, 217, 213, 39);
		contentPane.add(lblPompDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(271, 236, 775, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(308, 405, 775, 2);
		contentPane.add(separator_1);
		
		JLabel lblUpdateDetails = new JLabel("Update Details");
		lblUpdateDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUpdateDetails.setBounds(85, 386, 213, 39);
		contentPane.add(lblUpdateDetails);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField.getText();
				double abc = 0.0;
				try {
					pst =  con.prepareStatement("select * from pomp where po_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
					abc = rs.getDouble(5);
						
					}
				
				} catch (Exception e2) {
				
				}	
				
				
				try {
				   String fuel_liters = textField_2.getText();
				   double abc1 = Double.parseDouble(fuel_liters);
				   double abc2 = abc1 + abc;
					pst = con.prepareStatement("update pomp set po_fuel_liters=? where po_id=?");
					pst.setDouble(1, abc2);
					pst.setString(2, id);
					int k = pst.executeUpdate();
					if (k ==1) {
						JOptionPane.showMessageDialog(null, "Record updated");
						textField_2.setText("");
						textField.setText("");
						textField_1.setText("");
			
		
					}else {
						JOptionPane.showMessageDialog(null, "Record faild");
					}
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate_1.setBounds(796, 510, 146, 45);
		contentPane.add(btnUpdate_1);
	
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(435, 498, 280, 39);
		contentPane.add(textField_2);
	}
}
