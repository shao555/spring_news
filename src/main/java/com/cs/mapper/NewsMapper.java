package com.cs.mapper;

import com.cs.entity.News;

import java.util.List;
import java.util.Map;

public interface NewsMapper {

    //查询新闻表所有记录 select * from news
    public List<News> findAllNews() throws Exception;

    //查询新闻表所有信息的总记录数 select count(*) from news
    public int findByNewsCount() throws Exception;

    //修改新闻ID为XX的新闻标题和新闻内容
    public int updateNews(News news) throws Exception;

    //删除新闻ID为XX的新闻
    public int deleteNews(int newsID) throws Exception;

    //添加新闻
    public int addNews(News news) throws Exception;

    //查询新闻标题编号在5,6,7的新闻信息 数组传值
    public List<News> find1(Integer[] id) throws Exception;

    //查询新闻标题编号在5,6,7的新闻信息 集合传值
    public List<News> find2(List<Integer> list)throws Exception;

    //查询新闻标题编号在5,6,7的新闻信息 Map传值
    public List<News> find3(Map<String, Object> map);

}
