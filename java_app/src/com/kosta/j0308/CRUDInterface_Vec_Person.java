package com.kosta.j0308;

public interface CRUDInterface_Vec_Person {

	public void insertName(String name, String job, int age);	//����
	public int searchName(String name);		//�˻�
	public void updateName(String name, String newJob,int newAge);	//����,����
	public void deleteName(String name);	//����
	public void printName();						//���
	public boolean duplicateName(String name);			//�ߺ�
}
/*
 * ����)Vector�� �̿��Ͽ� ����� ��ȣ,�̸�,����,���� =====> ����, ����, ����, �˻�
   
   ��°��)
   
   <����޴�>
   1.�߰� 2.�˻� 3.���� 4.����
   ��ȣ�Է�==> 1
   
   �̸�: ȫ�浿  ---> String name = in.readLine();
   ����: 13      ---> int age = Integer.parseInt(in.readLine());
   ����: �л�    ---> String job = in.readLine();
   
   <PersonMenuTest>
   Person p = new Person(name,age,job);
     menu.insert(p);
    
   <PersonMenu>
   public void insert(Person p){ 
    persons.add(p);
   }
   
     
   <����޴�>
   1.�߰� 2.�˻� 3.���� 4.����
   ��ȣ�Է�==> 1
   
   �̸�: ���ֿ�
   ����: 14
   ����: �л�
       
   <����޴�>
   1.�߰� 2.�˻� 3.���� 4.����
   ��ȣ�Է�==> 1
   
   �̸�: ������
   ����: 15
   ����: ȭ��
   
   <����޴�>
   1.�߰� 2.�˻� 3.���� 4.����
   ��ȣ�Է�==> 2
   
   #������
   1: [ȫ�浿,13,�л�]
   2: [���ֿ�,14,�л�]
   3: [������,15,ȭ��] 
  
   
   <����޴�>
   1.�߰� 2.�˻� 3.���� 4.����
   ��ȣ�Է�==> 3
   
   ������ ��ȣ: 3 //�̸��� ������ ���� ������ ����
   ����: 19 
   ����: �屺
   
   <����޴�>
   1.�߰� 2.�˻� 3.���� 4.����
   ��ȣ�Է�==> 2
   
   #������
   1: [ȫ�浿,13,�л�]
   2: [���ֿ�,14,�л�]
   3: [������,19,�屺] 
   
   
   <�̸��޴�>
   1.�߰� 2.�˻� 3.���� 4.����
   ��ȣ�Է�==> 4
   
   ������ ��ȣ: 2
   
   
   <����޴�>
   1.�߰� 2.�˻� 3.���� 4.����
   ��ȣ�Է�==> 2
   
   #������
   1: [ȫ�浿,13,�л�]   
   2: [������,19,�屺] 
  
   
=========================================================
PersonMenu.java (�������: �߰�(insert,add,plus,append),����(delete,remove,clear)
               ,����(modify,change,replace,update),�˻�(search,find,select))
 ����ʵ�: Vector<Person> persons; ��������� ����
 ����޼ҵ�: insert(), delete(), update(), select()             

PersonMenuTest.java (main()����)
 1. �ݺ����� �޴����
 2. Vector�� �߰��� �������, ������ ��ȣ�� �������, ������ ��ȣ�� �Է��� �޴´�.
 3. ���õ� ��ȣ�� ���� PersonMenu�� �޼ҵ带 ȣ��*/
 