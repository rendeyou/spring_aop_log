package com.bj.service;

import com.bj.pojo.Address;
import org.springframework.stereotype.Component;

@Component
public interface AddressService {
    //添加收获地址
    void addAddressService(Address address);
}
