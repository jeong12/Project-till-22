package com.bitcamp.project.kms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class join extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					join frame = new join();
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
	public join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("���̵�");
		lblNewLabel.setBounds(33, 46, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("��й�ȣ");
		label.setBounds(33, 90, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("�̸�");
		label_1.setBounds(33, 137, 57, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("�޴��� ��ȣ");
		lblNewLabel_1.setBounds(33, 182, 64, 15);
		contentPane.add(lblNewLabel_1);
		

		
		JButton btnNewButton_1 = new JButton("�ڷΰ���");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(180, 455, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("�ֹι�ȣ");
		lblNewLabel_3.setBounds(33, 227, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("����");
		lblNewLabel_4.setBounds(33, 268, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("����");
		lblNewLabel_5.setBounds(33, 311, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ű");
		lblNewLabel_6.setBounds(33, 350, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(137, 43, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(137, 87, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(137, 134, 116, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(137, 179, 116, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(137, 224, 116, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(137, 265, 116, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("����");
		rdbtnNewRadioButton.setBounds(137, 307, 64, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("����");
		rdbtnNewRadioButton_1.setBounds(198, 307, 121, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(137, 347, 116, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(137, 390, 116, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("������");
		lblNewLabel_2.setBounds(33, 393, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO dao = new MemberDAO();
				memberDTO dto = new memberDTO();
				
				dto.setId(textField.getText());
				dto.setPw(textField_1.getText());
				dto.setName(textField_2.getText());
				dto.setCellphone(textField_3.getText());
			dto.setJumin(Integer.parseInt(textField_4.getText()));
				dto.setAge(Integer.parseInt(textField_5.getText()));
				dto.setHeight(Integer.parseInt(textField_6.getText()));
				dto.setWeight(Integer.parseInt(textField_7.getText()));
			   dto.setGender("");
		/*    if(rdbtnNewRadioButton.isSelected()){
		             dto.setGender("M");
		        }else if(rdbtnNewRadioButton_1.isSelected()){
		             dto.setGender("W");
		        }
				*/ //���⼭ ����
				 dao.JoinUser(dto);
			}

		
		});
		btnNewButton.setBounds(33, 455, 97, 23);
		contentPane.add(btnNewButton);
		
	}
}
