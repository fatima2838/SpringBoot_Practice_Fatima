
package com.example.MoneyTransfer.controller;


import com.example.MoneyTransfer.entity.User;
import com.example.MoneyTransfer.service.TransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
public class TransactionController {


    //PUT mapping 
    @Autowired
    private TransferService transferService;

    // Use a DTO to receive multiple fields in the request body


     @PutMapping("/transfer")
    public void performTransaction( @RequestParam Integer fromUserId,
                                    @RequestParam Integer toUserId,
                                    @RequestParam double amount) {

        transferService.transferMoney(fromUserId,toUserId, amount);
     }
    

  
    
    
}
