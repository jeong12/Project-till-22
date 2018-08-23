package com.bitcamp.project.kyr.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bitcamp.project.kyr.screenDTO;
import com.bitcamp.project.kyr.DAO.screenDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class returnscreen extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField bnum,number;
	
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	/**
	    *    Launch the application.
	  */
	/*public static void main(String[] args) {
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
	}*/

	screenDTO dto=new screenDTO();
	screenDAO dao=new screenDAO();
	Connection conn=null;
	
	
	public returnscreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원 번호");
		lblNewLabel.setBounds(12, 43, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("책 번호");
		lblNewLabel_1.setBounds(12, 10, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("책 반납");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDAO dao=new screenDAO();
				int r=0;
				
				try {
					
				Float bm=(Float.parseFloat(textField.getText()));
				dto.setBnum(bm);
				int nm=(Integer.parseInt(textField_1.getText()));
				dto.setNumber(nm);
				
				r=dao.retu(dto,conn);
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, "입력을 잘못하셨거나 대여할 수 있는 책이 없습니다.");
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(221, 6, 97, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();  //책번호
		textField.setBounds(96, 7, 91, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();   //회원 번호
		textField_1.setBounds(96, 40, 91, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("뒤로 가기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(221, 39, 97, 23);
		contentPane.add(btnNewButton_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
