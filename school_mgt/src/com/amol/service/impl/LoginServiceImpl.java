package com.amol.service.impl;

import com.amol.bean.Login;
import com.amol.dao.LoginDao;
import com.amol.dao.impl.LoginDaoImpl;
import com.amol.service.LoginService;


/**
 * 
 * @author amolm
 *
 */
public class LoginServiceImpl implements LoginService{
	
	LoginDao loginDao = null;

	@Override
	public boolean login(Login login) {
		loginDao = new LoginDaoImpl();
		return loginDao.login(login);
	}

}//end of class
