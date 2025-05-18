package com.example.MoneyTransfer.event;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

// lobmok annotations 
@Data
@NoArgsConstructor


public class MoneyTransferredEvent {
    @Id
    @GeneratedValue
    private Integer id; 
    private  Integer fromUserId;
    private  Integer toUserId;
    private  Double amount;


  
    public MoneyTransferredEvent(Integer fromUserId, Integer toUserId, Double amount) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.amount = amount;
    }

   
}

