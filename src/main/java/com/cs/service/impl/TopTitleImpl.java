package com.cs.service.impl;

import com.cs.entity.TopTitle;
import com.cs.mapper.TopTitleMapper;
import com.cs.service.TopTitleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("service2")
public class TopTitleImpl implements TopTitleService {

    @Resource
    private TopTitleMapper topTitleMapper;

    @Override
    public List<TopTitle> findAllTopTitle() throws Exception {
        return topTitleMapper.findAllTopTitle();
//        return null;
    }
}
