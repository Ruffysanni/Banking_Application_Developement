package com.example.Banking_Application_Developement.controller;


import com.example.Banking_Application_Developement.model.AccountUser;
import com.example.Banking_Application_Developement.service.AccountUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class AccountUserController {
    @Autowired
    private AccountUserService accountUserService;

    // Create endpoints

    // Get all Account Users
    @GetMapping("/allAccountUsers")
    public ResponseEntity<List<AccountUser>> getAllAccountUsers(){
        return accountUserService.getAllAccountUsers();
    }

    // Get Account User By Id
    @GetMapping("/account_user_id")
    public ResponseEntity<AccountUser> getAccountUserById(@PathVariable int id){
        return accountUserService.getAccountUserById(id);
    }

    // Get Account User By Phone Number
    @GetMapping("/account_user_phone_number")
    public ResponseEntity<AccountUser> getAccountUserByPhone(@PathVariable String phoneNumber){
        return accountUserService.getAccountUserByPhoneNumber(phoneNumber);
    }
    // Get Account User By Email
    @GetMapping("/account_user_phone_number")
    public ResponseEntity<AccountUser> getAccountUserByEmail(@PathVariable String email){
        return accountUserService.getAccountUserByEmail(email);
    }

    // Add new Account User
    @PostMapping("/add_user")
    public ResponseEntity<AccountUser> addNewAccountUser(@RequestBody @Valid AccountUser accountUser){
        return accountUserService.addNewAccountUser(accountUser);
    }

    // Update Account User
    @PutMapping("/update_user")
    public ResponseEntity<AccountUser> updateAccountUser(@PathVariable int id, @RequestBody AccountUser accountUser){
        return accountUserService.updateAccountUser(id, accountUser);
    }

    // Update an existing Account user field
    @PatchMapping("/update_user")
    public ResponseEntity<AccountUser> updateOneFieldOfAccountUser(@PathVariable int id, @RequestBody  Map<String, Object> accountUser){
        return accountUserService.updateOneFieldOfAccountUser(id, accountUser);
    }

    // Remove an existing user
    @DeleteMapping("/delete_user")
    public ResponseEntity<AccountUser> deleteAccountUser(@PathVariable int id){
        return accountUserService.removeAccountUser(id);
    }

}
