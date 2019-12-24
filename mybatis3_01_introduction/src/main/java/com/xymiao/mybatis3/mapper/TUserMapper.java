package com.xymiao.mybatis3.mapper;

import com.xymiao.mybatis3.pojo.TUser;

public interface TUserMapper {
	TUser selectUser(String uid);
}