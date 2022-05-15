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
     * @param uid uid
     * @param username username
     * @return if update operation success
     */
    boolean updateUsername(@Param("uid") String uid, @Param("username") String username);

    /**
     * update telenum
     * @param uid uid
     * @param telenum telephone number
     * @return if update operation success
     */
    boolean updateTelenum(@Param("uid") String uid, @Param("telenum") String telenum);

    /**
     * update email
     * @param uid uid
     * @param email email
     * @return if update operation success
     */
    boolean updateEmail(@Param("uid") String uid, @Param("email") String email);

    /**
     * update real name (need for permission)
     * @param uid uid
     * @param realname realname
     * @return if update operation success
     */
    boolean updateRealname(@Param("uid") String uid, @Param("realname") String realname);

    /**
     * update age (need for permission)
     * @param uid uid
     * @param age age
     * @return if update operation success
     */
    boolean updateAge(@Param("uid") String uid, @Param("age") int age);

    /**
     * update gender (need for permission)
     * @param uid uid
     * @param gender gender
     * @return if update operation success
     */
    boolean updateGender(@Param("uid") String uid, @Param("gender") String gender);

    /**
     * update password
     * @param uid uid
     * @param password password
     * @return if update operation success
     */
    boolean updatePassword(@Param("uid") String uid, @Param("pwd") String password);

    /**
     * count number of user by telephone number
     * @param telenum telephone number
     * @return number of user use telephone number: telenum
     */
    int countUserNumberByTelenum(@Param("telenum") String telenum);

    /**
     * count number of user by email number
     * @param email email address
     * @return number of user user email address: email
     */
    int countUserNumberByEmail(@Param("email") String email);

}
