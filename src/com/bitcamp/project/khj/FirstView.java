package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
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

	private JPanel contentPane;
	private JTextField textField_d;
	private JTextField textField_a;
	private JComboBox comboBox_t;
	private JComboBox comboBox_p;
	private JComboBox comboBox_d;
	private JComboBox comboBox_y;
	private JComboBox comboBox_m;
	
	
	
	public JComboBox getComboBox_t() {
		return comboBox_t;
	}

	public void setComboBox_t(JComboBox comboBox_t) {
		this.comboBox_t = comboBox_t;
	}

	public JComboBox getComboBox_d() {
		return comboBox_d;
	}

	public void setComboBox_d(JComboBox comboBox_d) {
		this.comboBox_d = comboBox_d;
	}

	public JComboBox getComboBox_y() {
		return comboBox_y;
	}

	public void setComboBox_y(JComboBox comboBox_y) {
		this.comboBox_y = comboBox_y;
	}

	public JComboBox getComboBox_m() {
		return comboBox_m;
	}

	public void setComboBox_m(JComboBox comboBox_m) {
		this.comboBox_m = comboBox_m;
	}

	public JComboBox getComboBox_p() {
		return comboBox_p;
	}

	public void setComboBox_p(JComboBox comboBox_p) {
		this.comboBox_p = comboBox_p;
	}

	public JTextField getTextField_d() {
		return textField_d;
	}

	public void setTextField_d(JTextField textField_d) {
		this.textField_d = textField_d;
	}

	public JTextField getTextField_a() {
		return textField_a;
	}

	public void setTextField_a(JTextField textField_a) {
		this.textField_a = textField_a;
	}

	FirstDAO dao=new FirstDAO();
	List<String> arr=dao.Cal();
	String[] year=dao.year(arr);
	String[] month=dao.month(arr);
	String[] date=dao.day(arr);
	String[] time=dao.time();
	String[] person=dao.Person();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstView frame = new FirstView();
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
	public FirstView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblNewLabel.setBounds(130, 61, 41, 15);
		contentPane.add(lblNewLabel);
		
		textField_d = new JTextField();
		textField_d.setBounds(196, 58, 198, 21);
		contentPane.add(textField_d);
		textField_d.setColumns(10);
		
		JLabel label = new JLabel("\uC5ED");
		label.setBounds(406, 61, 12, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uCC29\uC5ED");
		lblNewLabel_1.setBounds(130, 107, 41, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_a = new JTextField();
		textField_a.setBounds(196, 107, 198, 21);
		contentPane.add(textField_a);
		textField_a.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\uC5ED");
		lblNewLabel_5.setBounds(406, 107, 12, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD9C\uBC1C\uC77C\uC790");
		lblNewLabel_2.setBounds(117, 158, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_y = new JComboBox(year);
		comboBox_y.setBounds(196, 155, 65, 21);
		comboBox_y.addActionListener(new FirstActionYear(comboBox_y));
		contentPane.add(comboBox_y);
		
		JComboBox comboBox_m = new JComboBox(month);
		comboBox_m.setBounds(277, 155, 128, 21);
		comboBox_m.addActionListener(new FirstActionMonth(comboBox_m));
		contentPane.add(comboBox_m);
		
		JComboBox comboBox_d = new JComboBox(date);
		comboBox_d.setBounds(417, 155, 53, 21);
		comboBox_d.addActionListener(new FirstActionDay(comboBox_d));
		contentPane.add(comboBox_d);
		
		JLabel lblNewLabel_3 = new JLabel("\uCD9C\uBC1C\uC2DC\uAC04");
		lblNewLabel_3.setBounds(117, 207, 56, 15);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_t = new JComboBox(time);
		comboBox_t.setBounds(198, 204, 256, 21);
		comboBox_t.addActionListener(new FirstActionTime(comboBox_t));
		contentPane.add(comboBox_t);
		
		JLabel lblNewLabel_4 = new JLabel("\uC778\uC6D0");
		lblNewLabel_4.setBounds(142, 251, 29, 15);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_p = new JComboBox(person);
		comboBox_p.setBounds(196, 248, 256, 21);
		comboBox_p.addActionListener(new FirstActionPerson(comboBox_p));
		contentPane.add(comboBox_p);
		
		JButton btnNewButton_g = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton_g.setBounds(264, 300, 113, 23);
		btnNewButton_g.addActionListener(new FirstActionGoto(textField_d,textField_a));
		contentPane.add(btnNewButton_g);
	}

}
