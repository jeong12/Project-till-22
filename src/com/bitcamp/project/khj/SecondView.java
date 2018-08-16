package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SecondView extends JFrame {

	
	private JPanel contentPane;
	JTextField textField_d;
	JTextField textField_a;
	JComboBox comboBox_t;
	JComboBox comboBox_p;
	JComboBox comboBox_d;
	JComboBox comboBox_m;
	
	FirstCal fc=new FirstCal();
	List<String> arr=fc.Cal();
	String[] year=fc.year(arr);
	String[] month=fc.month(arr);
	String[] date=fc.day(arr);
	String[] time=fc.time();
	String[] person=fc.Person();
	FirstDTO fdto;
	FirstDAO fdao;
	
	/**
	 * Launch the application.
	 */
	
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForthView frame = new ForthView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public SecondView(FirstDTO fdto) {
		this.fdto=fdto;
		fdao = new FirstDAO(fdto);
		this.setTitle("기차예약시스템인데 경부선밖에 안됨.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB2E4\uC2DC\uC608\uB9E4\uD558\uAE30");
		lblNewLabel.setBounds(50, 35, 111, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblNewLabel_1.setBounds(76, 88, 61, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_d = new JTextField();
		textField_d.setBounds(142, 85, 243, 21);
		contentPane.add(textField_d);
		textField_d.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uB3C4\uCC29\uC5ED");
		lblNewLabel_2.setBounds(76, 144, 61, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_a = new JTextField();
		textField_a.setBounds(142, 141, 243, 21);
		contentPane.add(textField_a);
		textField_a.setColumns(10);
		
		JLabel label = new JLabel("\uCD9C\uBC1C\uB0A0\uC9DC");
		label.setBounds(76, 197, 61, 15);
		contentPane.add(label);
		
		JComboBox comboBox_y = new JComboBox(year);
		comboBox_y.setBounds(142, 194, 72, 21);
		comboBox_y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				List<String> arr=fc.Cal();
				String[]y=fc.year(arr);
				String year=y[index];
				fdto.setYear(year);	
				System.out.println(year);}
		});
		contentPane.add(comboBox_y);
		
		JComboBox comboBox_m = new JComboBox(month);
		comboBox_m.setBounds(226, 194, 72, 21);
		comboBox_m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				List<String> arr=fc.Cal();
				String[]m=fc.month(arr);
				String month=m[index];
				fdto.setMonth(month);
				System.out.println(fdto.getMonth());}
		});
		contentPane.add(comboBox_m);
		
		JComboBox comboBox_d = new JComboBox(date);
		comboBox_d.setBounds(313, 194, 72, 21);
		comboBox_d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				JComboBox cb = (JComboBox) e.getSource();
				int index = cb.getSelectedIndex();
				List<String> arr=fc.Cal();
				String[]date=fc.day(arr);
				String d=date[index];
				fdto.setDate(d);
				System.out.println(fdto.getDate());}
		});
		contentPane.add(comboBox_d);
		
		JLabel lblNewLabel_3 = new JLabel("\uCD9C\uBC1C\uC2DC\uAC04");
		lblNewLabel_3.setBounds(76, 249, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_t = new JComboBox(time);
		comboBox_t.setBounds(142, 246, 98, 21);
		comboBox_t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				JComboBox cb=(JComboBox)e.getSource();
				int index = cb.getSelectedIndex();
				String[]t=fc.time();
				String time=t[index];
				String rtime=time.substring(0, 1)+":00:00";
				fdto.setTime(rtime);
				System.out.println(fdto.getTime());}
			});
		contentPane.add(comboBox_t);
		
		
		JLabel lblNewLabel_4 = new JLabel("\uC778\uC6D0");
		lblNewLabel_4.setBounds(76, 294, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_p = new JComboBox(person);
		comboBox_p.setBounds(142, 291, 72, 21);
		comboBox_p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			JComboBox cb = (JComboBox) e.getSource();
			int index = cb.getSelectedIndex();
			String[]person=fc.Person();
			String personnel=person[index];
			fdto.setPerson(personnel);
			System.out.println(fdto.getPerson());}
		});
		contentPane.add(comboBox_p);
		
		JButton btnNewButton_g = new JButton("\uAC80\uC0C9");
		btnNewButton_g.setBounds(446, 290, 97, 23);
		btnNewButton_g.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {			
				String ds=textField_d.getText();
				fdto.setDs(ds);
				String as=textField_a.getText();
				fdto.setAs(as);}});
				
		contentPane.add(btnNewButton_g);
		
		JLabel label_1 = new JLabel("\uC5F4\uCC28\uBC88\uD638");
		label_1.setBounds(142, 369, 72, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_5 = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblNewLabel_5.setBounds(331, 369, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uB3C4\uCC29\uC5ED");
		lblNewLabel_6.setBounds(488, 369, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uC88C\uC11D");
		lblNewLabel_7.setBounds(677, 369, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\uAE08\uC561");
		lblNewLabel_8.setBounds(766, 369, 57, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\uC5F4\uCC28\uBA85");
		lblNewLabel_9.setBounds(245, 369, 57, 15);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("\uCD9C\uBC1C \uC2DC\uAC04");
		lblNewLabel_10.setBounds(400, 369, 57, 15);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("\uB3C4\uCC29 \uC2DC\uAC04");
		lblNewLabel_11.setBounds(580, 369, 57, 15);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_1 = new JButton("\uC5ED \uAC80\uC0C9");
		btnNewButton_1.setBounds(446, 84, 97, 23);
		contentPane.add(btnNewButton_1);
		
		List<String> arr=fdao.getInfor();
		int size=arr.size();
		String[]info=new String[size];
		for(int i=0;i<size;i++) {
			info[i]=arr.get(i);
		}
		
		
		int y=410;		
		JRadioButton[]rb=new JRadioButton[size];
		ButtonGroup bg=new ButtonGroup();
		for(int i=0; i<size;i++) {
		rb[i]=new JRadioButton(info[i]);
		rb[i].setBounds(16, y, 860, 23);
		bg.add(rb[i]);
		contentPane.add(rb[i]);
		y+=21;}
		
		JButton button = new JButton("\uC608\uC57D\uD558\uAE30");
		button.setBounds(775, 828, 97, 23);
		button.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {			
				Enumeration<AbstractButton> em=bg.getElements();
				String st=null;
				while(em.hasMoreElements()) {
					AbstractButton ab=em.nextElement();
					JRadioButton jr=(JRadioButton)ab;
					
					if(jr.isSelected()) {
					st=jr.getText();
					fdto.setResult(st);
					}
						
				}
				ThirdView tv=new ThirdView(fdto);
				tv.setVisible(true);
			}
			
		});
			contentPane.add(button);
	

		
	}
}
			

	
