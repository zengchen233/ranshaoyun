package cn.zengchen233.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userid;
    private String usercode;
    private String password;
    private String nickname;
    private int usertype;
    private String phone;
    private String email;
}
