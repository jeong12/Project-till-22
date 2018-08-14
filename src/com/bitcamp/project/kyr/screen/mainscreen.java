package com.bitcamp.project.kyr.screen;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainscreen extends JFrame implements ActionListener{

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
	 *  Create the frame.
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
