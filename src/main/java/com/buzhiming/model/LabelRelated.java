package com.buzhiming.model;

public class LabelRelated {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_label_related.id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_label_related.target_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private String targetId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_label_related.label_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Integer labelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column h_label_related.type
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    private Integer type;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_label_related.id
     *
     * @return the value of h_label_related.id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_label_related.id
     *
     * @param id the value for h_label_related.id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_label_related.target_id
     *
     * @return the value of h_label_related.target_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_label_related.target_id
     *
     * @param targetId the value for h_label_related.target_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setTargetId(String targetId) {
        this.targetId = targetId == null ? null : targetId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_label_related.label_id
     *
     * @return the value of h_label_related.label_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Integer getLabelId() {
        return labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_label_related.label_id
     *
     * @param labelId the value for h_label_related.label_id
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column h_label_related.type
     *
     * @return the value of h_label_related.type
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column h_label_related.type
     *
     * @param type the value for h_label_related.type
     *
     * @mbg.generated Sun May 03 22:05:49 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }
}