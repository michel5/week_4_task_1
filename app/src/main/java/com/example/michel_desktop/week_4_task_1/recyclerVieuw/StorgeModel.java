package com.example.michel_desktop.week_4_task_1.recyclerVieuw;

public class StorgeModel {
    private String titel;
    private String platform;
    private String notie;
    private String status;
    private String datum;

    /**
     * Constructor
     * @param titel titel
     * @param platform platform
     * @param notie noties
     * @param status de status
     */
    public StorgeModel(String titel, String platform, String notie, String status, String datum) {
        this.titel = titel;
        this.platform = platform;
        this.notie = notie;
        this.status = status;
        this.datum = datum;
    }

    public String getTitel() {
        return titel;
    }

    public String getPlatform() {
        return platform;
    }

    public String getNotie() {
        return notie;
    }

    public String getStatus() {
        return status;
    }

    public String getDatum(){
        return datum;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setNotie(String notie) {
        this.notie = notie;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
