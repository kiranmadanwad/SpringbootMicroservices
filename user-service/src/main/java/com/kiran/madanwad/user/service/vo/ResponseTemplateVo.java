package com.kiran.madanwad.user.service.vo;

import com.kiran.madanwad.user.service.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {

    private User user;
    private Department department;
}
