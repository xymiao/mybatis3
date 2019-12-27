package com.xymiao.mybatis3.mapper;

import java.util.Map;

import com.xymiao.mybatis3.pojo.TUser;

public interface TUserMapper {
	/**
	 * 根据主键查询对应的用户数据, 并且使用实体类接收数据
	 * @param uid 主键
	 * @return 用户信息
	 */
	TUser selectUser(String uid);
	/**
	 * 根据登录用户登录id， 进行用户查询
	 * @param loginid 登录用户名
	 * @return 用户信息
	 */
	Map<String, Object> selectUserByLoginid(String loginid);
}