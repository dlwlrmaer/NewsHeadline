package com.atguigu.headline.dao.impl;
import com.atguigu.headline.dao.BaseDao;
import com.atguigu.headline.dao.NewsUserDao;
import com.atguigu.headline.pojo.NewsUser;

import java.util.List;

public class NewsUserDaoImpl extends BaseDao implements NewsUserDao{

    @Override
    public NewsUser findByUsername(String username) {
        String sql = """
                select
                uid,
                username,
                user_pwd userPwd,
                nick_name nickName
                from
                news_user
                where username = ?
                """;
        List<NewsUser> newsUserList = baseQuery(NewsUser.class, sql, username);
        if(null != newsUserList && newsUserList.size() > 0) {
            return newsUserList.get(0);
        }
        return null;
    }
}
