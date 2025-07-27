package com.phone_repair.phone_repair.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {


    private long id;

    private String name;
    private String surname;

    private String email;
    private String numberPhone;

}
