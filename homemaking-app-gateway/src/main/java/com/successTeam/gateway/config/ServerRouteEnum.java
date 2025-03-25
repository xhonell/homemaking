package com.successTeam.gateway.config;

/**
 * program: homemaking
 * ClassName ServerRouteEnum
 * description:
 * author: xhonell
 * create: 2025年03月22日20时42分
 * Version 1.0
 **/
public enum ServerRouteEnum {
    /**
     * 路由信息
     */
    USER_ROUTE("user_route", "用户微服务接口"),
    AUTH_ROUTE("auth_route", "认证中心微服务接口"),
    CAT_ROUTE("cat_route", "宠物中心微服务接口"),
    ORDER_ROUTE("order_route", "订单微服务接口"),;


    private String routeId;
    private String swaggerInfo;

    ServerRouteEnum(String routeId, String swaggerInfo) {
        this.routeId = routeId;
        this.swaggerInfo = swaggerInfo;
    }

    /**
     * 根据路由id获取swagger信息
     *
     * @param routId 路由id
     * @return swagger信息
     */
    public static String getSwaggerInfoByRoutId(String routId) {
        for (ServerRouteEnum routeEnum : ServerRouteEnum.values()) {
            if (routId.equals(routeEnum.getRouteId())) {
                return routeEnum.getSwaggerInfo();
            }
        }
        return null;
    }

    /**
     * @return the routeId
     */
    public String getRouteId() {
        return routeId;
    }

    /**
     * @param routeId : the routeId to set
     */
    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    /**
     * @return the swaggerInfo
     */
    public String getSwaggerInfo() {
        return swaggerInfo;
    }

    /**
     * @param swaggerInfo : the swaggerInfo to set
     */
    public void setSwaggerInfo(String swaggerInfo) {
        this.swaggerInfo = swaggerInfo;
    }

}
