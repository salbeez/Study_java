package com.kosta.mvcTable.model;

import java.util.Vector;

public interface Table_Interface {

	void input(Person p);

	void modify(int index,Person p);

	void delete(int index);
	void search();
	public Vector<Person> getPersons();
	// void search();
}
