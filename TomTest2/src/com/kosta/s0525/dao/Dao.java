package com.kosta.s0525.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.kosta.s0525.dto.Dto;
import com.kosta.t0519.dto.Emp;

import iba.conf.MySqlMapClient;

public class Dao {
	SqlMapClient smc;

	public Dao() {
		smc = MySqlMapClient.getSqlMapInstance();
	}

	public List<String> selectAll() {
		List<String> list = null;
		try {
			list = smc.queryForList("selectAllName");
			System.out.println("찾아온 사이즈 : " + list.size());
		} catch (SQLException e) {
			System.out.println("???/");
			e.printStackTrace();
		}
		return list;
	}

	public List<String> selectKeyword(String keyword) {
		List<String> list = null;
		try {
			list = smc.queryForList("selectKeyword", keyword);
			System.out.println("찾아온 사이즈 : " + list.size());
		} catch (SQLException e) {
			System.out.println("???/");
			e.printStackTrace();
		}
		return list;
	}

	public List<Emp> selectAll2() {
		List<Emp> list = null;
		try {
			list = smc.queryForList("empInfo");
			System.out.println("찾아온 사이즈 : " + list.size());
		} catch (SQLException e) {
			System.out.println("???/");
			e.printStackTrace();
		}
		return list;
	}

	public List<String> selectSido() {
		List<String> list = null;
		try {
			list = smc.queryForList("selectSido");
			System.out.println("찾아온 시도 갯수 : " + list.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> selectGugun(String sido) {
		List<String> list = null;
		try {
			list = smc.queryForList("selectGugun",sido);
			System.out.println("찾아온 시도 갯수 : " + list.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> selectDong(String sido) {
		List<String> list = null;
		try {
			list = smc.queryForList("selectGugun",sido);
			System.out.println("찾아온 시도 갯수 : " + list.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
