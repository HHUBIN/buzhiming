package com.buzhiming.mapper;

import com.buzhiming.model.Answer;
import com.buzhiming.model.AnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AnswerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    long countByExample(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int deleteByExample(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int insert(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int insertSelective(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    List<Answer> selectByExampleWithBLOBsWithRowbounds(AnswerExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    List<Answer> selectByExampleWithBLOBs(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    List<Answer> selectByExampleWithRowbounds(AnswerExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    List<Answer> selectByExample(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    Answer selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Answer record, @Param("example") AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int updateByPrimaryKeySelective(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table h_answer
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    int updateByPrimaryKey(Answer record);
}