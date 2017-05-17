package com.kosta.t0516;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.w3c.dom.stylesheets.LinkStyle;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;
import com.kosta.t0516.dto.Emp;

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
