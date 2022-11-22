package adminGovernment;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateAccountForFuelStationManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountForFuelStationManager frame = new CreateAccountForFuelStationManager();
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
	
	public CreateAccountForFuelStationManager() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Create Account For Fuel Station Manager");
		ImageIcon icon;
	    icon = new ImageIcon("images/9.png");
	    setIconImage(icon.getImage());
		
		JLabel lblCreateAccountFor_1 = new JLabel("Create Account For Fuel Station Manager");
		lblCreateAccountFor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccountFor_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCreateAccountFor_1.setBounds(339, 26, 669, 81);
		contentPane.add(lblCreateAccountFor_1);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFullName.setBounds(235, 182, 200, 38);
		contentPane.add(lblFullName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(470, 133, 341, 38);
		contentPane.add(textField);
		
		JLabel lblStationCode = new JLabel("Station Code");
		lblStationCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblStationCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStationCode.setBounds(235, 133, 200, 38);
		contentPane.add(lblStationCode);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(470, 182, 341, 38);
		contentPane.add(textField_1);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdress.setBounds(235, 280, 200, 38);
		contentPane.add(lblAdress);
		
		final JTextArea textArea = new JTextArea();
		textArea.setRows(3);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(470, 285, 341, 64);
		contentPane.add(textArea);
		
		JLabel lblContactNumber_1 = new JLabel("Contact Number");
		lblContactNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNumber_1.setBounds(235, 231, 200, 38);
		contentPane.add(lblContactNumber_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(470, 231, 341, 38);
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
		btnBack_1.setBounds(48, 633, 146, 45);
		contentPane.add(btnBack_1);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String a = textField.getText();
				String b = textField_1.getText();
				String c = textField_2.getText();
				String d = textArea.getText();
				String f = textField_3.getText();
				String g = passwordField.getText();
				String h = passwordField_1.getText();
			
				if (g.equals(h)) {
					if (a.length()>0) {						
                if (b.length() > 1) {
					if (c.length() >1) {
						if (d.length()>1) {
							if (f.length()>1) {
				
				
				
				
				try {
					pst = con.prepareStatement("insert into adminmanager(a_id_stationcode,a_name,a_tele,a_address,a_nic,a_password)values(?,?,?,?,?,?)");
					pst.setString(1, a);
					pst.setString(2, b);
					pst.setString(3, c);
					pst.setString(4, d);
					pst.setString(5, f);
					pst.setString(6, g);
					pst.executeLargeUpdate();
					JOptionPane.showInternalMessageDialog(null,"Successfully created....... ");
				 textField.setText("");
				textField_1.setText("");
				 textField_2.setText("");
				 textArea.setText("");
			 textField_3.setText("");
			 passwordField.setText("");
		 passwordField_1.setText("");	 
		
				} catch (Exception e2) {
				
				}
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
				
				
				}else {
					JOptionPane.showMessageDialog(null, "Password does not match", "Password Error", JOptionPane.ERROR_MESSAGE);
				}
				

			
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCreate.setBounds(921, 464, 146, 45);
		contentPane.add(btnCreate);
		
		JLabel lblNicNumber = new JLabel("NIC Number");
		lblNicNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNicNumber.setBounds(235, 366, 200, 38);
		contentPane.add(lblNicNumber);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(470, 366, 341, 38);
		contentPane.add(textField_3);
		
		JLabel lblPassword = new JLabel("Temporly Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(213, 421, 200, 38);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(470, 418, 341, 38);
		contentPane.add(passwordField);
		
		JLabel lblReEnterTemporly = new JLabel("Re-Enter Temporly Password");
		lblReEnterTemporly.setHorizontalAlignment(SwingConstants.CENTER);
		lblReEnterTemporly.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReEnterTemporly.setBounds(174, 467, 271, 38);
		contentPane.add(lblReEnterTemporly);

		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(834, 476, 42, 29);
		contentPane.add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(834, 476, 42, 29);
		contentPane.add(lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				lblNewLabel_1.setIcon(null);
				lblNewLabel.setIcon(null);
				String z1 = passwordField.getText();
				String z2 = passwordField_1.getText();
				if (z1.equals(z2)) {
					if (z1.length() > 1) {
					ImageIcon dabIcon = new ImageIcon("images/42.png");
					Image dabImage = dabIcon.getImage();
					Image mod = dabImage.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
					dabIcon = new ImageIcon(mod);
					lblNewLabel_1.setIcon(dabIcon);
					}
					
				}else {
					
					ImageIcon dabIcon1 = new ImageIcon("images/47.png");
					Image dabImage1 = dabIcon1.getImage();
					Image mod1 = dabImage1.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
					dabIcon1 = new ImageIcon(mod1);
					lblNewLabel.setIcon(dabIcon1);
				}
				
			}
		});
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField_1.setBounds(470, 467, 341, 38);
		contentPane.add(passwordField_1);
		
	}
}
