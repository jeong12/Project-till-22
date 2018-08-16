package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThirdView extends JFrame {

	private JPanel contentPane;
	FirstDTO fdto;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThirdView frame = new ThirdView(fdto);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ThirdView(FirstDTO fdto) {
		this.fdto=fdto;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 38, 500, 300);
		textArea.append("열차번호     열차명        출발역        출발시간      도착역      도착시간       좌석     금액 "+"\n");
		textArea.append(fdto.getResult());
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("\uC120\uD0DD \uB0B4\uC6A9 \uD655\uC778");
		lblNewLabel.setBounds(27, 13, 371, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton.setBounds(400,300, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
	}

}
