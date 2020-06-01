package com.bj.service.impl;

import com.bj.mapper.UserMapper;
import com.bj.pojo.PageBean3;
import com.bj.pojo.User;
import com.bj.service.UserService;
import com.bj.util.DateUtil;
import com.bj.util.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// IoC注解
@Service
public class UserServiceImpl implements UserService {
    // DI注解
    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询用户列表
     *
     * @param p        分页对象
     * @param id       查询条件用户ID
     * @param username 查询条件用户名
     * @return
     */
    @Override
    public PageBean3<User> userListService(PageBean3 p, String id, String username) {
        // 查询总记录数
        int totalCount = userMapper.totalCount(id, username);
        // 查询每页结果集
        List<User> list = userMapper.userList(id, username, p.getStart(), p.getSize());
        // 封装分页对象
        p.setTotalCount(totalCount);
        p.setList(list);
        return p;
    }

    /**
     * 注册用户
     *
     * @param user    用户对象
     * @param confirm 确认密码
     */
    @Override
    // AOP注解
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class)
    public void registService(User user, String confirm) {
        // 校验确认密码
        if (StringUtils.isBlank(confirm) || !user.getPassword().equals(confirm)) {
            throw new RuntimeException("确认密码错误");
        }
        // 完善用户对象：1注册时间 2密码加密
        user.setRegistTime(new Date());
        try {
            user.setPassword(Md5Util.md5(user.getPassword()));
            // 调用Mapper方法
            userMapper.registMapper(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("注册用户失败");
        }

    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public User loginService(String username, String password) {
        try {
            // 完善用户对象：密码加密
            String pwd = Md5Util.md5(password);
            // 调用Mapper方法
            return userMapper.loginMapper(username, pwd);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 根据用户IDS批量删除选中用户
     *
     * @param ids 用户IDS
     */
    @Override
    // AOP注解
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class)
    public void delByIdsService(String ids) {
        // 校验IDS
        if (StringUtils.isBlank(ids)) {
            throw new RuntimeException("ids为空白!");
        }
        // 字符串转换成数组
        String[] idsArr = ids.split(",");
        // 调用Mapper方法
        userMapper.delByIdsMapper(idsArr);
    }

    /**
     * 根据用户ID查询用户详情(点击超链接查询用户详情)
     *
     * @param id 用户ID
     * @return
     */
    @Override
    public User findByIdService(Integer id) {
        // 调用Mapper方法
        User user = userMapper.findByIdMapper(id);
        return user;
    }

    /**
     * 批量导入用户
     *
     * @param userFile 文件
     * @throws Exception
     */
    @Override
    // AOP注解
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class)
    public void addUserBatch(MultipartFile userFile) throws Exception {
        List<User> userList = new ArrayList<>();
        Date date = new Date();
        // 校验文件
        if (userFile == null || userFile.isEmpty()) {
            throw new RuntimeException("文件无效");
        }
        // IO流处理文件
        BufferedReader br = new BufferedReader(new InputStreamReader(userFile.getInputStream(), "UTF-8"));
        // 循环读取每一行
        String line = null;
        while ((line = br.readLine()) != null) {
            // 空行
            if (StringUtils.isBlank(line)) {
                continue;
            }
            // 循环拆分每一行
            String[] temp = line.split(";");
            if (temp.length != 3) {
                continue;
            }
            // 循环封装user对象
            User user = new User();
            user.setUsername(temp[0]);
            user.setPassword(Md5Util.md5(temp[1]));
            user.setBirthday(DateUtil.str2Date(temp[2]));
            user.setRegistTime(date);
            // 循环封装list集合
            userList.add(user);
        }
        // 调用Mapper方法
        userMapper.insUserBatch(userList);
    }
}
