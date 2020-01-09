package com.xymiao.mybatis3.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.junit.Before;
import org.junit.Test;

public class TypeHandlersTest {
	private SqlSessionFactory sqlSessionFactory  = null;
	@Before
	public void init() throws IOException {
		// 配置文件地址 根据/resources的root查找
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建一个session工厂.
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void test() {
		//测试方法
		try (SqlSession session = sqlSessionFactory.openSession()) {
	        TypeHandlerRegistry typeHandlerRegistry = session.getConfiguration().getTypeHandlerRegistry();
	        Collection<TypeHandler<?>> handlers =  typeHandlerRegistry.getTypeHandlers();
	        System.out.println(handlers.size());
	        for (TypeHandler<?> typeHandler : handlers) {
	            System.out.println(typeHandler.getClass().getName());
	        }
		}
	}

}
