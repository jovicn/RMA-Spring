package rs.ac.singidunum.fir.AndroidIspit.services;

import org.springframework.stereotype.Service;
import rs.ac.singidunum.fir.AndroidIspit.dto.AccountLoginDto;
import rs.ac.singidunum.fir.AndroidIspit.dto.AccountRegDto;
import rs.ac.singidunum.fir.AndroidIspit.model.AccountModel;
import rs.ac.singidunum.fir.AndroidIspit.repository.AccountRepository;

import java.util.Optional;

@Service
public class AccountServis {


    private final AccountRepository accountRepository;

    public AccountServis(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountModel logIn(AccountLoginDto accountLoginDto){
        //System.out.println("Metod je pozvan");
        Optional<AccountModel> accountModel = accountRepository.findByEmail(accountLoginDto.getEmail());
        //System.out.println(accountModel.isPresent());
        if(accountModel.isPresent()){
            if(accountModel.get().getPasswordHash().equals(accountLoginDto.getPassword())){
                return accountModel.get();
            }
        }
        return null;
    }

        public AccountModel reg(AccountRegDto accountRegDto){
            Optional<AccountModel> accMod = accountRepository.findByEmail(accountRegDto.getEmail());
            if(accMod.isPresent()){
            return null;
            }else{
                AccountModel accountModel = new AccountModel();
                accountModel.setForename(accountRegDto.getForename());
                accountModel.setSurname(accountRegDto.getSurename());
                accountModel.setEmail(accountRegDto.getEmail());
                accountModel.setPhoneNumber(accountRegDto.getPhoneNumber());
                accountModel.setAddres(accountRegDto.getAddres());
                accountModel.setCity(accountRegDto.getCity());
                accountModel.setPostalCode(accountRegDto.getPostalCode());
                accountModel.setPasswordHash(accountRegDto.getPasswordHash());

                return  accountRepository.saveAndFlush(accountModel);
        }
    }

}
