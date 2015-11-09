package com.swarna.android.employeeinfoguide.models;


import java.util.ArrayList;
import java.util.List;

public class EmployeeInfoResponseModel {

    private String total;
    private List<EmployeeInfo> data = new ArrayList<EmployeeInfo>();

    /**
     *
     * @return
     * The total
     */
    public String getTotal() {
        return total;
    }

    /**
     *
     * @param total
     * The total
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     *
     * @return
     * The data
     */
    public List<EmployeeInfo> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<EmployeeInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EmployeeInfoResponseModel [total=" + total + ", data=" + data
                + "]";
    }
}
