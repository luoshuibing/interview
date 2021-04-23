package com.jd.dubbo.main;

import com.jd.dubbo.spi.DubboService;

import java.util.Iterator;
import java.util.ServiceLoader;


public class ServiceMain {

    public static void main(String[] args) {
        ServiceLoader<DubboService> load = ServiceLoader.load(DubboService.class);
        Iterator<DubboService> iterator = load.iterator();
        while(iterator.hasNext()){
            DubboService dubboService = iterator.next();
            dubboService.sayHello();
        }
    }

}
