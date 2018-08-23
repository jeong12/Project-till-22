package com.bitcamp.project.khj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ForthView extends JFrame {

	private JPanel contentPane;
	ArrayList<String> count;
	FirstDTO fdto;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForthView frame = new ForthView();
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
	 * @param fdto 
	 * @param count 
	 */
	public ForthView(FirstDTO fdto, ArrayList<String> count) {
		this.fdto=fdto;
		this.count=count;
		this.setTitle("시작은 작은 '경부선'이지만, 차근차근 한반도 구석까지 넓혀가겠습니다 :)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC608\uB9E4 \uB0B4\uC5ED \uCD9C\uB825\uD558\uAE30");
		lblNewLabel.setBounds(141, 23, 122, 15);
		contentPane.add(lblNewLabel);
		
		long time=System.currentTimeMillis();
		System.out.println(time);
		
		
		ArrayList<String> arr=count;
		int size=arr.size();
		
		String n="";
		
		for(int i=0;i<size;i++) {
		n=""+n.concat(","+arr.get(i));
		}
		System.out.println(n);
		
			
		
		int p=Integer.parseInt(fdto.getPerson().substring(0, 1));
		int fee=Integer.parseInt(fdto.getFair())*p;
		String fe=String.valueOf(fee);
		String text="열차번호: "+fdto.getTnumber()+"\t열차명: "+fdto.getTname()+"\n출발역: "+fdto.getDs()+"\t 출발시간: "+fdto.getDs()
		+"\n도착역: "+fdto.getAs()+"\t도착시간: "+fdto.getAtime()+"\n좌석: "+n+"\t금액: "+fe;
		

		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 50, 398, 92);
		textArea.append(text);
		contentPane.add(textArea);
		
		JButton btn_print = new JButton("\uCD9C\uB825");
		btn_print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String content=text;
				String filename="d://test//reseved train_"+time+".txt";
				FileWriter fw = null;
				File file=new File(filename);
				try {
					fw=new FileWriter(filename);
					fw.write(content);
					fw.flush();//
				} catch (IOException e) {
					System.out.println(e);
				}finally {
					if(fw!=null) try {}catch(Exception e) {}
				}
				
				if(file.exists()) {
					JOptionPane.showMessageDialog(contentPane, "출력을 성공하였습니다.\n d드라이브를 확인해주세요\n 파일명은 'reseved train_숫자.txt'입니다", "출력성공!",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "출력을 실패했습니다", "출력실패!",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		btn_print.setBounds(325, 217, 97, 23);
		contentPane.add(btn_print);
	}

}
