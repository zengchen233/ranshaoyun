package cn.zengchen233.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private String usercode;
    private String nickname;
    private Date datetime;
    private String title;
    private String message;
}
