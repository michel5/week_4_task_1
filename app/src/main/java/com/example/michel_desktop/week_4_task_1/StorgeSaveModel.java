package com.example.michel_desktop.week_4_task_1;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

@Entity(tableName = "storgelocatie")
public class StorgeSaveModel implements Serializable {

    /**
     * Constructor
     * @param titel titel
     * @param platform platform
     * @param notie noties
     * @param status de status
     */
    public StorgeSaveModel(String titel, String platform, String notie,
                           String status, String datum) {
        this.titel = titel;
        this.platform = platform;
        this.notie = notie;
        this.status = status;
        this.datum = datum;
    }

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "titel")
    private String titel;

    @ColumnInfo(name = "platform")
    private String platform;

    @ColumnInfo(name = "notie")
    private String notie;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "datum")
    private String datum;

    public Long getId() {
        return id;
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

    public String getDatum() {
        return datum;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
