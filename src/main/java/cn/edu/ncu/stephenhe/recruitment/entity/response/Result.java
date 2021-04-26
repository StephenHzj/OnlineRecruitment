package cn.edu.ncu.stephenhe.recruitment.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result {

    //响应码
    public Integer code;

    //返回消息
    public String message;

    //返回数据
    public Object data;

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
