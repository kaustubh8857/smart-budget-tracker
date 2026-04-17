package com.smartbudget.smartbudget.controller;

import com.smartbudget.smartbudget.model.Expense;
import com.smartbudget.smartbudget.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // GET ALL
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // ADD
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id,
                                  @RequestBody Expense updatedExpense) {
        return expenseService.updateExpense(id, updatedExpense);
    }
}

 