package com.phone_repair.phone_repair.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTORegistr {

    private String name;
    private String surname;

    @Email
    @NotBlank
    private String email;
    private String numberPhone;
}
