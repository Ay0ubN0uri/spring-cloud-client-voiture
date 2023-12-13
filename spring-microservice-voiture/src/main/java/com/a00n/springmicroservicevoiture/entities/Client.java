package com.a00n.springmicroservicevoiture.entities;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Long id;
    private String nom;
    private Float age;
}
