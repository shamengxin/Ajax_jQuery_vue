package com.shamengxin.vue_cli.service.impl;

import com.shamengxin.vue_cli.dao.UserDao;
import com.shamengxin.vue_cli.entity.User;
import com.shamengxin.vue_cli.service.UserService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }
}
