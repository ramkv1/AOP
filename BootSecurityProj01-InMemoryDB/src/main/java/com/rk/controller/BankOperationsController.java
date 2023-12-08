package com.rk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationsController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/balance")
	public String showBalance() {
		return "show_balance";
	}
	
	@GetMapping("/offers")
	public String showoffers() {
		return "offers";
	}
	
	@GetMapping("/loan")
	public String loanApprove() {
		return "loan_approve";
	}
	
	@GetMapping("/denied")
	public String accessDenied() {
		return "access_denied";
	}
}
