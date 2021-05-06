package com.zfcraft.web.mapper;


import com.zfcraft.web.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
@Repository
public interface UserMapper {

    User Sel(int id);

    User getTbadminUserInfo(String adminUsername);

    int register(User user);

    List<User> findAllUser();

    User getUserInfo(String username);
}
