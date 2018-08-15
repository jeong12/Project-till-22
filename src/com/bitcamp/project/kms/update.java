package com.bitcamp.project.kms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
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
	public update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 301, 523);
		contentPane.add(panel);
		
		JLabel label = new JLabel("아이디");
		label.setBounds(33, 46, 57, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("비밀번호");
		label_1.setBounds(33, 90, 57, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("이름");
		label_2.setBounds(33, 137, 57, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("휴대폰 번호");
		label_3.setBounds(33, 182, 64, 15);
		panel.add(label_3);
		
		JButton button = new JButton("수정");
		button.setBounds(33, 454, 97, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("뒤로가기");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1.setBounds(165, 454, 97, 23);
		panel.add(button_1);
		
		JLabel label_4 = new JLabel("주민번호");
		label_4.setBounds(33, 227, 57, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("나이");
		label_5.setBounds(33, 268, 57, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("성별");
		label_6.setBounds(33, 311, 57, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("키");
		label_7.setBounds(33, 350, 57, 15);
		panel.add(label_7);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(137, 43, 116, 21);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 87, 116, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 134, 116, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 179, 116, 21);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(137, 224, 116, 21);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(137, 265, 116, 21);
		panel.add(textField_5);
		
		JRadioButton radioButton = new JRadioButton("남자");
		radioButton.setBounds(137, 307, 64, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("여자");
		radioButton_1.setBounds(198, 307, 121, 23);
		panel.add(radioButton_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(137, 347, 116, 21);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(137, 390, 116, 21);
		panel.add(textField_7);
		
		JLabel label_8 = new JLabel("몸무게");
		label_8.setBounds(33, 393, 57, 15);
		panel.add(label_8);
	}
}
