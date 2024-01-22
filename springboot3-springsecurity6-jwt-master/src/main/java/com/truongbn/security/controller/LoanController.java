package com.truongbn.security.controller;

import com.truongbn.security.entities.Loan;
import com.truongbn.security.service.LoanService;
import com.truongbn.security.service.impl.LoanServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {

    @Autowired
    private LoanService loanService;

    public LoanController(LoanServiceImpl loanService){
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<List<Loan>> listLoans() {
        ArrayList<Loan> loans = loanService.listLoans();
        return ResponseEntity.ok().body(loans);
    }

    @GetMapping("/{loan_id}")
    public ResponseEntity<Loan> loanDetails(@PathVariable Long loan_id) {
        Loan loan = loanService.fetchLoan(loan_id);
        return ResponseEntity.ok().body(loan);
    }

    @PostMapping("/")
    public ResponseEntity<List<Loan>> createLoan(@RequestParam Loan loan) {
        Loan newLoan = loanService.createLoan(loan);
        return ResponseEntity.created(URI.create("/" + newLoan.getId())).build();
    }

    @DeleteMapping("/{loan_id}")
    public ResponseEntity<Loan> deleteLoan(@PathVariable Long loan_id) {
        Loan loan = loanService.deleteLoan(loan_id);
        return ResponseEntity.noContent().build();
    }
}
