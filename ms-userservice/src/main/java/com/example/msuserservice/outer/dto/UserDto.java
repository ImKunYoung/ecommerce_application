package com.example.msuserservice.outer.dto;

import com.example.msuserservice.inner.service.domain.vo.ResponseOrder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdAt;

    private String encryptedPwd;

    /*TODO: -setOrders*/
    private List<ResponseOrder> ordersList;
}
