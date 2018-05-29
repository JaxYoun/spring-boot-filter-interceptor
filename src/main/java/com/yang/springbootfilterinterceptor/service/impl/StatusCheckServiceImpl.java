package com.yang.springbootfilterinterceptor.service.impl;

import com.yang.springbootfilterinterceptor.service.StatusCheckService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StatusCheckServiceImpl implements StatusCheckService {

    @Override
    public List<String> getOperationList() {
        return Arrays.asList("/user/getUserById", "/user/login", "/user/getAllUser");
    }

}
