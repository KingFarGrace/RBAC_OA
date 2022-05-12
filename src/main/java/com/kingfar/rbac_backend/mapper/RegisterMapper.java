package com.kingfar.rbac_backend.mapper;

import com.kingfar.rbac_backend.dto.UserInfoResp;
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
     * @param uid
     * @param username
     * @param pwd
     * @param realname
     * @param ctime
     * @return
     */
    boolean setNewUserInfo(@Param("uid") String uid,
                           @Param("username") String username,
                           @Param("pwd") String pwd,
                           @Param("realname") String realname,
                           @Param("ctime") Date ctime);

    /**
     * count number of user by uid
     * @param uid
     * @return
     */
    int countUserByUid(@Param("uid") String uid);

    /**
     * count number of user by username
     * @param username
     * @return
     */
    int countUserByUsername(@Param("username") String username);

}
