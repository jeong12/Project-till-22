package com.bitcamp.project.kms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;
    private static MemberDTO dto;


	/**
	 * Create the frame.
	 */
	public Delete(MemberDTO dto) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(93, 66, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(93, 97, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(179, 63, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 94, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Å»Åð");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MemberDAO dao = new MemberDAO();
				

				dto.setId(textField.getText());
				dto.setPw(textField_1.getText());
				
				dao.Delete(dto);
				
				System.exit(0);
				
			}
		});
		btnNewButton.setBounds(86, 158, 97, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("µÚ·Î°¡±â");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(198, 157, 97, 23);
		contentPane.add(btnNewButton_1);
	}
}
