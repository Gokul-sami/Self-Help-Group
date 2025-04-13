package com.self_help_group.self_help_group.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resolution")
public class Resolution {
    @Id
    private String res_name;
    private String description;
    private String res_date;
    private String res_start_time;
    private String res_end_time;
    private String resTopics;
    private String resMembers;

    public Resolution() {}

    public Resolution(String res_name, String description, String res_date, String res_start_time, String res_end_time, String resTopics, String resMembers) {
        this.res_name = res_name;
        this.description = description;
        this.res_date = res_date;
        this.res_start_time = res_start_time;
        this.res_end_time = res_end_time;
        this.resTopics = resTopics;
        this.resMembers = resMembers;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRes_date() {
        return res_date;
    }

    public void setRes_date(String res_date) {
        this.res_date = res_date;
    }

    public String getRes_start_time() {
        return res_start_time;
    }

    public void setRes_start_time(String res_start_time) {
        this.res_start_time = res_start_time;
    }

    public String getRes_end_time() {
        return res_end_time;
    }

    public void setRes_end_time(String res_end_time) {
        this.res_end_time = res_end_time;
    }

    public String getResTopics() {
        return resTopics;
    }

    public void setResTopics(String resTopics) {
        this.resTopics = resTopics;
    }

    public String getResMembers() {
        return resMembers;
    }

    public void setResMembers(String resMembers) {
        this.resMembers = resMembers;
    }
}
