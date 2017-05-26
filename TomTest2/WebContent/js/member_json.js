//클래스 정의 생성자
//클래스 이름  = 생성자
Member = function() {
	alert("생성자");
}
//호출 방법 : new Member()


Member = function(name, age, job) {
	alert("생성자2");
	this.name = name;
	this.age = age;
	this.job = job;
}
//호출 방법 :  new Member("홍길동",13,"학생");

//prototype 나오면 클래스에 메소드 정의 한다고 생각
//Member클래스의 메소드 정의

Member.prototype = {
		toString : function() {return "[이름 : " + this.name + ", 나이 : " + this.age + ", 직업 : " + this.job+"]";},
		setName : function(name){this.name = name;},
		setAge : function(age){this.age = age;},
		setJob : function(job){this.job = job;}
};
