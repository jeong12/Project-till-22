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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("월요일");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridwidth = 4;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 4;
		gbc_textPane.gridy = 1;
		contentPane.add(textPane, gbc_textPane);
		
		JLabel lblNewLabel_1 = new JLabel("화요일");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JTextPane textPane_1 = new JTextPane();
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.gridwidth = 4;
		gbc_textPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_1.fill = GridBagConstraints.BOTH;
		gbc_textPane_1.gridx = 4;
		gbc_textPane_1.gridy = 3;
		contentPane.add(textPane_1, gbc_textPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("수요일");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JTextPane textPane_2 = new JTextPane();
		GridBagConstraints gbc_textPane_2 = new GridBagConstraints();
		gbc_textPane_2.gridwidth = 4;
		gbc_textPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_2.fill = GridBagConstraints.BOTH;
		gbc_textPane_2.gridx = 4;
		gbc_textPane_2.gridy = 5;
		contentPane.add(textPane_2, gbc_textPane_2);
		
		JLabel lblNewLabel_3 = new JLabel("목요일");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 7;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JTextPane textPane_3 = new JTextPane();
		GridBagConstraints gbc_textPane_3 = new GridBagConstraints();
		gbc_textPane_3.gridwidth = 4;
		gbc_textPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_3.fill = GridBagConstraints.BOTH;
		gbc_textPane_3.gridx = 4;
		gbc_textPane_3.gridy = 7;
		contentPane.add(textPane_3, gbc_textPane_3);
		
		JLabel lblNewLabel_4 = new JLabel("금요일");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 9;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JTextPane textPane_4 = new JTextPane();
		GridBagConstraints gbc_textPane_4 = new GridBagConstraints();
		gbc_textPane_4.gridwidth = 4;
		gbc_textPane_4.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_4.fill = GridBagConstraints.BOTH;
		gbc_textPane_4.gridx = 4;
		gbc_textPane_4.gridy = 9;
		contentPane.add(textPane_4, gbc_textPane_4);
		
		JLabel lblNewLabel_5 = new JLabel("토요일");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 11;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JTextPane textPane_5 = new JTextPane();
		GridBagConstraints gbc_textPane_5 = new GridBagConstraints();
		gbc_textPane_5.gridwidth = 4;
		gbc_textPane_5.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_5.fill = GridBagConstraints.BOTH;
		gbc_textPane_5.gridx = 4;
		gbc_textPane_5.gridy = 11;
		contentPane.add(textPane_5, gbc_textPane_5);
		
		JLabel lblNewLabel_6 = new JLabel("일요일");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 13;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JTextPane textPane_6 = new JTextPane();
		GridBagConstraints gbc_textPane_6 = new GridBagConstraints();
		gbc_textPane_6.gridwidth = 4;
		gbc_textPane_6.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_6.fill = GridBagConstraints.BOTH;
		gbc_textPane_6.gridx = 4;
		gbc_textPane_6.gridy = 13;
		contentPane.add(textPane_6, gbc_textPane_6);
		
		JLabel lblNewLabel_7 = new JLabel("평균 섭취칼로리");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.gridheight = 2;
		gbc_lblNewLabel_7.gridwidth = 4;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 15;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JTextPane textPane_7 = new JTextPane();
		GridBagConstraints gbc_textPane_7 = new GridBagConstraints();
		gbc_textPane_7.gridheight = 2;
		gbc_textPane_7.gridwidth = 3;
		gbc_textPane_7.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_7.fill = GridBagConstraints.BOTH;
		gbc_textPane_7.gridx = 5;
		gbc_textPane_7.gridy = 15;
		contentPane.add(textPane_7, gbc_textPane_7);
		
		JButton btnNewButton = new JButton("메인으로");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 10;
		gbc_btnNewButton.gridy = 17;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
