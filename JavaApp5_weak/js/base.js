//================ 전역변수
var com = new Array(3);
var user = new Array(3);
var r; //rand
var count;
var start;
//================ 초기값
//================


function enterTF() {
	if (event.keyCode == 13) {
		document.getElementById("ta").value = document.getElementById("tf_input").value;
		var str = document.getElementById("tf_input").value;
		alert(str);

		if (!str.match("[0-9]{3}")) { //세자리 숫자가 아니라면!!
			alert("세자리 숫자만 입력!!");
		}

		for (var i = 0; i < user.length; i++) {
			user[i] = str.charAt(i);
		}

		if (duplicateCheck(user)) { //중복된 수 발견!!
			alert('같은 수는 입력 불가!!');
			return;
		}
		var strike = 0;
		var ball = 0;
		//비교(컴퓨터가 발생시킨 난수(int[]) - 사용자가 입력한 수(int[]))
		for (var i = 0; i < com.length; i++) { //com배열 인덱스    i= 0 1 2
			//3번 반복
			for (var j = 0; j < user.length; j++) { //user배열 인덱스 j= 0 1 2
				//3번 반복
				//예)com--> 329     user--> 539
				console.log("▶"+com[i]+" : "+ user[j])
				if (com[i] == user[j]) { //숫자값이 일치했을때
					//일치하는 수를 찾기!! ----> strike 또는 ball 후보!!
					if (i == j){ //숫자일치, 자리위치(번지수)가 일치했을때
						strike++;
						}
					else { //숫자일치, 자리위치가 달랐을때
						ball++;
					}
				}
			} //안쪽for
		} //바깥쪽for

		//비교결과를 화면(JTextArea)에 출력!!
		//346 ▶ 1Strike 1Ball
		count++;

		if (strike == 3) {
			document.getElementById("ta").value += '\n♥축하합니다♥ 정답["+str+"]을 맞추셨습니다^^*\n';
			exitGame();
		} else {
			document.getElementById("ta").value += '\n'+count + ' : ' + str + ' ▶ ' + strike + 'Strike ' + ball + 'Ball\n';
		}
		document.getElementById("tf_input").value = '';
	}
}
function soution_B() {
	document.getElementById("ta").value += '▣ 정답은 [' + com[0] + com[1] + com[2] + ']입니다.\n';
	exitGame();
}
function hint_B() {
	alert('힌트 수==> ' + com[Math.floor((Math.random() * 3))]);
	document.getElementById("hintB").setAttribute("disabled", "disabled");
}
function ruleDescription() {
	document.getElementById("ta").value = '\n\n\t<숫자야구게임>';
	document.getElementById("ta").value += '\n1. 게임시작을 위해서 새게임버튼을 클릭';
	document.getElementById("ta").value += '\n2. 입력에 중복되지않는 세자리수를 입력 후 엔터';
	document.getElementById("ta").value += '\n3. 숫자와 자릿수를  맞추면 Strike 숫자만 맞추면 Ball이 추가됩니다.';
	document.getElementById("ta").value += '\n4. 정답을 보고 싶으면 정답버튼을 클릭';
	document.getElementById("ta").value += '\n5. 기타 문의사항이 있으면 관리자에게 연락바람 (070-5039-5815)';
} //ruleDescription

function showMsg(msg) {
	alert(msg);
} //showMsg

function initText() { //TextField와 TextArea초기화(지우기)
	document.getElementById("ta").value = '';
	document.getElementById("tf_input").value = '';
	document.getElementById("tf_input").value = '';
} //initText

function initGame() { //게임초기화(게임시작)	
	start = true;

	//		document.getElementById("tf_input").setAttribute("disabled","disabled");//false
	document.getElementById('tf_input').removeAttribute("disabled");

	document.getElementById("solutionB").removeAttribute("disabled"); //ture
	document.getElementById("hintB").removeAttribute("disabled");

	count = 0;

	initText();
} //initGame

function exitGame() { //한 게임 종료
	start = false;

	document.getElementById("tf_input").setAttribute("disabled", "disabled");
	document.getElementById("solutionB").setAttribute("disabled", "disabled");
	document.getElementById("hintB").setAttribute("disabled", "disabled");

	count = 0;
} //exitGame


function createNum() {
	com[0] = Math.floor((Math.random() * 9) + 1); //0~9
	do {
		com[1] = Math.floor((Math.random() * 9) + 1);
	} while (com[1] == com[0]); //중복된 수가 발생한다면

	do {
		com[2] = Math.floor((Math.random() * 9) + 1);
	} while (com[2] == com[1] || com[2] == com[0]);
} //createNum

function duplicateCheck(su) {
	for (var i = 0; i < su.length - 1; i++) {
		for (var j = i + 1; j < su.length; j++) {
			//  i=0    i=1    i=2
			//j=1,2    j=2    j=X
			if (su[i] == su[j]) {
				return true;
			}
		}
	} //바깥for
	return false;
} //duplicateCheck


function validCheck(str) { //유효성 검사	  
	if (str.length() != 3) return false;
	for (var i = 0; i < str.length(); i++) {
		var ch = str.charAt(i); //'0'~'9'
		if (ch < '0' || ch > '9') return false;
	}
	return true;
}