package com.bitcamp.project.lsy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class inputView extends JFrame implements ActionListener {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inputView frame = new inputView();
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
	
	public inputView() {
		indexa ina = new indexa();
		indexb inb = new indexb();
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 600);
		getContentPane().setLayout(null);
		
		JLabel morningLabel = new JLabel("아침");
		morningLabel.setBounds(30, 30, 40, 21);
		getContentPane().add(morningLabel);
		
		JLabel lunchLabel = new JLabel("점심");
		lunchLabel.setBounds(30, 86, 40, 21);
		getContentPane().add(lunchLabel);
		
		JLabel dinnerLabel = new JLabel("저녁");
		dinnerLabel.setBounds(30, 142, 40, 21);
		getContentPane().add(dinnerLabel);
		
		JLabel foodLabel = new JLabel("간식");
		foodLabel.setBounds(30, 198, 40, 21);
		getContentPane().add(foodLabel);
		
		JButton inputButton = new JButton("입력");
		inputButton.setBounds(30, 326, 394, 55);
		getContentPane().add(inputButton);
		inputButton.addActionListener(new saveDTO());
		
		JButton deleteButton = new JButton("초기화");
		deleteButton.setBounds(30, 432, 102, 60);
		getContentPane().add(deleteButton);
		
		JButton mainButton = new JButton("메인으로");
		mainButton.setBounds(322, 432, 102, 60);
		getContentPane().add(mainButton);
		
		JComboBox morBox1 = new JComboBox(ina.getListoba());
		morBox1.setBounds(82, 30, 82, 21);
		calDTO dto = new calDTO();
		
		JComboBox morBox2 = new JComboBox();
		morBox2.setBounds(200, 30, 82, 21);
		getContentPane().add(morBox2);
		
		morBox1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            
	        	JComboBox cb = (JComboBox) e.getSource();
	        	String aname = (String)cb.getSelectedItem();
	        	 dto.setAname(aname);
	        	 
	        	 morBox2.removeAllItems();
	        	 String[] subList = inb.getListobb(aname);
	        	 for (String subItem : subList) {
	        		 morBox2.addItem(subItem);
	        	 }
	         }
	      });
		
		getContentPane().add(morBox1);
		
		
		
		
		
		JComboBox morBox3 = new JComboBox();
		morBox3.setBounds(322, 30, 82, 21);
		getContentPane().add(morBox3);
		
		JComboBox lunBox1 = new JComboBox(ina.getListoba());
		lunBox1.setBounds(82, 86, 82, 21);
		getContentPane().add(lunBox1);
		
		JComboBox lunBox2 = new JComboBox();
		lunBox2.setBounds(200, 86, 82, 21);
		getContentPane().add(lunBox2);
		
		JComboBox lunBox3 = new JComboBox();
		lunBox3.setBounds(322, 86, 82, 21);
		getContentPane().add(lunBox3);
		
		JComboBox diBox1 = new JComboBox(ina.getListoba());
		diBox1.setBounds(82, 142, 82, 21);
		getContentPane().add(diBox1);
		
		JComboBox diBox2 = new JComboBox();
		diBox2.setBounds(200, 142, 82, 21);
		getContentPane().add(diBox2);
		
		JComboBox diBox3 = new JComboBox();
		diBox3.setBounds(322, 142, 82, 21);
		getContentPane().add(diBox3);
		
		JComboBox foodBox1 = new JComboBox(ina.getListoba());
		foodBox1.setBounds(82, 198, 82, 21);
		getContentPane().add(foodBox1);
		
		JComboBox foodBox2 = new JComboBox();
		foodBox2.setBounds(200, 198, 82, 21);
		getContentPane().add(foodBox2);
		
		JComboBox foodBox3 = new JComboBox();
		foodBox3.setBounds(322, 198, 82, 21);
		getContentPane().add(foodBox3);
		mainButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}
	
		
//		calDAO da = new calDAO();
//		calDTO dt = new calDTO();
		
		//
//		List<calDTO>arr = da.getList();
		
//		String[]aname=new String[arr.size()]; 
//		for(int i=0;i<arr.size();i++) {
//			aname[i]=arr.get(i).acode;
//		}
//		
//		for(String r:aname) {
//			System.out.println(r);
//		}
//		
//		Iterator<calDTO> itr = arr.iterator();
//		for(int i=0; i<arr.size(); i++) {
//			morBox1.addItem(itr.next().aname);
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		inputView frame = new inputView();
		frame.setVisible(true);
	}
}
