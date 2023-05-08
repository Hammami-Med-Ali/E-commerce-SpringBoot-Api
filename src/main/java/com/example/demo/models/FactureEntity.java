package com.example.demo.models;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratorType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactureEntity implements Serializable{
    @Id
    private Integer id;

    @Column(nullable = false)
    private String ref;

    @Column(nullable = false ,name = "date_creation_facture")
    private Date date;

    @ManyToOne
    private ClientEntity client;
    @OneToMany(mappedBy = "facture",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   private List<LigneFactureEntity> ligneFactures;
}
