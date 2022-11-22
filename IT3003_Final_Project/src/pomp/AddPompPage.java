package pomp;

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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPompPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPompPage frame = new AddPompPage();
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
	
	public AddPompPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Add Pomp");
		ImageIcon icon;
	    icon = new ImageIcon("images/3.jpg");
	    setIconImage(icon.getImage());
		
		JLabel lblAddPomp = new JLabel("Add Pomp");
		lblAddPomp.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPomp.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblAddPomp.setBounds(178, 21, 422, 58);
		contentPane.add(lblAddPomp);
		
		JLabel lblPompId = new JLabel("Pomp ID");
		lblPompId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPompId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPompId.setBounds(100, 131, 213, 39);
		contentPane.add(lblPompId);
		
		JLabel lblPoliceStationId_1 = new JLabel("Fuel Type");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(100, 181, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(360, 132, 280, 39);
		contentPane.add(textField);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Petrol 92", "Petrol 95", "Diesel", "Super Diesel", "Kerosene"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(360, 181, 280, 34);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(360, 233, 280, 39);
		contentPane.add(textField_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Station ID");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(100, 232, 213, 39);
		contentPane.add(lblPoliceStationId_2);
		
		JButton btnAddPomp = new JButton("Add Pomp");
		btnAddPomp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a = textField.getText();
		          String b = (String)comboBox.getSelectedItem();
					String c = textField_1.getText();
					String d = "0.0";
					String f = "0.0";
			
			
					try {
						pst = con.prepareStatement("insert into pomp(po_id,po_fuel_type,po_station_id,po_fuel_count,po_fuel_liters)values(?,?,?,?,?)");
						pst.setString(1, a);
						pst.setString(2, b);
						pst.setString(3, c);
						pst.setString(4, d);
						pst.setString(5, f);
						pst.executeLargeUpdate();
						JOptionPane.showInternalMessageDialog(null,"Record..........");
				    textField.setText("");
					textField_1.setText("");			
					
					
					} catch (Exception e2) {
						JOptionPane.showInternalMessageDialog(null,"unsussesful..........");
					}
			}
		});
		btnAddPomp.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddPomp.setBounds(595, 322, 146, 45);
		contentPane.add(btnAddPomp);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminManagerPompDetailsPage p1 = new AdminManagerPompDetailsPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(60, 475, 146, 45);
		contentPane.add(btnBack);
		
	
	}
}
