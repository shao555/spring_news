package com.cs.service.impl;

import com.cs.entity.News;
import com.cs.mapper.NewsMapper;
import com.cs.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("service")
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public List<News> findAllNews() throws Exception {
        return newsMapper.findAllNews();
//        return null;
    }

    @Override
    public int findByNewsCount() throws Exception {
        return newsMapper.findByNewsCount();
//        return 0;
    }

    @Override
    public int updateNews(News news) throws Exception {
        return newsMapper.updateNews(news);
//        return 0;
    }

    @Override
    public int deleteNews(int newsID) throws Exception {
        return newsMapper.deleteNews(newsID);
//        return 0;
    }

    @Override
    public int addNews(News news) throws Exception {
        return newsMapper.addNews(news);
//        return 0;
    }

    @Override
    public List<News> find1(Integer[] id) throws Exception {
        return newsMapper.find1(id);
//        return null;
    }

    @Override
    public List<News> find2(List<Integer> list) throws Exception {
        return newsMapper.find2(list);
//        return null;
    }

    @Override
    public List<News> find3(Map<String, Object> map) {
        return newsMapper.find3(map);
//        return null;
    }
}
