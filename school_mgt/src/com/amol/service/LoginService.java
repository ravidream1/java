package com.amol.service;

import com.amol.bean.Login;
import com.amol.dao.LoginDao;


/**
 * 
 * @author amolm
 *
 */
public interface LoginService {
	public boolean login(Login login);
}
