package vehicle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customer.CustomerLoginAccountPage3;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateVehiclePage1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateVehiclePage1 frame = new UpdateVehiclePage1();
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
	
	public UpdateVehiclePage1() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1247, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Update Vehicle Page");
		ImageIcon icon;
	    icon = new ImageIcon("images/32.png");
	    setIconImage(icon.getImage());
		
		
		JLabel lblUpdateVehicle = new JLabel("Update Vehicle");
		lblUpdateVehicle.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateVehicle.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblUpdateVehicle.setBounds(323, 27, 459, 65);
		contentPane.add(lblUpdateVehicle);
		
		JLabel lblNicNumber_1_2 = new JLabel("NIC Number");
		lblNicNumber_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2.setBounds(10, 263, 213, 34);
		contentPane.add(lblNicNumber_1_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(267, 261, 376, 34);
		contentPane.add(textField);
		
		JLabel lblNicNumber_1 = new JLabel("Vehicle Number");
		lblNicNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1.setBounds(10, 132, 213, 34);
		contentPane.add(lblNicNumber_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String id = textField_1.getText();
				try {
					pst =  con.prepareStatement("select * from vehicle where v_number=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						String a = rs.getString(9);
						textField_4.setText(rs.getString(5));
						textField_5.setText(rs.getString(7));
						textField_6.setText(rs.getString(2));
						textField_7.setText(rs.getString(3));
					try {
							pst =  con.prepareStatement("select * from customer where idnumber=?");
							pst.setString(1, a);
							rs = pst.executeQuery();
							if (rs.next()==true) {
								textField_3.setText(rs.getString(4));
							}						
						} catch (Exception e2) {
												}	

					}
				
				} catch (Exception e2) {
				
				
				
				}}
		});
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(267, 130, 376, 34);
		contentPane.add(textField_1);
		
		JLabel lblNicNumber_1_1_2 = new JLabel("Mobile Number");
		lblNicNumber_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_1_2.setBounds(10, 379, 213, 34);
		contentPane.add(lblNicNumber_1_1_2);
		
		final JCheckBox cb = new JCheckBox("");
		cb.setEnabled(false);
		cb.setBounds(677, 380, 29, 33);
		contentPane.add(cb);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(267, 377, 376, 34);
		contentPane.add(textField_2);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerLoginAccountPage3 page1 = new CustomerLoginAccountPage3();
				page1.show();
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack_1.setBounds(10, 627, 146, 45);
		contentPane.add(btnBack_1);
		
		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		int a = textField_3.getText().length();
				
				if (a>0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username1 = textField.getText();
					String password1 = textField_1.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from vehicle where v_nic = '"+username1+"'and v_number='"+password1+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
						String username = textField.getText();
						String password = passwordField.getText();
				         Statement stm1 = con.createStatement();
				         String sql1 = "select * from customer where idnumber = '"+username+"'and c_password='"+password+"'";
						ResultSet rs1 = stm1.executeQuery(sql1);
					cb.setSelected(true);
						con.close();
					} 
					
					else {
						JOptionPane.showMessageDialog(null, "NIC and Password do not match", "Verify Error", JOptionPane.ERROR_MESSAGE);
						textField_1.setText("");
						textField.setText("");
						passwordField.setText("");
						textField_3.setText("");
					}
				
					con.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "NIC and Password do not match", "Verify Error", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Please enter the Mobile Number", "Verify Error", JOptionPane.INFORMATION_MESSAGE);
			}
			}
		});
		btnVerify.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVerify.setBounds(565, 432, 163, 45);
		contentPane.add(btnVerify);
		
		JLabel lblNicNumber_1_2_1 = new JLabel("First we need to verify your details");
		lblNicNumber_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_1.setForeground(Color.RED);
		lblNicNumber_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_1.setBounds(38, 202, 579, 34);
		contentPane.add(lblNicNumber_1_2_1);
		
		JLabel lblNicNumber_1_2_2 = new JLabel("Password");
		lblNicNumber_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_2.setBounds(10, 322, 213, 34);
		contentPane.add(lblNicNumber_1_2_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(267, 322, 376, 31);
		contentPane.add(passwordField);
		
		JLabel lblNicNumber_1_2_3 = new JLabel("Owner");
		lblNicNumber_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3.setBounds(788, 172, 163, 34);
		contentPane.add(lblNicNumber_1_2_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(983, 173, 182, 34);
		contentPane.add(textField_3);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(780, 111, 2, 330);
		contentPane.add(separator);
		
		JLabel lblNicNumber_1_2_3_1 = new JLabel("Vehicle Details");
		lblNicNumber_1_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_1.setBounds(895, 111, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(983, 218, 182, 34);
		contentPane.add(textField_4);
		
		JLabel lblNicNumber_1_2_3_2 = new JLabel("Chassi Number");
		lblNicNumber_1_2_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_2.setBounds(788, 217, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(983, 263, 182, 34);
		contentPane.add(textField_5);
		
		JLabel lblNicNumber_1_2_3_3 = new JLabel("Liters Per Week");
		lblNicNumber_1_2_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_3.setBounds(788, 262, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_3);
		
	
		
		JLabel lblNicNumber_1_2_3_2_1 = new JLabel("Vehicle Type");
		lblNicNumber_1_2_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_2_1.setBounds(788, 307, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_2_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(983, 308, 182, 34);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(983, 353, 182, 34);
		contentPane.add(textField_7);
		
		JLabel lblNicNumber_1_2_3_3_1 = new JLabel("Vehicle Model");
		lblNicNumber_1_2_3_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1_2_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_3_3_1.setBounds(788, 352, 163, 34);
		contentPane.add(lblNicNumber_1_2_3_3_1);
		
		JButton btnNextPage = new JButton("Next Page");
		btnNextPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cb.isSelected()==true ) {
					dispose();
					UpdateVehiclePage2 page1 = new UpdateVehiclePage2();
					page1.show();
				}
				
			}
		});
		btnNextPage.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNextPage.setBounds(1044, 568, 163, 45);
		contentPane.add(btnNextPage);
		
		JLabel lblNicNumber_1_2_1_1 = new JLabel("If your details are correct go to the next ");
		lblNicNumber_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNicNumber_1_2_1_1.setForeground(Color.RED);
		lblNicNumber_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_1_1.setBounds(836, 452, 371, 34);
		contentPane.add(lblNicNumber_1_2_1_1);
		
		JLabel lblNicNumber_1_2_1_1_1 = new JLabel(" page if not please contact the help center");
		lblNicNumber_1_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNicNumber_1_2_1_1_1.setForeground(Color.RED);
		lblNicNumber_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1_2_1_1_1.setBounds(813, 497, 394, 34);
		contentPane.add(lblNicNumber_1_2_1_1_1);
	}
}
