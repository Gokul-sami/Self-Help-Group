package com.self_help_group.self_help_group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_help_group.self_help_group.repository.ResolutionRepo;
import com.self_help_group.self_help_group.domain.Resolution;

@Service
public class ResolutionService {
    @Autowired
    private ResolutionRepo res;

    public List<Resolution> getAllResolutions() {
        return res.findAll();
    }

    public Resolution addResolution(String res_name, String description, String res_date, String res_start_time, String res_end_time, String resTopics, String resMembers) {
        Resolution resolutionData = new Resolution(res_name, description, res_date, res_start_time, res_end_time, resTopics, resMembers);
        return res.save(resolutionData);
    }
}
