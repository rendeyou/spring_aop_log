package com.bj.service.impl;

import com.bj.mapper.AddressMapper;
import com.bj.pojo.Address;
import com.bj.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// IoC注解
@Service
public class AddressServiceImpl implements AddressService {
    // DI注解
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 添加收获地址
     *
     * @param address 地址对象
     */
    @Override
    // AOP注解
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = RuntimeException.class)
    public void addAddressService(Address address) {
        addressMapper.insAddressMapper( address );

    }
}
