package com.example.demo2.dao;

import com.example.demo2.entity.User;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface UserDao extends Mapper<User> {
    /**
     * 根据id查询
     * @param userId
     * @return
     */
    public User selectUserByUserId(String userId);

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    public User selectUserByUserName(String userName);

    /**
     * 根据手机号查询
     * @param phone
     * @return
     */
    public User selectUserByPhone(String phone);

    /**
     *
     * @param email
     * @return
     */
    public User selectUserByEmail(String email);

    /**
     * 根据企业名查询
     * @param enterpriseName
     * @return
     */
    public User selectUserByEnterpriseName(String enterpriseName);

    /**
     * 根据用户名和密码查询
     * @param userName
     * @param password
     * @return
     */
    public User selectUserByUserNameAndPassword(String userName, String password);

    /**
     *
     * @param user
     * @return
     */
    public int updateById(User user);

    /**
     *
     * @param user
     * @return
     */
    public int add(User user);
}
