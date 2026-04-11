package com.smartbudget.smartbudget.service;

import com.smartbudget.smartbudget.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // GET ALL
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // ADD
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // DELETE
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // UPDATE
    public Expense updateExpense(Long id, Expense updatedExpense) {
        Expense expense = expenseRepository.findById(id).orElse(null);
        if (expense != null) {
            expense.setTitle(updatedExpense.getTitle());
            expense.setAmount(updatedExpense.getAmount());
            return expenseRepository.save(expense);
        }
        return null;
    }
}