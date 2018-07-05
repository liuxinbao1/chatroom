package com.example.demo.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserVO;
import com.example.demo.service.UserService;

/**
 * 用户业务类.
 *
 * @author 刘新宝
 *
 */
@Service("UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * 日志常量.
	 */
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * 注入dao.
	 */
	@Autowired
	private UserDao userDao;

	@Override
	public Result<String> register(UserVO userVO) {
		Result<String> result = new Result<String>();
		boolean repeat =  isRepeat(userVO.getName());
		if(repeat) {
			result.setReturnStatus(Constants.FAILD);
			result.setReturnMessage("姓名重复");
			return result;
		}
		userVO.setAdmin("N");
		userVO.setStatus("0");
		userVO.setPsswd(encryptPsswd(userVO.getPsswd()));
		int modify = userDao.register(userVO);
		if(modify == 0) {
			result.setReturnStatus(Constants.FAILD);
			result.setReturnMessage("注册失败");
			return result;
		}
		result.setReturnStatus(Constants.SUCCESS);
		result.setReturnMessage("注册成功");
		return result;
	}

	/**
	 * 是否姓名重复.
	 *
	 * @param name 姓名
	 * @return boolean 是否重复
	 */
	public boolean isRepeat(String name) {
		int count = userDao.isRepeat(name);
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 密码编码.
	 *
	 * @param psswd 需要编译的密码
	 * @return 编译后的密码
	 */
	private String encryptPsswd(String psswd) {

		// 16进制字符串
		char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

		// 第一、二段
		char first, second;
		StringBuilder sb = new StringBuilder();
		try {

			// 获取md5加密对象
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] byt = messageDigest.digest(psswd.getBytes("UTF-8"));

			// md5加密后的密码
			for(byte b : byt) {
				second = arr[b & 15];
				b = (byte) (b >> 4);
				first = arr[b & 15];
				sb.append(first).append(second);
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			LOGGER.info(MessageFormat.format("UserServiceImpl function = encryptPsswd"
					+ " handler exception :", e.getMessage()));
		}
		return sb.toString();
	}

	@Override
	public Result<String> login(UserVO userVO) {
		LOGGER.info(MessageFormat.format("UserServiceImpl function = login,"
				+ " parameter userVO = [{0}]", userVO));

		Result<String> result = new Result<String>();
		String psswd = userDao.findPassWord(userVO);
		String loginPsswd = encryptPsswd(userVO.getPsswd());
		if(StringUtils.isNotEmpty(psswd) && psswd.equals(loginPsswd)) {
			result.setReturnStatus(Constants.SUCCESS);
			result.setReturnMessage("登录成功");
			return result; 
		}
		result.setReturnStatus(Constants.FAILD);
		result.setReturnMessage("登录失败");
		return result;
	}

}
