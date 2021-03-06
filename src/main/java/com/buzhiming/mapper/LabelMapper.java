package com.buzhiming.mapper;

import com.buzhiming.model.Label;
import com.buzhiming.model.LabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LabelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    long countByExample(LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    int deleteByExample(LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    int insert(Label record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    int insertSelective(Label record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    List<Label> selectByExampleWithRowbounds(LabelExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    List<Label> selectByExample(LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    Label selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    int updateByExampleSelective(@Param("record") Label record, @Param("example") LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    int updateByExample(@Param("record") Label record, @Param("example") LabelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    int updateByPrimaryKeySelective(Label record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_label
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    int updateByPrimaryKey(Label record);
}