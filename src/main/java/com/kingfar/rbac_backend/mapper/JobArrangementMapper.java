package com.kingfar.rbac_backend.mapper;

import com.kingfar.rbac_backend.pojo.GroupDetailInfo;
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
     * @param gname
     * @return gid, group name, group code, number of member in group, members' realname/username
     */
    GroupDetailInfo queryGroupDetailInfo(@Param("gname") String gname);

}
