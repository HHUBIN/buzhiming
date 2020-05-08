package com.buzhiming.service.impl;

import com.buzhiming.mapper.LabelRelatedMapper;
import com.buzhiming.model.LabelRelated;
import com.buzhiming.service.LabelRelatedService;
import org.springframework.beans.factory.annotation.Autowired;

public class LabelRelatedServiceImpl implements LabelRelatedService {
    @Autowired
    private LabelRelatedMapper labelRelatedMapper;
    @Override
    public void save(LabelRelated labelRelated) {
        labelRelatedMapper.insert(labelRelated);
    }
}
