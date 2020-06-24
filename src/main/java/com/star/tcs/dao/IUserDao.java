package com.star.tcs.dao;

import com.star.tcs.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账号dao接口
 */
@Repository("userDao")
public interface IUserDao {
    //保存账号信息
    @Insert("insert into kk_user(username,password,role,add_time) values(#{username},#{password},#{role},now())")
    public int saveUser(User user);

    @Select("select * from kk_user")
    public List<User> findAll();

}
