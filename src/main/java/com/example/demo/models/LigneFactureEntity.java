package com.example.demo.models;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.ToString;
@Entity
@Table(name="ligne_facture")
@Data
@ToString
    public class LigneFactureEntity  implements Serializable{

        /**
         *
         */
        private static final long serialVersionUID = -3181735183192870271L;

        @EmbeddedId
        private LigneFactureKey id;


        @ManyToOne()
        @MapsId("factureId")
        @JoinColumn(name="facture_id")
        private FactureEntity facture;

        @ManyToOne()
        @MapsId("produitId")
        @JoinColumn(name="produit_id")
        private ProduitEntity produit;

        private double quantite;

    }

