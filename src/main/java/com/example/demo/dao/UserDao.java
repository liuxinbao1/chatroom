package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.example.demo.entity.UserVO;

/**
 * 用户dao层.
 *
 * @author 刘新宝
 *
 */
@Mapper
@Component
public interface UserDao {

	/**
	 * 用户注册.
	 *
	 * @param userVO 用户实体类
	 */
	int register(@Param("user") UserVO userVO);

	
}
