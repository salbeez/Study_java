package com.kosta.j0316;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class JTableTest extends JFrame{
	
	JTable table;
	TableModel dataModel;
	JScrollPane scroll;
	DefaultTableModel tableModel;
	
	public JTableTest() {
		
			
		String row[][] ={
								{"홍길동","16","망나니"},
								{"김주원","30","부자"},
								{"길라임","65","탄핵된 자연인 "}
							  };
		String column[] ={"이름","나이","직업"};
		
		tableModel = new DefaultTableModel(row,column);
		table = new JTable(tableModel);
		
		scroll = new JScrollPane(table);// scroll <- table <- tableModel
		
		
		System.out.println(table.getValueAt(2, 0)+"\n");//길라임의 이름을 출력
		
		table.setValueAt("차라임", 2, 0);//길라임을 차라임으로 변경후 출력
		for(int i=0; i<table.getRowCount();i++){
			System.out.println(table.getValueAt(i, 0));//테이블 내의 모든 사람을 출력ㄴ			
		}
		//추가 !! ["김유신",]
		Object obj[] = {"김유신",13,"화랑"};
		tableModel.addRow(obj);
		
		tableModel.removeRow(3);
		
		//차라임의 행을 삭제
		for(int i=0; i<table.getRowCount();i++){
			if(table.getValueAt(i, 0)=="차라임"){
				tableModel.removeRow(i);
			}
		}
		
		
		add(scroll);
		setVisible(true);
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTableTest();
	}
}
