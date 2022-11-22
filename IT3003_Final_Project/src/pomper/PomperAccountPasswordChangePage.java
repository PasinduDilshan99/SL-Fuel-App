package pomper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.AdminLoginMainpage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PomperAccountPasswordChangePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PomperAccountPasswordChangePage frame = new PomperAccountPasswordChangePage();
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
	
	public PomperAccountPasswordChangePage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Password Change - Pomper Account");
		ImageIcon icon;
	    icon = new ImageIcon("images/30.png");
	    setIconImage(icon.getImage());
		
		JLabel lblPasswordChange = new JLabel("Password Change");
		lblPasswordChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordChange.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPasswordChange.setBounds(307, 11, 538, 81);
		contentPane.add(lblPasswordChange);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserId.setBounds(95, 117, 200, 38);
		contentPane.add(lblUserId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(325, 117, 280, 38);
		contentPane.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 PomperAccountMainMenuPage p1 = new PomperAccountMainMenuPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(37, 580, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordField_1.getText().equals(passwordField_2.getText())) {
					
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField.getText();
					String password = passwordField.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from pomper where p_id = '"+username+"'and p_password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						
						try {
							String id = textField.getText();
						   String new_password = passwordField_1.getText();
							pst = con.prepareStatement("update pomper set p_password=? where p_id=?");
							pst.setString(1, new_password);
							pst.setString(2, id);
							int k = pst.executeUpdate();
							if (k ==1) {
								JOptionPane.showMessageDialog(null, "password updated");
							  passwordField.setText("");
								passwordField_1.setText("");
								passwordField_2.setText("");
								textField.setText("");
								dispose();
								PomperAccountMainMenuPage p1 = new PomperAccountMainMenuPage();
								p1.show();
				
							}else {
								JOptionPane.showMessageDialog(null, "passwordfaild");
							}
							
						} catch (Exception e2) {
							
						}
						
					}else {
						JOptionPane.showInternalMessageDialog(null,"username or password wrong");
						textField.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						passwordField_2.setText("");
					}
					con.close();
				} catch (Exception e2) {
				
				}
			}else {
				JOptionPane.showInternalMessageDialog(null,"Your New password and Re-Enter New Password are does not match");
			}
			}
		});
		btnChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnChange.setBounds(704, 308, 146, 45);
		contentPane.add(btnChange);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurrentPassword.setBounds(95, 166, 200, 38);
		contentPane.add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewPassword.setBounds(95, 256, 200, 38);
		contentPane.add(lblNewPassword);
		
		JLabel lblReenterNewPassword = new JLabel("Re-Enter New Password");
		lblReenterNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblReenterNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReenterNewPassword.setBounds(95, 311, 200, 38);
		contentPane.add(lblReenterNewPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(61, 228, 977, 2);
		contentPane.add(separator);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(325, 172, 280, 32);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(325, 262, 280, 32);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(325, 308, 280, 32);
		contentPane.add(passwordField_2);
	}
}
