package com.zfcraft.web.service.servicesimpl;

import com.zfcraft.web.Exception.LoginException;
import com.zfcraft.web.entity.User;
import com.zfcraft.web.enums.ResultEnum;
import com.zfcraft.web.mapper.UserMapper;
import com.zfcraft.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by
 */
@Service
//@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User Sel(int id) {

        return userMapper.Sel(id);

    }


    @Override
    public boolean checkAdminUsername(String adminUsername, String adminPassword) {
        User tbAdmin = getTbadminUserInfo(adminUsername);
        System.out.println(adminPassword + ">>>>>>>>>>>>>>>>>>>>>>>>>");
        if (!(tbAdmin.getPassWord().equals(adminPassword))) {
            throw new LoginException(ResultEnum.PASSWORD_IS_ERROR);
        }
        return true;
    }

    @Override
    public User getTbadminUserInfo(String adminUsername) {

        User user = userMapper.getTbadminUserInfo(adminUsername);
//        if (user == null) {
//            throw new LoginException(ResultEnum.USERNAME_IS_ERROR);
//        }
        return user;
    }

    @Override
    public int register(User user) {

        int count = userMapper.register(user);

        System.out.println(count);
//        if (count == 0) {
//            throw new LoginException(ResultEnum.REGISTER_FAIL);
//        }
        return 1;
    }

    @Override
    public List<User> findAllUser() {

        List<User> userList = userMapper.findAllUser();
        return userList;
    }

    @Override
    public User getUserInfo(String username) {
        User user = userMapper.getUserInfo(username);
        return user;
    }
}