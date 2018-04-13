package com.example.demo.controller;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.entity.UserVO;
import com.example.demo.service.UserService;

/**
 * 用户控制层.
 *
 * @author 刘新宝
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);
	/**
	 * 注入用户逻辑层.
	 */
	@Autowired
	private UserService userServiceImpl;

	/**
	 * 用户注册方法.
	 *
	 * @param userVO 用户实体类
	 * @return Result<String> 注册信息
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Result<String> register(@RequestBody UserVO userVO) {
		LOGGER.debug(MessageFormat.format("UserController function = register,"
				+ " parameter userVO = [{0}]", userVO));

		//如果name，password为空则不允许注册
		if (null != userVO && StringUtils.isEmpty(userVO.getName())
				|| StringUtils.isEmpty(userVO.getPsswd())) {
			return new Result<String>(Constants.FAILD, "用户名或者密码不能为空", null);
		}

//		String patt = "";
		return userServiceImpl.register(userVO);
	}
}
