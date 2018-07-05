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

	/**
	 * 查询用户数量.
	 *
	 * @param name 用户数量
	 * @return int 用户数量
	 */
	int isRepeat(@Param("name") String name);

	/**
	 * 根据用户名查询密码.
	 *
	 * @param userVO 用户对象
	 * @return 密码
	 */
	String findPassWord(UserVO userVO);

}
