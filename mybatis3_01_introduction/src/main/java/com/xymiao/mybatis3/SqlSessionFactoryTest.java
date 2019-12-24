package com.xymiao.mybatis3;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xymiao.mybatis3.mapper.TUserMapper;
import com.xymiao.mybatis3.pojo.TUser;

public class SqlSessionFactoryTest {
	public static void main(String[] args) throws IOException {
		// 配置文件地址 根据/resources的root查找
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建一个session工厂.
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
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
