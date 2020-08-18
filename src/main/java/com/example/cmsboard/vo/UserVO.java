package com.example.cmsboard.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class UserVO {
    String id;
    String password;
    String name;
    String authority;
}
