package customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerLoginAccountPage2 extends JFrame {

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
					CustomerLoginAccountPage2 frame = new CustomerLoginAccountPage2();
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
	public CustomerLoginAccountPage2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1208, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login Account - Mobile Verification");
		ImageIcon icon;
	    icon = new ImageIcon("images/6.png");
	    setIconImage(icon.getImage());
		JLabel lblVerifyYourMobile = new JLabel("Verify Your Mobile Number");
		lblVerifyYourMobile.setHorizontalAlignment(SwingConstants.CENTER);
		lblVerifyYourMobile.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblVerifyYourMobile.setBounds(337, 11, 538, 103);
		contentPane.add(lblVerifyYourMobile);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(412, 230, 280, 45);
		contentPane.add(textField);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNumber.setBounds(122, 222, 213, 59);
		contentPane.add(lblMobileNumber);
		
		JLabel lblOtp = new JLabel("OTP");
		lblOtp.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOtp.setBounds(122, 286, 213, 59);
		contentPane.add(lblOtp);
		
		JButton btnGetCode = new JButton("Get Code");
		btnGetCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGetCode.setBounds(767, 230, 146, 45);
		contentPane.add(btnGetCode);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerLoginAccountPage1 p1 = new CustomerLoginAccountPage1();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(82, 542, 146, 45);
		contentPane.add(btnBack);
		
		JLabel lblEnterYourMobile = new JLabel("Enter Your Mobile number in below text box and get the OTP in your mobile number and it type the below OTP code blank the you can verify");
		lblEnterYourMobile.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourMobile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterYourMobile.setBounds(82, 135, 1047, 59);
		contentPane.add(lblEnterYourMobile);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(412, 294, 280, 45);
		contentPane.add(textField_1);
		
		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerLoginAccountPage3 p1 = new CustomerLoginAccountPage3();
				p1.show();
			}
		});
		btnVerify.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnVerify.setBounds(767, 294, 146, 45);
		contentPane.add(btnVerify);
		
		JLabel lblThisPageNot = new JLabel("This page not coded. Please enter the verify and goto next page");
		lblThisPageNot.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisPageNot.setForeground(Color.RED);
		lblThisPageNot.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblThisPageNot.setBounds(122, 386, 851, 59);
		contentPane.add(lblThisPageNot);
		
		JLabel lblPleaseLoginYour_1 = new JLabel("");
		lblPleaseLoginYour_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseLoginYour_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseLoginYour_1.setBounds(573, 386, 391, 82);
		contentPane.add(lblPleaseLoginYour_1);
	}
}
