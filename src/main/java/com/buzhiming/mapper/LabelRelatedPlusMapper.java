package com.buzhiming.mapper;

import com.buzhiming.model.Label;
import com.buzhiming.model.LabelRelated;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LabelRelatedPlusMapper {
    void insertLabelRelated(@Param("labelRelateds")List<LabelRelated> labelRelateds);
    List<Label> selectLabelById(String id);
}
