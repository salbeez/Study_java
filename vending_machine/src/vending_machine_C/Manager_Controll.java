package vending_machine_C;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager_Controll implements ActionListener{
	
	Controll_Admin con;
	public Manager_Controll() {
		con = new Controll_Admin();
		con.admin_view.setVisible(true);
		con.admin_view.bt_re.addActionListener(this);
	}

	public static void main(String[] args) {
		new Manager_Controll();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==con.admin_view.bt_re){
			System.out.println("메인 컨트롤 에서 적용");
			con.admin_view.setVisible(false);
			con.farm_view.setVisible(true);
		}
	}
}
