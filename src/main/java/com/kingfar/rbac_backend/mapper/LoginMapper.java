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
     * @param uid
     * @return
     */
    UserBasicInfo queryUserBasicInfoByUid(@Param("uid") String uid);

    /**
     * query user basic information by username
     *
     * @param username
     * @return
     */
    UserBasicInfo queryUserBasicInfoByUsername(@Param("username") String username);

    /**
     * query user basic information by telenum
     *
     * @param telenum
     * @return
     */
    UserBasicInfo queryUserBasicInfoByTelenum(@Param("telenum") String telenum);

    /**
     * query user basic information by email
     *
     * @param email
     * @return
     */
    UserBasicInfo queryUserBasicInfoByEmail(@Param("email") String email);

    /**
     * query user department information
     *
     * @param uid
     * @return
     */
    List<DepartInfo> queryDepartInfoByUid(@Param("uid") String uid);

    /**
     * query user group information
     *
     * @param uid
     * @return
     */
    List<GroupInfo> queryGroupInfoByUid(@Param("uid") String uid);

    /**
     * query user permission
     *
     * @param uid
     * @return
     */
    List<PermInfo> queryPermInfoByUid(@Param("uid") String uid);

    /**
     * query user role
     * @param uid
     * @return
     */
    List<RoleInfo> queryRoleInfoByUid(@Param("uid") String uid);

}
