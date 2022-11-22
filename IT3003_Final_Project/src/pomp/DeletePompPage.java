package pomp;

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

public class DeletePompPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePompPage frame = new DeletePompPage();
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
	
	public DeletePompPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1161, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Delete Pomp");
		ImageIcon icon;
	    icon = new ImageIcon("images/43.png");
	    setIconImage(icon.getImage());
		
		JLabel lblDeletePomp = new JLabel("Delete Pomp");
		lblDeletePomp.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletePomp.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblDeletePomp.setBounds(301, 30, 422, 58);
		contentPane.add(lblDeletePomp);
		
		JLabel lblPompeId = new JLabel("Pomp ID");
		lblPompeId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPompeId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPompeId.setBounds(195, 140, 213, 39);
		contentPane.add(lblPompeId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				String aa = textField.getText();
				try {
					pst =  con.prepareStatement("select * from pomp where po_id=?");
					pst.setString(1, aa);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(4));
						textField_3.setText(rs.getString(5));	
					}
				
				} catch (Exception e2) {
				
				}	
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(445, 141, 280, 39);
		contentPane.add(textField);
		
		JLabel lblPoliceStationId_1 = new JLabel("Fuel Type");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(193, 278, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Fuel Count Litters");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(193, 329, 213, 39);
		contentPane.add(lblPoliceStationId_2);
		
		JLabel lblPoliceStationId_3 = new JLabel("Remsining Fuel Litters");
		lblPoliceStationId_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3.setBounds(193, 382, 213, 39);
		contentPane.add(lblPoliceStationId_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(443, 279, 280, 39);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(443, 330, 280, 39);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(445, 383, 280, 39);
		contentPane.add(textField_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminManagerPompDetailsPage p1 = new AdminManagerPompDetailsPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(109, 578, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnDeletePomper = new JButton("Delete Pomp");
		btnDeletePomper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String id = textField.getText();
					pst = con.prepareStatement("delete from pomp where po_id=?");
					pst.setString(1,id);
					int k = pst.executeUpdate();
					if (k == 1) {
						JOptionPane.showMessageDialog(null, "record deleted");
						textField.setText("");
						dispose();
						AdminManagerPompDetailsPage pd = new AdminManagerPompDetailsPage();
						pd.show();
					}else {
						JOptionPane.showMessageDialog(null, "Faild");
					}
					
					} catch (Exception e2) {
				
					}
			}
		});
		btnDeletePomper.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDeletePomper.setBounds(716, 461, 175, 45);
		contentPane.add(btnDeletePomper);
		
		JLabel lblPoliceStationId_1_1 = new JLabel("Pomp Details");
		lblPoliceStationId_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPoliceStationId_1_1.setBounds(90, 215, 213, 39);
		contentPane.add(lblPoliceStationId_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(313, 236, 608, 2);
		contentPane.add(separator);
	}

}
