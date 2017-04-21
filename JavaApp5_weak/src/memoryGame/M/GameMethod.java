package memoryGame.M;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class GameMethod {

	int cards[][];
	private int time[] = { 15, 10, 6 };// 단계값에 따른 제한 시간

	public int setTime(int stage) {
		// p.s 파라메터로 단계값이 오면 그 단계에 따른 제한시간 변경 및 시간 리턴
		if (stage == 1) {
			return time[0];
		} else if (stage == 2) {
			return time[1];
		} else {
			return time[2];
		}
	}

	// card-0-0.jpeg 1,2,3
	public int[][] createCard(int stage) {
		if (stage == 1) {
			return cards = new int[2][2];
		} else if (stage == 2) {
			return cards = new int[2][3];
		} else {
			return cards = new int[4][4];
		}
	}
}
