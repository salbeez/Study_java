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
								{"ȫ�浿","16","������"},
								{"���ֿ�","30","����"},
								{"�����","65","ź�ٵ� �ڿ��� "}
							  };
		String column[] ={"�̸�","����","����"};
		
		tableModel = new DefaultTableModel(row,column);
		table = new JTable(tableModel);
		
		scroll = new JScrollPane(table);// scroll <- table <- tableModel
		
		
		System.out.println(table.getValueAt(2, 0)+"\n");//������� �̸��� ���
		
		table.setValueAt("������", 2, 0);//������� ���������� ������ ���
		for(int i=0; i<table.getRowCount();i++){
			System.out.println(table.getValueAt(i, 0));//���̺� ���� ��� ����� ��¤�			
		}
		//�߰� !! ["������",]
		Object obj[] = {"������",13,"ȭ��"};
		tableModel.addRow(obj);
		
		tableModel.removeRow(3);
		
		//�������� ���� ����
		for(int i=0; i<table.getRowCount();i++){
			if(table.getValueAt(i, 0)=="������"){
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
