package com.jobkuri.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobkuri.DTO.PaymentRequestDTO;
import com.jobkuri.DTO.PaymentResponseDTO;
import com.jobkuri.Entity.Payment;
import com.jobkuri.Enum.PaymentStatus;
import com.jobkuri.Repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	
	public PaymentResponseDTO processPayment(PaymentRequestDTO dto) {
		Payment pay = new Payment();
		pay.setUserId(dto.getUserId());
		pay.setPlanId(dto.getPlanId());
		pay.setAmount(dto.getAmount());
		pay.setPaymentStatus(PaymentStatus.SUCCESS);
		pay.setTransactionId(UUID.randomUUID().toString());
		pay.setTimeStamp(LocalDateTime.now());
		
		paymentRepo.save(pay);
		
		PaymentResponseDTO response = new PaymentResponseDTO();
		response.setTransactionId(pay.getTransactionId());
		response.setPaymentStatus(pay.getPaymentStatus());
		response.setAmount(pay.getAmount());
		return response;
	}

}



