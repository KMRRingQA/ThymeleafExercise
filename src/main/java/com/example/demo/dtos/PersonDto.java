package com.example.demo.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {
    private String firstName;
    private String lastName;
    private String email;
    private int score;
}
