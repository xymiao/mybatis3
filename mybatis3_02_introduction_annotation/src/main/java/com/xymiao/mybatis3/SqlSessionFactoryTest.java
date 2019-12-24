package com.xymiao.mybatis3;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.xymiao.mybatis3.mapper.TUserMapper;
import com.xymiao.mybatis3.pojo.TUser;

public class SqlSessionFactoryTest {
	public static void main(String[] args) throws IOException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mybatis3?useUnicode=true&amp;characterEncoding=UTF-8";
		String username = "root";
		String password = "xymiao";
		//获得一个DataSource
		DataSource dataSource = new PooledDataSource(driver, url, username, password);
		//事物管理方式
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		//配置环境变量
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		//配置 Mapper
		configuration.addMapper(TUserMapper.class);
		//获得 SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	
		// 第一种方式， 推荐使用第二种
		try (SqlSession session = sqlSessionFactory.openSession()) {
			TUser tUser = (TUser) session.selectOne("com.xymiao.mybatis3.mapper.TUserMapper.selectUser", "1");
			System.out.println(tUser);
		}

		// 第二种方式, 推荐使用这种
		try (SqlSession session = sqlSessionFactory.openSession()) {
			TUserMapper mapper = session.getMapper(TUserMapper.class);
			TUser tUser = mapper.selectUser("1");
			System.out.println(tUser);
		}
	}
}
