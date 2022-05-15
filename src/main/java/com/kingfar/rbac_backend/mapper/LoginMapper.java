package com.kingfar.rbac_backend.mapper;

import com.kingfar.rbac_backend.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZKH
 */
@Mapper
@Repository
public interface LoginMapper {

    /**
     * query user basic information by uid
     *
     * @param uid uid
     * @return {@link UserBasicInfo}
     */
    UserBasicInfo queryUserBasicInfoByUid(@Param("uid") String uid);

    /**
     * query user basic information by username
     *
     * @param username username
     * @return {@link UserBasicInfo}
     */
    UserBasicInfo queryUserBasicInfoByUsername(@Param("username") String username);

    /**
     * query user basic information by telenum
     *
     * @param telenum telephone number
     * @return {@link UserBasicInfo}
     */
    UserBasicInfo queryUserBasicInfoByTelenum(@Param("telenum") String telenum);

    /**
     * query user basic information by email
     *
     * @param email email address
     * @return {@link UserBasicInfo}
     */
    UserBasicInfo queryUserBasicInfoByEmail(@Param("email") String email);

    /**
     * query user department information
     *
     * @param uid uid
     * @return List of {@link DepartInfo}
     */
    List<DepartInfo> queryDepartInfoByUid(@Param("uid") String uid);

    /**
     * query user group information
     *
     * @param uid uid
     * @return List of {@link GroupInfo}
     */
    List<GroupInfo> queryGroupInfoByUid(@Param("uid") String uid);

    /**
     * query user permission
     *
     * @param uid uid
     * @return List of {@link PermInfo}
     */
    List<PermInfo> queryPermInfoByUid(@Param("uid") String uid);

    /**
     * query user role
     * @param uid uid
     * @return List of {@link RoleInfo}
     */
    List<RoleInfo> queryRoleInfoByUid(@Param("uid") String uid);

}
