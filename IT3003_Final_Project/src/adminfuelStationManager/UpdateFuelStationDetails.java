package adminfuelStationManager;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateFuelStationDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFuelStationDetails frame = new UpdateFuelStationDetails();
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
		} catch (ClassNotFoundException ex) {
		
		}catch (Exception ex) {
			 
		}}
	
	public UpdateFuelStationDetails() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1184, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Update Fuel Station Details");
		ImageIcon icon;
	    icon = new ImageIcon("images/15.jpg");
	    setIconImage(icon.getImage());
		
		JLabel lblNicNumber_3_1_3_1 = new JLabel("Does Not Work");
		lblNicNumber_3_1_3_1.setForeground(Color.RED);
		lblNicNumber_3_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_3_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNicNumber_3_1_3_1.setBounds(824, 286, 280, 88);
		contentPane.add(lblNicNumber_3_1_3_1);
		
		JLabel lblUpdateFuelStation = new JLabel("Update Fuel Station Details");
		lblUpdateFuelStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateFuelStation.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUpdateFuelStation.setBounds(325, 11, 538, 74);
		contentPane.add(lblUpdateFuelStation);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(300, 327, 305, 62);
		contentPane.add(textArea);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(615, 616, 305, 62);
		contentPane.add(textArea_1);
		
		JLabel lblNicNumber = new JLabel("NIC");
		lblNicNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber.setBounds(68, 122, 188, 37);
		contentPane.add(lblNicNumber);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String a1 = textField.getText();
				try {
					pst =  con.prepareStatement("select * from adminmanager where a_nic=?");
					pst.setString(1, a1);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(1));
					}
				
				} catch (Exception e2) {
				
				}	
				
				String id = textField_1.getText();
				try {
					pst =  con.prepareStatement("select * from fuelstation where s_code=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(2));
						textArea.setText(rs.getString(4));
					
			
					}
				
				} catch (Exception e2) {
				
				}	
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(300, 122, 305, 37);
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
		btnBack.setBounds(78, 644, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					String id = textField_1.getText();
					String b = textField_5.getText();
					pst = con.prepareStatement("update fuelstation set s_tele=? where s_code=?");
					pst.setString(1, b);
					pst.setString(2, id);
		
					int k = pst.executeUpdate();
					if (k ==1) {
						JOptionPane.showMessageDialog(null, "Record updated");
					
		
					}else {
						JOptionPane.showMessageDialog(null, "Record faild");
					}
		
				} catch (Exception e2) {
					
				}
				textField_4.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textArea.setText("");
				textField_1.setText("");
			 textField_5.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(959, 503, 146, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNicNumber_1 = new JLabel("Code");
		lblNicNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_1.setBounds(68, 170, 188, 37);
		contentPane.add(lblNicNumber_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(300, 170, 305, 37);
		contentPane.add(textField_1);
		
		JLabel lblNicNumber_2 = new JLabel("Contact Number");
		lblNicNumber_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_2.setBounds(68, 218, 188, 37);
		contentPane.add(lblNicNumber_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(300, 218, 305, 37);
		contentPane.add(textField_2);
		
		JLabel lblNicNumber_3 = new JLabel("Owner Name");
		lblNicNumber_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_3.setBounds(68, 269, 188, 37);
		contentPane.add(lblNicNumber_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(300, 269, 305, 37);
		contentPane.add(textField_3);
		
		JLabel lblNicNumber_3_1 = new JLabel("Address");
		lblNicNumber_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_3_1.setBounds(68, 317, 188, 37);
		contentPane.add(lblNicNumber_3_1);
		
	
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(615, 558, 305, 37);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(615, 507, 305, 37);
		contentPane.add(textField_5);
		
		JLabel lblNicNumber_2_1 = new JLabel("Contact Number");
		lblNicNumber_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_2_1.setBounds(383, 507, 188, 37);
		contentPane.add(lblNicNumber_2_1);
		
		JLabel lblNicNumber_3_2 = new JLabel("Owner Name");
		lblNicNumber_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_3_2.setBounds(383, 558, 188, 37);
		contentPane.add(lblNicNumber_3_2);
		
		JLabel lblNicNumber_3_1_1 = new JLabel("New Address");
		lblNicNumber_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_3_1_1.setBounds(383, 619, 188, 37);
		contentPane.add(lblNicNumber_3_1_1);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					String id = textField_1.getText();
					String c = textField_4.getText();
					pst = con.prepareStatement("update fuelstation set s_name=? where s_code=?");
					pst.setString(1, c);
					pst.setString(2, id);
		
					int k = pst.executeUpdate();
					if (k ==1) {
						JOptionPane.showMessageDialog(null, "Record updated");
					
		
					}else {
						JOptionPane.showMessageDialog(null, "Record faild");
					}
		
				} catch (Exception e2) {
					
				}
				textField_5.setText("");
				textField_4.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textArea.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(959, 559, 146, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					String id = textField_1.getText();
					String d = textArea_1.getText();
					pst = con.prepareStatement("update fuelstation set s_address=? where s_code=?");
					pst.setString(1, d);
					pst.setString(2, id);
		
					int k = pst.executeUpdate();
					if (k ==1) {
						JOptionPane.showMessageDialog(null, "Record updated");
					
		
					}else {
						JOptionPane.showMessageDialog(null, "Record faild");
					}
		
				} catch (Exception e2) {
					
				}
				textArea_1.setText("");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textArea.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(959, 632, 146, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnChooseANew = new JButton("Choose a New Photo");
		btnChooseANew.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnChooseANew.setBounds(844, 350, 242, 45);
		contentPane.add(btnChooseANew);
		
		JLabel lblNicNumber_3_1_2 = new JLabel("");
		lblNicNumber_3_1_2.setIcon(new ImageIcon("C:\\Users\\pasin\\eclipse-workspace\\IT3003_Final_Project\\images\\7.jpg"));
		lblNicNumber_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber_3_1_2.setBounds(794, 122, 327, 202);
		contentPane.add(lblNicNumber_3_1_2);
		
		JLabel lblNicNumber_3_1_3 = new JLabel("Update Details");
		lblNicNumber_3_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNicNumber_3_1_3.setBounds(288, 459, 188, 37);
		contentPane.add(lblNicNumber_3_1_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(486, 475, 629, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(371, 503, 2, 215);
		contentPane.add(separator_1);
		
		
	}
}
