package com.bitcamp.project.lsy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class mainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView frame = new mainView();
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
	public mainView() {
		bodydata data = new bodydata();
		String body = data.getData();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton inputCalButton = new JButton("Ä®·Î¸® ÀÔ·Â");
		inputCalButton.setBounds(35, 496, 105, 60);
		contentPane.add(inputCalButton);
		inputCalButton.addActionListener(new inputView());
		inputCalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		
		JButton outputCalButton = new JButton("Áö³­ Ä®·Î¸®");
		outputCalButton.setBounds(319, 496, 105, 60);
		contentPane.add(outputCalButton);
		outputCalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 40, 389, 427);
		contentPane.add(textArea);
		outputCalButton.addActionListener(new outputView());
		textArea.setText(body);
		
		
	}
}
