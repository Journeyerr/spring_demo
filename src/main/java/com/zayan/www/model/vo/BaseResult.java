package com.zayan.www.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @param <T>
 * @author AnYuan
 */

@Data
@Accessors(chain = true)
public class BaseResult<T> {

    private Integer code = 0;
    private String message = "SUCCESS";
    private String requestId = "";
    private T data;

    public static BaseResult<?> success() {
        return new BaseResult<>();
    }

    public static <T> BaseResult<T> success(T data) {
        BaseResult<T> result = new BaseResult<>();
        result.setData(data);
        return result;
    }

    public static BaseResult error(String message) {
        return error(500, message);
    }

    public static BaseResult error(int code, String message) {
        return error(code, message, null);
    }

    public static <T> BaseResult<T> error(int code, String message, T data) {
        BaseResult<T> result = new BaseResult<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }


}
