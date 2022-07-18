package com.example.demo.springbatch.batch;

import com.example.demo.springbatch.controller.BatchController;
import com.example.demo.springbatch.model.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PokemonItemProcessor implements ItemProcessor<Pokemon, Pokemon> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchController.class);

    private static final Map<String, String> GENERATION_NAMES = new HashMap<>();

    public PokemonItemProcessor() {
        GENERATION_NAMES.put("1", "Generation I (Kanto)");
        GENERATION_NAMES.put("2", "Generation II (Johto)");
        GENERATION_NAMES.put("3", "Generation III (Hoenn)");
        GENERATION_NAMES.put("4", "Generation IV (Sinnoh)");
        GENERATION_NAMES.put("5", "Generation V (Unova)");
        GENERATION_NAMES.put("6", "Generation VI (Kalos)");
        GENERATION_NAMES.put("7", "Generation VII (Alola)");
        GENERATION_NAMES.put("8", "Generation VIII (Galar)");
    }

    @Override
    public Pokemon process(Pokemon pokemon) throws Exception {
        String generationNumber = pokemon.getGeneration();
        String generationName = GENERATION_NAMES.get(generationNumber);
        pokemon.setGeneration(generationName);

        LOGGER.info("Converted from {} to {}", generationNumber, generationName);
        return pokemon;
    }
}