package com.luka.goodspro.service.impl;

import com.luka.goodspro.bean.Brank;
import com.luka.goodspro.mapper.BrankMapper;
import com.luka.goodspro.service.BrankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrankServiceImpl implements BrankService {

    @Autowired
    private BrankMapper brankMapper;

    @Override
    public void insert(Brank brank) {
        brankMapper.insert(brank);
    }
}
