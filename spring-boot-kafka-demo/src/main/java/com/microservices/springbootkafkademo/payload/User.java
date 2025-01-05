package com.microservices.springbootkafkademo.payload;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String firstName;
    private String lastName;
}
