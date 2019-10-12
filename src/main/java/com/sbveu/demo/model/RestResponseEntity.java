package com.sbveu.demo.model;

import org.springframework.http.HttpStatus;

/**
 * @author NieYinjun
 * @date 2019/10/12 13:46
 */

public class RestResponseEntity<T> {
    private Integer code;
    private String desc;
    private T data;

    public RestResponseEntity() {
    }

    public RestResponseEntity(int code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static <T> RestResponseEntity<T> ok(String desc, T data) {
        RestResponseEntity<T> restResponseEntity = new RestResponseEntity();
        restResponseEntity.desc = desc;
        restResponseEntity.code = HttpStatus.OK.value();
        restResponseEntity.data = data;
        return restResponseEntity;
    }

    public static <T> RestResponseEntity<T> ok(String desc) {
        return ok(desc, null);
    }

    public static <T> RestResponseEntity<T> ok(T data) {
        return ok("", data);
    }

    public static <T> RestResponseEntity<T> error(String desc, T data) {
        RestResponseEntity<T> entity = new RestResponseEntity();
        entity.data = data;
        entity.desc = desc;
        entity.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        return entity;
    }

    public static <T> RestResponseEntity<T> error(int code, String desc) {
        RestResponseEntity<T> entity = new RestResponseEntity();
        entity.desc = desc;
        entity.code = code;
        return entity;
    }

    public static <T> RestResponseEntity<T> error(String desc) {
        return error(desc, null);
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    public T getData() {
        return this.data;
    }

    public RestResponseEntity<T> setCode(final Integer code) {
        this.code = code;
        return this;
    }

    public RestResponseEntity<T> setDesc(final String desc) {
        this.desc = desc;
        return this;
    }

    public RestResponseEntity<T> setData(final T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "RestResponseEntity(code=" + this.getCode() + ", desc=" + this.getDesc() + ", data=" + this.getData() + ")";
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RestResponseEntity)) {
            return false;
        } else {
            RestResponseEntity<?> other = (RestResponseEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label47;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label47;
                    }

                    return false;
                }

                Object this$desc = this.getDesc();
                Object other$desc = other.getDesc();
                if (this$desc == null) {
                    if (other$desc != null) {
                        return false;
                    }
                } else if (!this$desc.equals(other$desc)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RestResponseEntity;
    }

    @Override
    public int hashCode() {
        int result = 1;
        Object code1 = this.getCode();
        result = result * 59 + (code1 == null ? 43 : code1.hashCode());
        Object desc1 = this.getDesc();
        result = result * 59 + (desc1 == null ? 43 : desc1.hashCode());
        Object data1 = this.getData();
        result = result * 59 + (data1 == null ? 43 : data1.hashCode());
        return result;
    }
}