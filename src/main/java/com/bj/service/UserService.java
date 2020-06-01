package com.bj.service;

import com.bj.pojo.PageBean3;
import com.bj.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface UserService {
    //分页查询用户列表
    PageBean3<User> userListService(PageBean3 p, String id, String username);

    //注册用户
    void registService(User user, String confirm);

    //用户登录
    User loginService(String username, String password);

    //批量删除选中用户
    void delByIdsService(String ids);

    //用户详情
    User findByIdService(Integer id);

    //批量导入用户
    void addUserBatch(MultipartFile userFile) throws Exception;
}
