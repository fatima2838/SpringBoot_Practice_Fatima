package com.example.MoneyTransfer.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;


import com.example.MoneyTransfer.dao.UserRepository;
import com.example.MoneyTransfer.entity.User;
import com.example.MoneyTransfer.event.MoneyTransferredEvent;
import jakarta.transaction.Transactional;

@Service
public class TransferService {

    // transaction annotation creates context ??? 
   @Autowired
    private  UserRepository user_repo;
    @Autowired
    private  ApplicationEventPublisher eventPublisher;

    

    @Transactional
    public void transferMoney(Integer fromUserId, Integer toUserId, Double amount) {

        // 1. check if the sender has enough 
                //  repo->getuserobject->getuserbalance 

             User toUser =    user_repo.findById(toUserId).get(); 
             User fromUser = user_repo.findById(fromUserId).get(); 

             if (fromUser.getBalance() >=amount){
                // logic transfer 
                fromUser.setBalance(fromUser.getBalance()-amount);
                toUser.setBalance(toUser.getBalance()+amount);

        
             eventPublisher.publishEvent(new MoneyTransferredEvent(fromUserId, toUserId, amount));
                
             }

       

    }
}
