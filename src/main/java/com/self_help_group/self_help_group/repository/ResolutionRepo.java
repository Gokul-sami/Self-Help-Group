package com.self_help_group.self_help_group.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.self_help_group.self_help_group.domain.Resolution;

@Repository
public interface ResolutionRepo extends JpaRepository<Resolution, String> {
    // Resolution findByResolutionId(String resolutionId);

    public List<Resolution> findAll();
}