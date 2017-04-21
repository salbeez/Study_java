package memoryGame.C;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import memoryGame.M.GameMethod;
import memoryGame.V.MainView;

public class ManagerC implements ActionListener{
	MainView view;
	GameMethod method;
	Timer t;
	int time;
	private int stage;
	
	public ManagerC() {
		init();
		setting();
		eventUp();
	}

	private void init() {
		view = new MainView();
		method = new GameMethod();
		t=new Timer(1000, this);
	}

	private void setting() {

	}
	private void eventUp(){
		view.bt_start.addActionListener(this);
	}

	public static void main(String[] args) {
		new ManagerC();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == view.bt_start){//Start Games
			stage=1;
			time=method.setTime(stage);
			t.start();
			view.drawCards(method.createCard(stage));//카드 그려주고
			
			view.bt_start.setEnabled(false);
		}else if(obj == t){
			view.la_time.setText("제한시간 : "+time);
			time--;
			if(time<=0){
				t.stop();
				view.la_time.setText("제한시간 끝");
				view.bt_start.setEnabled(true);
			}	
		}
	}
}
