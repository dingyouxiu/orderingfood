package com.dyx.ordering.common.constant;

public class WechatOpenAPIConstants {

    public static String  LOGIN_API =
            "https://api.weixin.qq.com/sns/jscode2session?appid=${appId}&secret=${secret}&js_code=${code}&grant_type=authorization_code";

    public static String APP_ID = "appId";

    public static String SECRET = "secret";

}
