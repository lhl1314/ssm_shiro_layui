package com.zjitc.layui.dao;

import com.zjitc.layui.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IDEA
 * author:lhl
 * Date:2019/3/28 0028
 * Time:17:07
 */
@Mapper
public interface UserDao {
    /**
     * 查看
     * @return
     */
    List<User>getAll();

    /**
     * 增加
     * @param user
     */
    void add(User user);

    /**
     * 删除
     * @param id
     */
    void delete(int id);

    /**
     * 改
     * @param user
     */
    void update(User user);

    /**
     * 查
     * @param id
     * @return
     */
    User getOne(int id);
}
