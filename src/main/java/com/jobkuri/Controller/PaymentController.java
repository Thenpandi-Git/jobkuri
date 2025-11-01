package com.jobkuri.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobkuri.DTO.PaymentRequestDTO;
import com.jobkuri.DTO.PaymentResponseDTO;
import com.jobkuri.Entity.Payment;
import com.jobkuri.Entity.SubscriptionPlan;
import com.jobkuri.Repository.PaymentRepository;
import com.jobkuri.Repository.SubscriptionPlanRepository;
import com.jobkuri.Service.InvoiceService;
import com.jobkuri.Service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private SubscriptionPlanRepository subPlanRepo;
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@PostMapping("/process")
	public ResponseEntity<PaymentResponseDTO>process(@RequestBody PaymentRequestDTO dto ){
		return ResponseEntity.ok(paymentService.processPayment(dto));
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<SubscriptionPlan>>getPlans(){
		return ResponseEntity.ok(subPlanRepo.findAll());
	}
	@PostMapping("/plans")
	public ResponseEntity<SubscriptionPlan>createPlans(@RequestBody SubscriptionPlan plan){
		return ResponseEntity.ok(subPlanRepo.save(plan));
	}
    @GetMapping("/history/{userId}")
    public ResponseEntity<List<Payment>>history(@PathVariable Long userId){
    	return ResponseEntity.ok(paymentRepo.findByUserId(userId));
    }
	
	
    @GetMapping("/invoice/{paymentId}")
	public ResponseEntity<byte[]>downloadInvoice(@PathVariable Long paymentId){
		
		Payment payment = paymentRepo.findById(paymentId).orElseThrow(()-> new RuntimeException("Payment not found"));
		byte[] pdfBytes = invoiceService.generateInvoice(payment);
		
		return ResponseEntity.ok()
				.header("Content-Disposition", "Attachment; fileName=Invoice-" +payment.getTransactionId() + ".pdf")
				.contentType(org.springframework.http.MediaType.APPLICATION_PDF).body(pdfBytes);
	}
	
}
