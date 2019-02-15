package com.example.statisdatainfo.entity;

public class DocmentWithBLOBs extends Docment {
    private String doccontent;

    private String dochtmlcon;

    private String docpubhtmlcon;

    public String getDoccontent() {
        return doccontent;
    }

    public void setDoccontent(String doccontent) {
        this.doccontent = doccontent == null ? null : doccontent.trim();
    }

    public String getDochtmlcon() {
        return dochtmlcon;
    }

    public void setDochtmlcon(String dochtmlcon) {
        this.dochtmlcon = dochtmlcon == null ? null : dochtmlcon.trim();
    }

    public String getDocpubhtmlcon() {
        return docpubhtmlcon;
    }

    public void setDocpubhtmlcon(String docpubhtmlcon) {
        this.docpubhtmlcon = docpubhtmlcon == null ? null : docpubhtmlcon.trim();
    }
}