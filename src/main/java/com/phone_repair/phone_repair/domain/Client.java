package com.phone_repair.phone_repair.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    private String numberPhone;

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
