package com.kosta.t0519;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.kosta.t0519.dto.Emp;

import iba.conf.MySqlMapClient;

/**
 * @author kosta @
 */
public class EmpDAO3 {

	SqlMapClient smc;

	public EmpDAO3() {
		smc = MySqlMapClient.getSqlMapInstance();
	}

	public List<Emp> selectAll() {

		List<Emp> list = null;
		try {
			list = smc.queryForList("empInfo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}
