package com.truongbn.security.service.impl;

import com.truongbn.security.entities.Loan;
import com.truongbn.security.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {


    @Override
    public ArrayList<Loan> listLoans() {
        return null;
    }

    @Override
    public Loan fetchLoan(Long loanId) {
        return null;
    }

    @Override
    public Loan createLoan(Loan loan) {
        return null;
    }

    @Override
    public Loan deleteLoan(Long loanId) {
        return null;
    }
}
