package com.truongbn.security.service;

import com.truongbn.security.entities.Loan;

import java.util.ArrayList;

public interface LoanService {
    ArrayList<Loan> listLoans();

    Loan fetchLoan(Long loanId);

    Loan createLoan(Loan loan);

    Loan deleteLoan(Long loanId);
}
