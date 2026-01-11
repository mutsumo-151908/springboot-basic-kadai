package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        // FlashAttributesで送られてきたデータがない場合のみ、新しいインスタンスを作成
        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }
        return "contactFormView";
    }

    @PostMapping("/confirm")
    public String confirm(@ModelAttribute @Validated ContactForm contactForm, 
                          BindingResult result, 
                          RedirectAttributes redirectAttributes) {
        
        if (result.hasErrors()) {
            // エラー情報をリダイレクト先に引き継ぐための設定
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
            // 入力内容をリダイレクト先に引き継ぐ
            redirectAttributes.addFlashAttribute("contactForm", contactForm);
            
            return "redirect:/form"; // ここでリダイレクト
        }
        
        return "confirmView";
    }
}