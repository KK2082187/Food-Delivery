package com.geekster.Food.Delivery.App.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private String userContactNumber;
}
