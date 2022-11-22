package pomper;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.AdminLoginMainpage;
import pomp.PomperWorkPompPage;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class PomperAccountMainMenuPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PomperAccountMainMenuPage frame = new PomperAccountMainMenuPage();
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
	public PomperAccountMainMenuPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Main Menu - Pomper Account");
		ImageIcon icon;
	    icon = new ImageIcon("images/1.png");
	    setIconImage(icon.getImage());
		
		JLabel lblPomperMenuPage = new JLabel("Pomper Menu Page");
		lblPomperMenuPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperMenuPage.setForeground(Color.BLACK);
		lblPomperMenuPage.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPomperMenuPage.setBounds(242, 28, 398, 64);
		contentPane.add(lblPomperMenuPage);
		
		final JLabel lblShowMyDetails = new JLabel("Show My Details");
		lblShowMyDetails.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 ShowPomperDetailsPage p1 = new ShowPomperDetailsPage();
				p1.show();
			}
		});
		lblShowMyDetails.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblShowMyDetails.setForeground(Color.red);
			}
		});
		lblShowMyDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowMyDetails.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblShowMyDetails.setBounds(332, 168, 296, 45);
		contentPane.add(lblShowMyDetails);
		
		final JLabel lblCreateAccountFor_1 = new JLabel("Select The Work Pomp");
		lblCreateAccountFor_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 PomperWorkPompPage p1 = new PomperWorkPompPage();
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
		lblCreateAccountFor_1.setBounds(274, 236, 416, 45);
		contentPane.add(lblCreateAccountFor_1);
		
		final JLabel lblPasswordChange = new JLabel("Password Change");
		lblPasswordChange.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				 PomperAccountPasswordChangePage p1 = new PomperAccountPasswordChangePage();
				p1.show();
			}
		});
		lblPasswordChange.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblPasswordChange.setForeground(Color.red);
			}
		});
		lblPasswordChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordChange.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPasswordChange.setBounds(333, 304, 307, 45);
		contentPane.add(lblPasswordChange);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 PomperAccountLoginPage p1 = new PomperAccountLoginPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(73, 638, 146, 45);
		contentPane.add(btnBack);
		
		JLabel lblShowMyDetails_1 = new JLabel("");
		lblShowMyDetails_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				lblShowMyDetails.setForeground(Color.black);
				lblCreateAccountFor_1.setForeground(Color.black);
				lblPasswordChange.setForeground(Color.black);
				
			}
		});
		lblShowMyDetails_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowMyDetails_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblShowMyDetails_1.setBounds(262, 144, 416, 254);
		contentPane.add(lblShowMyDetails_1);
	}

}
