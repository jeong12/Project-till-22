package com.bitcamp.project.kyr.screen;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bitcamp.project.kms.MemberDTO;
import com.bitcamp.project.kyr.screenDTO;
import com.bitcamp.project.kyr.DAO.booklist;
import com.bitcamp.project.kyr.DAO.screenDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class rentscreen extends JFrame implements ActionListener {
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rentscreen frame = new rentscreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField bnum,number;
	/**
	 *   Launch the application.
	 */
	MemberDTO mto=new MemberDTO();

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
	screenDTO dto=new screenDTO();
	screenDAO dao=new screenDAO();
	private JTable table;
	private JLabel label;
	private JLabel label_1;
	private JButton button;
	private JButton button_1;

	/**
	 * Create the frame.
	 */
	//private String
	Connection conn=null;

	public rentscreen(int number) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		mto.setNumber(number);
		
		booklist bls=new booklist();
		Vector header=new Vector();
		header.add("책이름");
		header.add("출판사");
		header.add("출판일");
		header.add("책 번호");
		Vector data= bls.bok();

		DefaultTableModel model = new DefaultTableModel(data, header);
		contentPane.setLayout(null);

		table = new JTable(model);
		table.setBounds(1, 27, 351, 64);
		contentPane.add(table, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 5, 353, 214);
		contentPane.add(scrollPane);

		label = new JLabel("책 번호");
		label.setBounds(15, 231, 57, 15);
		contentPane.add(label);

		/*label_1 = new JLabel("회원 번호");
		label_1.setBounds(15, 261, 57, 15);
		contentPane.add(label_1);*/

		textField = new JTextField(); //책번호
		textField.setBounds(84, 229, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
/*		textField_1 = new JTextField();  //회원번호
		textField_1.setBounds(84, 255, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);*/

		button = new JButton("대여 하기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screenDTO dto=new screenDTO();
				int r=0;

				try {

					Float bm=(Float.parseFloat(textField.getText()));
					dto.setBnum(bm);
					int nm=number; //(Integer.parseInt(textField_1.getText()));
					dto.setNumber(nm);

					r=dao.rent(dto,conn,number);

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "입력을 잘못하셨거나 대여할 수 있는 책이 없습니다.");
					e1.printStackTrace();
				 }
			}
		});
		button.setBounds(231, 227, 97, 23);
		contentPane.add(button);

		button_1 = new JButton("뒤로 가기");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainscreen mai=new mainscreen(dto.getNumber());
				setVisible(false);
			}
		});
		button_1.setBounds(231, 253, 97, 23);
		contentPane.add(button_1);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}