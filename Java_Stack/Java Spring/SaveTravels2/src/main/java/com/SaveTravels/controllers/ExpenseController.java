package com.SaveTravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SaveTravels.models.Expense;
import com.SaveTravels.services.ExpenseService;

@Controller
public class ExpenseController {
    
	@Autowired
	ExpenseService expenseService;
    
    @GetMapping("/expenses")
    public String index(Model model, @ModelAttribute("expense") Expense expense) {
    	List<Expense> allExpenses = expenseService.allExpenses();
    	model.addAttribute("allExpenses", allExpenses);
        return "index.jsp";
    }
    
    
    @PostMapping("/expenses")
    public String showBook(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Expense> allExpenses = expenseService.allExpenses();
        	model.addAttribute("allExpenses", allExpenses);
            return "index.jsp";
        } else {
        	expenseService.createExpense(expense);
        	return "redirect:/expenses";
        }
    }
    
}