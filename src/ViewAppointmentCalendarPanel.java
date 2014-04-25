import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import Backend.Appointment;

import java.awt.SystemColor;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class ViewAppointmentCalendarPanel extends JPanel {

	private MedicalFrame parent;
	private String username;
	JButton btnGo, btnBack;
	private JComboBox dayComboBox;
	private JComboBox monthComboBox;
	private JComboBox yearComboBox;
	
	private ArrayList<JLabel> labels;
	private JLabel label_01;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JLabel label_28;
	private JLabel label_29;
	private JLabel label_30;
	private JLabel label_31;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private ArrayList<Appointment> apptList;
	
	/**
	 * Create the panel.
	 */
	public ViewAppointmentCalendarPanel(MedicalFrame parent, String username) {
		
		this.parent = parent;
		this.username = username;
		ButtonListener listener = new ButtonListener();
		
		setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(142, 177, 90, 90);
		add(panel);
		panel.setLayout(null);
		
		labels = new ArrayList<JLabel>();
		
		label_8 = new JLabel("");
		label_8.setHorizontalTextPosition(SwingConstants.CENTER);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_8.setBounds(6, 30, 78, 30);
		panel.add(label_8);
		
		JLabel label_58 = new JLabel("8");
		label_58.setBounds(6, 6, 61, 16);
		panel.add(label_58);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(244, 177, 90, 90);
		add(panel_9);
		panel_9.setLayout(null);
		
		label_9 = new JLabel("");
		label_9.setHorizontalTextPosition(SwingConstants.CENTER);
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_9.setBounds(6, 30, 78, 30);
		panel_9.add(label_9);
		
		JLabel label_57 = new JLabel("9");
		label_57.setBounds(6, 6, 61, 16);
		panel_9.add(label_57);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(346, 177, 90, 90);
		add(panel_10);
		panel_10.setLayout(null);
		
		label_10 = new JLabel("");
		label_10.setHorizontalTextPosition(SwingConstants.CENTER);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_10.setBounds(6, 30, 78, 30);
		panel_10.add(label_10);
		
		JLabel label_56 = new JLabel("10");
		label_56.setBounds(6, 6, 61, 16);
		panel_10.add(label_56);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(448, 177, 90, 90);
		add(panel_11);
		panel_11.setLayout(null);
		
		label_11 = new JLabel("");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setHorizontalTextPosition(SwingConstants.CENTER);
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_11.setBounds(6, 30, 78, 30);
		panel_11.add(label_11);
		
		JLabel label_41 = new JLabel("11");
		label_41.setBounds(6, 6, 61, 16);
		panel_11.add(label_41);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(550, 177, 90, 90);
		add(panel_12);
		panel_12.setLayout(null);
		
		label_12 = new JLabel("");
		label_12.setHorizontalTextPosition(SwingConstants.CENTER);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.RED);
		label_12.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_12.setBounds(6, 30, 78, 30);
		panel_12.add(label_12);
		
		JLabel label_40 = new JLabel("12");
		label_40.setBounds(6, 6, 61, 16);
		panel_12.add(label_40);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(652, 177, 90, 90);
		add(panel_13);
		panel_13.setLayout(null);
		
		label_13 = new JLabel("");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setHorizontalTextPosition(SwingConstants.CENTER);
		label_13.setForeground(Color.RED);
		label_13.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_13.setBounds(6, 30, 78, 30);
		panel_13.add(label_13);
		
		JLabel label_39 = new JLabel("13");
		label_39.setBounds(6, 6, 61, 16);
		panel_13.add(label_39);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		panel_16.setBounds(244, 279, 90, 90);
		add(panel_16);
		panel_16.setLayout(null);
		
		label_16 = new JLabel("");
		label_16.setHorizontalTextPosition(SwingConstants.CENTER);
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_16.setForeground(Color.RED);
		label_16.setBounds(6, 30, 78, 30);
		panel_16.add(label_16);
		
		JLabel label_54 = new JLabel("16");
		label_54.setBounds(6, 6, 61, 16);
		panel_16.add(label_54);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.WHITE);
		panel_17.setBounds(346, 279, 90, 90);
		add(panel_17);
		panel_17.setLayout(null);
		
		label_17 = new JLabel("");
		label_17.setHorizontalTextPosition(SwingConstants.CENTER);
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_17.setForeground(Color.RED);
		label_17.setBounds(6, 30, 78, 30);
		panel_17.add(label_17);
		
		JLabel label_55 = new JLabel("17");
		label_55.setBounds(6, 6, 61, 16);
		panel_17.add(label_55);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.WHITE);
		panel_18.setBounds(448, 279, 90, 90);
		add(panel_18);
		panel_18.setLayout(null);
		
		label_18 = new JLabel("");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setHorizontalTextPosition(SwingConstants.CENTER);
		label_18.setForeground(Color.RED);
		label_18.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_18.setBounds(6, 30, 78, 30);
		panel_18.add(label_18);
		
		JLabel label_45 = new JLabel("18");
		label_45.setBounds(6, 6, 61, 16);
		panel_18.add(label_45);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		panel_19.setBounds(550, 279, 90, 90);
		add(panel_19);
		panel_19.setLayout(null);
		
		label_19 = new JLabel("");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setHorizontalTextPosition(SwingConstants.CENTER);
		label_19.setForeground(Color.RED);
		label_19.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_19.setBounds(6, 33, 78, 30);
		panel_19.add(label_19);
		
		JLabel label_44 = new JLabel("19");
		label_44.setBounds(6, 6, 61, 16);
		panel_19.add(label_44);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.WHITE);
		panel_20.setBounds(652, 279, 90, 90);
		add(panel_20);
		panel_20.setLayout(null);
		
		label_20 = new JLabel("");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setHorizontalTextPosition(SwingConstants.CENTER);
		label_20.setForeground(Color.RED);
		label_20.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_20.setBounds(6, 30, 78, 30);
		panel_20.add(label_20);
		
		JLabel label_43 = new JLabel("20");
		label_43.setBounds(6, 6, 61, 16);
		panel_20.add(label_43);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(142, 279, 90, 90);
		add(panel_15);
		panel_15.setLayout(null);
		
		label_15 = new JLabel("");
		label_15.setHorizontalTextPosition(SwingConstants.CENTER);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_15.setForeground(Color.RED);
		label_15.setBounds(6, 29, 78, 29);
		panel_15.add(label_15);
		
		JLabel label_59 = new JLabel("15");
		label_59.setBounds(6, 6, 61, 16);
		panel_15.add(label_59);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.WHITE);
		panel_23.setBounds(244, 383, 90, 90);
		add(panel_23);
		panel_23.setLayout(null);
		
		label_23 = new JLabel("");
		label_23.setHorizontalTextPosition(SwingConstants.CENTER);
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_23.setForeground(Color.RED);
		label_23.setBounds(6, 30, 78, 30);
		panel_23.add(label_23);
		
		JLabel label_51 = new JLabel("25");
		label_51.setBounds(6, 6, 61, 16);
		panel_23.add(label_51);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(Color.WHITE);
		panel_24.setBounds(346, 383, 90, 90);
		add(panel_24);
		panel_24.setLayout(null);
		
		label_24 = new JLabel("");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setHorizontalTextPosition(SwingConstants.CENTER);
		label_24.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_24.setForeground(Color.RED);
		label_24.setBounds(6, 30, 78, 30);
		panel_24.add(label_24);
		
		JLabel label_50 = new JLabel("24");
		label_50.setBounds(6, 6, 61, 16);
		panel_24.add(label_50);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(Color.WHITE);
		panel_25.setBounds(448, 383, 90, 90);
		add(panel_25);
		panel_25.setLayout(null);
		
		label_25 = new JLabel("");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setHorizontalTextPosition(SwingConstants.CENTER);
		label_25.setForeground(Color.RED);
		label_25.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_25.setBounds(6, 30, 78, 30);
		panel_25.add(label_25);
		
		JLabel label_49 = new JLabel("25");
		label_49.setBounds(6, 6, 61, 16);
		panel_25.add(label_49);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(Color.WHITE);
		panel_26.setBounds(550, 383, 90, 90);
		add(panel_26);
		panel_26.setLayout(null);
		
		label_26 = new JLabel("");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setHorizontalTextPosition(SwingConstants.CENTER);
		label_26.setForeground(Color.RED);
		label_26.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_26.setBounds(6, 29, 78, 30);
		panel_26.add(label_26);
		
		JLabel label_48 = new JLabel("26");
		label_48.setBounds(6, 6, 61, 16);
		panel_26.add(label_48);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(Color.WHITE);
		panel_27.setBounds(652, 383, 90, 90);
		add(panel_27);
		panel_27.setLayout(null);
		
		label_27 = new JLabel("");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setHorizontalTextPosition(SwingConstants.CENTER);
		label_27.setForeground(Color.RED);
		label_27.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_27.setBounds(6, 30, 78, 30);
		panel_27.add(label_27);
		
		JLabel label_47 = new JLabel("27");
		label_47.setBounds(6, 6, 61, 16);
		panel_27.add(label_47);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(Color.WHITE);
		panel_22.setBounds(142, 383, 90, 90);
		add(panel_22);
		panel_22.setLayout(null);
		
		label_22 = new JLabel("");
		label_22.setHorizontalTextPosition(SwingConstants.CENTER);
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_22.setForeground(Color.RED);
		label_22.setBounds(6, 30, 78, 30);
		panel_22.add(label_22);
		
		JLabel label_60 = new JLabel("22");
		label_60.setBounds(6, 6, 61, 16);
		panel_22.add(label_60);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBackground(Color.WHITE);
		panel_30.setBounds(244, 485, 90, 90);
		add(panel_30);
		panel_30.setLayout(null);
		
		label_30 = new JLabel("");
		label_30.setHorizontalTextPosition(SwingConstants.CENTER);
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_30.setForeground(Color.RED);
		label_30.setBounds(6, 30, 78, 30);
		panel_30.add(label_30);
		
		JLabel label_53 = new JLabel("30");
		label_53.setBounds(6, 6, 61, 16);
		panel_30.add(label_53);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBackground(Color.WHITE);
		panel_29.setBounds(142, 485, 90, 90);
		add(panel_29);
		panel_29.setLayout(null);
		
		label_29 = new JLabel("");
		label_29.setHorizontalTextPosition(SwingConstants.CENTER);
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_29.setForeground(Color.RED);
		label_29.setBounds(6, 30, 78, 30);
		panel_29.add(label_29);
		
		JLabel label_61 = new JLabel("29");
		label_61.setBounds(6, 6, 61, 16);
		panel_29.add(label_61);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(244, 75, 90, 90);
		add(panel_2);
		panel_2.setLayout(null);
		
		label_2 = new JLabel("");
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_2.setForeground(Color.RED);
		label_2.setBounds(6, 30, 78, 30);
		panel_2.add(label_2);
		
		JLabel label_32 = new JLabel("2");
		label_32.setBounds(6, 6, 61, 16);
		panel_2.add(label_32);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(346, 75, 90, 90);
		add(panel_3);
		panel_3.setLayout(null);
		
		label_3 = new JLabel("");
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_3.setForeground(Color.RED);
		label_3.setBounds(6, 29, 78, 30);
		panel_3.add(label_3);
		
		JLabel label_33 = new JLabel("3");
		label_33.setBounds(6, 6, 61, 16);
		panel_3.add(label_33);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(448, 75, 90, 90);
		add(panel_4);
		panel_4.setLayout(null);
		
		label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_4.setBounds(6, 30, 78, 30);
		panel_4.add(label_4);
		
		JLabel label_34 = new JLabel("4");
		label_34.setBounds(6, 6, 61, 16);
		panel_4.add(label_34);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(550, 75, 90, 90);
		add(panel_5);
		panel_5.setLayout(null);
		
		label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_5.setBounds(6, 30, 78, 29);
		panel_5.add(label_5);
		
		JLabel label_35 = new JLabel("5");
		label_35.setBounds(6, 6, 61, 16);
		panel_5.add(label_35);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(652, 75, 90, 90);
		add(panel_6);
		panel_6.setLayout(null);
		
		label_6 = new JLabel("");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setHorizontalTextPosition(SwingConstants.CENTER);
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_6.setBounds(6, 33, 78, 30);
		panel_6.add(label_6);
		
		JLabel label_36 = new JLabel("6");
		label_36.setBounds(6, 5, 61, 16);
		panel_6.add(label_36);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(142, 75, 90, 90);
		add(panel_1);
		panel_1.setLayout(null);
		
		label_01 = new JLabel("");
		label_01.setHorizontalTextPosition(SwingConstants.CENTER);
		label_01.setHorizontalAlignment(SwingConstants.CENTER);
		label_01.setForeground(Color.RED);
		label_01.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_01.setBounds(6, 30, 78, 30);
		panel_1.add(label_01);
		
		JLabel label_199 = new JLabel("1");
		label_199.setBounds(6, 6, 61, 16);
		panel_1.add(label_199);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(754, 177, 90, 90);
		add(panel_14);
		panel_14.setLayout(null);
		
		label_14 = new JLabel("");
		label_14.setHorizontalTextPosition(SwingConstants.CENTER);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.RED);
		label_14.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_14.setBounds(6, 30, 78, 30);
		panel_14.add(label_14);
		
		JLabel label_38 = new JLabel("14");
		label_38.setBounds(6, 6, 61, 16);
		panel_14.add(label_38);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		panel_21.setBounds(754, 279, 90, 90);
		add(panel_21);
		panel_21.setLayout(null);
		
		label_21 = new JLabel("");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setHorizontalTextPosition(SwingConstants.CENTER);
		label_21.setForeground(Color.RED);
		label_21.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_21.setBounds(6, 30, 78, 30);
		panel_21.add(label_21);
		
		JLabel label_42 = new JLabel("21");
		label_42.setBounds(6, 6, 61, 16);
		panel_21.add(label_42);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBackground(Color.WHITE);
		panel_28.setBounds(754, 383, 90, 90);
		add(panel_28);
		panel_28.setLayout(null);
		
		label_28 = new JLabel("");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setHorizontalTextPosition(SwingConstants.CENTER);
		label_28.setForeground(Color.RED);
		label_28.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_28.setBounds(6, 30, 78, 30);
		panel_28.add(label_28);
		
		JLabel label_46 = new JLabel("28");
		label_46.setBounds(6, 6, 61, 16);
		panel_28.add(label_46);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(754, 75, 90, 90);
		add(panel_7);
		panel_7.setLayout(null);
		
		label_7 = new JLabel("");
		label_7.setHorizontalTextPosition(SwingConstants.CENTER);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		label_7.setBounds(6, 30, 78, 30);
		panel_7.add(label_7);
		
		JLabel label_37 = new JLabel("7");
		label_37.setBounds(6, 6, 61, 16);
		panel_7.add(label_37);
		
		JPanel panel_31 = new JPanel();
		panel_31.setLayout(null);
		panel_31.setBackground(Color.WHITE);
		panel_31.setBounds(346, 485, 90, 90);
		add(panel_31);
		
		label_31 = new JLabel("");
		label_31.setHorizontalTextPosition(SwingConstants.CENTER);
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setFont(new Font("Dialog", Font.PLAIN, 30));
		label_31.setForeground(Color.RED);
		label_31.setBounds(6, 30, 78, 31);
		panel_31.add(label_31);
		
		JLabel label_52 = new JLabel("31");
		label_52.setBounds(6, 6, 61, 16);
		panel_31.add(label_52);
		
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		monthComboBox = new JComboBox(months);
		monthComboBox.setBounds(448, 36, 130, 27);
		add(monthComboBox);
		
		String[] years = {"1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014"};
		yearComboBox = new JComboBox(years);
		yearComboBox.setBounds(600, 36, 98, 27);
		add(yearComboBox);
		
		String[] days = {"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		dayComboBox = new JComboBox(days);
		dayComboBox.setBounds(346, 36, 72, 27);
		add(dayComboBox);
		
		btnGo = new JButton("Go");
		btnGo.setBounds(723, 35, 63, 29);
		add(btnGo);
		btnGo.addActionListener(listener);
		
		JLabel lblLabel = new JLabel("Date:");
		lblLabel.setBounds(254, 40, 61, 16);
		add(lblLabel);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(891, 562, 97, 25);
		add(btnBack);
		btnBack.addActionListener(listener);
		
		labels.add(label_01);
		labels.add(label_2);
		labels.add(label_3);
		labels.add(label_3);
		labels.add(label_4);
		labels.add(label_5);
		labels.add(label_6);
		labels.add(label_7);
		labels.add(label_8);
		labels.add(label_9);
		labels.add(label_10);
		labels.add(label_11);
		labels.add(label_12);
		labels.add(label_13);
		labels.add(label_14);
		labels.add(label_15);
		labels.add(label_16);
		labels.add(label_17);
		labels.add(label_18);
		labels.add(label_19);
		labels.add(label_20);
		labels.add(label_21);
		labels.add(label_22);
		labels.add(label_23);
		labels.add(label_24);
		labels.add(label_25);
		labels.add(label_26);
		labels.add(label_27);
		labels.add(label_28);
		labels.add(label_29);
		labels.add(label_30);
		labels.add(label_31);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String s = dateFormat.format(cal.getTime());
		String year = s.substring(0,4);
		String month = s.substring(5,7);
		  
		System.out.println(year);
		System.out.println(month);
		monthComboBox.setSelectedIndex(Integer.parseInt(month) - 1);
		yearComboBox.setSelectedItem(year);
		
	}
	
	private class ButtonListener implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnGo) {
				if(!dayComboBox.getSelectedItem().equals("-")) {
					ViewAppointmentDatePanel vadp = new ViewAppointmentDatePanel(parent, username, Integer.parseInt((String) dayComboBox.getSelectedItem()),
							(String) monthComboBox.getSelectedItem(), Integer.parseInt((String) yearComboBox.getSelectedItem()));
					parent.getContentPane().add(vadp);
					CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
					cl.next(parent.getContentPane());
				} else {
					//Reset All labels
					for(JLabel l : labels) {
						l.setText("");
					}
					//Get the entire list of Appointments for this particular Doctor
					apptList = parent.getHandler().getAppointmentsForDoctor(username);
					ArrayList<Date> dateList = new ArrayList<Date>();
					int monthIndex = monthComboBox.getSelectedIndex();
					Object years = yearComboBox.getSelectedItem();
					int[] noVisits = new int[31];
					//Get the Number of Appointments for the selected Month and Year
					for(Appointment a : apptList) {
						int year = a.getDate().getYear()+1900;
						int month = a.getDate().getMonth();
						if(month == monthIndex && year == Integer.parseInt(years.toString())) {
							noVisits[a.getDate().getDate()]++;
							dateList.add(a.getDate());
						}
					}
					//Update the label for each affected date
					for(Date d : dateList) {
						Integer i = noVisits[d.getDate()];
						labels.get(d.getDate()).setText(i.toString());
					}

				}
			}
			else if(e.getSource() == btnBack){
				CardLayout cl = (CardLayout) parent.getContentPane().getLayout();
				parent.getContentPane().remove(parent.getContentPane().getComponents().length-1);
				cl.last(parent.getContentPane());
			}
		}
		
	}
}
