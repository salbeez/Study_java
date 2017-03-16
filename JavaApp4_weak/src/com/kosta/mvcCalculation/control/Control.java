package com.kosta.mvcCalculation.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kosta.mvcCalculation.model.Model;
import com.kosta.mvcCalculation.view.View;

/**
 * @author ksota ��ü ���α׷� ���� ���� ���� ���޵� ��û�� �м��ؼ� �˸��� �޼ҵ带 ȣ��.
 */
//  <��Ʈ�ѷ��� ����> : ���α׷� ��ü���� �帧����
// 	1. ������� ��û(�䱸) ���� �м� [��ư 1�� Ŭ���ߴ��� , ��ư2�� Ŭ���ߴ��� ...]  obj==bt or bt2
//	2. ������� �Է��� �����͸� �����°� [] �Ǵ�.... ���⿡ choice�� ���� �ɵ�...
//	3. �� Ŭ���� ��ü ����
//		=> �޼ҵ� ȣ��0
//		=> ������� ����
//	4. �̵��� ������(Frame)�� ����(������ �̵� ����)
//	5. ��ȿ�� �˻�[�߰� �ɼ�] ex) ����ڰ� �Է��� �����Ͱ� �ùٸ� ������ ��ܿ����� �Ҽ� ����
//	6. ���� or ����
public class Control implements ActionListener{
	View view;
	
	public Control() {
		view = new View();
		eventUp();
	}


	private void eventUp(){//������
		view.bt_calc.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//�䱸 �м�
		Object obj =  e.getSource();		
		if(obj ==view.bt_calc){
			int su1 = Integer.parseInt(view.tf_su1.getText()); //2.
			int su2 =Integer.parseInt(view.tf_su2.getText());
			String oper = (String)view.combo_oper.getSelectedItem();
			
			Model model = new Model(su1, su2, oper);//3
				String result = model.getResult();//3-1, 3-2
				
			view.la_result.setText(result);	//4
				
		}
	}
	
	public static void main(String[] args) {
		new Control();
	}
}
