package com.jd.dubbo.impl;

import com.jd.dubbo.spi.DubboService;

public class DubboServiceImpl implements DubboService {

    @Override
    public void sayHello() {
        System.out.println("apple");
    }

}
