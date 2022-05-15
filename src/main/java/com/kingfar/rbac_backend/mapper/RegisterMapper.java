package com.kingfar.rbac_backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author ZKH
 */
@Repository
@Mapper
public interface RegisterMapper {

    /**
     * insert a new user info
     * @param uid uid
     * @param username username
     * @param pwd password
     * @param realname real name
     * @param ctime create time of this user
     * @return if insert operation success
     */
    boolean setNewUserInfo(@Param("uid") String uid,
                           @Param("username") String username,
                           @Param("pwd") String pwd,
                           @Param("realname") String realname,
                           @Param("ctime") Date ctime);

    /**
     * count number of user by uid
     * @param uid uid
     * @return number of user with uid: uid
     */
    int countUserByUid(@Param("uid") String uid);

    /**
     * count number of user by username
     * @param username username
     * @return number of user in name: username
     */
    int countUserByUsername(@Param("username") String username);

}
