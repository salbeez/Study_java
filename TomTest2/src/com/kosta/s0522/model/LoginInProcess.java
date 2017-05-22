package com.kosta.s0522.model;

import java.util.HashMap;

import com.kosta.s0522.beans.UserInfo;

public class LoginInProcess {
	HashMap<String, String> userPass;
	HashMap<String, UserInfo> userInfos;

	public LoginInProcess() {
		userPass = new HashMap<>(); // key:아이디 value 패스워드
		userInfos = new HashMap<>(); // key:아이디,value 사용자 정보

		// 로그인 테스트를 위한 데이터 입력
		userPass.put("gildong", "1234");
		userPass.put("lime", "5678");
		userPass.put("jowon", "2222");

		userInfos.put("gildong", new UserInfo("나길동", "010-123-4567", "aaa@gmail.com"));
		userInfos.put("lime", new UserInfo("차라임", "010-222-3333", "bbb@gmail.com"));
		userInfos.put("juwon", new UserInfo("정주원", "010-444-4444", "ccc@gmail.com"));
	}// LoginInProcess

	public UserInfo selectLogin(String id, String pass) {
		// 아이디 존재
		String dpass = userPass.get(id);// 만약 존재하지 않는 key값은 null

		if (dpass == null) {
			return null;
		}

		if (!dpass.equals(pass)) {
			return null;
		}
		// 아이디 존재o 패스워드 일치함
		UserInfo user = userInfos.get(id);
		return user;
	}
}
