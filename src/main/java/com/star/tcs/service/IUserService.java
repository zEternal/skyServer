package com.star.tcs.service;

import com.star.tcs.bean.User;

import java.util.List;

public interface IUserService {

    //保存账号信息
    public void saveUser(User user);

    //查询所有账户
    public List<User> findAll();
}
