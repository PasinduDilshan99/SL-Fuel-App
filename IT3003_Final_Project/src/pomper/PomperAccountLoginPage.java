package pomper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.AdminLoginMainpage;
import main.MainMenuPage;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PomperAccountLoginPage extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PomperAccountLoginPage frame = new PomperAccountLoginPage();
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
	public PomperAccountLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Pomper Account - Login Page");
		ImageIcon icon;
	    icon = new ImageIcon("images/20.png");
	    setIconImage(icon.getImage());
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(330, 266, 280, 40);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(82, 256, 213, 59);
		contentPane.add(lblPassword);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserId.setBounds(82, 172, 213, 59);
		contentPane.add(lblUserId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(330, 180, 280, 45);
		contentPane.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				 MainMenuPage p1 = new MainMenuPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(57, 553, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField.getText();
					String password = passwordField.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from pomper where p_id = '"+username+"'and p_password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						dispose();
					PomperAccountMainMenuPage pl1 = new PomperAccountMainMenuPage();
						pl1.show();
					}else {
						JOptionPane.showInternalMessageDialog(null,"username or password wrong");
						textField.setText("");
						passwordField.setText("");
					}
					con.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(573, 358, 146, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblPomperLogin = new JLabel("Pomper Login");
		lblPomperLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperLogin.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPomperLogin.setBounds(292, 37, 306, 77);
		contentPane.add(lblPomperLogin);
	}

}
