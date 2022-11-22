package customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class CustomerUpdatePage extends JFrame {

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
					CustomerUpdatePage frame = new CustomerUpdatePage();
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
	
	public CustomerUpdatePage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1236, 745);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Personal Details Update");
		ImageIcon icon;
	    icon = new ImageIcon("images/15.jpg");
	    setIconImage(icon.getImage());
		
		JLabel lblPersonalDetailsUpdate = new JLabel("Personal Details Update");
		lblPersonalDetailsUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalDetailsUpdate.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPersonalDetailsUpdate.setBounds(332, 27, 538, 81);
		contentPane.add(lblPersonalDetailsUpdate);
		
		final JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setRows(3);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(350, 290, 280, 64);
		contentPane.add(textArea);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setRows(3);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_1.setBounds(350, 456, 280, 64);
		contentPane.add(textArea_1);
		
		JLabel lblNicNumber = new JLabel("NIC Number");
		lblNicNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNicNumber.setBounds(120, 133, 200, 38);
		contentPane.add(lblNicNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(350, 133, 280, 38);
		contentPane.add(textField);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = textField.getText();
				String address = textArea_1.getText();
				
				try {
					
					pst = con.prepareStatement("update customer set c_address=? where idnumber=?");
					pst.setString(1, address);
					pst.setString(2, id);
					int k = pst.executeUpdate();
					if (k ==1) {
						JOptionPane.showMessageDialog(null, "Record updated");
						textArea_1.setText("");		
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Record faild");
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(685, 475, 146, 45);
		contentPane.add(btnUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(94, 377, 977, 2);
		contentPane.add(separator);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(350, 182, 280, 38);
		contentPane.add(textField_1);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFullName.setBounds(120, 182, 200, 38);
		contentPane.add(lblFullName);
		
		JLabel lblNewMobileNumber = new JLabel("New Mobile Number");
		lblNewMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewMobileNumber.setBounds(115, 404, 200, 38);
		contentPane.add(lblNewMobileNumber);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(350, 404, 280, 38);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(350, 231, 280, 38);
		contentPane.add(textField_3);
		
	
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobileNumber.setBounds(120, 231, 200, 38);
		contentPane.add(lblMobileNumber);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerLoginAccountPage3 p3 = new CustomerLoginAccountPage3();
				p3.show();
			}
		});
		btnBack_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack_1.setBounds(62, 596, 146, 45);
		contentPane.add(btnBack_1);
		
		JButton btnChange_1_1 = new JButton("OK");
		btnChange_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id1 = textField.getText();
				try {
					pst =  con.prepareStatement("select * from customer where idnumber=?");
					pst.setString(1, id1);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(4));				
						textField_3.setText(rs.getString(2));	
						textArea.setText(rs.getString(5));
						
					}
				
				} catch (Exception e2) {
				
				}	
			}
		});
		btnChange_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnChange_1_1.setBounds(673, 126, 146, 45);
		contentPane.add(btnChange_1_1);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdress.setBounds(120, 297, 200, 38);
		contentPane.add(lblAdress);
		
		
		
		JLabel lblNewAddress = new JLabel("New Address");
		lblNewAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewAddress.setBounds(120, 463, 200, 38);
		contentPane.add(lblNewAddress);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id = textField.getText();
					String tele = textField_2.getText();
					pst = con.prepareStatement("update customer set c_tele=? where idnumber=?");
					pst.setString(1, tele);
					pst.setString(2, id);
					int k = pst.executeUpdate();
					if (k ==1) {
						JOptionPane.showMessageDialog(null, "Record updated");
						textField_2.setText("");
		
					}else {
						JOptionPane.showMessageDialog(null, "Record faild");
					}
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate_1.setBounds(685, 397, 146, 45);
		contentPane.add(btnUpdate_1);
	}
}
