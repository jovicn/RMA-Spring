package rs.ac.singidunum.fir.AndroidIspit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.fir.AndroidIspit.dto.AccountLoginDto;
import rs.ac.singidunum.fir.AndroidIspit.dto.AccountRegDto;
import rs.ac.singidunum.fir.AndroidIspit.model.AccountModel;
import rs.ac.singidunum.fir.AndroidIspit.repository.AccountRepository;
import rs.ac.singidunum.fir.AndroidIspit.services.AccountServis;

import java.util.List;

@RestController
public class AccountController {


    @Autowired(required = false)
    private AccountServis accountServis;

    @Autowired(required = false)
    private AccountRepository accountRepository;

    //get all accounts
    @GetMapping("/account")
    public List<AccountModel> showAccounts(){
        return  (List<AccountModel>) accountRepository.findAll();
    }

    //return one of all accounts
    @GetMapping("/account/{id}")
    public AccountModel oneAccount(@PathVariable int id){
        return accountRepository.findById(id).orElse(null);
    }

    //account create
    @PostMapping(path="/account")
    public AccountModel createAccount(@RequestBody AccountModel acc){
        return accountRepository.save(acc);
    }

    // account delete
    @DeleteMapping("/account/{id}")
    public boolean delete(@PathVariable String id){
        int accountId = Integer.parseInt(id);
        accountRepository.deleteById(accountId);
        return true;
    }

    //update account
    @PutMapping(path="/account/{id}")
    public AccountModel accUpdate(@PathVariable int id, @RequestBody AccountModel am){
        AccountModel accMod = accountRepository.findById(id).orElse(null);
        accMod.setForename(am.getForename());
        accMod.setSurname(am.getSurname());
        accMod.setEmail(am.getEmail());
        accMod.setPhoneNumber(am.getPhoneNumber());
        accMod.setAddres(am.getAddres());
        accMod.setCity(am.getCity());
        accMod.setPostalCode(am.getPostalCode());
        accMod.setPasswordHash(am.getPasswordHash());

        return accountRepository.save(accMod);
    }


    @PostMapping("/account/login")
    public AccountModel logIn(@RequestBody AccountLoginDto accountLoginDto){

        return accountServis.logIn(accountLoginDto);
    }

    @PostMapping("/account/reg")
    public AccountModel reg(@RequestBody AccountRegDto accountRegDto){

        return accountServis.reg(accountRegDto);
    }
}
