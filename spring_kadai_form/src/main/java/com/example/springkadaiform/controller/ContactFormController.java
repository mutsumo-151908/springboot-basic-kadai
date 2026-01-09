package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	//お問い合わせフォームを表示させる
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "confirmView";
	}
	
	//送信を押したとき
	@PostMapping("/confirm")
	public String submitForm(@Validated ContactForm contactForm, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "confirmView";
		}
		return "contactFormView";
	}

}
