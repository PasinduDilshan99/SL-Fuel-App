package fuelStation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.MainMenuPage;
import main.MainPage1;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchFuelStation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFuelStation frame = new SearchFuelStation();
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
			 
		}
	}
	
	public SearchFuelStation() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1333, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Search Fuel Station Details");
		ImageIcon icon;
	    icon = new ImageIcon("images/2.png");
	    setIconImage(icon.getImage());
		
		JLabel lblNewLabel = new JLabel(" Type Your Near Town");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(244, 11, 275, 56);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				String a= textField.getText();	
				if (textField.getText().equals("")) {
					table.setModel(new DefaultTableModel(null,new String[] {"Station Code","Owner Name","Telephone Number","Address","Town"}));		
					textField.setText("");
				}else {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/slfuelappdb","root","");
					String sql = "select * from fuelstation WHERE s_town LIKE '"+a+"'";
					pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (ClassNotFoundException ex) {
				
				}catch (Exception ex) {
					 
				}finally {
					try {
						if (pst!=null) {
							rs.close();
							pst.close();
						}
					} catch (Exception e2) {
						
					}
				}
				}
				
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(613, 27, 329, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				ShowFuelStationDetails p1 = new ShowFuelStationDetails();
				p1.show();
			}
		});
		scrollPane.setBounds(54, 171, 768, 245);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Station Code", "Owner Name", "Telephone Number", "Address", "Town"
			}
		));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenuPage p1 = new MainMenuPage();
				p1.show();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(70, 641, 119, 37);
		contentPane.add(btnNewButton);
		
		final JLabel lb = new JLabel("");
		lb.setBounds(934, 131, 319, 399);
		contentPane.add(lb);
		ImageIcon dabIcon = new ImageIcon("images/40.jpg");
		Image dabImage = dabIcon.getImage();
		Image mod = dabImage.getScaledInstance(346, 441, java.awt.Image.SCALE_SMOOTH);
		dabIcon = new ImageIcon(mod);
		lb.setIcon(dabIcon);
		
		lb.setBounds(890, 108, 346, 441);
		contentPane.add(lb);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon dabIcon = (ImageIcon) lb.getIcon();
				Image dabImage = dabIcon.getImage();
				Image mod = dabImage.getScaledInstance(dabIcon.getIconWidth()+25, dabIcon.getIconHeight()+25, java.awt.Image.SCALE_SMOOTH);
				dabIcon = new ImageIcon(mod);
				lb.setIcon(dabIcon);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(1002, 552, 60, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("-");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon dabIcon = (ImageIcon) lb.getIcon();
				Image dabImage = dabIcon.getImage();
				Image mod = dabImage.getScaledInstance(dabIcon.getIconWidth()-10, dabIcon.getIconHeight()-10, java.awt.Image.SCALE_SMOOTH);
				dabIcon = new ImageIcon(mod);
				lb.setIcon(dabIcon);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(1105, 552, 60, 37);
		contentPane.add(btnNewButton_1_1);
	}
}
