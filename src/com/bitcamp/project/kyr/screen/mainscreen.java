package com.bitcamp.project.kyr.screen;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bitcamp.project.kyr.screenDTO;
import com.bitcamp.project.kyr.DAO.screenDAO;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class mainscreen extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainscreen frame = new mainscreen();
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
	public mainscreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 227, 267);
		getContentPane().setLayout(null);
		
		JButton button = new JButton("책 대여");
		button.setBounds(38, 37, 97, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("책 반납");
		button_1.setBounds(38, 82, 97, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("책 추가");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setBounds(38, 129, 97, 23);
		getContentPane().add(button_2);
	}

}
