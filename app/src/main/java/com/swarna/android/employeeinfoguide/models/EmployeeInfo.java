package com.swarna.android.employeeinfoguide.models;


public class EmployeeInfo {

    private String startDate;
    private String endDate;
    private String name;
    private String url;
    private int loginRequired;
    private Venue venue;
    private String objType;
    private String icon;
    /**
     *
     * @return
     * The startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     * The startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     * The endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     * The endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The loginRequired
     */
    public int getLoginRequired() {
        return loginRequired;
    }

    /**
     *
     * @param loginRequired
     * The login_required
     */
    public void setLoginRequired(int loginRequired) {
        this.loginRequired = loginRequired;
    }

    /**
     *
     * @return
     * The venue
     */
    public Venue getVenue() {
        return venue;
    }

    /**
     *
     * @param venue
     * The venue
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     *
     * @return
     * The objType
     */
    public String getObjType() {
        return objType;
    }

    /**
     *
     * @param objType
     * The objType
     */
    public void setObjType(String objType) {
        this.objType = objType;
    }

    /**
     *
     * @return
     * The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @param icon
     * The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "EmployeeInfo [startDate=" + startDate + ", endDate=" + endDate
                + ", name=" + name + ", url=" + url + ", loginRequired="
                + loginRequired + ", venue=" + venue + ", objType=" + objType
                + ", icon=" + icon + "]";
    }

}
