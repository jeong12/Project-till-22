package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class SecondView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondView frame = new SecondView();
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
	public SecondView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB2E4\uC2DC\uC608\uB9E4\uD558\uAE30");
		lblNewLabel.setBounds(50, 35, 111, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblNewLabel_1.setBounds(76, 88, 61, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(142, 85, 243, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uB3C4\uCC29\uC5ED");
		lblNewLabel_2.setBounds(76, 144, 61, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 141, 243, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("\uCD9C\uBC1C\uB0A0\uC9DC");
		label.setBounds(76, 197, 61, 15);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 194, 72, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(226, 194, 72, 21);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(313, 194, 72, 21);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uCD9C\uBC1C\uC2DC\uAC04");
		lblNewLabel_3.setBounds(76, 249, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(142, 246, 98, 21);
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC778\uC6D0");
		lblNewLabel_4.setBounds(76, 294, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(142, 291, 72, 21);
		contentPane.add(comboBox_4);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setBounds(580, 304, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("\uC5F4\uCC28\uBC88\uD638");
		label_1.setBounds(142, 369, 72, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_5 = new JLabel("\uCD9C\uBC1C\uC5ED");
		lblNewLabel_5.setBounds(331, 369, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uB3C4\uCC29\uC5ED");
		lblNewLabel_6.setBounds(488, 369, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uC88C\uC11D");
		lblNewLabel_7.setBounds(677, 369, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\uAE08\uC561");
		lblNewLabel_8.setBounds(766, 369, 57, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("\uC5F4\uCC28\uBA85");
		lblNewLabel_9.setBounds(245, 369, 57, 15);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("\uCD9C\uBC1C \uC2DC\uAC04");
		lblNewLabel_10.setBounds(400, 369, 57, 15);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("\uB3C4\uCC29 \uC2DC\uAC04");
		lblNewLabel_11.setBounds(580, 369, 57, 15);
		contentPane.add(lblNewLabel_11);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uC608\uC57D\uD558\uAE30");
		chckbxNewCheckBox.setBounds(22, 396, 88, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("\uC5ED \uAC80\uC0C9");
		btnNewButton_1.setBounds(446, 84, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(115, 396, 708, 24);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(115, 425, 708, 24);
		contentPane.add(textArea_1);
		
		JCheckBox checkBox = new JCheckBox("\uC608\uC57D\uD558\uAE30");
		checkBox.setBounds(22, 425, 88, 23);
		contentPane.add(checkBox);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(115, 454, 708, 24);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(115, 482, 708, 24);
		contentPane.add(textArea_3);
		
		JCheckBox checkBox_1 = new JCheckBox("\uC608\uC57D\uD558\uAE30");
		checkBox_1.setBounds(22, 454, 88, 23);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("\uC608\uC57D\uD558\uAE30");
		checkBox_2.setBounds(22, 482, 88, 23);
		contentPane.add(checkBox_2);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(115, 509, 708, 24);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(115, 538, 708, 24);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(115, 567, 708, 24);
		contentPane.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(115, 595, 708, 24);
		contentPane.add(textArea_7);
		
		JCheckBox checkBox_3 = new JCheckBox("\uC608\uC57D\uD558\uAE30");
		checkBox_3.setBounds(22, 509, 88, 23);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("\uC608\uC57D\uD558\uAE30");
		checkBox_4.setBounds(22, 538, 88, 23);
		contentPane.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("\uC608\uC57D\uD558\uAE30");
		checkBox_5.setBounds(22, 567, 88, 23);
		contentPane.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("\uC608\uC57D\uD558\uAE30");
		checkBox_6.setBounds(22, 595, 88, 23);
		contentPane.add(checkBox_6);
	}
}
