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
		dayDTO dto = new dayDTO();
		dayDAO dao = new dayDAO();
		dto = dao.getdayList();
		
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
		
		montext.setText(Integer.toString(dto.getMon()));
		
		JLabel tuelabel = new JLabel("화요일");
		tuelabel.setBounds(65, 95, 59, 15);
		contentPane.add(tuelabel);
		
		JTextPane tuetext = new JTextPane();
		tuetext.setBounds(136, 92, 137, 22);
		contentPane.add(tuetext);
		tuetext.setText(Integer.toString(dto.getTue()));
		
		JLabel wedlabel = new JLabel("수요일");
		wedlabel.setBounds(65, 152, 59, 15);
		contentPane.add(wedlabel);
		
		JTextPane wedtext = new JTextPane();
		wedtext.setBounds(136, 149, 137, 22);
		contentPane.add(wedtext);
		wedtext.setText(Integer.toString(dto.getWed()));
		
		JLabel thulabel = new JLabel("목요일");
		thulabel.setBounds(65, 209, 59, 15);
		contentPane.add(thulabel);
		
		JTextPane thutext = new JTextPane();
		thutext.setBounds(136, 206, 137, 22);
		contentPane.add(thutext);
		thutext.setText(Integer.toString(dto.getThu()));
		
		JLabel frilabel = new JLabel("금요일");
		frilabel.setBounds(65, 266, 59, 15);
		contentPane.add(frilabel);
		
		JTextPane fritext = new JTextPane();
		fritext.setBounds(136, 263, 137, 22);
		contentPane.add(fritext);
		fritext.setText(Integer.toString(dto.getFri()));
		
		JLabel satlabel = new JLabel("토요일");
		satlabel.setBounds(65, 323, 59, 15);
		contentPane.add(satlabel);
		
		JTextPane sattext = new JTextPane();
		sattext.setBounds(136, 320, 137, 22);
		contentPane.add(sattext);
		sattext.setText(Integer.toString(dto.getSat()));
		
		JLabel sunlabel = new JLabel("일요일");
		sunlabel.setBounds(65, 380, 59, 15);
		contentPane.add(sunlabel);
		
		JTextPane suntext = new JTextPane();
		suntext.setBounds(136, 377, 137, 22);
		contentPane.add(suntext);
		suntext.setText(Integer.toString(dto.getSun()));
		
		
		JButton mainButton = new JButton("메인으로");
		mainButton.setBounds(315, 465, 111, 55);
		contentPane.add(mainButton);
		mainButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainView in = new mainView();
				in.setVisible(true);
				dispose();
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		outputView frame = new outputView();
		frame.setVisible(true);
		dispose();
		
	}

}
