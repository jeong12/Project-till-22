package com.bitcamp.project.kyr.screen;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.xml.ws.soap.MTOM;

import com.bitcamp.project.kms.MemberDTO;
import com.bitcamp.project.kms.main2;
import com.bitcamp.project.kyr.screenDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainscreen extends JFrame implements ActionListener{

	MemberDTO mto=new MemberDTO();
	screenDTO dto=new screenDTO();

	public mainscreen(int number) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 228, 328);
		getContentPane().setLayout(null);

		mto.setNumber(number);

		JButton button = new JButton("책 대여");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentscreen ren=new rentscreen(number);
				ren.setVisible(true);
			}
		});
		button.setBounds(12, 26, 187, 62);
		getContentPane().add(button);

		JButton button_1 = new JButton("책 반납");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnscreen ret=new returnscreen(number);
				ret.setVisible(true);
			}
		});
		button_1.setBounds(12, 82, 187, 66);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("책 추가");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertscreen ins=new insertscreen();
				ins.setVisible(true);
			}
		});
		button_2.setBounds(12, 145, 187, 62);
		getContentPane().add(button_2);

		JButton btnNewButton = new JButton("메인 화면으로");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDTO mto=new MemberDTO();

				main2 ma2=new main2(number);
				ma2.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 204, 187, 62);
		getContentPane().add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}