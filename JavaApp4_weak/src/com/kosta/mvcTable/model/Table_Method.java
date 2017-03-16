package com.kosta.mvcTable.model;

import java.util.Vector;

//model
public class Table_Method implements Table_Interface{
	private Vector<Person> person;
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
		//���°����... ������
		person.set(index, p);
	}

	@Override
	public void delete(int index) {//input ���̾� �α�
		// TODO Auto-generated method stub
		person.remove(index);
	}

	public Vector<Person> getPersons(){
		return person;
	}
	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}
}
