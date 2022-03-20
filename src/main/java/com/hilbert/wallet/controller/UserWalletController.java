package com.hilbert.wallet.controller;

import com.hilbert.wallet.dto.UserWalletDTO;
import com.hilbert.wallet.entity.User;
import com.hilbert.wallet.entity.UserWallet;
import com.hilbert.wallet.entity.Wallet;
import com.hilbert.wallet.response.Response;
import com.hilbert.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user-wallet")
public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    @PostMapping
    public ResponseEntity<Response<UserWalletDTO>> create(@RequestBody @Valid UserWalletDTO userWalletDTO,
                                                          BindingResult result){
        Response<UserWalletDTO> response = new Response<UserWalletDTO>();

        if(result.hasErrors()){
            result.getAllErrors().forEach(r -> response.getErrors().add(r.getDefaultMessage()));
        }

        UserWallet userWallet = userWalletService.save(this.convertDTOtoEntity(userWalletDTO));

        response.setData(this.convertEntityToDTO(userWallet));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private UserWallet convertDTOtoEntity(UserWalletDTO userWalletDTO){
        UserWallet userWallet = new UserWallet();
        User user = new User();
        user.setId(userWalletDTO.getUsersId());
        Wallet wallet = new Wallet();
        wallet.setId(userWalletDTO.getWalletId());

        userWallet.setId(userWalletDTO.getId());
        userWallet.setUsers(user);
        userWallet.setWallet(wallet);

        return userWallet;
    }

    private UserWalletDTO convertEntityToDTO(UserWallet userWallet){
        UserWalletDTO userWalletDTO = new UserWalletDTO();
        userWalletDTO.setId(userWallet.getId());
        userWalletDTO.setUsersId(userWallet.getUsers().getId());
        userWalletDTO.setWalletId(userWallet.getWallet().getId());

        return userWalletDTO;
    }
}
