//package com.flysky.study.mybatis.common;
//
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
///**
// * 基本响应对象
// * Created by longshengtang on 2017/4/7.
// */
//@ApiModel("基本响应信息")
//public class BaseResp<T> {
//
//    /**
//     * 用于判定返回码是否为200
//     *
//     * @return 如果this.status值为20000或者返回true；反之返回false
//     */
//    @ApiModelProperty(value = "返回是否成功", dataType = "boolean", position = 3)
//    public boolean isOk() {
//        return StatusEm.SUCCESS.getCode().equals(this.code);
//    }
//
//    public BaseResp() {
//        this(StatusEm.SUCCESS);
//    }
//
//    public BaseResp(T data) {
//        this.setInfo(StatusEm.SUCCESS).setData(data);
//    }
//
//    public BaseResp(String code, String desc, String msg, T data) {
//        this.code = code;
//        this.desc = desc;
//        this.msg = msg;
//        this.data = data;
//    }
//
//    public BaseResp(StatusEm StatusEm) {
//        this.setInfo(StatusEm);
//    }
//
//    public static BaseResp buildStatus(StatusEm status) {
//        return new BaseResp().setInfo(status);
//    }
//
//    public static <U> BaseResp<U> build() {
//        return build(null);
//    }
//
//    public static <U> BaseResp<U> build(U data) {
//        return buildStatus(StatusEm.SUCCESS).setData(data);
//    }
//
//    public static BaseResp buildFail() {
//        return buildStatus(StatusEm.FAILED);
//    }
//
//    public static BaseResp buildFail(String msg) {
//        return buildStatus(StatusEm.FAILED).setMsg(msg);
//    }
//
//    /**
//     * @param status
//     * @return
//     */
//    public BaseResp setInfo(StatusEm status) {
//        setInfo(status.getCode(), status.getExplain(), status.getDesc());
//        return this;
//    }
//
//    public BaseResp setInfo(String code, String desc, String msg) {
//        this.code = code;
//        this.desc = desc;
//        this.msg = msg;
//        return this;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public BaseResp<T> setCode(String code) {
//        this.code = code;
//        return this;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public BaseResp<T> setMsg(String msg) {
//        this.msg = msg;
//        return this;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public BaseResp setDesc(String desc) {
//        this.desc = desc;
//        return this;
//    }
//
//    public BaseResp<T> setData(T data) {
//        this.data = data;
//        return this;
//    }
//
//    @Override
//    public String toString() {
//        return "BaseResp{" +
//                "code='" + code + '\'' +
//                ", msg='" + msg + '\'' +
//                ", desc='" + desc + '\'' +
//                ", data=" + data +
//                '}';
//    }
//
//    /**
//     * 返回码
//     */
//    @ApiModelProperty(value = "返回码", dataType = "String", position = 1)
//    private String code = "200";
//    /**
//     * 返回描述
//     */
//    @ApiModelProperty(value = "返回说明", dataType = "String", position = 2)
//    private String msg;
//
//    /**
//     * 返回描述
//     */
//    @ApiModelProperty(value = "返回描述", dataType = "String", position = 3)
//    private String desc;
//
//    /**
//     * 返回数据
//     */
//    @ApiModelProperty(value = "返回数据", dataType = "Object", position = 4)
//    private T data;
//
//}
//
