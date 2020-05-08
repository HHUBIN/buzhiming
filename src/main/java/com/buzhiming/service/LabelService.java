package com.buzhiming.service;

import com.buzhiming.model.Label;

import java.util.List;

public interface LabelService {
    public List<Label> getLabel();
    public List<Label> saveLabel(String name);

}
