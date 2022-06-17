package com.upc.homemade.paymentservice.services;

import com.upc.homemade.paymentservice.entities.Payment;

public interface PaymentService extends CrudService<Payment,Long> {
    Payment getPaymentById(Long aLong);
}
