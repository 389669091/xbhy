package com.hxh.dao;

import com.hxh.utils.DBUtil;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @auth hxh
 * @date 2020/6/23 0:29
 * @Description
 */
public class BaseDao {
    public JdbcTemplate template=new JdbcTemplate(DBUtil.getDataSource());
}
