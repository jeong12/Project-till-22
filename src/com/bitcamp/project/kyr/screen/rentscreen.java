package com.bitcamp.project.kyr.screen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bitcamp.project.kyr.screenDTO;
import com.bitcamp.project.kyr.DAO.screenDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import javax.swing.JTextArea;

public class rentscreen extends JFrame implements ActionListener {
	private static final Component JTable = null;
	private static final Object[][] Object = null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rentscreen frame = new rentscreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField bnum,number;
	/**
	  *   Launch the application.
	 */

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
	screenDTO dto=new screenDTO();
	screenDAO dao=new screenDAO();
	
	/**
	 * Create the frame.
	 */
	
	public rentscreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("책 번호");
		lblNewLabel_1.setBounds(27, 26, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("회원 번호");
		lblNewLabel.setBounds(27, 51, 57, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();  //책번호 bnum
		textField.setBounds(109, 23, 95, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		dto.setBnum(textField.getColumns());
		
		textField_1 = new JTextField();   //회원번호 number
		textField_1.setBounds(109, 48, 95, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		dto.setNumber(textField.getColumns());
		
		JButton btnNewButton = new JButton("책 대여");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDAO dao=new screenDAO();
				dao.rent(dto);
			}
		});
		btnNewButton.setBounds(234, 22, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("뒤로 가기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainscreen mai=new mainscreen();
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(234, 47, 97, 23);
		contentPane.add(btnNewButton_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
