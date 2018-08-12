package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;


public class FirstView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_d;
	private JTextField textField_a;
	
	public JTextField getTextField_d() {
		return textField_d;
	}

	public void setTextField_d(JTextField textField_d) {
		this.textField_d = textField_d;
	}

	public JTextField getTextField_a() {
		return textField_a;
	}

	public void setTextField_a(JTextField textField_a) {
		this.textField_a = textField_a;
	}

	DAO dao=new DAO();
	List<String> arr=dao.Cal();
	List<String> year=dao.year(arr);
	List<String> date=dao.date(arr);
	List<String> day=dao.day(arr);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstView frame = new FirstView();
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
	public FirstView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Departure Station");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_d = new JTextField();
		GridBagConstraints gbc_textField_d = new GridBagConstraints();
		gbc_textField_d.gridwidth = 3;
		gbc_textField_d.insets = new Insets(0, 0, 5, 5);
		gbc_textField_d.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_d.gridx = 4;
		gbc_textField_d.gridy = 3;
		contentPane.add(textField_d, gbc_textField_d);
		textField_d.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Find Station");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 8;
		gbc_btnNewButton_1.gridy = 3;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Arrival Station");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_a = new JTextField();
		GridBagConstraints gbc_textField_a = new GridBagConstraints();
		gbc_textField_a.gridwidth = 3;
		gbc_textField_a.insets = new Insets(0, 0, 5, 5);
		gbc_textField_a.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_a.gridx = 4;
		gbc_textField_a.gridy = 4;
		contentPane.add(textField_a, gbc_textField_a);
		textField_a.setColumns(10);
		
		JButton btnNewButton = new JButton("Find Station");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 8;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Departure Date");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox comboBox_y = new JComboBox();
		GridBagConstraints gbc_comboBox_y = new GridBagConstraints();
		gbc_comboBox_y.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_y.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_y.gridx = 4;
		gbc_comboBox_y.gridy = 5;
		contentPane.add(comboBox_y, gbc_comboBox_y);
		
		JComboBox comboBox_m = new JComboBox();
		GridBagConstraints gbc_comboBox_m = new GridBagConstraints();
		gbc_comboBox_m.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_m.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_m.gridx = 5;
		gbc_comboBox_m.gridy = 5;
		contentPane.add(comboBox_m, gbc_comboBox_m);
		
		JComboBox comboBox_d = new JComboBox();
		GridBagConstraints gbc_comboBox_d = new GridBagConstraints();
		gbc_comboBox_d.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_d.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_d.gridx = 6;
		gbc_comboBox_d.gridy = 5;
		contentPane.add(comboBox_d, gbc_comboBox_d);
		
		JLabel lblNewLabel_3 = new JLabel("Departure Time");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 6;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox comboBox_t = new JComboBox();
		GridBagConstraints gbc_comboBox_t = new GridBagConstraints();
		gbc_comboBox_t.gridwidth = 3;
		gbc_comboBox_t.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_t.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_t.gridx = 4;
		gbc_comboBox_t.gridy = 6;
		contentPane.add(comboBox_t, gbc_comboBox_t);
		
		JLabel lblNewLabel_4 = new JLabel("Personnel");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 7;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox comboBox_p = new JComboBox();
		GridBagConstraints gbc_comboBox_p = new GridBagConstraints();
		gbc_comboBox_p.gridwidth = 3;
		gbc_comboBox_p.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_p.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_p.gridx = 4;
		gbc_comboBox_p.gridy = 7;
		contentPane.add(comboBox_p, gbc_comboBox_p);
		
		JButton btnNewButton_g = new JButton("Go to Reserve");
		btnNewButton_g.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_g = new GridBagConstraints();
		gbc_btnNewButton_g.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_g.gridx = 5;
		gbc_btnNewButton_g.gridy = 8;
		contentPane.add(btnNewButton_g, gbc_btnNewButton_g);
	}

}
