package com.example.demo.springbatch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "POKEMONS")
@EntityListeners(AuditingEntityListener.class)
public class Pokemon {

    @Id
    private Integer pokemonId;

    private String name;

    private String form;

    private String type1;

    private String type2;

    private Integer total;

    private Integer healthPoints;

    private Integer attack;

    private Integer defence;

    private Integer specialAttack;

    private Integer specialDefence;

    private Integer speed;

    private String generation;

}
