package com.self_help_group.self_help_group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_help_group.self_help_group.domain.Savings;
import com.self_help_group.self_help_group.repository.SavingsRepo;

@Service
public class SavingsService {
    @Autowired
    private SavingsRepo sav;

    public List<Savings> getSavings() {
        List<Savings> list = sav.findAll();
        for (Savings s : list) {
            System.out.println(s.getMonth() + " " + s.getYear() + " " + s.getAmount());
        }
        return list;
    }

    public Savings addSavings(int year, String month, double amount) {
        Savings savingsData = new Savings(year, month, amount);
        return sav.save(savingsData);
    }
}
