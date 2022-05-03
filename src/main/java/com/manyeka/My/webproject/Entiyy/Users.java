package com.manyeka.My.webproject.Entiyy;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String name;
    private String passW;
    private String email;
}
