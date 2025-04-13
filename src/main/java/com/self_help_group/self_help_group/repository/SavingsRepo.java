package com.self_help_group.self_help_group.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.self_help_group.self_help_group.domain.Savings;

@Repository
public interface SavingsRepo extends JpaRepository<Savings, Double>  {
    public List<Savings> findAll();
}
