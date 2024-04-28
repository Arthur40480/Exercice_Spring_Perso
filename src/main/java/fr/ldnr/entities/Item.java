package fr.ldnr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=5,max=100)
    private String name;
    private int buffAttack;
    private int buffDefense;
    @NotNull
    @Size(min=1,max=100)
    private String rarity;
    @ManyToOne
    private Hero hero;

    public Item(String name, int buffAttack, int buffDefense, String rarity) {
        this.name = name;
        this.buffAttack = buffAttack;
        this.buffDefense = buffDefense;
        this.rarity = rarity;
    }

    public Item(String name, int buffAttack, int buffDefense, String rarity, Hero hero) {
        this.name = name;
        this.buffAttack = buffAttack;
        this.buffDefense = buffDefense;
        this.rarity = rarity;
        this.hero = hero;
    }
}
