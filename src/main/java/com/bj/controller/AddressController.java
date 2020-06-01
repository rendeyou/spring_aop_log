package com.bj.controller;

import com.bj.pojo.Address;
import com.bj.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// IoC注解
@Controller
public class AddressController {
    // DI注解
    @Autowired
    private AddressService addressService;

    /**
     * 添加收获地址
     *
     * @param address 地址对象
     * @param model   请求作用域
     * @return
     */
    // mvc注解
    @RequestMapping("/addAddress")
    public String addAddress(Address address, Model model) {
        try {
            // 调用后台方法
            addressService.addAddressService(address);
            // 请求作用域
            model.addAttribute("msg", "添加收获地址成功");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "添加收获地址失败");
        }
        // 跳转控制器
        return "forward:/findById?id=" + address.getUid();
    }
}
