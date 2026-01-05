package com.crudcliente.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "client")
@Entity(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    private Double income;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private Integer children;
}
