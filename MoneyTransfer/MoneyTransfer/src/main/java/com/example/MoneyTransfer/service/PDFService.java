package com.example.MoneyTransfer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.example.MoneyTransfer.event.MoneyTransferredEvent;



@Service
public class PDFService {

   @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
   
    public void handleTransferEvent(MoneyTransferredEvent event) {
        System.out.println(event.toString());
    }
}

