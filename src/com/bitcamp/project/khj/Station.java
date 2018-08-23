package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		FirstCal fc=new FirstCal();
		List<String> sta=fc.getStation();
		int size=sta.size();
		String[] station=new String[size];
		for(int i=0;i<size;i++) {
			station[i]=sta.get(i);
		}
	
		
		
		
		
	}

}
