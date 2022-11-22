package customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainMenuPage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class CustomerCreateAccountPage1 extends JFrame {

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
					CustomerCreateAccountPage1 frame = new CustomerCreateAccountPage1();
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
	public CustomerCreateAccountPage1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1167, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Create Account");
		ImageIcon icon;
	    icon = new ImageIcon("images/9.png");
	    setIconImage(icon.getImage());
		
		JLabel lblCreateAccount = new JLabel("Create Account ");
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblCreateAccount.setBounds(305, 11, 538, 103);
		contentPane.add(lblCreateAccount);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(380, 230, 280, 45);
		contentPane.add(textField);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNumber.setBounds(90, 222, 213, 59);
		contentPane.add(lblMobileNumber);
		
		JLabel lblOtp = new JLabel("OTP");
		lblOtp.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOtp.setBounds(90, 333, 213, 59);
		contentPane.add(lblOtp);
		
		JLabel lblIfYouAlready = new JLabel("If you already have an account ? ");
		lblIfYouAlready.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIfYouAlready.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIfYouAlready.setBounds(170, 396, 384, 59);
		contentPane.add(lblIfYouAlready);
		
		final JLabel lblPleaseLoginYour = new JLabel("Please login your current account");
		lblPleaseLoginYour.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				CustomerLoginAccountPage1 p3 = new CustomerLoginAccountPage1();
				p3.show();
			}
		});
		lblPleaseLoginYour.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblPleaseLoginYour.setToolTipText("If You have any account please click this and goto Login page and first create your account");
				lblPleaseLoginYour.setForeground(Color.RED);
			}
		});
		lblPleaseLoginYour.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseLoginYour.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseLoginYour.setBounds(556, 396, 364, 59);
		contentPane.add(lblPleaseLoginYour);
		
		JButton btnGetCode = new JButton("Get Code");
		btnGetCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGetCode.setBounds(735, 230, 146, 45);
		contentPane.add(btnGetCode);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenuPage p3 = new MainMenuPage();
				p3.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(68, 586, 146, 45);
		contentPane.add(btnBack);
		
		JLabel lblFirstWeNeed = new JLabel("First we need to verify your mobile Number. So enter your mobile number and please verify it");
		lblFirstWeNeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstWeNeed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstWeNeed.setBounds(68, 130, 921, 59);
		contentPane.add(lblFirstWeNeed);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(380, 341, 280, 45);
		contentPane.add(textField_1);
		
		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerCreateAccountPage2 p1 = new CustomerCreateAccountPage2();
				p1.show();
			}
		});
		btnVerify.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVerify.setBounds(735, 341, 146, 45);
		contentPane.add(btnVerify);
		
		JLabel lblEnterYourOtp = new JLabel("Enter Your OTP below space");
		lblEnterYourOtp.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourOtp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterYourOtp.setBounds(316, 286, 384, 34);
		contentPane.add(lblEnterYourOtp);
		
		JLabel lblThisPageNot = new JLabel("This page not coded. Please enter the verify and goto next page");
		lblThisPageNot.setForeground(Color.RED);
		lblThisPageNot.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisPageNot.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThisPageNot.setBounds(108, 467, 851, 59);
		contentPane.add(lblThisPageNot);
		
		JLabel lblPleaseLoginYour_1 = new JLabel("");
		lblPleaseLoginYour_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblPleaseLoginYour.setForeground(Color.black);
			}
		});
		lblPleaseLoginYour_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseLoginYour_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseLoginYour_1.setBounds(541, 386, 391, 82);
		contentPane.add(lblPleaseLoginYour_1);
	}

}
