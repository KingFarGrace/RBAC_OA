package com.kingfar.rbac_backend.mapper;

import com.kingfar.rbac_backend.pojo.DepartDetailInfo;
import com.kingfar.rbac_backend.pojo.DepartInfo;
import com.kingfar.rbac_backend.pojo.GroupDetailInfo;
import com.kingfar.rbac_backend.pojo.GroupInfo;
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
     * @param groupName
     * @return see details in {@link com.kingfar.rbac_backend.pojo.GroupInfo}
     */
    GroupInfo queryGroupInfoByGroupName(@Param("gname") String groupName);

    /**
     * count number of group in certain name
     * @param groupName
     * @return
     */
    int countGroupNumberByName(@Param("gname") String groupName);

    /**
     * count number of group in certain code
     * @param groupCode
     * @return
     */
    int countGroupNumberByCode(@Param("gcode") String groupCode);

    /**
     * query department basic by certain name
     * @param departName
     * @return see details in {@link com.kingfar.rbac_backend.pojo.DepartInfo}
     */
    DepartInfo queryDepartInfoByDepartName(@Param("dname") String departName);

    /**
     * count number of department in certain name
     * @param departName
     * @return
     */
    int countDepartNumberByName(@Param("dname") String departName);

    /**
     * count number of department in certain code
     * @param departCode
     * @return
     */
    int countDepartNumberByCode(@Param("dcode") String departCode);

    /**
     * establish new group(need for permission)
     * @param groupName
     * @param groupCode
     * @return success to set a new group or not
     */
    boolean setNewGroup(@Param("gname") String groupName, @Param("gcode") String groupCode);

    /**
     * establish new department(need for permission)
     * @param departName
     * @param departCode
     * @return success to set a new department or not
     */
    boolean setNewDepartment(@Param("dname") String departName, @Param("dcode") String departCode);

    /**
     * establish new role/job(need for permission)
     * @param roleName
     * @param roleCode
     * @return success to set a new role or not
     */
    boolean setNewRole(@Param("rname") String roleName, @Param("rcode") String roleCode);

    /**
     * query for group detail information
     * @param groupName
     * @return gid, group name, group code, number of member in group, members' realname/username
     */
    GroupDetailInfo queryGroupDetailInfo(@Param("gname") String groupName);

    /**
     * query for department detail information
     * @param departName
     * @return did, department name, department code, number of member in group, members' realname
     */
    DepartDetailInfo queryDepartDetailInfo(@Param("dname") String departName);

}
