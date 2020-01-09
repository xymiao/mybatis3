package com.xymiao.mybatis3.mapper;

import com.xymiao.mybatis3.pojo.TUser;

public interface TUserMapper {
	/**
	 * 根据主键查询对应的用户数据, 并且使用实体类接收数据
	 * @param uid 主键
	 * @return 用户信息
	 */
	TUser selectUser(String uid);
	
}