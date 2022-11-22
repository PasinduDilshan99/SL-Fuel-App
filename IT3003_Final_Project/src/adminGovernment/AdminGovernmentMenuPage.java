package adminGovernment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fuelStation.AdminGovernmentUpdateFuelStationFuelDetails;
import main.AdminLoginMainpage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class AdminGovernmentMenuPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGovernmentMenuPage frame = new AdminGovernmentMenuPage();
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
	public AdminGovernmentMenuPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Main Menu - Admin Governmnet");
		ImageIcon icon;
	    icon = new ImageIcon("images/26.png");
	    setIconImage(icon.getImage());
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 AdminLoginMainpage p1 = new AdminLoginMainpage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(69, 669, 146, 45);
		contentPane.add(btnBack);
		
		final JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				AdminGovernmentPasswordChange p1 = new AdminGovernmentPasswordChange();
				p1.show();
			}
		});
		lblChangePassword.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblChangePassword.setForeground(Color.red);
			}
		});
		lblChangePassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblChangePassword.setBounds(309, 470, 293, 45);
		contentPane.add(lblChangePassword);
		
		final JLabel lblDeleteFuelStation = new JLabel("Delete Fuel Station");
		lblDeleteFuelStation.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 DeleteFuelStationAccount p1 = new DeleteFuelStationAccount();
				p1.show();
			}
		});
		lblDeleteFuelStation.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblDeleteFuelStation.setForeground(Color.red);
			}
		});
		lblDeleteFuelStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteFuelStation.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDeleteFuelStation.setBounds(299, 404, 293, 45);
		contentPane.add(lblDeleteFuelStation);
		
		final JLabel lblUpdateFuelStations = new JLabel("Update Fuel Stations Fuel Details");
		lblUpdateFuelStations.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 AdminGovernmentUpdateFuelStationFuelDetails p1 = new AdminGovernmentUpdateFuelStationFuelDetails();
				p1.show();
			}
		});
		lblUpdateFuelStations.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblUpdateFuelStations.setForeground(Color.red);
			}
		});
		lblUpdateFuelStations.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateFuelStations.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUpdateFuelStations.setBounds(238, 338, 416, 45);
		contentPane.add(lblUpdateFuelStations);
		
		final JLabel lblCreateAccountFor_1 = new JLabel("Create Account For Fuel Station Manager");
		lblCreateAccountFor_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 CreateAccountForFuelStationManager p1 = new CreateAccountForFuelStationManager();
				p1.show();
			}
		});
		lblCreateAccountFor_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblCreateAccountFor_1.setForeground(Color.red);
			}
		});
		lblCreateAccountFor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccountFor_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCreateAccountFor_1.setBounds(216, 266, 500, 45);
		contentPane.add(lblCreateAccountFor_1);
		
		final JLabel lblCreateAccountFor = new JLabel("Create Account For Fuel Station");
		lblCreateAccountFor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 CreateAccountForFuelStation p1 = new CreateAccountForFuelStation();
				p1.show();
			}
		});
		lblCreateAccountFor.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblCreateAccountFor.setForeground(Color.red);
			}
		});
		lblCreateAccountFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccountFor.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCreateAccountFor.setBounds(270, 199, 384, 45);
		contentPane.add(lblCreateAccountFor);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(Color.BLACK);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblMenu.setBounds(272, 42, 349, 64);
		contentPane.add(lblMenu);
		
		JLabel lblFuelStation_1 = new JLabel("");
		lblFuelStation_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblChangePassword.setForeground(Color.black);
				lblCreateAccountFor.setForeground(Color.black);
				lblCreateAccountFor_1.setForeground(Color.black);
				lblDeleteFuelStation.setForeground(Color.black);
				lblUpdateFuelStations.setForeground(Color.black);
			}
		});
		lblFuelStation_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelStation_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFuelStation_1.setBounds(163, 154, 615, 410);
		contentPane.add(lblFuelStation_1);
	}

}
