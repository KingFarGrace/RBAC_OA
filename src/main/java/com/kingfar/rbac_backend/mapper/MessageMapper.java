package com.kingfar.rbac_backend.mapper;

import com.kingfar.rbac_backend.pojo.DepartMessage;
import com.kingfar.rbac_backend.pojo.GroupMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZKH
 */
@Mapper
@Repository
public interface MessageMapper {

    /**
     * insert group message
     * @param groupName
     * @param uid
     * @param content
     * @param isFromUser
     * @return
     */
    boolean setGroupMessage(@Param("gname") String groupName,
                            @Param("uid") String uid,
                            @Param("content") String content,
                            @Param("is_from_user") boolean isFromUser);

    /**
     * insert department message
     * @param departName
     * @param uid
     * @param content
     * @param isFromUser
     * @return
     */
    boolean setDepartMessage(@Param("dname") String departName,
                             @Param("uid") String uid,
                             @Param("content") String content,
                             @Param("is_from_user") boolean isFromUser);

    /**
     * search department announcement
     * @return
     */
    List<DepartMessage> querySystemAnnouncement();

    /**
     * search department announcement
     * @param departName
     * @return
     */
    List<DepartMessage> queryDepartAnnouncement(@Param("dname") String departName);

    /**
     * search department messages
     * @param departName
     * @param uid
     * @return
     */
    List<DepartMessage> queryDepartMessage(@Param("dname") String departName,
                                           @Param("uid") String uid);

    /**
     * search group announcement
     * @param groupName
     * @return
     */
    List<GroupMessage> queryGroupAnnouncement(@Param("gname") String groupName);

    /**
     * search group messages
     * @param groupName
     * @param uid
     * @return
     */
    List<GroupMessage> queryGroupMessage(@Param("gname") String groupName,
                                         @Param("uid") String uid);

}
