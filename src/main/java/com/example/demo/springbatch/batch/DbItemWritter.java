package com.example.demo.springbatch.batch;

import com.example.demo.springbatch.model.Pokemon;
import com.example.demo.springbatch.repository.PokemonRepository;
import com.example.demo.springbatch.utils.ObjectConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbItemWritter implements ItemWriter<Pokemon> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbItemWritter.class);

    private final PokemonRepository pokemonRepository;

    @Autowired
    public DbItemWritter(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public void write(List<? extends Pokemon> pokemons) throws Exception{

        pokemons.forEach( pokemon -> {
            LOGGER.info("Data Saved for Pokémon: {}", ObjectConverter.convertToJson(pokemon));
        });

        this.pokemonRepository.saveAll(pokemons);
    }
}
