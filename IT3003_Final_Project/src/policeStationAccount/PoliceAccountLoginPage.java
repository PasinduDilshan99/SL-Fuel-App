package policeStationAccount;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainMenuPage;
import pomper.PomperAccountLoginPage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PoliceAccountLoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoliceAccountLoginPage frame = new PoliceAccountLoginPage();
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
	public PoliceAccountLoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login Page - Police Account");
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblLoginPage.setBounds(251, 11, 538, 76);
		contentPane.add(lblLoginPage);
		setTitle("Police Account Login");
		ImageIcon icon;
	    icon = new ImageIcon("images/34.png");
	    setIconImage(icon.getImage());
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(318, 192, 280, 45);
		contentPane.add(textField);
		
		JLabel lblPoliceStationId = new JLabel("Police Station ID");
		lblPoliceStationId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId.setBounds(28, 184, 213, 59);
		contentPane.add(lblPoliceStationId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(28, 268, 213, 59);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(318, 278, 280, 40);
		contentPane.add(passwordField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 MainMenuPage p1 = new MainMenuPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(45, 565, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null,"Please Enter the Station ID");
				}
				else if (passwordField.getText().equals("")) {
                         	JOptionPane.showInternalMessageDialog(null,"Please Enter the Password");
                        }
                   else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField.getText();
					String password = passwordField.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from police_account where ps_id = '"+username+"'and p_password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						dispose();
						PoliceReportUpdatePage prp3 = new PoliceReportUpdatePage();
						prp3.show();
					}else {
						JOptionPane.showInternalMessageDialog(null,"Station ID or password wrong");
						textField.setText("");
						passwordField.setText("");
					}
					con.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
                   }
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(757, 279, 146, 45);
		contentPane.add(btnNewButton);
	}
}
