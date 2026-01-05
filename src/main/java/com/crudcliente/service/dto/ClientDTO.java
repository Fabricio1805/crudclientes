package com.crudcliente.service.dto;

import com.crudcliente.entity.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;

    @NotBlank(message = "Nome: não pode ser vazio")
    private String name;

    private String cpf;

    private Double income;

    @PastOrPresent(message = "Data de nascimento: Não pode ser data futura")
    private LocalDate birthDate;

    private Integer children;

    public ClientDTO(Client client){
        id =  client.getId();
        name =  client.getName();
        cpf =  client.getCpf();
        income =  client.getIncome();
        birthDate =  client.getBirthDate();
        children =  client.getChildren();
    }
}
