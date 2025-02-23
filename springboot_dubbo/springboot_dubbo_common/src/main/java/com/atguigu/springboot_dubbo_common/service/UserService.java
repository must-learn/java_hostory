package com.atguigu.springboot_dubbo_common.service;


import com.atguigu.springboot_dubbo_common.bean.UserAddress;

import java.util.List;


/**
 * 用户服务
 * @author lfy
 *
 */
public interface UserService {
	
	/**
	 * 按照用户id返回所有的收货地址
	 * @param userId
	 * @return
	 */
	public List<UserAddress> getUserAddressList(String userId);

}
