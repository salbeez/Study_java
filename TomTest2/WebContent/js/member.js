

//member.js

//클래스 정의(생성자)
/*Member = function(){
	
}*/
//new Member()호출

Member = function(name,age,job){	
   //멤버속성 정의 ---> this.속성 !! 
   this.name = name;
   this.age = age;
   this.job = job;
}
//new Member('홍길동',13,'학생'); 호출

//Member클래스의 메소드 정의
Member.prototype.toString=function(){  //toString(){}함수 정의
   return "[이름:"+ this.name+", 나이:"+ this.age+", 직업:"+ this.job+"]";
}

Member.prototype.setName=function(name){
	this.name=name;
}
Member.prototype.setAge=function(age){
	this.age=age;
}
Member.prototype.setJob=function(job){
	this.job=job;
}








