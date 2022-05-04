package com.upc.homemade.securityservice.services;

import com.upc.homemade.securityservice.entities.Payment;

public interface PaymentService extends CrudService<Payment, Long>{
    Payment getPaymentById(Long aLong);
}
