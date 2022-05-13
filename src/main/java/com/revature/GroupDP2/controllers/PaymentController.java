package com.revature.GroupDP2.controllers;



import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    PaymentService paySereRepo;


    @GetMapping("/add")
    public String addPaymentForm(Model model) {

        Payment aPayment = new Payment();
        model.addAttribute("payment", aPayment);


        return "add-payment";
    }

    @PostMapping("/save")
    public String addPayment(@Valid Payment payment, Errors errors) {
        if(errors.hasErrors())
            return "add-payment";
        //save to the database using a payment crud repository
        System.out.println(payment);
        paySereRepo.save(payment);
        //use a redirect to prevent duplicate submission
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updatePaymentForm(@RequestParam("id") Integer paymentId, Model model) {

        Payment payment = paySereRepo.getPaymentById(paymentId);
        model.addAttribute("payment", payment);
        return "/update-payment";
    }

    @GetMapping("/delete")
    public String deleteApayment(@RequestParam("id") Integer paymentId, Model model) {

        Payment payment = paySereRepo.getPaymentById(paymentId);
        paySereRepo.delete(payment);
        return "redirect:/payments/list";
    }

    @GetMapping("/list")
    public String displayPaymentList(Model model) {
        List<Payment> aPaymet = paySereRepo.getAll();
        model.addAttribute("payment",aPaymet);
        return "payments-list";
    }

}


