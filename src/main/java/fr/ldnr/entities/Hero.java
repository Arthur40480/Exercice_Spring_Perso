package fr.ldnr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hero {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int pv;
    private int attaque;
    private int defense;
    @OneToMany(mappedBy = "hero")
    List<Item> inventaire;
    @ManyToOne
    private Race race;

    public Hero(String name, int pv, int attaque, int defense, List<Item> inventaire, Race race) {
       this.name = name;
       this.pv = pv;
       this.attaque = attaque;
       this.defense = defense;
       this.inventaire = inventaire;
       this.race = race;
    }
}
