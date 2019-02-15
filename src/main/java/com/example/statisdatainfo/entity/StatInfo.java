package com.example.statisdatainfo.entity;

import java.util.Date;

public class StatInfo {
    private Integer statisticsid;

    private Integer docid;

    private String doctitle;

    private Integer docchannel;

    private Date docpubtime;

    private Date docclickdate;

    private Integer docclickcount;

    public Integer getStatisticsid() {
        return statisticsid;
    }

    public void setStatisticsid(Integer statisticsid) {
        this.statisticsid = statisticsid;
    }

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }

    public String getDoctitle() {
        return doctitle;
    }

    public void setDoctitle(String doctitle) {
        this.doctitle = doctitle == null ? null : doctitle.trim();
    }

    public Integer getDocchannel() {
        return docchannel;
    }

    public void setDocchannel(Integer docchannel) {
        this.docchannel = docchannel;
    }

    public Date getDocpubtime() {
        return docpubtime;
    }

    public void setDocpubtime(Date docpubtime) {
        this.docpubtime = docpubtime;
    }

    public Date getDocclickdate() {
        return docclickdate;
    }

    public void setDocclickdate(Date docclickdate) {
        this.docclickdate = docclickdate;
    }

    public Integer getDocclickcount() {
        return docclickcount;
    }

    public void setDocclickcount(Integer docclickcount) {
        this.docclickcount = docclickcount;
    }
}