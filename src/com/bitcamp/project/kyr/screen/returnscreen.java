package com.bitcamp.project.kyr.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class returnscreen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnscreen frame = new returnscreen();
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
	public returnscreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원 번호");
		lblNewLabel.setBounds(48, 43, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("책 번호");
		lblNewLabel_1.setBounds(143, 43, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("책 반납");
		btnNewButton.setBounds(258, 39, 97, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(29, 68, 91, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 68, 91, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("뒤로 가기");
		btnNewButton_1.setBounds(258, 97, 97, 23);
		contentPane.add(btnNewButton_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
