package com.hilbert.wallet.controller;

import com.hilbert.wallet.dto.WalletDTO;
import com.hilbert.wallet.entity.Wallet;
import com.hilbert.wallet.response.Response;
import com.hilbert.wallet.service.WalletService;
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
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Response<WalletDTO>> create(@RequestBody @Valid WalletDTO walletDTO,
                                                      BindingResult result){

        Response<WalletDTO> response = new Response<WalletDTO>();

        if (result.hasErrors()){
            result.getAllErrors().forEach( r -> response.getErrors().add(r.getDefaultMessage()));

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        Wallet wallet = walletService.save(this.convertDTOToEntity(walletDTO));

        response.setData(this.convertEntityToDTO(wallet));

        return ResponseEntity.ok().body(response);
    }

    private Wallet convertDTOToEntity(WalletDTO walletDTO) {
        Wallet wallet = new Wallet();
        wallet.setId(walletDTO.getId());
        wallet.setName(walletDTO.getName());
        wallet.setValue(walletDTO.getValue());

        return wallet;
    }

    private WalletDTO convertEntityToDTO(Wallet wallet) {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setId(wallet.getId());
        walletDTO.setName(wallet.getName());
        walletDTO.setValue(wallet.getValue());

        return walletDTO;
    }

}
