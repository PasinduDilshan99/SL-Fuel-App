package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import customer.CustomerCreateAccountPage1;
import customer.CustomerLoginAccountPage1;
import fuelStation.SearchFuelStation;
import policeStationAccount.PoliceAccountLoginPage;
import pomper.PomperAccountLoginPage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MainMenuPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuPage frame = new MainMenuPage();
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
	public MainMenuPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1358, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Main Menu Page");
		ImageIcon icon;
	    icon = new ImageIcon("images/26.png");
	    setIconImage(icon.getImage());
	
		
		JLabel lblSlFuelApplicane = new JLabel("SL Fuel Application Main Menu");
		lblSlFuelApplicane.setForeground(Color.DARK_GRAY);
		lblSlFuelApplicane.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlFuelApplicane.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblSlFuelApplicane.setBounds(0, 0, 608, 64);
		contentPane.add(lblSlFuelApplicane);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainPage1 p1 = new MainPage1();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(45, 674, 146, 45);
		contentPane.add(btnBack);
		
		JLabel lblLanguage = new JLabel("Language");
		lblLanguage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLanguage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLanguage.setBounds(818, 16, 168, 45);
		contentPane.add(lblLanguage);
		
		JButton btnSinhal = new JButton("Sinhala");
		btnSinhal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSinhal.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSinhal.setBounds(1112, 17, 109, 45);
		contentPane.add(btnSinhal);
		
		JButton btnEnglish = new JButton("English");
		btnEnglish.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEnglish.setBounds(990, 17, 109, 45);
		contentPane.add(btnEnglish);
		
		JButton btnTamil = new JButton("Tamil");
		btnTamil.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTamil.setBounds(1231, 17, 101, 45);
		contentPane.add(btnTamil);
		
		final JLabel lblFuelStation = new JLabel("Fuel Station");
		lblFuelStation.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				SearchFuelStation p1 = new SearchFuelStation();
				p1.show();
			}
		});
		lblFuelStation.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblFuelStation.setForeground(Color.red); 
			}
		});
		lblFuelStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelStation.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFuelStation.setBounds(167, 178, 293, 45);
		contentPane.add(lblFuelStation);
		
		final JLabel lblLoginYourAccount = new JLabel("Login Your Account");
		lblLoginYourAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				CustomerLoginAccountPage1 p1 = new CustomerLoginAccountPage1();
				p1.show();
			}
		});
		lblLoginYourAccount.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblLoginYourAccount.setForeground(Color.red);
			}
		});
		lblLoginYourAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginYourAccount.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblLoginYourAccount.setBounds(167, 249, 293, 45);
		contentPane.add(lblLoginYourAccount);
		
		final JLabel lblCreateFuelAccount = new JLabel("Create An Account");
		lblCreateFuelAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				CustomerCreateAccountPage1 p1 = new CustomerCreateAccountPage1();
				p1.show();
			}
		});
		lblCreateFuelAccount.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblCreateFuelAccount.setForeground(Color.red);
			}
		});
		lblCreateFuelAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateFuelAccount.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCreateFuelAccount.setBounds(167, 322, 293, 45);
		contentPane.add(lblCreateFuelAccount);
		
		final JLabel lblAdminAcountLogin = new JLabel("Admin Acount Login");
		lblAdminAcountLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 AdminLoginMainpage p1 = new AdminLoginMainpage();
				p1.show();
			}
		});
		lblAdminAcountLogin.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
			lblAdminAcountLogin.setForeground(Color.red);	
			}
		});
		lblAdminAcountLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminAcountLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAdminAcountLogin.setBounds(819, 249, 293, 45);
		contentPane.add(lblAdminAcountLogin);
		
		final JLabel lblPomperAccountLogin = new JLabel("Pomper Account Login");
		lblPomperAccountLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 PomperAccountLoginPage p1 = new PomperAccountLoginPage();
				p1.show();
			}
		});
		lblPomperAccountLogin.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblPomperAccountLogin.setForeground(Color.red);
			}
		});
		lblPomperAccountLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperAccountLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPomperAccountLogin.setBounds(819, 322, 293, 45);
		contentPane.add(lblPomperAccountLogin);
		
		final JLabel lblPoliceStationLogin = new JLabel("Police Station Login");
		lblPoliceStationLogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 PoliceAccountLoginPage p1 = new PoliceAccountLoginPage();
				p1.show();
			}
		});
		lblPoliceStationLogin.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblPoliceStationLogin.setForeground(Color.red);
			}
		});
		lblPoliceStationLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPoliceStationLogin.setBounds(819, 398, 293, 45);
		contentPane.add(lblPoliceStationLogin);
		
		JLabel lblFuelStation_1 = new JLabel("");
		lblFuelStation_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblFuelStation.setForeground(Color.black);
				lblLoginYourAccount.setForeground(Color.black);
				lblCreateFuelAccount.setForeground(Color.black);
			}
		});
		lblFuelStation_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelStation_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFuelStation_1.setBounds(126, 133, 374, 282);
		contentPane.add(lblFuelStation_1);
		
		JLabel lblFuelStation_1_1 = new JLabel("");
		lblFuelStation_1_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblAdminAcountLogin.setForeground(Color.black);
				lblPoliceStationLogin.setForeground(Color.black);
				lblPomperAccountLogin.setForeground(Color.black);
			}
		});
		lblFuelStation_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelStation_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFuelStation_1_1.setBounds(770, 219, 398, 282);
		contentPane.add(lblFuelStation_1_1);
		
		JLabel lblDoesNotWork = new JLabel("Does Not Work");
		lblDoesNotWork.setForeground(Color.RED);
		lblDoesNotWork.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoesNotWork.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDoesNotWork.setBounds(1148, 49, 168, 45);
		contentPane.add(lblDoesNotWork);
	}
}
