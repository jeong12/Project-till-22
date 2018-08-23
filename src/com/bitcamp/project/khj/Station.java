package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.bitcamp.project.kms.main2;
import javax.swing.JScrollBar;

public class Station extends JFrame {

	private JPanel contentPane;
	private FirstDTO fdto;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(fdto) {
			public void run() {
				try {
					Station frame = new Station();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param fdto2 
	 */
	public Station(FirstDTO fdto) {
		this.fdto=fdto;
		this.setTitle("그냥 나가면 프로그램이 꺼집니다. 꼭 아래있는 돌아가기를 눌러주세요");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		FirstCal fc=new FirstCal();
		List<String> sta=fc.getStation();
		int size=sta.size();
		String[] station=new String[size];
		for(int i=0;i<size;i++) {
			station[i]=sta.get(i);
		}
		
		JList list = new JList(station);
		list.setBounds(22, 21, 529, 339);
		contentPane.add(list);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(22, 21, 529, 339);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("\uC608\uC57D\uD654\uBA74\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(12, 378, 560, 23);
		contentPane.add(btnNewButton);
		
		
		
		
	}
	}


