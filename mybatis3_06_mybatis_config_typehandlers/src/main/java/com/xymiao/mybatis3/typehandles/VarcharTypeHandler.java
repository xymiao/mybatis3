package com.xymiao.mybatis3.typehandles;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.VARCHAR)
public class VarcharTypeHandler extends BaseTypeHandler<String> {

	  @Override
	  public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
	    ps.setString(i, parameter);
	    System.out.println("Cust setNonNullParameter");
	  }

	  @Override
	  public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		  System.out.println("Cust getNullableResult");
	    return rs.getString(columnName);
	  }

	  @Override
	  public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		  System.out.println("Cust getNullableResult");
	    return rs.getString(columnIndex);
	  }

	  @Override
	  public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		  System.out.println("Cust getNullableResult");
	    return cs.getString(columnIndex);
	  }
}
