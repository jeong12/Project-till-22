package com.bitcamp.project.lsy;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class mainView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView frame = new mainView();
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
	public mainView() {
		bodydata data = new bodydata();
		String body = data.getData();
		DefaultTableModel model = new DefaultTableModel(new Object[] {"품목","칼로리"}, 0);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton inputCalButton = new JButton("칼로리 입력");
		inputCalButton.setBounds(35, 496, 105, 60);
		contentPane.add(inputCalButton);
		inputCalButton.addActionListener(new inputView(/*model*/));
		inputCalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		
		JButton outputCalButton = new JButton("지난 칼로리");
		outputCalButton.setBounds(319, 496, 105, 60);
		contentPane.add(outputCalButton);
		outputCalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 40, 389, 147);
		contentPane.add(textArea);
		outputCalButton.addActionListener(new outputView());
		textArea.setText(body);
		
		
		
		JTable table = new JTable(model);// model이 table안에 있어야 함 꼭
		JScrollPane scrollPane = new JScrollPane(table); // 테이블을 감싸고 있어야 함
		scrollPane.setBounds(35, 238, 395, 226);
		contentPane.add(scrollPane);
		
		
		bodyDAO dao = new bodyDAO();
		List<calDTO> list = dao.getdayitemList();
		
		for(int i=0; i<list.size(); i++) {
			
			model.addRow(new Object[] {list.get(i).getIname(),list.get(i).getKcal()});// 한 행식 추가
			
		}
		
		
		
	}
}
