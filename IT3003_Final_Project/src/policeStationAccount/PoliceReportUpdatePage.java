package policeStationAccount;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class PoliceReportUpdatePage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoliceReportUpdatePage frame = new PoliceReportUpdatePage();
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
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
		} catch (ClassNotFoundException ex) {
		
		}catch (Exception ex) {
			 
		}}
	
	
	public PoliceReportUpdatePage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1195, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("updae Police Report");
		ImageIcon icon;
	    icon = new ImageIcon("images/34.png");
	    setIconImage(icon.getImage());
		
		JLabel lblPoliceReportUpdate = new JLabel("Police Report Update Page");
		lblPoliceReportUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceReportUpdate.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblPoliceReportUpdate.setBounds(302, 28, 538, 76);
		contentPane.add(lblPoliceReportUpdate);
		
		JLabel lblPoliceStationId = new JLabel("Vehicle Number");
		lblPoliceStationId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId.setBounds(95, 154, 213, 39);
		contentPane.add(lblPoliceStationId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				textField_8.setEditable(true);
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				
				
				
				String id = textField.getText();
				String aaa = "";
/////////////
				try {
					pst =  con.prepareStatement("select * from vehicle where v_number=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						String a = rs.getString(9);
						textField_2.setText(rs.getString(2));
						textField_3.setText(rs.getString(3));
						textField_5.setText(rs.getString(7));
						textField_6.setText(rs.getString(9));
						aaa = rs.getString(9);
						
		//			
						try {
							pst =  con.prepareStatement("select * from customer where idnumber=?");
							pst.setString(1, aaa);
							rs = pst.executeQuery();
							if (rs.next()==true) {
								textField_1.setText(rs.getString(4));
							}						
						} catch (Exception e2) {	
				}
      //
			}
		
		} catch (Exception e2) {
		
		}	
///////////////
				try {
					pst =  con.prepareStatement("select * from police_report where pr_v_number=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_4.setText(rs.getString(1));
					}
					if (textField_4.getText().equals("")) {
						textField_4.setText("0");
					}
						
				} catch (Exception e2) {
				
				}
////////////////////////////////////////////////////////////
				String ab = textField_4.getText();
				if (ab.equals("0")) {
				}else {
					textField_8.setEditable(false);
				}
				
				
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(345, 155, 280, 39);
		contentPane.add(textField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 PoliceAccountLoginPage p1 = new PoliceAccountLoginPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(55, 610, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id1 = textField_8.getText();
				String aa = textField.getText();
				
					try {
						pst = con.prepareStatement("insert into police_report(pr_id,pr_v_number)values(?,?)");
						pst.setString(1, id1);
						pst.setString(2, aa);
						pst.executeLargeUpdate();
						JOptionPane.showInternalMessageDialog(null,"Record..........");
				    textField.setText("");
					textField_8.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");


					} catch (Exception e2) {
						JOptionPane.showInternalMessageDialog(null,"unsussesful..........");
					}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(892, 328, 146, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblPoliceStationId_1 = new JLabel("Vehicle Owner");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(95, 204, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(345, 205, 280, 39);
		contentPane.add(textField_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Vehicle Type");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(95, 255, 213, 39);
		contentPane.add(lblPoliceStationId_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(345, 256, 280, 39);
		contentPane.add(textField_2);
		
		JLabel lblPoliceStationId_3 = new JLabel("Vehicle Model");
		lblPoliceStationId_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3.setBounds(95, 308, 213, 39);
		contentPane.add(lblPoliceStationId_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(345, 309, 280, 39);
		contentPane.add(textField_3);
		
		JLabel lblPoliceStationId_4 = new JLabel("Vehicle Police Report");
		lblPoliceStationId_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_4.setBounds(95, 358, 213, 39);
		contentPane.add(lblPoliceStationId_4);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(345, 359, 280, 39);
		contentPane.add(textField_4);
		
		JLabel lblPoliceStationId_5 = new JLabel("How Much Litters Occurs");
		lblPoliceStationId_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5.setBounds(79, 409, 229, 39);
		contentPane.add(lblPoliceStationId_5);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(345, 410, 280, 39);
		contentPane.add(textField_5);
		
		JLabel lblPoliceStationId_6 = new JLabel("Owner NIC");
		lblPoliceStationId_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_6.setBounds(95, 466, 213, 39);
		contentPane.add(lblPoliceStationId_6);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(345, 467, 280, 39);
		contentPane.add(textField_6);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(698, 96, 2, 461);
		contentPane.add(separator);
		
		JLabel lblNewFuelLitters = new JLabel("New Fuel Litters");
		lblNewFuelLitters.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewFuelLitters.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewFuelLitters.setBounds(849, 104, 213, 39);
		contentPane.add(lblNewFuelLitters);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(811, 154, 280, 39);
		contentPane.add(textField_7);
		
		JLabel lblPoliceStationId_7_1 = new JLabel("Police Report Update");
		lblPoliceStationId_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_7_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_7_1.setBounds(859, 204, 213, 39);
		contentPane.add(lblPoliceStationId_7_1);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				textField_7.setText("");
				String id = textField.getText();
				String aaa = "";
				String bbb = "";
				try {
					pst =  con.prepareStatement("select * from vehicle where v_number=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {			
						aaa = rs.getString(6);
						bbb = rs.getString(7);
			}
		if (aaa.equals("0")) {
			double bbb1 = Double.parseDouble(bbb);
			double ccc = 10 + bbb1;
			textField_7.setText(ccc+"");
		}else {
			if (aaa.equals("")) {
				double bbb1 = Double.parseDouble(bbb);
				double ccc = 10 + bbb1;
				textField_7.setText(ccc+""); 
			}	
		}
					
					
		} catch (Exception e2) {
		
		}	
				
			}
		});
		textField_8.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				if (textField_8.isEditable() == false) {
					textField_8.setToolTipText("You can't update it Because it alredy updated");		
				}
			}
		});
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(821, 254, 280, 39);
		contentPane.add(textField_8);
	}
}
