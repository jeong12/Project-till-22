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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;

public class outputView extends JFrame implements ActionListener{

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
		
		JLabel monlabel = new JLabel("월요일");
		monlabel.setBounds(65, 38, 59, 15);
		contentPane.add(monlabel);
		
		JTextPane montext = new JTextPane();
		montext.setBounds(136, 35, 137, 22);
		contentPane.add(montext);
		
		JLabel tuelabel = new JLabel("화요일");
		tuelabel.setBounds(65, 95, 59, 15);
		contentPane.add(tuelabel);
		
		JTextPane tuetext = new JTextPane();
		tuetext.setBounds(136, 92, 137, 22);
		contentPane.add(tuetext);
		
		JLabel wedlabel = new JLabel("수요일");
		wedlabel.setBounds(65, 152, 59, 15);
		contentPane.add(wedlabel);
		
		JTextPane wedtext = new JTextPane();
		wedtext.setBounds(136, 149, 137, 22);
		contentPane.add(wedtext);
		
		JLabel thulabel = new JLabel("목요일");
		thulabel.setBounds(65, 209, 59, 15);
		contentPane.add(thulabel);
		
		JTextPane thutext = new JTextPane();
		thutext.setBounds(136, 206, 137, 22);
		contentPane.add(thutext);
		
		JLabel frilabel = new JLabel("금요일");
		frilabel.setBounds(65, 266, 59, 15);
		contentPane.add(frilabel);
		
		JTextPane fritext = new JTextPane();
		fritext.setBounds(136, 263, 137, 22);
		contentPane.add(fritext);
		
		JLabel satlabel = new JLabel("토요일");
		satlabel.setBounds(65, 323, 59, 15);
		contentPane.add(satlabel);
		
		JTextPane sattext = new JTextPane();
		sattext.setBounds(136, 320, 137, 22);
		contentPane.add(sattext);
		
		JLabel sunlabel = new JLabel("일요일");
		sunlabel.setBounds(65, 380, 59, 15);
		contentPane.add(sunlabel);
		
		JTextPane suntext = new JTextPane();
		suntext.setBounds(136, 377, 137, 22);
		contentPane.add(suntext);
		
		JLabel avglabel = new JLabel("평균 섭취칼로리");
		avglabel.setBounds(65, 439, 111, 15);
		contentPane.add(avglabel);
		
		JTextPane avgtext = new JTextPane();
		avgtext.setBounds(188, 434, 85, 26);
		contentPane.add(avgtext);
		
		JButton mainButton = new JButton("메인으로");
		mainButton.setBounds(315, 465, 111, 55);
		contentPane.add(mainButton);
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
		outputView frame = new outputView();
		frame.setVisible(true);
	}

}
