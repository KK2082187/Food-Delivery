package com.geekster.Food.Delivery.App.Services;

import com.geekster.Food.Delivery.App.Dto.SignInInput;
import com.geekster.Food.Delivery.App.Dto.SignInOutput;
import com.geekster.Food.Delivery.App.Dto.SignUpOutput;
import com.geekster.Food.Delivery.App.Models.AuthenticationToken;
import com.geekster.Food.Delivery.App.Models.User;
import com.geekster.Food.Delivery.App.Repository.IUserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepo iUserRepo;
    @Autowired
    private TokenService tokenService;

    public List<User>getAllUsers(){
        return iUserRepo.findAll();
    }
    public SignUpOutput signUp(User signUpInput) {
        User user = iUserRepo.findFirstByUserEmail(signUpInput.getUserEmail());
        if(user != null){
            throw new IllegalStateException("User already exist");
        }
        String encryptedPassword = null;
        try{
            encryptedPassword= encryptPassword(signUpInput.getUserPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        signUpInput.setUserPassword(encryptedPassword);
        iUserRepo.save(signUpInput);
        return new SignUpOutput(HttpStatus.ACCEPTED,"User created successfully");
    }
    public String encryptPassword(String userPassword) throws NoSuchAlgorithmException{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();
        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signIn(SignInInput signInInput) {
        User user = iUserRepo.findFirstByUserEmail(signInInput.getUserEmail());
        if(user==null){
            throw new IllegalStateException("User invalid!!!");
        }
        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(signInInput.getUserPassword());
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();;
        }
        boolean isPasswordValid = encryptedPassword.equals(user.getUserPassword());
        if(!isPasswordValid){
            throw new IllegalStateException("User invalid!!!");
        }
        AuthenticationToken authenticationToken = new AuthenticationToken(user);
        tokenService.saveToken(authenticationToken);
        return new SignInOutput("Authentication Successfull!!!",authenticationToken.getToken());
    }

}
