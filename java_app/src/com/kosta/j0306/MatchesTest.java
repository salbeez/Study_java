package com.kosta.j0306;

public class MatchesTest {

	// boolean str.matches(String regex)
	// regex´Â Á¤±Ô Ç¥Çö½Ä
	// regex¸¦ ÅëÇØ Àü´ŞµÇ´Â ÆĞÅÏ¿¡ strÀÌ ºÎÇÕ µÇ¸é true¸®ÅÏ

	public static void main(String[] args) {
		String str = "b";
		System.out.println(str.matches("[a]"));//a¹®ÀÚ ÇÑ¹ø
		System.out.println(str.matches("[a]?"));// a¹®ÀÚ°¡ 0,1°ú ÇÑ¹øÀ» Ç¥ÇöÇÒ¶§
		System.out.println(str.matches("[a]*"));//a¹®ÀÚ 0~¹«ÇÑ´ë
		System.out.println(str.matches("[a]+"));//a¹®ÀÚ 1~¹«ÇÑ´ë
		
		System.out.println(str.matches("[abc]"));//a or b or c Áß¿¡ ÇÑ¹ø ÃâÇö½Ã true
		
		String str2 = "gildong";	//¿µ¹®ÀÚ Ã¼Å©
		
		System.out.println(str2.matches("[a-z]+"));//¿µ¹®ÀÚ[¼Ò¹®ÀÚ] Á¶ÇÕ
		
		String su = "123456";
		System.out.println(su.matches("[0-9]+"));
		
		String hangle = "³ªÇÑ±Û";
		System.out.println(hangle.matches("[¤¡-ÆR]+"));
		
		//È¸¿ø °¡ÀÔ½Ã
		String id = "gildong1004";
//		id = 8~12ÀÚ¸® ÀÌ°í ¿µ¹®ÀÚ¿Í ¼ıÀÚ Á¶ÇÕ
		System.out.println(id.matches("[a-z0-9]{8,12}"));
	}
}
