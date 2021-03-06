package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bitcamp.project.kms.main2;
import com.bitcamp.project.kyr.screen.returnscreen;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


public class FirstView extends JFrame {

	JPanel contentPane;
	JTextField textField_d;
	JTextField textField_a;
	JComboBox comboBox_t;
	JComboBox comboBox_p;
	JComboBox comboBox_d;
	JComboBox comboBox_y;
	JComboBox comboBox_m;
	
	FirstCal fc=new FirstCal();
	FirstDTO fdto=new FirstDTO();
	List<String> arr=fc.Cal();
	String[] year=fc.year(arr);
	String[] month=fc.month(arr);
	String[] date=fc.day(arr);
	String[] time=fc.time();
	String[] person=fc.Person();
	static int mid;
	private JButton btn_tm;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstView frame = new FirstView(mid);
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
	public FirstView(int mid) {
		this.mid=mid;
		fdto.setMid(mid);
		fdto.setYear(year[0]);
		fdto.setMonth(month[0]);
		fdto.setDate(date[0]);
		fdto.setPerson(person[0]);
		fdto.setDtime(time[0].substring(0, 2)+":00:00");
		
		this.setTitle("시작은 작은 '경부선'이지만, 차근차근 한반도 구석까지 넓혀가겠습니다 :)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		System.out.println(fdto.getMid());
		
		JLabel lblNewLabel = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblNewLabel.setBounds(130, 61, 41, 15);
		contentPane.add(lblNewLabel);
		
		textField_d = new JTextField();
		textField_d.setBounds(196, 58, 198, 21);
		contentPane.add(textField_d);
		textField_d.setColumns(10);
		
		JLabel label = new JLabel("\uC5ED");
		label.setBounds(406, 61, 29, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uCC29\uC5ED");
		lblNewLabel_1.setBounds(130, 107, 41, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_a = new JTextField();
		textField_a.setBounds(196, 107, 198, 21);
		contentPane.add(textField_a);
		textField_a.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uC5ED");
		lblNewLabel_5.setBounds(406, 107, 29, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD9C\uBC1C\uC77C\uC790");
		lblNewLabel_2.setBounds(117, 158, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_y = new JComboBox(year);
		comboBox_y.setBounds(196, 155, 65, 21);
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
		comboBox_m.setBounds(277, 155, 128, 21);
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
		comboBox_d.setBounds(417, 155, 53, 21);
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
		lblNewLabel_3.setBounds(117, 207, 56, 15);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_t = new JComboBox(time);
		comboBox_t.setBounds(198, 204, 256, 21);
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
		lblNewLabel_4.setBounds(142, 251, 29, 15);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_p = new JComboBox(person);
		comboBox_p.setBounds(196, 248, 256, 21);
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
		
		
		JButton btnNewButton_g = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton_g.setBounds(265, 300, 113, 23);
		btnNewButton_g.addActionListener(new ActionListener() {		
		public void actionPerformed(ActionEvent e) {					
			
			String ds=textField_d.getText();
			String as=textField_a.getText();
			System.out.println(ds);
			System.out.println(as);
			List<String>sta=fc.getStation();
			if(sta.contains(ds)&sta.contains(as)) {
				fdto.setDs(ds);
				fdto.setAs(as);
				if(fdto.getDate()==null||fdto.getMonth()==null||fdto.getYear()==null||fdto.getDtime()==null||fdto.getPerson()==null) {
					JOptionPane.showMessageDialog(contentPane, "클릭하지 않은 정보를 눌러주세요.\n 다시한번씩 정보를 눌러주세요", "오류창!",JOptionPane.ERROR_MESSAGE);
				}
				else {
					SecondView sc=new SecondView(fdto);
					sc.setVisible(true);
					dispose();	
				}
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "존재하지 않는 역입니다.\n 다시 입력하세요", "오류창!",JOptionPane.ERROR_MESSAGE);
			}			
		}
			
		});				
		contentPane.add(btnNewButton_g);
		
		btn_tm = new JButton("메인화면으로");
		btn_tm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main2 main=new main2(mid);
				main.setVisible(true);
				dispose();
			
			}
		});
		btn_tm.setActionCommand("\uBA54\uC778\uD654\uBA74\uC73C\uB85C");
		btn_tm.setBounds(544, 10, 128, 23);
		contentPane.add(btn_tm);
		
		JButton btnNewButton = new JButton("\uC5ED\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Station st=new Station(fdto);
				st.setVisible(true);
			}
		});
		btnNewButton.setBounds(449, 81, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\uCDE8\uC18C\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delview dl=new Delview(fdto);
				dl.setVisible(true);
				dispose();	
			}
		});
		button.setBounds(12, 328, 97, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uC608\uC57D\uB0B4\uC5ED \uCD9C\uB825\uD558\uAE30");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prtview pv=new Prtview(fdto);
				pv.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(531, 328, 141, 23);
		contentPane.add(button_1);
		

	}
}
