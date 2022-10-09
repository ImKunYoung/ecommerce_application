package com.example.msuserservice.dto;

import com.example.msuserservice.vo.ResponseOrder;
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
    public void setOrders(List<ResponseOrder> ordersList) {
    }
//    List<ResponseOrder> ordersList;
}
