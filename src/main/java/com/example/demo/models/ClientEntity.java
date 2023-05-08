package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "client_number")
    private String number;

    @OneToMany(mappedBy = "client",cascade =CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<FactureEntity> factures;
}
