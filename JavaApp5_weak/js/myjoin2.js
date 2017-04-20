
var joinform = document.form;
var flag;
var passwordRules = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;

function validCheck() {
	//유효성 검사
	//적합한 데이터 :페이지 이동
	/*
	 * 유효성 검사
	 * ID,PW,NAME,주민번호에 대한 체크
	 * -> 빈값일 때 입력 메시지(alert)
	 * 
	 * 비번과 비번확인 일치 체크
	 * 주민 번호의 숫자값 체크 및 자릿수 체크
	 * 직업을 선택했는지 체크*/
	if(idCh() && nameCh() && pwCh() && ssnCh() && jobCh()){
		if(pwCheck()){
			return true;//submit 실행
		}
	}
	return false;
	
//아닐경우 페이지 이동
}

function pwCheck() {
	if(form.pass.value ===form.pass2.value){	
		if(passwordRules .test(form.pass.value)){
			return true;			
		}else{
			alert("최소 1개의 숫자,문자, 특수 문자를 포함 [8~16자리]")
			return false;
		}
	}
	alert("비번과 비번확인이 서로 맞지 않습니다")
	return false;
}

function jobCh(){
	if(form.jobs.value =='옵션'){
		alert("직업을 선택하시오");
		return false;
	}else{
		return true;
	}
	
}

function pwCh(){
	if(form.pass.value.length>0 && form.pass2.value.length>0){
		return true;
	}
	console.log(form.pass.value.length + "  "+ form.pass2.value.length)
	alert("비번 과 비번확인을 쓰시오")
	return false;
}
function idCh() {
	if (form.id.value.length > 0) {
		return true;
	}
	alert("ID를 작성하시오")
	return false
}
function nameCh() {
	if (form.name.value.length > 0) {
		return true;
	}
	alert("이름을 작성하시오")
	return false
}
function ssnCh() {
	if (form.ssn.value.match("[0-9]{6}")) {
		if (form.ssn2.value.match("[0-9]{7}")) {
			return true;
		}
	}
	alert("주민번호를 다시 작성하시오")
	return false
}

function init(){
	form.id.value = '';
	form.pass.value = '';
	form.pass2.value = '';
	form.name.value = '';
	form.ssn.value = '';
	form.ssn2.value = '';
	form.tel.value = '';
	form.tel2.value = '';
	form.tel3.value = '';
	form.addr.value = '';
}
function movejumin(){
	if(form.ssn.value.length ==6){
		form.ssn2.focus();
	}
}