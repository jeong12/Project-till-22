package com.bitcamp.project.khj;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Delview extends JFrame {

	private JPanel contentPane;
	private FirstDTO fdto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delview frame = new Delview();
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
	public Delview() {
		FirstDAO fdao=new FirstDAO(fdto);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC608\uC57D\uB0B4\uC5ED \uC911 \uC0AD\uC81C\uD558\uC2E4 \uB0B4\uC5ED\uC744 \uC120\uD0DD\uD558\uC138\uC694.");
		lblNewLabel.setBounds(343, 36, 238, 15);
		contentPane.add(lblNewLabel);
		
		JButton btn_del = new JButton("\uC0AD\uC81C\uD558\uAE30");
		btn_del.setBounds(875, 428, 97, 23);
		contentPane.add(btn_del);
				
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(131, 121, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(211, 121, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(293, 121, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(373, 121, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(459, 121, 57, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(539, 121, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(618, 121, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(708, 121, 57, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(801, 121, 57, 15);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(886, 121, 57, 15);
		contentPane.add(lblNewLabel_10);
		
		List<String> arr=fdao.getRev();
		
		int size=arr.size();
		String[]rsv=new String[size];
		String[]tnumber=new String[size];
		String[]tname=new String[size];
		String[]dsname=new String[size];
		String[]dtime=new String[size];
		String[]asname=new String[size];
		String[]atime=new String[size];
		String[]fair=new String[size];
		String[]seat=new String[size];
		String[]date=new String[size];
		
		int r=0;
		for(int i=0;i<arr.size();i++) {
			String s=arr.get(i);
			String[]ar=s.split(",");
			rsv[i]=ar[0];
			tnumber[i]=ar[1];
			tname[i]=ar[2];
			dsname[i]=ar[3];
			dtime[i]=ar[4];
			asname[i]=ar[5];
			atime[i]=ar[6];
			fair[i]=ar[7];
			seat[i]=ar[8];
			date[i]=ar[9];
		}
		
		int y=117;
		for(int j=0;j<rsv.length;j++) {
		JCheckBox chckbxNewCheckBox = new JCheckBox(rsv[j]);
		chckbxNewCheckBox.setBounds(8, y, 115, 23);
		contentPane.add(chckbxNewCheckBox);
		y+=21;
		} //checkbox 생성까지 만듬. selected된거 구할 차례.
		
		
	}
}
