package com.bitcamp.project.kms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bitcamp.project.khj.FirstView;
import com.bitcamp.project.kyr.screen.mainscreen;
import com.bitcamp.project.lsy.mainView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main2 extends JFrame {

	private JPanel contentPane;
	private static MemberDTO dto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main2 frame = new main2(dto);
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
	
	
	public main2(MemberDTO dto) {
		
		this.dto = dto;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("�迵��");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int number = dto.getNumber();
				
				mainscreen ms = new mainscreen(number);
				ms.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(37, 54, 97, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("������");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int number = dto.getNumber();
				
				FirstView fv = new FirstView(number);
				fv.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(146, 54, 97, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("�̼���");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = dto.getId();
			    
				mainView mv = new mainView();
				
				mv.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(255, 54, 97, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ȸ������ ����");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		      Update u = new Update(dto);
		      u.setVisible(true);
				
			 }
		});
		btnNewButton_3.setBounds(80, 194, 109, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("ȸ��Ż��");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Delete d = new Delete(dto);
				d.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(201, 194, 109, 23);
		contentPane.add(btnNewButton_4);
	}
}
