package com.bitcamp.project.lsy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(35, 35, 389, 426);
		contentPane.add(textPane);
		
		JButton inputCalButton = new JButton("Ä®·Î¸® ÀÔ·Â");
		inputCalButton.setBounds(35, 496, 105, 60);
		contentPane.add(inputCalButton);
		inputCalButton.addActionListener(new inputView());
		
		JButton outputCalButton = new JButton("Áö³­ Ä®·Î¸®");
		outputCalButton.setBounds(319, 496, 105, 60);
		contentPane.add(outputCalButton);
		outputCalButton.addActionListener(new outputView());
		
	}


	
}
