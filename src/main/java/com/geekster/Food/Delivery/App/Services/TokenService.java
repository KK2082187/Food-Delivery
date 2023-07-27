package com.geekster.Food.Delivery.App.Services;

import com.geekster.Food.Delivery.App.Models.AuthenticationToken;
import com.geekster.Food.Delivery.App.Repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
     ITokenRepo iTokenRepo;

    public void saveToken(AuthenticationToken token){
        iTokenRepo.save(token);
    }
    public boolean authenticate(String email,String token){
        if(token==null || email==null){
            return false;
        }
        AuthenticationToken authenticationToken = iTokenRepo.findFirstByToken(token);
            if(authenticationToken==null){
                return false;
            }
            String expectedEmail = authenticationToken.getUser().getUserEmail();
            return expectedEmail.equals(email);
        }

}
