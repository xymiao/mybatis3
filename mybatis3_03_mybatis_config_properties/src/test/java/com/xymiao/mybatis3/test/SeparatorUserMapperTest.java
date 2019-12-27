package com.xymiao.mybatis3.test;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.xymiao.mybatis3.mapper.TUserMapper;
import com.xymiao.mybatis3.pojo.TUser;

public class SeparatorUserMapperTest {
	private SqlSessionFactory sqlSessionFactory  = null;
	@Before
	public void init() throws IOException {
		// 配置文件地址 根据/resources的root查找
		String resource = "separator-mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建一个session工厂.
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void test() {
		// 测试是否会有问题。
		try (SqlSession session = sqlSessionFactory.openSession()) {
			TUserMapper mapper = session.getMapper(TUserMapper.class);
			TUser tUser  = mapper.selectUser("1");
			assertArrayEquals(new Boolean[] {Objects.isNull(tUser)}, new Boolean[] {false});
		}
	}
}