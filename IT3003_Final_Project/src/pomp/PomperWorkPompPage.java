package pomp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pomper.PomperAccountMainMenuPage;

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
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PomperWorkPompPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PomperWorkPompPage frame = new PomperWorkPompPage();
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
	
	public PomperWorkPompPage() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1217, 791);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Select Working Pomp");
		ImageIcon icon;
	    icon = new ImageIcon("images/20.png");
	    setIconImage(icon.getImage());
		
		JLabel lblPompId = new JLabel("Pomp ID");
		lblPompId.setHorizontalAlignment(SwingConstants.CENTER);
		lblPompId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPompId.setBounds(192, 119, 213, 39);
		contentPane.add(lblPompId);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				

				String id = textField.getText();
				try {
					pst =  con.prepareStatement("select * from pomp where po_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(5));
					}
				
				} catch (Exception e2) {
				
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(449, 120, 280, 39);
		contentPane.add(textField);
		
		JLabel lblWorkPomp = new JLabel("Work Pomp");
		lblWorkPomp.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkPomp.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblWorkPomp.setBounds(391, 22, 422, 58);
		contentPane.add(lblWorkPomp);
		
		JLabel lblPoliceStationId_1 = new JLabel("Fuel Type");
		lblPoliceStationId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_1.setBounds(202, 169, 213, 39);
		contentPane.add(lblPoliceStationId_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(452, 170, 280, 39);
		contentPane.add(textField_1);
		
		JLabel lblPoliceStationId_2 = new JLabel("Remaining Fuel Litters In Pomp");
		lblPoliceStationId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_2.setBounds(135, 220, 280, 39);
		contentPane.add(lblPoliceStationId_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(452, 221, 280, 39);
		contentPane.add(textField_2);
		
		JLabel lblPoliceStationId_3 = new JLabel("Enter The  Customer NIC");
		lblPoliceStationId_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3.setBounds(153, 340, 252, 39);
		contentPane.add(lblPoliceStationId_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(449, 341, 280, 39);
		contentPane.add(textField_3);
		
		JLabel lblPoliceStationId_5_1 = new JLabel("Remaining Fuel Litters");
		lblPoliceStationId_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5_1.setBounds(153, 457, 229, 39);
		contentPane.add(lblPoliceStationId_5_1);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(449, 458, 280, 39);
		contentPane.add(textField_4);
		
		JLabel lblPoliceStationId_5_1_1 = new JLabel("Enter The Fuel Litters");
		lblPoliceStationId_5_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_5_1_1.setBounds(163, 523, 252, 39);
		contentPane.add(lblPoliceStationId_5_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(449, 524, 280, 39);
		contentPane.add(textField_5);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 
			}
			public void mousePressed(MouseEvent e) {
				
				 String a=(String) comboBox.getSelectedItem();
	 				try {
	 					pst =  con.prepareStatement("select * from vehicle where v_number=?");
	 					pst.setString(1, a);
	 					rs = pst.executeQuery();
	 					if (rs.next()) {
	 						textField_4.setText(rs.getString(8));
	 					}
	 				
	 				} catch (Exception e2) {
	 				
	 				}
			}
		});
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(449, 391, 280, 32);
		contentPane.add(comboBox);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 PomperAccountMainMenuPage p1 = new PomperAccountMainMenuPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(92, 654, 146, 45);
		contentPane.add(btnBack);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.removeAllItems();
				String id = textField_3.getText();
				try {
					pst =  con.prepareStatement("select * from vehicle where v_nic=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					while(rs.next()==true){
						String a = rs.getString(4);
						comboBox.addItem(a);
					}

				
				} catch (Exception e2) {
				
				}
				
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOk.setBounds(772, 338, 146, 45);
		contentPane.add(btnOk);
		
		JButton btnUpdate_1 = new JButton("Fuel");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a1 = textField_2.getText();
				double a2 =Double.parseDouble(a1);
				String b1 = textField_5.getText();
				double b2 =Double.parseDouble(b1);
				double b3 = a2-b2;
				String id = textField.getText();
				double count = 0.0;
				double count1 = 0.0;
				
				if (Double.parseDouble(textField_4.getText())< b2){
					JOptionPane.showMessageDialog(null, "Please Enter the correct fuel amount");
				}else {
				
				
				try {
					pst =  con.prepareStatement("select * from pomp where po_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
				count = rs.getDouble(4);
					}
					
				} catch (Exception e2) {
				
				}	
				
				
				try {
					count1 = count +b2;
					pst = con.prepareStatement("update pomp set po_fuel_count=?,po_fuel_liters=? where po_id=?");
					pst.setDouble(1,count1);
					pst.setDouble(2,b3);
					pst.setString(3, id);
					int k = pst.executeUpdate();
					if (k ==1) {
						//JOptionPane.showMessageDialog(null, "Record updated");
	
					}else {
						//JOptionPane.showMessageDialog(null, "Record faild");
					}
					
					
					//
					try {		
						String ac = (String) comboBox.getSelectedItem();
						 String ab = textField_4.getText();
						 double ab1 = Double.parseDouble(ab);
						 double ab2 = ab1 - b2;
						pst = con.prepareStatement("update vehicle set re_fuel=? where v_number=?");
						pst.setDouble(1,ab2);
						pst.setString(2,ac);
						int k1 = pst.executeUpdate();
						if (k1 ==1) {
							JOptionPane.showMessageDialog(null, "Record updated");
							textField_2.setText("");
							textField_5.setText("");
				            comboBox.removeAllItems();
							
		
						}else {
							JOptionPane.showMessageDialog(null, "Record faild");
						}
						
					} catch (Exception e2) {
						
					}
					//
				} catch (Exception e2) {
					
				}
						
				
				
		////////////////////////////////////////////Load Data///////////////////////////////////////////////////////////////////	
				
				String id1 = textField.getText();
				String aaa = null;
				double idp92 = 0.0;
				double idp95 = 0.0;
				double iddi = 0.0;
				double idsd = 0.0;
				double idk = 0.0;
//				System.out.println(aaa);
//				System.out.println(iddi);
				try {
					pst =  con.prepareStatement("select * from pomp where po_id=?");
					pst.setString(1, id1);
					rs = pst.executeQuery();
					if (rs.next()==true) {
		            aaa = rs.getString(3);
					}	
				} catch (Exception e2) {
				
				}
//				System.out.println(aaa);
	//petrol 92
				try {
					pst =  con.prepareStatement("select * from petrol_92 where st_id=?");
					pst.setString(1, aaa);
					rs = pst.executeQuery();
					if (rs.next()==true) {
					 idp92 = rs.getDouble(2);
					}
					
				} catch (Exception e2) {
				
				}
				
	//petrol 95
				try {
					pst =  con.prepareStatement("select * from petrol_95 where st_id=?");
					pst.setString(1, aaa);
					rs = pst.executeQuery();
					if (rs.next()==true) {
				idp95 = rs.getDouble(2);
					}
					
				} catch (Exception e2) {
				
				}		
				
	//Diesel
				try {
					pst =  con.prepareStatement("select * from diesel where s_id=?");
					pst.setString(1, aaa);
					rs = pst.executeQuery();
					if (rs.next()==true) {
				 iddi = rs.getDouble(2);
					}
					
				} catch (Exception e2) {
				
				}		
			//	System.out.println(iddi);
	//Super Diesel
				try {
					pst =  con.prepareStatement("select * from super_diesel where s_id=?");
					pst.setString(1, aaa);
					rs = pst.executeQuery();
					if (rs.next()==true) {
			 idsd = rs.getDouble(2);
					}
					
				} catch (Exception e2) {
				
				}	
				
				
//kerosene
				try {
					pst =  con.prepareStatement("select * from kerosene where s_id=?");
					pst.setString(1, aaa);
					rs = pst.executeQuery();
					if (rs.next()==true) {
				idk = rs.getDouble(2);
					}
					
				} catch (Exception e2) {
				
				}
				
				
			
		//////////////////////////////////////////////Update Data////////////////////////////////////////////////////////////		
				String bbb = textField_1.getText();
			    double new_p92 = idp92 -b2;
			    double new_p95 = idp95 -b2;
			    double new_di = iddi -b2;
			    double new_sd = idsd -b2;
			    double new_k = idk -b2;
			    
				// petrol 92		
				if (bbb.equals("Petrol 92")) {
							try {
								pst = con.prepareStatement("update petrol_92 set p92_litters=? where st_id=?");
								pst.setDouble(1, new_p92);
								pst.setString(2, aaa);
								int k = pst.executeUpdate();
								if (k ==1) {
								}else {
								}							
							} catch (Exception e2) {
								
							}
				}
							
				  // petrol 95		
				if (bbb.equals("Petrol 95")) {
					try {
						pst = con.prepareStatement("update petrol_95 set p95_litters=? where st_id=?");
						pst.setDouble(1, new_p95);
						pst.setString(2, aaa);
						int k = pst.executeUpdate();
						if (k ==1) {
						}else {
						}							
					} catch (Exception e2) {
						
					}
		}
				// System.out.println(bbb);	
			
				if (bbb.equals("Diesel")) {
					try {
				//		System.out.print("aaabbbba");
						pst = con.prepareStatement("update diesel set di_litters=? where s_id=?");
						pst.setDouble(1, new_di);
						pst.setString(2, aaa);
						int k = pst.executeUpdate();
						 System.out.print(new_di);
						if (k ==1) {
						}else {
						}							
					} catch (Exception e2) {
				//		System.out.print("aaaa");
						
					}
		}
							
					// Super Diesel		
				if (bbb.equals("Super Diesel")) {
					try {
						pst = con.prepareStatement("update super_diesel set sd_litters=? where s_id=?");
						pst.setDouble(1, new_sd);
						pst.setString(2, aaa);
						int k = pst.executeUpdate();
						if (k ==1) {
						}else {
						}							
					} catch (Exception e2) {
						
					}
		}
							
						// kerosene	
				if (bbb.equals("Kerosene")) {
					try {
						pst = con.prepareStatement("update kerosene set ke_litters=? where s_id=?");
						pst.setDouble(1, new_k);
						pst.setString(2, aaa);
						int k = pst.executeUpdate();
						if (k ==1) {
						}else {
						}							
					} catch (Exception e2) {
						
					}
		}
				
				
				String id21 = textField.getText();
				try {
					pst =  con.prepareStatement("select * from pomp where po_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_2.setText(rs.getString(5));
					}
				
				} catch (Exception e2) {
				
				}	
				}
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate_1.setBounds(794, 521, 146, 45);
		contentPane.add(btnUpdate_1);
		
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerDetails.setBounds(62, 295, 213, 39);
		contentPane.add(lblCustomerDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(285, 310, 858, 2);
		contentPane.add(separator);
		
		
		
		JLabel lblPoliceStationId_3_1 = new JLabel("Select Vehicle");
		lblPoliceStationId_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoliceStationId_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoliceStationId_3_1.setBounds(153, 390, 252, 39);
		contentPane.add(lblPoliceStationId_3_1);
	}

}
