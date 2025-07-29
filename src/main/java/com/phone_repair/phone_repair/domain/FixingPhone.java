package com.phone_repair.phone_repair.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class FixingPhone {
    @Id
    private Long id;

    private String modelPhone;



}

