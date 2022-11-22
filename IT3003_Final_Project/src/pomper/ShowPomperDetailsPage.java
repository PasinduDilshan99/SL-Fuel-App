package pomper;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowPomperDetailsPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowPomperDetailsPage frame = new ShowPomperDetailsPage();
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
	ResultSet rs;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
		} catch (ClassNotFoundException ex) {
		
		}catch (Exception ex) {
			 
		}}
	public ShowPomperDetailsPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 948, 793);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Show Pomper Details");
		ImageIcon icon;
	    icon = new ImageIcon("images/22.png");
	    setIconImage(icon.getImage());
		
		JLabel lblPomperUserId = new JLabel("Pomper User ID");
		lblPomperUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperUserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPomperUserId.setBounds(170, 152, 213, 39);
		contentPane.add(lblPomperUserId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				String id = textField.getText();
				try {
					pst =  con.prepareStatement("select * from pomper where p_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
						textField_4.setText(rs.getString(5));
						textField_5.setText(rs.getString(6));
	
					}
				
				} catch (Exception e2) {
				
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(420, 153, 280, 39);
		contentPane.add(textField);
		
		JLabel lblPomperDetails = new JLabel("Pomper Details");
		lblPomperDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblPomperDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPomperDetails.setBounds(246, 36, 422, 58);
		contentPane.add(lblPomperDetails);
		
		JLabel lblPoliceStationId_1 = new JLabel("Full Name");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(170, 202, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(420, 203, 280, 39);
		contentPane.add(textField_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Contact Number");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(170, 253, 213, 39);
		contentPane.add(lblPoliceStationId_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(420, 254, 280, 39);
		contentPane.add(textField_2);
		
		JLabel lblPoliceStationId_3 = new JLabel("NIC");
		lblPoliceStationId_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3.setBounds(170, 306, 213, 39);
		contentPane.add(lblPoliceStationId_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(420, 307, 280, 39);
		contentPane.add(textField_3);
		
		JLabel lblPoliceStationId_4 = new JLabel("Address");
		lblPoliceStationId_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_4.setBounds(170, 356, 213, 39);
		contentPane.add(lblPoliceStationId_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(420, 357, 280, 39);
		contentPane.add(textField_4);
		
		JLabel lblPoliceStationId_5 = new JLabel("Fuel Station");
		lblPoliceStationId_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5.setBounds(154, 407, 229, 39);
		contentPane.add(lblPoliceStationId_5);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(420, 408, 280, 39);
		contentPane.add(textField_5);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 PomperAccountMainMenuPage p1 = new PomperAccountMainMenuPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(95, 639, 146, 45);
		contentPane.add(btnBack);
	}

}
