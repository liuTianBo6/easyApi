package com.api.common.service;

import com.api.common.model.entity.User;


/**
 * 用户服务
 */
public interface InnerUserService {

    /**
     * 数据库中查是否已分配给用户秘钥（accessKey）
     */
    User getInvokeUser(String accessKey);
}
