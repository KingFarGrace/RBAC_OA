package com.kingfar.rbac_backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ZKH
 */
@Repository
@Mapper
public interface InfoOperateMapper {

    /**
     * update username
     * @param uid
     * @param username
     * @return
     */
    boolean updateUsername(@Param("uid") String uid, @Param("username") String username);

    /**
     * update telenum
     * @param uid
     * @param telenum
     * @return
     */
    boolean updateTelenum(@Param("uid") String uid, @Param("telenum") String telenum);

    /**
     * update email
     * @param uid
     * @param email
     * @return
     */
    boolean updateEmail(@Param("uid") String uid, @Param("email") String email);

    /**
     * update real name (need for permission)
     * @param uid
     * @param realname
     * @return
     */
    boolean updateRealname(@Param("uid") String uid, @Param("realname") String realname);

    /**
     * update age (need for permission)
     * @param uid
     * @param age
     * @return
     */
    boolean updateAge(@Param("uid") String uid, @Param("age") int age);

    /**
     * update gender (need for permission)
     * @param uid
     * @param gender
     * @return
     */
    boolean updateGender(@Param("uid") String uid, @Param("gender") String gender);

    /**
     * count number of user by telephone number
     * @param telenum
     * @return
     */
    int countUserNumberByTelenum(String telenum);

    /**
     * count number of user by email number
     * @param email
     * @return
     */
    int countUserNumberByEmail(String email);

}
