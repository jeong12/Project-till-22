package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.animation.Interpolator;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		comboBox_t.setBounds(142, 246, 120, 21);
		comboBox_t.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				JComboBox cb=(JComboBox)e.getSource();
				int index = cb.getSelectedIndex();
				String[]t=fc.time();
				String time=t[index];
				String rtime=time.substring(0, 2)+":00:00";
				fdto.setDtime(rtime);
				System.out.println(fdto.getDtime());}
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
		
		JButton btn_s = new JButton("\uAC80\uC0C9");
		btn_s.setBounds(446, 290, 97, 23);
		btn_s.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {			
				String ds=textField_d.getText();
				String as=textField_a.getText();
				System.out.println(ds);
				System.out.println(as);
				List<String>sta=fc.getStation();
				if(sta.contains(ds)&sta.contains(as)) {
					fdto.setDs(ds);
					fdto.setAs(as);
					SecondView sc=new SecondView(fdto);
					sc.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "존재하지 않는 역입니다.\n 다시 입력하세요", "오류창!",JOptionPane.ERROR_MESSAGE);
				}

			}});
				
		contentPane.add(btn_s);
		
		JLabel label_1 = new JLabel("\uC5F4\uCC28\uBC88\uD638");
		label_1.setBounds(33, 369, 72, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_5 = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblNewLabel_5.setBounds(278, 369, 57, 15);
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
		lblNewLabel_9.setBounds(170, 369, 57, 15);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("\uCD9C\uBC1C \uC2DC\uAC04");
		lblNewLabel_10.setBounds(379, 369, 57, 15);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("\uB3C4\uCC29 \uC2DC\uAC04");
		lblNewLabel_11.setBounds(580, 369, 57, 15);
		contentPane.add(lblNewLabel_11);
		
		JButton Button_next = new JButton("\uC5ED \uAC80\uC0C9");
		Button_next.setBounds(446, 84, 97, 23);
		contentPane.add(Button_next);
		
		JButton btnNewButton_2 = new JButton("\uB2E4\uC74C");
		btnNewButton_2.setBounds(121, 828, 97, 23);
		btnNewButton_2.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {			
			
				SecondView2 sv2=new SecondView2(fdto);
				sv2.setVisible(true);
				dispose();
				
			}
			
		});
		
		
		
		
		List<String> info=fdao.getInfor();
		int size=info.size();
		List<String> sit=fdao.getSeat(info);
		
		String[]tnumber=new String[size];
		String[]tname=new String[size];
		String[]dsname=new String[size];
		String[]dtime=new String[size];
		String[]asname=new String[size];
		String[]atime=new String[size];
		String[]fair=new String[size];
		String[]seat=new String[size];
		
		for(int e=0;e<sit.size();e++) {
			seat[e]=sit.get(e);
		}
		
		for(int i=0;i<size;i++) {
			String str=info.get(i);
			String[] r=str.split(",");
			tnumber[i]=r[0];
			tname[i]=r[1];
			dsname[i]=r[2];
			dtime[i]=r[3];
			asname[i]=r[4];
			atime[i]=r[5];
			String fe=r[6];
			int p=Integer.parseInt(fdto.getPerson().substring(0, 1));
			int fee=Integer.parseInt(fe)*p;
			fair[i]=String.valueOf(fee);
		}// 라디오버튼 페이지의 내용들 쪼개기(열차번호, 열차명, 역이름, 시간, 금액, 좌석)
		
		// 라이더 버튼 만들기
		int y=410;		
		JRadioButton[]rb=new JRadioButton[size];
		ButtonGroup bg=new ButtonGroup();
		if(size<20) {
		for(int i=0; i<size;i++) {
		rb[i]=new JRadioButton(tnumber[i]);
		rb[i].setBounds(30, y, 60, 23);
		bg.add(rb[i]);
		contentPane.add(rb[i]);
		y+=21;}
		} //라디어버튼 만들기 (사이즈가 20보다 작을 때)
		else {
			for(int i=0; i<20;i++) {
				rb[i]=new JRadioButton(tnumber[i]);
				rb[i].setBounds(30, y, 60, 23);
				bg.add(rb[i]);
				contentPane.add(rb[i]);
				contentPane.add(btnNewButton_2);	
				y+=21;}			
		}//라디어버튼 만들기 (사이즈가 20보다 클 때)
		
			
			JLabel[] tn=new JLabel[size];
			JLabel[] ds=new JLabel[size];
			JLabel[] dt=new JLabel[size];
			JLabel[] as=new JLabel[size];
			JLabel[] at=new JLabel[size];
			JLabel[] f=new JLabel[size];
			JLabel[] s=new JLabel[size];
			
			int y1=410;
			
			if(size<20) {			
			
			for(int k=0;k<size;k++) {
				tn[k]=new JLabel(tname[k]);
				tn[k].setBounds(160,y1,70,15);
				
				ds[k]=new JLabel(dsname[k]);
				ds[k].setBounds(278, y1, 57, 15);
				
				dt[k]=new JLabel(dtime[k]);
				dt[k].setBounds(379, y1, 57, 15);
				
				as[k]=new JLabel(asname[k]);
				as[k].setBounds(488, y1, 57, 15);
				
				at[k]=new JLabel(atime[k]);
				at[k].setBounds(580, y1, 57, 15);
				
				s[k]=new JLabel(seat[k]+"/28");
				s[k].setBounds(677, y1, 57, 15);
				
				f[k]=new JLabel(fair[k]);
				f[k].setBounds(766, y1, 57, 15);
				
				contentPane.add(tn[k]);
				contentPane.add(ds[k]);
				contentPane.add(dt[k]);
				contentPane.add(as[k]);
				contentPane.add(at[k]);
				contentPane.add(f[k]);
				contentPane.add(s[k]);
				
				y1+=21;
				
			}
			}
			else {
				for(int k=0;k<20;k++) {
					tn[k]=new JLabel(tname[k]);
					tn[k].setBounds(160,y1,70,15);
					
					ds[k]=new JLabel(dsname[k]);
					ds[k].setBounds(278, y1, 57, 15);
					
					dt[k]=new JLabel(dtime[k]);
					dt[k].setBounds(379, y1, 57, 15);
					
					as[k]=new JLabel(asname[k]);
					as[k].setBounds(488, y1, 57, 15);
					
					at[k]=new JLabel(atime[k]);
					at[k].setBounds(580, y1, 57, 15);
					
					s[k]=new JLabel(seat[k]+"/28");
					s[k].setBounds(677, y1, 57, 15);
					
					f[k]=new JLabel(fair[k]);
					f[k].setBounds(766, y1, 57, 15);
					
					contentPane.add(tn[k]);
					contentPane.add(ds[k]);
					contentPane.add(dt[k]);
					contentPane.add(as[k]);
					contentPane.add(at[k]);
					contentPane.add(f[k]);
					contentPane.add(s[k]);
					
					y1+=21;
				
			}
			}
			
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
						fdto.setTnumber(st);
						System.out.println(fdto.getTnumber());
						}						
					}
					
					List<String> arr=fdao.Final(fdto);
/*					String as=arr.get(0);
					String at=arr.get(1);
					String tname=arr.get(2);
					String fair=arr.get(3);
					
					fdto.setAs(as);
					fdto.setAtime(at);
					fdto.setTname(tname);
					fdto.setFair(fair);
					*/
					
					String s=fdao.Seat();
					fdto.setSeat(s);
					
					
					ThirdView tv=new ThirdView(fdto);
					tv.setVisible(true);
				}
				
			});
				contentPane.add(button);
				
			
		
	}
}
			

	
