package com.revature.GroupDP2.controllers;



import com.revature.GroupDP2.model.Payment;
import com.revature.GroupDP2.services.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    final
    PaymentService paySerRepo;

    public PaymentController(PaymentService paySerRepo) {
        this.paySerRepo = paySerRepo;
    }


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
        paySerRepo.save(payment);
        //use a redirect to prevent duplicate submission
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updatePaymentForm(@RequestParam("id") Integer paymentId, Model model) {

        Optional<Payment> payment = paySerRepo.getPaymentById(paymentId);
        model.addAttribute("payment", payment);
        return "/update-payment";
    }

    @GetMapping("/delete")
    public String deleteApayment(@RequestParam("id") Integer paymentId) {

        Payment payment = paySerRepo.getPaymentById(paymentId).get();
        paySerRepo.delete(payment);
        return "redirect:/payments/list";
    }

    @GetMapping("/list")
    public String displayPaymentList(Model model) {
        List<Payment> aPaymet = paySerRepo.getAll();
        model.addAttribute("payment",aPaymet);
        return "payments-list";
    }

}


