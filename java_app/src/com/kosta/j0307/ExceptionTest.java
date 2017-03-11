package com.kosta.j0307;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * <�ڹ� ����� 4�� Ŭ����> - �߻�Ŭ����
 * ----------------------->byte������ �����
 * 1. InputStream �Է���
 * 2. OutputStream
 * 
 * ---------->char(2byte)������ �Է�, ���
 * 3. reader 
 * 4. Writer
 * 
 * =========
 * FileInputStream
 * FileReader
 * 
 * a
 * */

public class ExceptionTest {

	// ����(���� ����)�� �о �ֿܼ� ���
	void readFile(){

		try{ //���࿡ try������ ���ܰ� �߻��Ѵٸ� ex)��ΰ� �߸���ų� ������ ���ų� ��
			FileReader fr = new FileReader("a.txt");	//File NOT Found
			
			int i;
			while( (i=fr.read()) !=-1){	//�ؽ�Ʈ�� ������ ����
//				s.o.f(  (char)97  )
			System.out.print((char)i);// IOException	//13,10 Enter
			}
			
		/*	while( (fr.read() !=-1){	//�ؽ�Ʈ�� ������ ����
				s.o.f(  (char)97  )
				System.out.print((char)fr.read());
				�̷��� �ϸ� abcd�� ��µ��� �ʰ� bd�� ���
				���� : while������ a �а� s.o.f���� b�а� ....�ٽ� while���� c�а� s.o.f���� d�а�
			}		
		System.out.println("\n���� �б� ����");*/
			
		} catch(FileNotFoundException fe){
			System.out.println("������ ã�� ���߽��ϴ� [���Ȯ��,���翩�� �˻�]");
		} catch(IOException ie) {
			
		}
	}

	public static void main(String[] args) {
		ExceptionTest ex = new ExceptionTest();
					ex.readFile();
			
	}
}
