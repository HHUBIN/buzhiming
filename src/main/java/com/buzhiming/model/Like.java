package com.buzhiming.model;

public class Like {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_like.id
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_like.target_id
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    private String targetId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_like.user_id
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    private String userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_like.id
     *
     * @return the value of h_like.id
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_like.id
     *
     * @param id the value for h_like.id
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_like.target_id
     *
     * @return the value of h_like.target_id
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_like.target_id
     *
     * @param targetId the value for h_like.target_id
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId == null ? null : targetId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_like.user_id
     *
     * @return the value of h_like.user_id
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_like.user_id
     *
     * @param userId the value for h_like.user_id
     *
     * @mbg.generated Fri Jun 05 20:18:38 CST 2020
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}