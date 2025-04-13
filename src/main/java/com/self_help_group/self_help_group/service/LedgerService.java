package com.self_help_group.self_help_group.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self_help_group.self_help_group.repository.LedgerRepository;
import com.self_help_group.self_help_group.domain.Ledger;

@Service
public class LedgerService {
    @Autowired
    private LedgerRepository res;

    public List<Ledger> getLedger() {
        return res.findAll();
    }

    public Ledger addLedger(String date, String description, double credit, double debit, double balance) {
        Ledger ledgerData = new Ledger(date, description, credit, debit, balance);
        return res.save(ledgerData);
    }
}
