package com.bitcamp.project.kms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {

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
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(56, 59, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(56, 90, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(138, 56, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 87, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Log-In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberDTO dto = new MemberDTO();
				MemberDAO dao = new MemberDAO();
				
				
				dto = dao.getMember(textField.getText(),textField_1.getText());
				
				main2 m2 = new main2(dto);
				
				
				if(textField.getText().equals(dto.getId()) && textField_1.getText().equals(dto.getPw()))
				{
					
			      m2.setVisible(true);
				}

				else
				{
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인해주세요");
				}
				
				
			}
		});
		btnNewButton.setBounds(266, 56, 97, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				join j = new join();
				j.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(117, 152, 157, 23);
		contentPane.add(btnNewButton_1);
	}


}
