package fuelStation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminGovernment.AdminGovernmentMenuPage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminGovernmentUpdateFuelStationFuelDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGovernmentUpdateFuelStationFuelDetails frame = new AdminGovernmentUpdateFuelStationFuelDetails();
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
	public AdminGovernmentUpdateFuelStationFuelDetails() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1415, 810);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("update Fuel Station Fuel Details - Admin Government Manager");
		ImageIcon icon;
	    icon = new ImageIcon("images/6.png");
	    setIconImage(icon.getImage());
		
		JLabel lblNewLabel = new JLabel("Update Fuel Station Fuel Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(500, 0, 322, 45);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 AdminGovernmentMenuPage  p1 = new AdminGovernmentMenuPage();
				p1.show();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(26, 726, 146, 45);
		contentPane.add(btnBack);
		
		JLabel lblCode = new JLabel("Station Code");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCode.setBounds(169, 72, 171, 31);
		contentPane.add(lblCode);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContactNumber.setBounds(169, 114, 171, 31);
		contentPane.add(lblContactNumber);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(374, 114, 302, 28);
		contentPane.add(textField_1);
		
		JLabel lblOwnerName = new JLabel("Owner Name");
		lblOwnerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblOwnerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOwnerName.setBounds(169, 155, 171, 31);
		contentPane.add(lblOwnerName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(374, 155, 302, 28);
		contentPane.add(textField_2);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(169, 197, 171, 31);
		contentPane.add(lblAddress);
		
		final JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setEditable(false);
		textArea.setBounds(374, 194, 302, 58);
		contentPane.add(textArea);
		
		JLabel lblNowFuelAvalability = new JLabel("Now Fuel Avalability");
		lblNowFuelAvalability.setHorizontalAlignment(SwingConstants.CENTER);
		lblNowFuelAvalability.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNowFuelAvalability.setBounds(26, 269, 196, 31);
		contentPane.add(lblNowFuelAvalability);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(232, 286, 1054, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(196, 350, 1103, 2);
		contentPane.add(separator_1);
		
		final JCheckBox cb1 = new JCheckBox("Petrol (Octane 92)");
		cb1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb1.setBounds(277, 318, 181, 23);
		contentPane.add(cb1);
		
		final JCheckBox cb2 = new JCheckBox("Petrol (Octane 95)");
		cb2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb2.setBounds(470, 318, 181, 23);
		contentPane.add(cb2);
		
		final JCheckBox cb3 = new JCheckBox("Diesel");
		cb3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb3.setBounds(712, 320, 78, 23);
		contentPane.add(cb3);
		
		final JCheckBox cb4 = new JCheckBox("Super Diesel");
		cb4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb4.setBounds(905, 318, 146, 23);
		contentPane.add(cb4);
		
		final JCheckBox cb5 = new JCheckBox("Kerosene");
		cb5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cb5.setBounds(1112, 318, 121, 23);
		contentPane.add(cb5);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(312, 363, 78, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(515, 363, 78, 28);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(710, 363, 78, 28);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(905, 363, 78, 28);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("0");
		textField_7.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(1124, 363, 78, 28);
		contentPane.add(textField_7);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(464, 313, 2, 131);
		contentPane.add(separator_2);
		
		textField_8 = new JTextField();
		textField_8.setText("0");
		textField_8.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(312, 402, 78, 28);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setText("0");
		textField_9.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_9.setColumns(10);
		textField_9.setBounds(515, 402, 78, 28);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setText("0");
		textField_10.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_10.setColumns(10);
		textField_10.setBounds(710, 402, 78, 28);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setText("0");
		textField_11.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_11.setColumns(10);
		textField_11.setBounds(905, 402, 78, 28);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setText("0");
		textField_12.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_12.setColumns(10);
		textField_12.setBounds(1124, 402, 78, 28);
		contentPane.add(textField_12);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setBounds(657, 318, 2, 131);
		contentPane.add(separator_2_1);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setOrientation(SwingConstants.VERTICAL);
		separator_2_2.setBounds(857, 318, 2, 131);
		contentPane.add(separator_2_2);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setOrientation(SwingConstants.VERTICAL);
		separator_2_3.setBounds(1069, 318, 2, 131);
		contentPane.add(separator_2_3);
		
		JSeparator separator_2_4 = new JSeparator();
		separator_2_4.setOrientation(SwingConstants.VERTICAL);
		separator_2_4.setBounds(255, 313, 2, 131);
		contentPane.add(separator_2_4);
		
		JSeparator separator_2_5 = new JSeparator();
		separator_2_5.setOrientation(SwingConstants.VERTICAL);
		separator_2_5.setBounds(1262, 318, 2, 131);
		contentPane.add(separator_2_5);
		
		JLabel lblHowManyLitters = new JLabel("How Many Litters");
		lblHowManyLitters.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowManyLitters.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHowManyLitters.setBounds(47, 363, 196, 31);
		contentPane.add(lblHowManyLitters);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTime.setBounds(47, 399, 196, 31);
		contentPane.add(lblTime);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(263, 477, 1023, 2);
		contentPane.add(separator_3);
		
		JLabel lblNextDaysFuel = new JLabel("Next Days Fuel Avalability");
		lblNextDaysFuel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNextDaysFuel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNextDaysFuel.setBounds(10, 460, 233, 31);
		contentPane.add(lblNextDaysFuel);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(196, 546, 1103, 2);
		contentPane.add(separator_1_1);
		
		JSeparator separator_2_4_1 = new JSeparator();
		separator_2_4_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_4_1.setBounds(255, 509, 2, 155);
		contentPane.add(separator_2_4_1);
		
		JSeparator separator_2_6 = new JSeparator();
		separator_2_6.setOrientation(SwingConstants.VERTICAL);
		separator_2_6.setBounds(464, 509, 2, 155);
		contentPane.add(separator_2_6);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1_1.setBounds(657, 514, 2, 150);
		contentPane.add(separator_2_1_1);
		
		JSeparator separator_2_2_1 = new JSeparator();
		separator_2_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_2_1.setBounds(857, 514, 2, 150);
		contentPane.add(separator_2_2_1);
		
		JSeparator separator_2_3_1 = new JSeparator();
		separator_2_3_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_3_1.setBounds(1069, 514, 2, 150);
		contentPane.add(separator_2_3_1);
		
		JSeparator separator_2_5_1 = new JSeparator();
		separator_2_5_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_5_1.setBounds(1262, 514, 2, 150);
		contentPane.add(separator_2_5_1);
		
		final JLabel lblTomorrow = new JLabel("Tomorrow");
		lblTomorrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblTomorrow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTomorrow.setBounds(47, 557, 196, 31);
		contentPane.add(lblTomorrow);
		
		final JLabel lblDayAfterTomorrow = new JLabel("Day After Tomorrow");
		lblDayAfterTomorrow.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayAfterTomorrow.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDayAfterTomorrow.setBounds(47, 593, 196, 31);
		contentPane.add(lblDayAfterTomorrow);
		
		final JLabel lblday = new JLabel("Next Day");
		lblday.setHorizontalAlignment(SwingConstants.CENTER);
		lblday.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblday.setBounds(47, 635, 196, 31);
		contentPane.add(lblday);
		
		final JLabel lblPetroloctane = new JLabel("Petrol (Octane 92)");
		lblPetroloctane.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetroloctane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPetroloctane.setBounds(290, 490, 146, 21);
		contentPane.add(lblPetroloctane);
		
		final JLabel lblPetroloctane_5 = new JLabel("Petrol (Octane 95)");
		lblPetroloctane_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblPetroloctane_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPetroloctane_5.setBounds(489, 490, 146, 21);
		contentPane.add(lblPetroloctane_5);
		
		final JLabel lblKerosene = new JLabel("Kerosene");
		lblKerosene.setHorizontalAlignment(SwingConstants.CENTER);
		lblKerosene.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblKerosene.setBounds(1102, 490, 146, 21);
		contentPane.add(lblKerosene);
		
		final JLabel lblSuperDetails = new JLabel("Super Diesel");
		lblSuperDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuperDetails.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSuperDetails.setBounds(888, 490, 146, 21);
		contentPane.add(lblSuperDetails);
		
		final JLabel lblDiesel = new JLabel("Diesel");
		lblDiesel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiesel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDiesel.setBounds(686, 490, 146, 21);
		contentPane.add(lblDiesel);
		
		JLabel lblAva = new JLabel("Avalability");
		lblAva.setHorizontalAlignment(SwingConstants.CENTER);
		lblAva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAva.setBounds(277, 514, 78, 21);
		contentPane.add(lblAva);
		
		JLabel lblTime_1 = new JLabel("Time");
		lblTime_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime_1.setBounds(376, 514, 56, 21);
		contentPane.add(lblTime_1);
		
		JSeparator separator_2_4_1_1 = new JSeparator();
		separator_2_4_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_4_1_1.setForeground(Color.BLUE);
		separator_2_4_1_1.setBounds(365, 522, 1, 142);
		contentPane.add(separator_2_4_1_1);
		
		JSeparator separator_2_4_1_1_1 = new JSeparator();
		separator_2_4_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_4_1_1_1.setForeground(Color.BLUE);
		separator_2_4_1_1_1.setBounds(557, 522, 1, 142);
		contentPane.add(separator_2_4_1_1_1);
		
		JLabel lblTime_1_2 = new JLabel("Time");
		lblTime_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime_1_2.setBounds(579, 514, 56, 21);
		contentPane.add(lblTime_1_2);
		
		JLabel lblAva_1 = new JLabel("Avalability");
		lblAva_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAva_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAva_1.setBounds(480, 514, 78, 21);
		contentPane.add(lblAva_1);
		
		JSeparator separator_2_4_1_1_2 = new JSeparator();
		separator_2_4_1_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_2_4_1_1_2.setForeground(Color.BLUE);
		separator_2_4_1_1_2.setBounds(755, 522, 1, 142);
		contentPane.add(separator_2_4_1_1_2);
		
		JLabel lblTime_1_3 = new JLabel("Time");
		lblTime_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime_1_3.setBounds(766, 514, 56, 21);
		contentPane.add(lblTime_1_3);
		
		JLabel lblAva_2 = new JLabel("Avalability");
		lblAva_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAva_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAva_2.setBounds(667, 514, 78, 21);
		contentPane.add(lblAva_2);
		
		JSeparator separator_2_4_1_1_3 = new JSeparator();
		separator_2_4_1_1_3.setOrientation(SwingConstants.VERTICAL);
		separator_2_4_1_1_3.setForeground(Color.BLUE);
		separator_2_4_1_1_3.setBounds(967, 522, 1, 142);
		contentPane.add(separator_2_4_1_1_3);
		
		JLabel lblTime_1_4 = new JLabel("Time");
		lblTime_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime_1_4.setBounds(978, 514, 56, 21);
		contentPane.add(lblTime_1_4);
		
		JLabel lblAva_3 = new JLabel("Avalability");
		lblAva_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAva_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAva_3.setBounds(879, 514, 78, 21);
		contentPane.add(lblAva_3);
		
		JSeparator separator_2_4_1_1_4 = new JSeparator();
		separator_2_4_1_1_4.setOrientation(SwingConstants.VERTICAL);
		separator_2_4_1_1_4.setForeground(Color.BLUE);
		separator_2_4_1_1_4.setBounds(1169, 522, 1, 142);
		contentPane.add(separator_2_4_1_1_4);
		
		JLabel lblTime_1_5 = new JLabel("Time");
		lblTime_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime_1_5.setBounds(1180, 514, 56, 21);
		contentPane.add(lblTime_1_5);
		
		JLabel lblAva_4 = new JLabel("Avalability");
		lblAva_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAva_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAva_4.setBounds(1081, 514, 78, 21);
		contentPane.add(lblAva_4);
		
		textField_13 = new JTextField();
		textField_13.setText("-");
		textField_13.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_13.setColumns(10);
		textField_13.setBounds(374, 559, 78, 28);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setText("-");
		textField_14.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_14.setColumns(10);
		textField_14.setBounds(573, 559, 78, 28);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setText("-");
		textField_15.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_15.setColumns(10);
		textField_15.setBounds(766, 559, 78, 28);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setText("-");
		textField_16.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_16.setColumns(10);
		textField_16.setBounds(978, 559, 78, 28);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setText("-");
		textField_17.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_17.setColumns(10);
		textField_17.setBounds(1174, 559, 78, 28);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setText("-");
		textField_18.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_18.setColumns(10);
		textField_18.setBounds(374, 600, 78, 28);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setText("-");
		textField_19.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_19.setColumns(10);
		textField_19.setBounds(569, 600, 78, 28);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setText("-");
		textField_20.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_20.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_20.setColumns(10);
		textField_20.setBounds(769, 600, 78, 28);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setText("-");
		textField_21.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_21.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_21.setColumns(10);
		textField_21.setBounds(978, 600, 78, 28);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setText("-");
		textField_22.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_22.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_22.setColumns(10);
		textField_22.setBounds(1174, 600, 78, 28);
		contentPane.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setText("-");
		textField_23.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_23.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_23.setColumns(10);
		textField_23.setBounds(374, 642, 78, 28);
		contentPane.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setText("-");
		textField_24.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_24.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_24.setColumns(10);
		textField_24.setBounds(569, 642, 78, 28);
		contentPane.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setText("-");
		textField_25.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_25.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_25.setColumns(10);
		textField_25.setBounds(769, 636, 78, 28);
		contentPane.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setText("-");
		textField_26.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_26.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_26.setColumns(10);
		textField_26.setBounds(978, 642, 78, 28);
		contentPane.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setText("-");
		textField_27.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_27.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_27.setColumns(10);
		textField_27.setBounds(1174, 642, 78, 28);
		contentPane.add(textField_27);
		
		final JCheckBox cbb = new JCheckBox("");
		cbb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb.setBounds(291, 555, 35, 33);
		contentPane.add(cbb);
		
		final JCheckBox cbb_1 = new JCheckBox("");
		cbb_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_1.setBounds(500, 555, 35, 33);
		contentPane.add(cbb_1);
		
		final JCheckBox cbb_2 = new JCheckBox("");
		cbb_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_2.setBounds(686, 555, 35, 33);
		contentPane.add(cbb_2);
		
		final JCheckBox cbb_3 = new JCheckBox("");
		cbb_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_3.setBounds(905, 555, 35, 33);
		contentPane.add(cbb_3);
		
		final JCheckBox cbb_4 = new JCheckBox("");
		cbb_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_4.setBounds(1104, 555, 35, 33);
		contentPane.add(cbb_4);
		
		final JCheckBox cbb_5 = new JCheckBox("");
		cbb_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_5.setBounds(290, 593, 35, 33);
		contentPane.add(cbb_5);
		
		final JCheckBox cbb_6 = new JCheckBox("");
		cbb_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_6.setBounds(500, 593, 35, 33);
		contentPane.add(cbb_6);
		
		final JCheckBox cbb_7 = new JCheckBox("");
		cbb_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_7.setBounds(686, 591, 35, 33);
		contentPane.add(cbb_7);
		
		final JCheckBox cbb_8 = new JCheckBox("");
		cbb_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_8.setBounds(905, 593, 35, 33);
		contentPane.add(cbb_8);
		
		final JCheckBox cbb_9 = new JCheckBox("");
		cbb_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_9.setBounds(1102, 593, 35, 33);
		contentPane.add(cbb_9);
		
		final JCheckBox cbb_10 = new JCheckBox("");
		cbb_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_10.setBounds(290, 631, 35, 33);
		contentPane.add(cbb_10);
		
		final JCheckBox cbb_11 = new JCheckBox("");
		cbb_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_11.setBounds(500, 635, 35, 33);
		contentPane.add(cbb_11);
		
		final JCheckBox cbb_12 = new JCheckBox("");
		cbb_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_12.setBounds(686, 635, 35, 33);
		contentPane.add(cbb_12);
		
		final JCheckBox cbb_13 = new JCheckBox("");
		cbb_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_13.setBounds(905, 635, 35, 33);
		contentPane.add(cbb_13);
		
		final JCheckBox cbb_14 = new JCheckBox("");
		cbb_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbb_14.setBounds(1102, 635, 35, 33);
		contentPane.add(cbb_14);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  
				String id = textField.getText();
			    
				// petrol 92							
							try {
								String p92_l = textField_3.getText();
								String p92_t = textField_8.getText();
								boolean yn = cb1.isSelected();
								pst = con.prepareStatement("update petrol_92 set p92_litters=?, p92_time=?, yesno=? where st_id=?");
								pst.setString(1, p92_l);
								pst.setString(2, p92_t);
								pst.setBoolean(3, yn);
								pst.setString(4, id);
								int k = pst.executeUpdate();
								if (k ==1) {
				//					JOptionPane.showMessageDialog(null, "Record updated");
					
								}else {
					//				JOptionPane.showMessageDialog(null, "Record faild");
								}
								
							} catch (Exception e2) {
								
							}
							
							
				  // petrol 95		
							try {	
								String p95_l = textField_4.getText();
								String p95_t = textField_9.getText();
								boolean yn = cb2.isSelected();
								pst = con.prepareStatement("update petrol_95 set p95_litters=?, p95_time=?, yesno=? where st_id=?");
								pst.setString(1, p95_l);
								pst.setString(2, p95_t);
								pst.setBoolean(3, yn);
								pst.setString(4, id);
								int k = pst.executeUpdate();
								if (k ==1) {
					//				JOptionPane.showMessageDialog(null, "Record updated");
					
								}else {
						//			JOptionPane.showMessageDialog(null, "Record faild");
								}
								
							} catch (Exception e2) {
								
							}
							
				// Diesel		
							try {	
								String d_l = textField_5.getText();
								String d_t = textField_10.getText();
								boolean yn = cb3.isSelected();
								pst = con.prepareStatement("update diesel set di_litters=?, di_time=?, yesno=? where st_id=?");
								pst.setString(1, d_l);
								pst.setString(2, d_t);
								pst.setBoolean(3, yn);
								pst.setString(4, id);
								int k = pst.executeUpdate();
								if (k ==1) {
					//				JOptionPane.showMessageDialog(null, "Record updated");
					
								}else {
						//			JOptionPane.showMessageDialog(null, "Record faild");
								}
								
							} catch (Exception e2) {
								
							}
							
					// Super Diesel		
							try {	
								String sd_l = textField_6.getText();
								String sd_t = textField_11.getText();
								boolean yn = cb4.isSelected();
								pst = con.prepareStatement("update super_diesel set sd_litters=?, sd_time=?, yesno=? where st_id=?");
								pst.setString(1, sd_l);
								pst.setString(2, sd_t);
								pst.setBoolean(3, yn);
								pst.setString(4, id);
								int k = pst.executeUpdate();
								if (k ==1) {
						//JOptionPane.showMessageDialog(null, "Record updated");
					
								}else {
						//	JOptionPane.showMessageDialog(null, "Record faild");
								}
								
							} catch (Exception e2) {
								
							}
							
						// kerosene	
							try {	
								String k_l = textField_7.getText();
								String k_t = textField_12.getText();
								boolean yn = cb5.isSelected();
								pst = con.prepareStatement("update kerosene set ke_litters=?, ke_time=?, yesno=? where st_id=?");
								pst.setString(1, k_l);
								pst.setString(2, k_t);
								pst.setBoolean(3, yn);
								pst.setString(4, id);
								int k = pst.executeUpdate();
								if (k ==1) {
					//	JOptionPane.showMessageDialog(null, "Record updated");
					
								}else {
						//	JOptionPane.showMessageDialog(null, "Record faild");
								}
								
							} catch (Exception e2) {
								
							}
							
				// tomorrow	
							try {	
								String p92_t = textField_13.getText();
								String p95_t = textField_14.getText();
								String di_t = textField_15.getText();
								String sd_t = textField_16.getText();
								String k_t = textField_17.getText();
								boolean yn1 = cbb.isSelected();
								boolean yn2 = cbb_1.isSelected();
								boolean yn3 = cbb_2.isSelected();
								boolean yn4 = cbb_3.isSelected();
								boolean yn5 = cbb_4.isSelected();
								pst = con.prepareStatement("update tomorrow set p92_av=?, p92_time=?, p95_av=?, p95_time=?, di_av=?, di_time=?, sd_av=?, sd_time=?, k_av=?, k_time=? where st_id=?");
								pst.setBoolean(1, yn1); 
								pst.setString(2, p92_t);
								pst.setBoolean(3, yn2);
								pst.setString(4, p95_t);
								pst.setBoolean(5,yn3);
								pst.setString(6, di_t);
								pst.setBoolean(7, yn4);
								pst.setString(8, sd_t);
								pst.setBoolean(9, yn5);
								pst.setString(10, k_t);
								pst.setString(11, id);
								int k = pst.executeUpdate();
								if (k ==1) {
			         //	JOptionPane.showMessageDialog(null, "Record updated");
					
								}else {
					//	JOptionPane.showMessageDialog(null, "Record faild");
								}
								
							} catch (Exception e2) {
								
							}
							
				// Day after tomorrow	
							try {	
								String p92_t = textField_18.getText();
								String p95_t = textField_19.getText();
								String di_t = textField_20.getText();
								String sd_t = textField_21.getText();
								String k_t = textField_22.getText();
								boolean yn1 = cbb_5.isSelected();
								boolean yn2 = cbb_6.isSelected();
								boolean yn3 = cbb_7.isSelected();
								boolean yn4 = cbb_8.isSelected();
								boolean yn5 = cbb_9.isSelected();
								pst = con.prepareStatement("update day_after_tomorrow set p92_av=?, p92_time=?, p95_av=?, p95_time=?, di_av=?, di_time=?, sd_av=?, sd_time=?, k_av=?, k_time=? where st_id=?");
								pst.setBoolean(1, yn1); 
								pst.setString(2, p92_t);
								pst.setBoolean(3, yn2);
								pst.setString(4, p95_t);
								pst.setBoolean(5,yn3);
								pst.setString(6, di_t);
								pst.setBoolean(7, yn4);
								pst.setString(8, sd_t);
								pst.setBoolean(9, yn5);
								pst.setString(10, k_t);
								pst.setString(11, id);
								int k = pst.executeUpdate();
								if (k ==1) {
			 //    JOptionPane.showMessageDialog(null, "Record updated");
					
								}else {
//				JOptionPane.showMessageDialog(null, "Record faild");
								}
								
							} catch (Exception e2) {
								
							}
							
					// Next Day	
							try {	
								String p92_t = textField_23.getText();
								String p95_t = textField_24.getText();
								String di_t = textField_25.getText();
								String sd_t = textField_26.getText();
								String k_t = textField_27.getText();
								boolean yn1 = cbb_10.isSelected();
								boolean yn2 = cbb_11.isSelected();
								boolean yn3 = cbb_12.isSelected();
								boolean yn4 = cbb_13.isSelected();
								boolean yn5 = cbb_14.isSelected();
								pst = con.prepareStatement("update next_day set p92_av=?, p92_time=?, p95_av=?, p95_time=?, di_av=?, di_time=?, sd_av=?, sd_time=?, k_av=?, k_time=? where st_id=?");
								pst.setBoolean(1, yn1); 
								pst.setString(2, p92_t);
								pst.setBoolean(3, yn2);
								pst.setString(4, p95_t);
								pst.setBoolean(5,yn3);
								pst.setString(6, di_t);
								pst.setBoolean(7, yn4);
								pst.setString(8, sd_t);
								pst.setBoolean(9, yn5);
								pst.setString(10, k_t);
								pst.setString(11, id);
								int k = pst.executeUpdate();
								if (k ==1) {
			   //  JOptionPane.showMessageDialog(null, "Record updated");
					
								}else {
//				JOptionPane.showMessageDialog(null, "Record faild");
								}
							
							} catch (Exception e2) {
								
							}
							
							textField_27.setText("");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_3.setText("");
							textField_4.setText("");
							textField_5.setText("");
							textField_6.setText("");
							textField_7.setText("");
							textField_8.setText("");
							textField_9.setText("");
							textField_10.setText("");
							textField_11.setText("");
							textField_12.setText("");
							textField_13.setText("");
							textField_14.setText("");
							textField_15.setText("");
							textField_16.setText("");
							textField_17.setText("");
							textField_18.setText("");
							textField_19.setText("");
							textField_20.setText("");
							textField_21.setText("");
							textField_22.setText("");
							textField_23.setText("");
							textField_24.setText("");
							textField_25.setText("");
							textField_26.setText("");
							textArea.setText("");
							cb1.setSelected(false);
							cb2.setSelected(false);
							cb3.setSelected(false);
							cb4.setSelected(false);
							cb5.setSelected(false);
							cbb.setSelected(false);
							cbb_1.setSelected(false);
							cbb_2.setSelected(false);
							cbb_3.setSelected(false);
							cbb_4.setSelected(false);
							cbb_5.setSelected(false);
							cbb_6.setSelected(false);
							cbb_7.setSelected(false);
							cbb_8.setSelected(false);
							cbb_9.setSelected(false);
							cbb_10.setSelected(false);
							cbb_11.setSelected(false);
							cbb_12.setSelected(false);
							cbb_13.setSelected(false);
							cbb_14.setSelected(false);
							
							
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(1220, 726, 146, 45);
		contentPane.add(btnUpdate);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				textField_27.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				textField_17.setText("");
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
				textField_21.setText("");
				textField_22.setText("");
				textField_23.setText("");
				textField_24.setText("");
				textField_25.setText("");
				textField_26.setText("");
				textArea.setText("");
				cb1.setSelected(false);
				cb2.setSelected(false);
				cb3.setSelected(false);
				cb4.setSelected(false);
				cb5.setSelected(false);
				cbb.setSelected(false);
				cbb_1.setSelected(false);
				cbb_2.setSelected(false);
				cbb_3.setSelected(false);
				cbb_4.setSelected(false);
				cbb_5.setSelected(false);
				cbb_6.setSelected(false);
				cbb_7.setSelected(false);
				cbb_8.setSelected(false);
				cbb_9.setSelected(false);
				cbb_10.setSelected(false);
				cbb_11.setSelected(false);
				cbb_12.setSelected(false);
				cbb_13.setSelected(false);
				cbb_14.setSelected(false);
				
				
				String id = textField.getText();
				try {
					pst =  con.prepareStatement("select * from fuelstation where s_code=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_1.setText(rs.getString(3));
						textField_2.setText(rs.getString(2));
						textArea.setText(rs.getString(4));
					}
					
				} catch (Exception e2) {
				
				}
			
	//petrol 92
				try {
					pst =  con.prepareStatement("select * from petrol_92 where st_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_3.setText(rs.getString(2));
						textField_8.setText(rs.getString(3));
						cb1.setSelected(rs.getBoolean(4));
					}
					
				} catch (Exception e2) {
				
				}
				
	//petrol 95
				try {
					pst =  con.prepareStatement("select * from petrol_95 where st_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_4.setText(rs.getString(2));
						textField_9.setText(rs.getString(3));
						cb2.setSelected(rs.getBoolean(4));
					}
					
				} catch (Exception e2) {
				
				}		
				
	//Diesel
				try {
					pst =  con.prepareStatement("select * from diesel where st_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_5.setText(rs.getString(2));
						textField_10.setText(rs.getString(3));
						cb3.setSelected(rs.getBoolean(4));
					}
					
				} catch (Exception e2) {
				
				}		
				
	//Super Diesel
				try {
					pst =  con.prepareStatement("select * from super_diesel where st_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_6.setText(rs.getString(2));
						textField_11.setText(rs.getString(3));
						cb4.setSelected(rs.getBoolean(4));
					}
					
				} catch (Exception e2) {
				
				}	
				
				
//kerosene
				try {
					pst =  con.prepareStatement("select * from kerosene where st_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						textField_7.setText(rs.getString(2));
						textField_12.setText(rs.getString(3));
						cb5.setSelected(rs.getBoolean(4));
					}
					
				} catch (Exception e2) {
				
				}
				
//tomorrow
				try {
					pst =  con.prepareStatement("select * from tomorrow where st_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						cbb.setSelected(rs.getBoolean(2));
						textField_13.setText(rs.getString(3));
						cbb_1.setSelected(rs.getBoolean(4));
						textField_14.setText(rs.getString(5));
						cbb_2.setSelected(rs.getBoolean(6));
						textField_15.setText(rs.getString(7));
						cbb_3.setSelected(rs.getBoolean(8));
						textField_16.setText(rs.getString(9));
						cbb_4.setSelected(rs.getBoolean(10));
						textField_17.setText(rs.getString(11));
					}
					
				} catch (Exception e2) {
				
				}
				
	//Day after tomorrow
				try {
					pst =  con.prepareStatement("select * from day_after_tomorrow where st_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						cbb_5.setSelected(rs.getBoolean(2));
						textField_18.setText(rs.getString(3));
						cbb_6.setSelected(rs.getBoolean(4));
						textField_19.setText(rs.getString(5));
						cbb_7.setSelected(rs.getBoolean(6));
						textField_20.setText(rs.getString(7));
						cbb_8.setSelected(rs.getBoolean(8));
						textField_21.setText(rs.getString(9));
						cbb_9.setSelected(rs.getBoolean(10));
						textField_22.setText(rs.getString(11));
					}
					
				} catch (Exception e2) {
				
				}
				
//Next Day
				try {
					pst =  con.prepareStatement("select * from next_day where st_id=?");
					pst.setString(1, id);
					rs = pst.executeQuery();
					if (rs.next()==true) {
						cbb_10.setSelected(rs.getBoolean(2));
						textField_23.setText(rs.getString(3));
						cbb_11.setSelected(rs.getBoolean(4));
						textField_24.setText(rs.getString(5));
						cbb_12.setSelected(rs.getBoolean(6));
						textField_25.setText(rs.getString(7));
						cbb_13.setSelected(rs.getBoolean(8));
						textField_26.setText(rs.getString(9));
						cbb_14.setSelected(rs.getBoolean(10));
						textField_27.setText(rs.getString(11));
					}
					
				} catch (Exception e2) {
				
				}	
				
				if (cb1.isSelected()==true) {
					cb1.setForeground(Color.blue);
				}else {
					cb1.setForeground(Color.red);
				}
				if (cb2.isSelected() == true) {
					cb2.setForeground(Color.blue);
				}else {
					cb2.setForeground(Color.red);
				}
				if (cb3.isSelected() == true) {
					cb3.setForeground(Color.blue);
				}else {
					cb3.setForeground(Color.red);
				}
				if (cb4.isSelected()==true) {
					cb4.setForeground(Color.blue);
				}else {
					cb4.setForeground(Color.red);
				}
				if (cb5.isSelected()==true) {
					cb5.setForeground(Color.blue);
				}else {
					cb5.setForeground(Color.red);
				}
				
//				cb1.setEnabled(false);
//				cb2.setEnabled(false);
//				cb3.setEnabled(false);
//				cb4.setEnabled(false);
//				cb5.setEnabled(false);
				
			////////////////////////////////////////////////////////	
				
				
				if (cbb.isSelected()==true) {
					lblPetroloctane.setForeground(Color.blue);
					lblTomorrow.setForeground(Color.blue);
				}else {
					lblPetroloctane.setForeground(Color.red);
					lblTomorrow.setForeground(Color.red);
				}
				if (cbb_1.isSelected()==true) {
					lblPetroloctane_5.setForeground(Color.blue);
					lblTomorrow.setForeground(Color.blue);
				}else {
					lblPetroloctane_5.setForeground(Color.red);
					lblTomorrow.setForeground(Color.red);
				}
				if (cbb_2.isSelected()==true) {
					lblDiesel.setForeground(Color.blue);
					lblTomorrow.setForeground(Color.blue);
				}else {
					lblDiesel.setForeground(Color.red);
					lblTomorrow.setForeground(Color.red);
				}
				if (cbb_3.isSelected()==true) {
					lblSuperDetails.setForeground(Color.blue);
					lblTomorrow.setForeground(Color.blue);
				}else {
					lblSuperDetails.setForeground(Color.red);
					lblTomorrow.setForeground(Color.red);
				}
				if (cbb_4.isSelected()==true) {
					lblKerosene.setForeground(Color.blue);
					lblTomorrow.setForeground(Color.blue);
				}else {
					lblKerosene.setForeground(Color.red);
					lblTomorrow.setForeground(Color.red);
				}
				if (cbb_5.isSelected()==true) {
					lblPetroloctane.setForeground(Color.blue);
					lblDayAfterTomorrow.setForeground(Color.blue);
				}else {
					lblPetroloctane.setForeground(Color.red);
					lblDayAfterTomorrow.setForeground(Color.red);
				}
				if (cbb_6.isSelected()==true) {
					lblPetroloctane_5.setForeground(Color.blue);
					lblDayAfterTomorrow.setForeground(Color.blue);
				}else {
					lblPetroloctane_5.setForeground(Color.red);
					lblDayAfterTomorrow.setForeground(Color.red);
				}
				if (cbb_7.isSelected()==true) {
					lblDiesel.setForeground(Color.blue);
					lblDayAfterTomorrow.setForeground(Color.blue);
				}else {
					lblDiesel.setForeground(Color.red);
					lblDayAfterTomorrow.setForeground(Color.red);
				}
				if (cbb_8.isSelected()==true) {
					lblSuperDetails.setForeground(Color.blue);
					lblDayAfterTomorrow.setForeground(Color.blue);
				}else {
					lblSuperDetails.setForeground(Color.red);
					lblDayAfterTomorrow.setForeground(Color.red);
				}
				if (cbb_9.isSelected()==true) {
					lblKerosene.setForeground(Color.blue);
					lblDayAfterTomorrow.setForeground(Color.blue);
				}else {
					lblKerosene.setForeground(Color.red);
					lblDayAfterTomorrow.setForeground(Color.red);
				}
				if (cbb_10.isSelected()==true) {
					lblPetroloctane.setForeground(Color.blue);
					lblday.setForeground(Color.blue);
				}else {
					lblPetroloctane.setForeground(Color.red);
					lblday.setForeground(Color.red);
				}
				if (cbb_11.isSelected()==true) {
					lblPetroloctane_5.setForeground(Color.blue);
					lblday.setForeground(Color.blue);
				}else {
					lblPetroloctane_5.setForeground(Color.red);
					lblday.setForeground(Color.red);
				}
				if (cbb_12.isSelected()==true) {
					lblDiesel.setForeground(Color.blue);
					lblday.setForeground(Color.blue);
				}else {
					lblDiesel.setForeground(Color.red);
					lblday.setForeground(Color.red);
				}
				if (cbb_13.isSelected()==true) {
					lblSuperDetails.setForeground(Color.blue);
					lblday.setForeground(Color.blue);
				}else {
					lblSuperDetails.setForeground(Color.red);
					lblday.setForeground(Color.red);
				}
				if (cbb_14.isSelected()==true) {
					lblKerosene.setForeground(Color.blue);
					lblday.setForeground(Color.blue);
				}else {
					lblKerosene.setForeground(Color.red);
					lblday.setForeground(Color.red);
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(374, 75, 302, 28);
		contentPane.add(textField);
	}
}
