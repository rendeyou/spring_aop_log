package com.bj.mapper;

import com.bj.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    /**
     * 分页查询用户列表：总记录数
     *
     * @param id       查询条件用户ID
     * @param username 查询条件用户名
     * @return
     */
    int totalCount(
            @Param("id") String id,
            @Param("username") String username
    );

    /**
     * 分页查询用户列表：每页结果集
     *
     * @param id       查询条件用户ID
     * @param username 查询条件用户名
     * @param start    开始角标
     * @param size     每页显示的记录数
     * @return
     */
    List<User> userList(
            @Param("id") String id,
            @Param("username") String username,
            @Param("start") int start,
            @Param("size") int size
    );

    /**
     * 用户注册
     *
     * @param user 用户对象
     */
    void registMapper(User user);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User loginMapper(
            @Param("username") String username,
            @Param("password") String password
    );

    /**
     * 根据用户IDS批量删除选中用户
     *
     * @param idsArr 用户IDS数组
     */
    void delByIdsMapper(@Param("idsArr") String[] idsArr);

    /**
     * 根据用户ID查询用户详情(点击超链接查询用户详情)
     *
     * @param id 用户ID
     * @return
     */
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "addressList", many = @Many(select = "com.bj.mapper.AddressMapper.selByUid"), column = "id")
    })
    @Select("select id,username,password,birthday,regist_time from tb_user where id=#{id}")
    User findByIdMapper(Integer id);

    /**
     * 批量导入用户
     *
     * @param userList 用户集合
     */
    void insUserBatch(@Param("userList") List<User> userList);
}
