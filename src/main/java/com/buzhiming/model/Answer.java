package com.buzhiming.model;

import java.util.Date;

public class Answer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_answer.id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_answer.user_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_answer.ask_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String askId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_answer.like_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_answer.comment_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_answer.create_time
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_answer.update_time
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_answer.content
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_answer.id
     *
     * @return the value of h_answer.id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_answer.id
     *
     * @param id the value for h_answer.id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_answer.user_id
     *
     * @return the value of h_answer.user_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_answer.user_id
     *
     * @param userId the value for h_answer.user_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_answer.ask_id
     *
     * @return the value of h_answer.ask_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getAskId() {
        return askId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_answer.ask_id
     *
     * @param askId the value for h_answer.ask_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setAskId(String askId) {
        this.askId = askId == null ? null : askId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_answer.like_count
     *
     * @return the value of h_answer.like_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_answer.like_count
     *
     * @param likeCount the value for h_answer.like_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_answer.comment_count
     *
     * @return the value of h_answer.comment_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_answer.comment_count
     *
     * @param commentCount the value for h_answer.comment_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_answer.create_time
     *
     * @return the value of h_answer.create_time
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_answer.create_time
     *
     * @param createTime the value for h_answer.create_time
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_answer.update_time
     *
     * @return the value of h_answer.update_time
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_answer.update_time
     *
     * @param updateTime the value for h_answer.update_time
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_answer.content
     *
     * @return the value of h_answer.content
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_answer.content
     *
     * @param content the value for h_answer.content
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}