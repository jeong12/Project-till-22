package com.bitcamp.project.lsy;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class inputView extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inputView frame = new inputView();
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
	public inputView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 600);
		getContentPane().setLayout(null);
		
		JLabel morningLabel = new JLabel("아침");
		morningLabel.setBounds(71, 30, 40, 21);
		getContentPane().add(morningLabel);
		
		textField = new JTextField();
		textField.setBounds(146, 30, 192, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lunchLabel = new JLabel("점심");
		lunchLabel.setBounds(71, 86, 40, 21);
		getContentPane().add(lunchLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 86, 192, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel dinnerLabel = new JLabel("저녁");
		dinnerLabel.setBounds(71, 142, 40, 21);
		getContentPane().add(dinnerLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 142, 192, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel foodLabel = new JLabel("간식");
		foodLabel.setBounds(71, 198, 40, 21);
		getContentPane().add(foodLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 198, 192, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton inputButton = new JButton("입력");
		inputButton.setBounds(30, 326, 394, 55);
		getContentPane().add(inputButton);
		
		JButton deleteButton = new JButton("초기화");
		deleteButton.setBounds(30, 432, 102, 60);
		getContentPane().add(deleteButton);
		
		JButton mainButton = new JButton("메인으로");
		mainButton.setBounds(322, 432, 102, 60);
		getContentPane().add(mainButton);
		mainButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		inputView frame = new inputView();
		frame.setVisible(true);
	}

}
