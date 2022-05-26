package com.kingfar.rbac_backend.mapper;

import com.kingfar.rbac_backend.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ZKH
 */
@Repository
@Mapper
public interface JobArrangementMapper {

    /**
     * query group basic info by group name
     * @param groupName name of group
     * @return see details in {@link com.kingfar.rbac_backend.pojo.GroupInfo}
     */
    GroupInfo queryGroupInfoByGroupName(@Param("gname") String groupName);

    /**
     * count number of group in certain name
     * @param groupName name of group
     * @return number of group in name: groupName
     */
    int countGroupNumberByName(@Param("gname") String groupName);

    /**
     * count number of group in certain code
     * @param groupCode code of group
     * @return number of group with code：groupCode
     */
    int countGroupNumberByCode(@Param("gcode") String groupCode);

    /**
     * query department basic info by certain name
     * @param departName name of department
     * @return see details in {@link com.kingfar.rbac_backend.pojo.DepartInfo}
     */
    DepartInfo queryDepartInfoByDepartName(@Param("dname") String departName);

    /**
     * count number of department in certain name
     * @param departName name of department
     * @return number of department in name: departName
     */
    int countDepartNumberByName(@Param("dname") String departName);

    /**
     * count number of department in certain code
     * @param departCode name of department
     * @return number of department with code: departCode
     */
    int countDepartNumberByCode(@Param("dcode") String departCode);

    /**
     * query role basic info by role name
     * @param roleName name of role
     * @return see details in {@link com.kingfar.rbac_backend.pojo.RoleInfo}
     */
    RoleInfo queryRoleInfoByRoleName(@Param("rname") String roleName);

    /**
     * count number of role in certain name
     * @param roleName name of role
     * @return number of role in name: roleName
     */
    int countRoleNumberByName(@Param("rname") String roleName);

    /**
     * count number of role in certain code
     * @param roleCode code of role
     * @return number of role with code: roleCode
     */
    int countRoleNumberByCode(@Param("rcode") String roleCode);

    /**
     * establish new group(need for permission)
     * @param groupName name of group
     * @param groupCode code of group
     * @return success vo set a new group or not
     */
    boolean setNewGroup(@Param("gname") String groupName, @Param("gcode") String groupCode);

    /**
     * establish new department(need for permission)
     * @param departName name of department
     * @param departCode code of department
     * @return success vo set a new department or not
     */
    boolean setNewDepartment(@Param("dname") String departName, @Param("dcode") String departCode);

    /**
     * establish new role/job(need for permission)
     * @param roleName name of role
     * @param roleCode code of role
     * @return success vo set a new role or not
     */
    boolean setNewRole(@Param("rname") String roleName, @Param("rcode") String roleCode);

    /**
     * query for group detail information
     * @param groupName name of group
     * @return gid, group name, group code, number of member in group, members' realname/username
     */
    GroupDetailInfo queryGroupDetailInfo(@Param("gname") String groupName);

    /**
     * query for department detail information
     * @param departName name of department
     * @return did, department name, department code, number of member in group, members' realname
     */
    DepartDetailInfo queryDepartDetailInfo(@Param("dname") String departName);

    /**
     * associate user with group
     * @param uid uid
     * @param groupName name of group
     * @param isLeader if this user is leader of group
     * @return if insert operation success
     */
    boolean setUserInGroup(@Param("uid") String uid, @Param("gname") String groupName, @Param("is_leader") boolean isLeader);

    /**
     * associate user with department
     * @param uid uid
     * @param departName name of department
     * @param isLeader if this user is leader of department
     * @return if insert operation success
     */
    boolean setUserInDepartment(@Param("uid") String uid, @Param("dname") String departName, @Param("is_leader") boolean isLeader);

    /**
     * associate user with role
     * @param uid uid
     * @param roleName name of role
     * @return if insert operation success
     */
    boolean setUserInRole(@Param("uid") String uid, @Param("rname") String roleName);

}
