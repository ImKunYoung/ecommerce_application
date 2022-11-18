package com.example.msuserservice.inner.service.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값은 json으로 변환하지 않는다.
public class ResponseUser {

    private String email;

    private String name;

    private String userId;

    private List<ResponseOrder> orders;

}
