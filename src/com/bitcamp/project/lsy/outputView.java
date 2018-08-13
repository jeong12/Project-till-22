package com.bitcamp.project.lsy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextPane;

public class outputView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					outputView frame = new outputView();
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
	public outputView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("월요일");
		lblNewLabel.setBounds(65, 38, 59, 15);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(136, 35, 137, 22);
		contentPane.add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("화요일");
		lblNewLabel_1.setBounds(65, 95, 59, 15);
		contentPane.add(lblNewLabel_1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(136, 92, 137, 22);
		contentPane.add(textPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("수요일");
		lblNewLabel_2.setBounds(65, 152, 59, 15);
		contentPane.add(lblNewLabel_2);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(136, 149, 137, 22);
		contentPane.add(textPane_2);
		
		JLabel lblNewLabel_3 = new JLabel("목요일");
		lblNewLabel_3.setBounds(65, 209, 59, 15);
		contentPane.add(lblNewLabel_3);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(136, 206, 137, 22);
		contentPane.add(textPane_3);
		
		JLabel lblNewLabel_4 = new JLabel("금요일");
		lblNewLabel_4.setBounds(65, 266, 59, 15);
		contentPane.add(lblNewLabel_4);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(136, 263, 137, 22);
		contentPane.add(textPane_4);
		
		JLabel lblNewLabel_5 = new JLabel("토요일");
		lblNewLabel_5.setBounds(65, 323, 59, 15);
		contentPane.add(lblNewLabel_5);
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBounds(136, 320, 137, 22);
		contentPane.add(textPane_5);
		
		JLabel lblNewLabel_6 = new JLabel("일요일");
		lblNewLabel_6.setBounds(65, 380, 59, 15);
		contentPane.add(lblNewLabel_6);
		
		JTextPane textPane_6 = new JTextPane();
		textPane_6.setBounds(136, 377, 137, 22);
		contentPane.add(textPane_6);
		
		JLabel lblNewLabel_7 = new JLabel("평균 섭취칼로리");
		lblNewLabel_7.setBounds(65, 439, 111, 15);
		contentPane.add(lblNewLabel_7);
		
		JTextPane textPane_7 = new JTextPane();
		textPane_7.setBounds(188, 434, 85, 26);
		contentPane.add(textPane_7);
		
		JButton btnNewButton = new JButton("메인으로");
		btnNewButton.setBounds(315, 465, 111, 55);
		contentPane.add(btnNewButton);
	}

}
