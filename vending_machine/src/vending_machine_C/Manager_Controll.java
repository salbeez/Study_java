package vending_machine_C;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager_Controll implements ActionListener{
	
	Controll_Admin cont_Admin;
	UserController cont_User;
	
	public Manager_Controll() {
		cont_Admin = new Controll_Admin();
		cont_User = new UserController();
		
		cont_Admin.admin_view.setVisible(false);
		cont_Admin.admin_view.bt_re.addActionListener(this);
		
		cont_User.uv.setVisible(true);
		cont_User.uv.bt_admin.addActionListener(this);
	}

	public static void main(String[] args) {
		new Manager_Controll();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==cont_Admin.admin_view.bt_re){
			cont_Admin.admin_view.setVisible(false);
			
			//한개의 버튼을 2개의 리스너가 감시시 메인 리스너 먼저 실행후 다 끝나면 그다음 하위 리스너가 실행 
			cont_Admin.model.currentSellItems(cont_Admin.sellItems);
			
			cont_User.initialize();
			cont_User.uv.setVisible(true);
			
		}else if(e.getSource() ==cont_User.uv.bt_admin){
			cont_Admin.admin_view.setVisible(true);
			cont_User.uv.setVisible(false);
			
		}
	}
}
