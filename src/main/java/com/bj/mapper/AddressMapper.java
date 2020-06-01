package com.bj.mapper;

import com.bj.pojo.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AddressMapper {
    /**
     * 根据用户ID查询用户详情(点击超链接查询用户详情)
     *
     * @param uid 用户ID
     * @return
     */
    @Select("select * from tb_address where uid=#{id}")
    List<Address> selByUid(int uid);

    /**
     * 添加收获地址
     *
     * @param address
     */
    @Insert("insert into tb_address values(default,#{province},#{city},#{district},#{uid})")
    void insAddressMapper(Address address);

}
