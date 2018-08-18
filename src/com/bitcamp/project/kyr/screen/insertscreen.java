package com.bitcamp.project.kyr.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bitcamp.project.khj.FirstActionGoto;
import com.bitcamp.project.kyr.screenDTO;
import com.bitcamp.project.kyr.DAO.screenDAO;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class insertscreen extends JFrame{

/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertscreen frame = new insertscreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel label;
	private JTextField bname,publish,redate,bnum;
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	
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

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}
	
	screenDAO dao=new screenDAO();
	screenDTO dto=new screenDTO();
	
	
	
	public insertscreen() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 261, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("å �̸�");
		lblNewLabel.setBounds(12, 30, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("���ǻ�");
		lblNewLabel_1.setBounds(12, 65, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("������ ");
		lblNewLabel_2.setBounds(12, 103, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("å ��ȣ");
		lblNewLabel_3.setBounds(12, 142, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("å �߰�");
		btnNewButton.setBounds(12, 181, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDAO dao=new screenDAO();
				dao.insert(dto);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�ڷ� ����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainscreen mai=new mainscreen();
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(121, 181, 97, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField(); //å�̸� 
		textField.setBounds(100, 27, 97, 21);
		contentPane.add(textField);
		textField.setColumns(20);
		dto.setBname(textField.getText());
		
		textField_1 = new JTextField(); //������
		textField_1.setBounds(100, 100, 97, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(30);
		dto.setRedate(textField_1.getText());
		
		textField_2 = new JTextField();  //���ǻ�
		textField_2.setBounds(100, 62, 97, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(20);
		dto.setPublish(textField_2.getText());
		
		textField_3 = new JTextField();  //å��ȣ
		textField_3.setBounds(100, 139, 97, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(20);
		dto.setBnum(textField_3.getText());
		
		label = new JLabel("yyyy-mm-dd");
		label.setBounds(12, 115, 73, 15);
		contentPane.add(label);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	screenDAO dao=new screenDAO();
	
	dao.insert(dto);
	
	}
}
