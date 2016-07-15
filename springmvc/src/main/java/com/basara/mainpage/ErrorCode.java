package com.basara.mainpage;

/**
 * Created by hzlifangjian on 2016/6/12.
 */
public enum ErrorCode {

    NULL(0, "SUCCESS"),
    UNAUTHENTICATED_USER(12, "用户未登录"),
    INVALID_TOKEN(13, "token验证失败"),
    PARAM_NO_MATCH(21, "参数非法或缺失"),
    AREA_NOT_MATCH(100, "区域地址获取失败或不匹配"),
    DATA_NOT_MATCH(101, "访问资源不存在"),
    SERVICE_EXEC_FAIL(102, "服务返回错误"),
    SERVICE_EXCEPTION(103, "服务器异常"),
    DATA_OUTOF_TIME(105, "访问资源已过期或不可用"),
    AREA_NOT_SUPPORT(197, "未开放的区域"),
    AREA_NOT_FOUND(198, "不支持的地区"),
    SERVICE_ERROR(199, "服务器未知错误"),
    LOGIN_FAIL(200, "登录失败，未知错误"),
    USER_NAME_NOT_EXSIX(201, "登录失败，用户名不存在"),
    PASSWORD_ERROR(202, "登录失败，密码错误"),
    ACCOUNT_FREEZE(203, "登录失败，账号受限制"),
    LOGIN_ERROR_TOO_MANY(204, "登录失败次数过多"),
    CART_TIMEOUT(300, "操作购物车失败，购物车超时"),
    ADD_CART_FAIL_EMPTY(301, "加入购物车失败，库存不足"),
    ADD_CART_FAIL_MAXCOUNT(306, "加入购物车失败，一个商品款式限购两件"),
    ADD_CART_FAIL_CARTFULL(307, "加入购物车失败，购物车商品数不能超过10件"),
    ADD_CART_FAIL_POOUT(308, "加入购物车失败，该特卖已经结束"),
    ADD_CART_FAIL_ERROR(309, "加入购物车失败，后台异常"),
    DELETE_CART_FAIL(310, "删除失败"),
    CART_ADDRESS_EMPTY(320, "购物车结算失败，没有默认地址"),
    CART_OP_ERROR(311, "不允许操作已超时品类的数量"),
    ORDER_ERROR(400, "提交订单失败"),
    ORDER_TIMEOUT(401, "提交订单失败，订单超时"),
    ORDER_COUPON_ERROR(402, "提交订单失败，结算错误（红包、优惠券无法使用）"),
    ORDER_COD_ERROR(403, "提交订单失败，不支持货到付款"),
    ORDER_ADDRESS_ERROR(404, "提交订单失败，地址缺失"),
    ORDER_SKU_EMPTY(405, "提交订单失败，库存不足"),
    ORDER_HASH_ERROR(406, "提交订单失败，购物袋已被修改"),
    ORDER_CANCEL_ERROR(407, "提交订单取消失败"),
    COUPON_TIMEOUT(420, "优惠券过期"),
    COUPON_NOT_EXETIS(421, "优惠券不存在"),
    COUPON_NOT_START(422, "优惠券未生效"),
    COUPON_NOT_OPEN(423, "优惠券暂未启用"),
    COUPON_USED(424, "优惠券已被激活"),
    COUPON_DISABLE(425, "优惠券已失效"),
    COUPON_USED_AGAIN(426, "优惠券已被使用"),
    COUPON_NOT_MATCH(427, "优惠券不匹配"),
    PAY_FAIL(501, "支付失败"),
    PO_TIMEOUT(601, "该特卖已经结束"),
    UNKNOW_ERROR(999, "UNKNOW ERROR");

    private final int value;
    private final String desc;

    ErrorCode(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ErrorCode genEnumByIntValue(int intValue) {
        ErrorCode[] var5;
        int var4 = (var5 = values()).length;
        for (int var3 = 0; var3 < var4; ++var3) {
            ErrorCode item = var5[var3];
            if (item.value == intValue) {
                return item;
            }
        }
        return null;
    }


    public int getIntValue() {
        return this.value;
    }

    public String getDesc() {
        return this.desc;
    }
}
