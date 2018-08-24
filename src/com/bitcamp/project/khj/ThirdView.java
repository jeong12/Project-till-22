package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bitcamp.project.kms.main2;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ThirdView extends JFrame {

	private JPanel contentPane;
	FirstDTO fdto;
	FirstDAO fdao;
	ArrayList<String> count;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThirdView frame = new ThirdView(fdto);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 * @param seat 
	 */
	public ThirdView(FirstDTO fdto, ArrayList<String> count) {
		this.count=count;
		this.fdto=fdto;
		fdao = new FirstDAO(fdto);
		this.setTitle("시작은 작은 '경부선'이지만, 차근차근 한반도 구석까지 넓혀가겠습니다 :)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		JLabel lblNewLabel = new JLabel("\uC120\uD0DD \uB0B4\uC6A9 \uD655\uC778");
		lblNewLabel.setBounds(27, 13, 371, 15);
		contentPane.add(lblNewLabel);
		
				
		JLabel label_tnumber = new JLabel("\uC5F4\uCC28\uBC88\uD638");
		label_tnumber.setBounds(65, 75, 57, 15);
		contentPane.add(label_tnumber);
		
		JLabel label_1= new JLabel(fdto.getTnumber());
		label_1.setBounds(65, 121, 97, 15);
		contentPane.add(label_1);
		
		JLabel label_tname = new JLabel("\uC5F4\uCC28\uBA85");
		label_tname.setBounds(208, 75, 57, 15);
		contentPane.add(label_tname);
		
		JLabel label_2= new JLabel(fdto.getTname());
		label_2.setBounds(200, 121, 97, 15);
		contentPane.add(label_2);
		
		JLabel label_dsname = new JLabel("\uCD9C\uBC1C\uC5ED");
		label_dsname.setBounds(344, 75, 57, 15);
		contentPane.add(label_dsname);
		
		JLabel label_3= new JLabel(fdto.getDs());
		label_3.setBounds(340, 121, 97, 15);
		contentPane.add(label_3);
		
		JLabel label_dtime = new JLabel("\uCD9C\uBC1C\uC2DC\uAC04");
		label_dtime.setBounds(481, 75, 57, 15);
		contentPane.add(label_dtime);
		
		JLabel label_4= new JLabel(fdto.getDtime());
		label_4.setBounds(480, 121, 97, 15);
		contentPane.add(label_4);		
		
		JLabel label_asname = new JLabel("\uB3C4\uCC29\uC5ED");
		label_asname.setBounds(65, 176, 57, 15);
		contentPane.add(label_asname);
		
		JLabel label_5= new JLabel(fdto.getAs());
		label_5.setBounds(65, 228, 97, 15);
		contentPane.add(label_5);
		
		JLabel label_atime = new JLabel("\uB3C4\uCC29\uC2DC\uAC04");
		label_atime.setBounds(208, 176, 65, 15);
		contentPane.add(label_atime);
		
		JLabel label_6= new JLabel(fdto.getAtime());
		label_6.setBounds(200, 228, 97, 15);
		contentPane.add(label_6);
		
		JLabel label_seat = new JLabel("\uC88C\uC11D");
		label_seat.setBounds(341, 176, 57, 15);
		contentPane.add(label_seat);
		
		int x=340;
		for(int c=0;c<count.size();c++) {
		JLabel label_7= new JLabel(count.get(c));
		label_7.setBounds(x, 228, 97, 15);
		contentPane.add(label_7);
		x+=20;
		}
		JLabel label_fair = new JLabel("\uAE08\uC561");
		label_fair.setBounds(65, 280, 65, 15);
		contentPane.add(label_fair);
		
		
		int p=Integer.parseInt(fdto.getPerson().substring(0, 1));
		int fee=Integer.parseInt(fdto.getFair())*p;
		System.out.println(fee);
		String fe=String.valueOf(fee);
		JLabel label_8= new JLabel(fe);
		label_8.setBounds(65, 310, 100, 15);
		contentPane.add(label_8);
		
		JButton bnt_back = new JButton("\uB3CC\uC544\uAC00\uAE30");
		bnt_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FirstView sv=new FirstView(fdto.getMid());
				sv.setVisible(true);
				dispose();
			}
		});
		bnt_back.setBounds(12, 378, 97, 23);
		contentPane.add(bnt_back);
		
		JButton btnNewButton = new JButton("\uC608\uC57D\uD558\uAE30");
		btnNewButton.setBounds(463, 365, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r=fdao.goReserve(fdto,count);
				if(r>0) {
					JOptionPane.showMessageDialog(contentPane, "예약를 성공했습니다", "예약성공!",JOptionPane.PLAIN_MESSAGE);
					int answer=JOptionPane.showInternalConfirmDialog(contentPane, "예약내역을 출력하시겠습니까?", "출력창으로",JOptionPane.PLAIN_MESSAGE,JOptionPane.YES_NO_CANCEL_OPTION);
					if(answer==0) {
						ForthView fv=new ForthView(fdto,count); 
						fv.setVisible(true);
						dispose();
					}
					else {
						dispose(); //
					}
					
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "예약를 실패했습니다", "예약실패!",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btn_tm = new JButton("\uBA54\uC778\uD654\uBA74\uC73C\uB85C");
		btn_tm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main2 main=new main2(fdto.getMid());
				main.setVisible(true);
				dispose();
			}
		});
		btn_tm.setBounds(446, 9, 131, 23);
		contentPane.add(btn_tm);
	}

}
