package com.buzhiming.model;

import java.util.Date;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_comment.id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_comment.user_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_comment.content
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_comment.target
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String target;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_comment.target_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String targetId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_comment.like_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_comment.comment_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_comment.create_time
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_comment.read_stuate
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Integer readStuate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_comment.id
     *
     * @return the value of h_comment.id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_comment.id
     *
     * @param id the value for h_comment.id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_comment.user_id
     *
     * @return the value of h_comment.user_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_comment.user_id
     *
     * @param userId the value for h_comment.user_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_comment.content
     *
     * @return the value of h_comment.content
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_comment.content
     *
     * @param content the value for h_comment.content
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_comment.target
     *
     * @return the value of h_comment.target
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getTarget() {
        return target;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_comment.target
     *
     * @param target the value for h_comment.target
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_comment.target_id
     *
     * @return the value of h_comment.target_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_comment.target_id
     *
     * @param targetId the value for h_comment.target_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId == null ? null : targetId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_comment.like_count
     *
     * @return the value of h_comment.like_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_comment.like_count
     *
     * @param likeCount the value for h_comment.like_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_comment.comment_count
     *
     * @return the value of h_comment.comment_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_comment.comment_count
     *
     * @param commentCount the value for h_comment.comment_count
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_comment.create_time
     *
     * @return the value of h_comment.create_time
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_comment.create_time
     *
     * @param createTime the value for h_comment.create_time
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_comment.read_stuate
     *
     * @return the value of h_comment.read_stuate
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Integer getReadStuate() {
        return readStuate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_comment.read_stuate
     *
     * @param readStuate the value for h_comment.read_stuate
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setReadStuate(Integer readStuate) {
        this.readStuate = readStuate;
    }
}