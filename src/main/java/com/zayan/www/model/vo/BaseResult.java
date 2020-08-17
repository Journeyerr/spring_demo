package com.zayan.www.model.vo;

import com.zayan.www.constant.enums.ErrorEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author AnYuan
 * @param <T>
 */

@Data
@Accessors(chain = true)
public class BaseResult<T> {

    private Integer code = 0;

    private String message = "success";

    private String requestId = "";

    private T data;

    public static BaseResult<?> success(){
        return new BaseResult<>();
    }

    public static <T> BaseResult<?> success(T data){
        return new BaseResult<T>().setCode(0).setData(data);
    }

    public static BaseResult<?> error(String message){
        return new BaseResult<>().setCode(500).setMessage(message);
    }

    public static <T> BaseResult<?> error(ErrorEnum errorEnum){
        return new BaseResult<>().setCode(errorEnum.getCode()).setMessage(errorEnum.getMessage());
    }

    public static <T> BaseResult<?> error(ErrorEnum errorEnum, T data){
        return new BaseResult<>().setCode(errorEnum.getCode()).setMessage(errorEnum.getMessage()).setData(data);
    }

}
