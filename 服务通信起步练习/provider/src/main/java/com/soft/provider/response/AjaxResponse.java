package com.soft.provider.response;


import lombok.Data;

/**
 * @description: 请求接口统一响应数据结构
 * @author: mqxu
 * @date: 2022-04-11
 **/
@Data
public class AjaxResponse {
    /**
     * 请求响应状态码
     */
    private int code;
    /**
     * 请求结果描述信息
     */
    private String message;
    /**
     * 请求结果数据（通常用于查询操作）
     */
    private Object data;


    private long total;

    private AjaxResponse() {
    }



    /**
     * 请求成功的响应，不带查询数据（用于删除、修改、新增接口）
     *
     * @return AjaxResponse
     */
    public static AjaxResponse success() {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        return ajaxResponse;
    }

    /**
     * 请求成功的响应，带有查询数据（用于数据查询接口）
     *
     * @param obj obj
     * @return AjaxResponse
     */
    public static AjaxResponse success(Object obj) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    /**
     * 请求成功的响应，带有查询数据（用于数据查询接口）
     *
     * @param obj     obj
     * @param message message
     * @return AjaxResponse
     */
    public static AjaxResponse success(Object obj, String message, long total) {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        ajaxResponse.setTotal(total);
        return ajaxResponse;
    }

}