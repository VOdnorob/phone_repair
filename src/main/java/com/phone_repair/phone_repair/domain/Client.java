package com.phone_repair.phone_repair.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    private String numberPhone;

    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<RepairRequest> repairRequests = new ArrayList<>();

    public Client(String name, String surname, String email, String password, String numberPhone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.numberPhone = numberPhone;
        this.repairRequests = new ArrayList<>();
    }

}
