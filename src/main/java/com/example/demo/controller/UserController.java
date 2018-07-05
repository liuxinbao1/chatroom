package com.example.demo.controller;

import java.text.MessageFormat;

import javax.websocket.server.PathParam;

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

	/**
	 * 日志常量.
	 */
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
		LOGGER.info(MessageFormat.format("UserController function = register,"
				+ " parameter userVO = [{0}]", userVO));

		//如果name，password为空则不允许注册
		if (null == userVO || StringUtils.isEmpty(userVO.getName())
				|| StringUtils.isEmpty(userVO.getPsswd())) {
			return new Result<String>(Constants.FAILD, "用户名或者密码不能为空", null);
		}

//		String patt = "";
		return userServiceImpl.register(userVO);
	}

	/**
	 * 用户登录.
	 *
	 * @param userVO
	 * @return Result<String>
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.POST})
	public Result<String> login(@RequestBody UserVO userVO) {

		LOGGER.info(MessageFormat.format("UserController function = login,"
				+ " parameter userVO = [{0}]", userVO));
		//如果name，password为空则不允许登录
		if (null == userVO || StringUtils.isEmpty(userVO.getName())
				|| StringUtils.isEmpty(userVO.getPsswd())) {
			return new Result<String>(Constants.FAILD, "用户名或者密码不能为空", null);
		}

		return userServiceImpl.login(userVO);
	}

	/**
	 * 名称是否重复.
	 *
	 * @param name 名称
	 * @return Result<String> 是否重复
	 */
	@RequestMapping(value = "/isRepeat", method = {RequestMethod.GET})
	public Result<String> isRepeat(@PathParam("name") String name) {
		LOGGER.info(MessageFormat.format("UserController function = isRepeat, parameter name = [{0}]", name));
		Result<String> result = new Result<>();
		if(userServiceImpl.isRepeat(name)) {
			result.setReturnStatus(Constants.FAILD);
			result.setReturnMessage("姓名重复");
			return result;
		}
		result.setReturnStatus(Constants.SUCCESS);
		result.setReturnMessage("姓名可用");
		return result;
	}
}
