package com.kosta.mvcTable.model;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//model
public class Table_Method implements Table_Interface{
	private Vector<Person> person;
	private Vector<Person> selectionPerson;
	public Table_Method() {
		person = new Vector<>();
	}
	@Override
	public void input(Person p) {
		person.addElement(p);
		System.out.println(person.size());
	}

	@Override
	public void modify(int index,Person p) {
		//몇번째인지... 선택후
		person.set(index, p);
	}

	@Override
	public void delete(int index) {//input 다이얼 로그
		// TODO Auto-generated method stub
		person.remove(index);
	}

	public Vector<Person> getPersons(){//전체 데이터 리턴
		return person;
	}
	@Override
	public Vector<Person> section_Search(int section,String str) {
		selectionPerson = new Vector<>();
		Pattern p = null;
		String matching_Str=null;
		if(section == 0){ // "^" 해당 문자로 시작하는 이름을 검색
			p = Pattern.compile("^"+str);
		}else{
			p = Pattern.compile(str+"+");
		}
		
		for(int i =0; i<person.size();i++){
			Matcher m = p.matcher(person.get(i).getName());
			if(m.find()){	//해당 값을 찾으면 벡터에 넣는다
				selectionPerson.add(person.get(i));
			}
		}
		return selectionPerson;
	}
}
