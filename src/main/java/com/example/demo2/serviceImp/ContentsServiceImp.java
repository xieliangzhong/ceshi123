package com.example.demo2.serviceImp;

import com.example.demo2.dao.ContentsDao;
import com.example.demo2.entity.Contents;
import com.example.demo2.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContentsServiceImp implements ContentsService {
    @Autowired
    private ContentsDao contentsDao;
    @Override
    public List<Contents> contentsList() {
        return contentsDao.selectAll();
    }
}
