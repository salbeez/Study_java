package com.kosta.j0308;

public interface CRUDInterface_Vec_Person {

	public void insertName(String name, String job, int age);	//삽입
	public int searchName(String name);		//검색
	public void updateName(String name, String newJob,int newAge);	//갱신,수정
	public void deleteName(String name);	//삭제
	public void printName();						//출력
	public boolean duplicateName(String name);			//중복
}
/*
 * 문제)Vector을 이용하여 사람의 번호,이름,나이,직업 =====> 저장, 삭제, 수정, 검색
   
   출력결과)
   
   <사람메뉴>
   1.추가 2.검색 3.수정 4.삭제
   번호입력==> 1
   
   이름: 홍길동  ---> String name = in.readLine();
   나이: 13      ---> int age = Integer.parseInt(in.readLine());
   직업: 학생    ---> String job = in.readLine();
   
   <PersonMenuTest>
   Person p = new Person(name,age,job);
     menu.insert(p);
    
   <PersonMenu>
   public void insert(Person p){ 
    persons.add(p);
   }
   
     
   <사람메뉴>
   1.추가 2.검색 3.수정 4.삭제
   번호입력==> 1
   
   이름: 김주원
   나이: 14
   직업: 학생
       
   <사람메뉴>
   1.추가 2.검색 3.수정 4.삭제
   번호입력==> 1
   
   이름: 김유신
   나이: 15
   직업: 화랑
   
   <사람메뉴>
   1.추가 2.검색 3.수정 4.삭제
   번호입력==> 2
   
   #사람목록
   1: [홍길동,13,학생]
   2: [김주원,14,학생]
   3: [김유신,15,화랑] 
  
   
   <사람메뉴>
   1.추가 2.검색 3.수정 4.삭제
   번호입력==> 3
   
   수정할 번호: 3 //이름을 제외한 나이 직업만 수정
   나이: 19 
   직업: 장군
   
   <사람메뉴>
   1.추가 2.검색 3.수정 4.삭제
   번호입력==> 2
   
   #사람목록
   1: [홍길동,13,학생]
   2: [김주원,14,학생]
   3: [김유신,19,장군] 
   
   
   <이름메뉴>
   1.추가 2.검색 3.수정 4.삭제
   번호입력==> 4
   
   삭제할 번호: 2
   
   
   <사람메뉴>
   1.추가 2.검색 3.수정 4.삭제
   번호입력==> 2
   
   #사람목록
   1: [홍길동,13,학생]   
   2: [김유신,19,장군] 
  
   
=========================================================
PersonMenu.java (기능정의: 추가(insert,add,plus,append),삭제(delete,remove,clear)
               ,수정(modify,change,replace,update),검색(search,find,select))
 멤버필드: Vector<Person> persons; 사람정보를 저장
 멤버메소드: insert(), delete(), update(), select()             

PersonMenuTest.java (main()포함)
 1. 반복적인 메뉴출력
 2. Vector에 추가할 사람정보, 수정할 번호와 사람정보, 삭제할 번호의 입력을 받는다.
 3. 선택된 번호에 따라 PersonMenu의 메소드를 호출*/
 