package com.zfcraft.web.service;


import com.zfcraft.web.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Repository
public interface UserService {

     User Sel(int id);

     boolean checkAdminUsername(String adminUsername,String adminPassword);
     User getTbadminUserInfo(String adminUsername);

     int register(User user);

     List<User> findAllUser();

     User getUserInfo(String username);
}
