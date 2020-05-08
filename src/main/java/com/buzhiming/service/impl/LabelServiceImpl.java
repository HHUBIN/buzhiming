package com.buzhiming.service.impl;

import com.buzhiming.mapper.LabelMapper;
import com.buzhiming.model.Label;
import com.buzhiming.model.LabelExample;
import com.buzhiming.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;
    @Override
    public List<Label> getLabel() {
        List<Label> labels = labelMapper.selectByExample(new LabelExample());

        return labels;
    }

    @Override
    public List<Label> saveLabel(String name) {
        LabelExample labelExample = new LabelExample();
        labelExample.createCriteria().andNameEqualTo(name);
        List<Label> labels = labelMapper.selectByExample(labelExample);
        if(labels == null || labels.size() == 0){
            Label label = new Label();
            label.setName(name);
            labelMapper.insert(label);
        }
        return getLabel();
    }
}
