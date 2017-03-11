package com.kosta.j0308;

public class ExceptionTest3 {
	public static void main(String[] args) {
		/* Run Configurations -> Arguments탭 적고 apply-> 확인
		 * su1		su2
		 * 10			5
		 * 10			0
		 * ab			cd
		 * 10			x
		 * */
		System.out.println("매개변수를 통해 받은 두개의 수");
		
		try {
			int su1 = Integer.parseInt(args[0]);	//ArrayIndexOutOfBounds,NumberFormat
			int su2 = Integer.parseInt(args[1]);	//ArrayIndexOutOfBounds,NumberFormat
			
			System.out.println("su1 = "+su1+", su2 = "+su2);
			System.out.println("su1을 su2로 나눈 몫 = "+(su1/su2));// Arithmeic
			System.out.println("나눗셈을 원할히 수행하였습니다");
		} /*catch (ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			System.out.println("두개의 수를 입력");
		}
		catch(NumberFormatException ne){
			System.out.println("숫자만 입력");
//			return;
		}
		catch(ArithmeticException ae){
			System.out.println("0으로 나눌수 없습니다");
		}*/
		catch(Exception e){
			System.out.println("모든 예외 처리");
		}
		finally {
			//예외 발생과 상관없이 실행할 문장
//			왜 쓰냐면 예외에서 return을 만나면 "마지막 문장"은 실행은 안되지만
//			Finally문장은 실행된다
			System.out.println("finally() : 반드시 실행하는 문장" );
		}
//		try~catch~finally
		System.out.println("마지막 문장");
	}
}

/**/
