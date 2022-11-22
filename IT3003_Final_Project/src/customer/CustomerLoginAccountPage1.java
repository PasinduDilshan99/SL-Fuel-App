package customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainMenuPage;

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
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class CustomerLoginAccountPage1 extends JFrame {

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
					CustomerLoginAccountPage1 frame = new CustomerLoginAccountPage1();
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
	public CustomerLoginAccountPage1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1279, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Account");
		ImageIcon icon;
	    icon = new ImageIcon("images/6.png");
	    setIconImage(icon.getImage());
		
		JLabel lblNewLabel = new JLabel("Log in to Your Fuel Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(346, 26, 538, 103);
		contentPane.add(lblNewLabel);
		
		JLabel lblNicNumber = new JLabel("NIC Number");
		lblNicNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNicNumber.setBounds(68, 187, 213, 59);
		contentPane.add(lblNicNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(68, 271, 213, 59);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(358, 195, 280, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "First we need to idintify your NIC number", "Invalid Login", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		passwordField.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(358, 281, 280, 40);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String username = textField.getText();
					String password = passwordField.getText();
			         Statement stm = con.createStatement();
			         String sql = "select * from customer where idnumber = '"+username+"'and c_password='"+password+"'";
					ResultSet rs = stm.executeQuery(sql);
					if(rs.next()) {
						dispose();
						CustomerLoginAccountPage2 p1 = new CustomerLoginAccountPage2();
						p1.show();
					}else {
						JOptionPane.showMessageDialog(null, "Your Password or NIC dose not match", "Invalid Login", JOptionPane.ERROR_MESSAGE);
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
		btnNewButton.setBounds(797, 282, 146, 45);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenuPage p3 = new MainMenuPage();
				p3.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(85, 568, 146, 45);
		contentPane.add(btnBack);
		
		JLabel lblIfYouDo = new JLabel("If you do not have any account ? ");
		lblIfYouDo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIfYouDo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIfYouDo.setBounds(148, 361, 384, 59);
		contentPane.add(lblIfYouDo);
		
		final JLabel lblPleaseCreateOne = new JLabel("Please create one");
		lblPleaseCreateOne.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				CustomerCreateAccountPage1 p3 = new CustomerCreateAccountPage1();
				p3.show();
			}
		});
		lblPleaseCreateOne.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblPleaseCreateOne.setToolTipText("If You do not have any account please click this and goto create page and first create your account");
				lblPleaseCreateOne.setForeground(Color.red);
			}
		});
		lblPleaseCreateOne.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseCreateOne.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseCreateOne.setBounds(534, 361, 213, 59);
		contentPane.add(lblPleaseCreateOne);
		
		JLabel lblPleaseCreateOne_1 = new JLabel("");
		lblPleaseCreateOne_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblPleaseCreateOne.setForeground(Color.black);
			}
			
		});
		lblPleaseCreateOne_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseCreateOne_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseCreateOne_1.setBounds(517, 349, 298, 83);
		contentPane.add(lblPleaseCreateOne_1);
	}
}
