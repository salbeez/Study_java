package com.kosta.j0321;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class People implements Serializable{
	private String name;
	private String age;
	private String job;

	public People(String name, String age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
public class FileCopyTest {
	// File Copy Test
	// read in File and print console
	// and print File
	public static void main(String[] args){
//		File file = new File("a.txt");
//		FileReader fr = new FileReader(file);
//		FileWriter fw = new FileWriter("a2.txt");
//		int i=0;
//		while((i = fr.read()) !=-1){
//			System.out.println((char)i);
//			fw.write(i);
//
//		}			
//		fw.close();
//		fr.close();
//		
		try {
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			
			FileOutputStream fos = new FileOutputStream("people.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(int j =0; j<2;j++){
				System.out.println("이름 : ");
				String name = br.readLine();
				System.out.println("나이 : ");
				String age = br.readLine();
				System.out.println("직업 : ");
				String job = br.readLine();
				People p = new People(name, age, job);// 		
				oos.writeObject(p);//오브젝트를 넣고 쓴다
			}
			fos.close();
			oos.close();
			System.out.println("저장완료");
			
			FileInputStream fis = new FileInputStream("people.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			People p2;
			while((p2=(People) ois.readObject())!=null){
				System.out.println(p2.getName()+p2.getAge()+p2.getJob());			
			}
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		while((i = fr.read()) !=-1){
//			System.out.println((char)i);
//		}
//		
	}
}
