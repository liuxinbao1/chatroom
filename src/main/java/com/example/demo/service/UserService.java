package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.entity.UserVO;

public interface UserService {

	/**
	 * 用户注册.
	 *
	 * @param userVO 用户实体类
	 * @return Result<String> 返回注册情况:成功或失败
	 */
	Result<String> register(UserVO userVO);

	/**
	 * 姓名是否重复.
	 *
	 * @param name 姓名
	 * @return boolean 是否重复
	 */
	boolean isRepeat(String name);

	/**
	 * 用户登录.
	 *
	 * @param userVO 用户对象
	 * @return Result<String> 登录结果
	 */
	Result<String> login(UserVO userVO);
}
