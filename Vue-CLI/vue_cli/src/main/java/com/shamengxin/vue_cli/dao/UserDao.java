package com.shamengxin.vue_cli.dao;

import com.shamengxin.vue_cli.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    void save(User user);

    void update(User user);

    void delete(String id);

    List<User> findAll();

    User findById(String id);

}
