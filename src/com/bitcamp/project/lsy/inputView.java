package com.bitcamp.project.lsy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class inputView extends JFrame implements ActionListener {
	String id = "";

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
	
	public inputView(	/*DefaultTableModel model*/ ) {
		indexa ina = new indexa();
		indexb inb = new indexb();
		indexi ini = new indexi();
		
	
		
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
		
		// 입력 하기
		JButton inputButton = new JButton("입력");
		inputButton.setBounds(30, 326, 394, 55);
		getContentPane().add(inputButton);
		
		JButton mainButton = new JButton("메인으로");
		mainButton.setBounds(30, 432, 394, 60);
		getContentPane().add(mainButton);
		mainButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainView in = new mainView(id);
				in.setVisible(true);
			}
		});
		
		JComboBox morBox1 = new JComboBox(ina.getListoba());
		morBox1.setBounds(82, 30, 82, 21);
		calDTO dto = new calDTO();
		getContentPane().add(morBox1);
		
		JComboBox morBox2 = new JComboBox();
		morBox2.setBounds(200, 30, 82, 21);
		getContentPane().add(morBox2);
		
		JComboBox morBox3 = new JComboBox();
		morBox3.setBounds(322, 30, 82, 21);
		getContentPane().add(morBox3);
		
		
		morBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("state changed!!");
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
		
		morBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String bname = (String)cb.getSelectedItem();
				dto.setBname(bname);
				
				morBox3.removeAllItems();
				String[] subList2 = ini.getListitemi(bname);
				for (String subItem2 : subList2) {
					morBox3.addItem(subItem2);
				}
			}
		});
		
		
		
		JComboBox lunBox1 = new JComboBox(ina.getListoba());
		lunBox1.setBounds(82, 86, 82, 21);
		getContentPane().add(lunBox1);
		
		JComboBox lunBox2 = new JComboBox();
		lunBox2.setBounds(200, 86, 82, 21);
		getContentPane().add(lunBox2);
		
		JComboBox lunBox3 = new JComboBox();
		lunBox3.setBounds(322, 86, 82, 21);
		getContentPane().add(lunBox3);
		
		
		
		lunBox1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            
	        	JComboBox cb = (JComboBox) e.getSource();
	        	String aname = (String)cb.getSelectedItem();
	        	 dto.setAname(aname);
	        	 
	        	 lunBox2.removeAllItems();
	        	 String[] subList = inb.getListobb(aname);
	        	 for (String subItem : subList) {
	        		 lunBox2.addItem(subItem);
	        	 }
	         }
	      });
		
		lunBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String bname = (String)cb.getSelectedItem();
				dto.setBname(bname);
				
				lunBox3.removeAllItems();
				String[] subList2 = ini.getListitemi(bname);
				for (String subItem2 : subList2) {
					lunBox3.addItem(subItem2);
				}
			}
		});
		
		
		
		JComboBox diBox1 = new JComboBox(ina.getListoba());
		diBox1.setBounds(82, 142, 82, 21);
		getContentPane().add(diBox1);
		
		JComboBox diBox2 = new JComboBox();
		diBox2.setBounds(200, 142, 82, 21);
		getContentPane().add(diBox2);
		
		JComboBox diBox3 = new JComboBox();
		diBox3.setBounds(322, 142, 82, 21);
		getContentPane().add(diBox3);
		
		diBox1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            
	        	JComboBox cb = (JComboBox) e.getSource();
	        	String aname = (String)cb.getSelectedItem();
	        	 dto.setAname(aname);
	        	 
	        	 diBox2.removeAllItems();
	        	 String[] subList = inb.getListobb(aname);
	        	 for (String subItem : subList) {
	        		 diBox2.addItem(subItem);
	        	 }
	         }
	      });
		
		diBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String bname = (String)cb.getSelectedItem();
				dto.setBname(bname);
				
				diBox3.removeAllItems();
				String[] subList2 = ini.getListitemi(bname);
				for (String subItem2 : subList2) {
					diBox3.addItem(subItem2);
				}
			}
		});
		
		
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
		
		
		
		foodBox1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            
	        	JComboBox cb = (JComboBox) e.getSource();
	        	String aname = (String)cb.getSelectedItem();
	        	 dto.setAname(aname);
	        	 
	        	 foodBox2.removeAllItems();
	        	 String[] subList = inb.getListobb(aname);
	        	 for (String subItem : subList) {
	        		 foodBox2.addItem(subItem);
	        	 }
	         }
	      });
		
		foodBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				String bname = (String)cb.getSelectedItem();
				dto.setBname(bname);
				
				foodBox3.removeAllItems();
				String[] subList2 = ini.getListitemi(bname);
				for (String subItem2 : subList2) {
					foodBox3.addItem(subItem2);
				}
			}
		});
		
		inputButton.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(morBox3.getSelectedItem()!=null) {
				inputDTO dto = new inputDTO();
				dto.setInid(id);
				dto.setInmeal((String)morBox3.getSelectedItem());
				
				
				inputDAO dao = new inputDAO();
				dao.InsertData(dto);
				}
				
				if(lunBox3.getSelectedItem()!=null) {
					inputDTO dto = new inputDTO();
					dto.setInid(id);
					dto.setInmeal((String)lunBox3.getSelectedItem());
					
					
					inputDAO dao = new inputDAO();
					dao.InsertData(dto);
					}
				
				if(diBox3.getSelectedItem()!=null) {
					inputDTO dto = new inputDTO();
					dto.setInid(id);
					dto.setInmeal((String)diBox3.getSelectedItem());
					
					
					inputDAO dao = new inputDAO();
					dao.InsertData(dto);
					}
				
				if(foodBox3.getSelectedItem()!=null) {
					inputDTO dto = new inputDTO();
					dto.setInid(id);
					dto.setInmeal((String)foodBox3.getSelectedItem());
					
					
					inputDAO dao = new inputDAO();
					dao.InsertData(dto);
					
					}
				
				
			}
		});
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		inputView frame = new inputView();
		frame.setVisible(true);
	}
}
