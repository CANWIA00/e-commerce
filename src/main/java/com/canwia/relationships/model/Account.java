package com.canwia.relationships.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long id;
    private String accountName;
    private String password;
    private String email;
    private String phone;
    private String location;

    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> product;

    @OneToMany(mappedBy = "account")
    private List<Like> like;
    @OneToMany(mappedBy = "account")
    private List<Comment> comment;



}
