package com.xymiao.mybatis3.mapper;

import org.apache.ibatis.annotations.Select;

import com.xymiao.mybatis3.pojo.TUser;

public interface TUserMapper {
	@Select("SELECT * FROM t_user WHERE uid = #{uid}")
	TUser selectUser(String uid);
}