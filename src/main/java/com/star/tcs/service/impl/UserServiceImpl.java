package com.star.tcs.service.impl;

import com.star.tcs.bean.User;
import com.star.tcs.dao.IUserDao;
import com.star.tcs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void saveUser(User user) {
        System.out.println("业务层，保存账号信息------");
        user.setRole(1);
        int i = userDao.saveUser(user);
        System.out.println("------" + i + "行被save");
    }

    @Override
    public List<User> findAll() {
     System.out.println("业务层，保存账号信息------");
        return userDao.findAll();
    }


}
