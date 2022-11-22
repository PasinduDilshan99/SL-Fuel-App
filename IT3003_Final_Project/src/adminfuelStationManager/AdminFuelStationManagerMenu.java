package adminfuelStationManager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fuelStation.AdminManagerUpdateFuelStationFuelDetails;
import main.AdminLoginMainpage;
import main.MainPage1;
import pomp.AdminManagerPompDetailsPage;
import pomper.AdminManagerPomperDetailsPage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFuelStationManagerMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFuelStationManagerMenu frame = new AdminFuelStationManagerMenu();
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
	public AdminFuelStationManagerMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1330, 796);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Fuel Station Manger - Menu Page");
		ImageIcon icon;
	    icon = new ImageIcon("images/26.png");
	    setIconImage(icon.getImage());
		
		final JLabel lblCreateFuelAccount = new JLabel("Password Change");
		lblCreateFuelAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				AdminFuelStationManagerPasswordChange p1 = new AdminFuelStationManagerPasswordChange();
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
		lblCreateFuelAccount.setBounds(432, 344, 293, 45);
		contentPane.add(lblCreateFuelAccount);
		
		final JLabel lblLoginYourAccount = new JLabel("Fuel Station Details Update");
		lblLoginYourAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				UpdateFuelStationDetails p1 = new UpdateFuelStationDetails();
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
		lblLoginYourAccount.setBounds(396, 279, 368, 45);
		contentPane.add(lblLoginYourAccount);
		
		final JLabel lblFuelStation = new JLabel("Update Fuel Details");
		lblFuelStation.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblFuelStation.setForeground(Color.red); 
			}
		});
		lblFuelStation.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				AdminManagerUpdateFuelStationFuelDetails  p1 = new AdminManagerUpdateFuelStationFuelDetails();
				p1.show();
			}
		});
		lblFuelStation.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelStation.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFuelStation.setBounds(432, 207, 293, 45);
		contentPane.add(lblFuelStation);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLoginMainpage p1 = new AdminLoginMainpage();
				p1.show();
			}
			
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(70, 671, 146, 45);
		contentPane.add(btnBack);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setForeground(Color.BLACK);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblMenu.setBounds(427, 39, 349, 64);
		contentPane.add(lblMenu);
		
		final JLabel lblPomperAccount = new JLabel("Pomper Account");
		lblPomperAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				AdminManagerPomperDetailsPage p1 = new AdminManagerPomperDetailsPage();
				p1.show();
			}
		});
		lblPomperAccount.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblPomperAccount.setForeground(Color.red);
			}
			
		});
		lblPomperAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperAccount.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPomperAccount.setBounds(432, 411, 293, 45);
		contentPane.add(lblPomperAccount);
		
		final JLabel lblPompAccount = new JLabel("Pomp Account");
		lblPompAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				AdminManagerPompDetailsPage p1 = new AdminManagerPompDetailsPage();
				p1.show();
			}
		});
		lblPompAccount.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblPompAccount.setForeground(Color.red);
			}
		});
		lblPompAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblPompAccount.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPompAccount.setBounds(432, 476, 293, 45);
		contentPane.add(lblPompAccount);
		
		JLabel lblFuelStation_1 = new JLabel("");
		lblFuelStation_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblFuelStation.setForeground(Color.black);
				lblCreateFuelAccount.setForeground(Color.black);
				lblLoginYourAccount.setForeground(Color.black);
				lblPomperAccount.setForeground(Color.black);
				lblPompAccount.setForeground(Color.black);
			}
		});
		lblFuelStation_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuelStation_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFuelStation_1.setBounds(358, 157, 441, 396);
		contentPane.add(lblFuelStation_1);
	}
}
