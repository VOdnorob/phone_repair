package com.phone_repair.phone_repair.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "repair_requests")
public class RepairRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneModel;
    private String descriptionProblem;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}


