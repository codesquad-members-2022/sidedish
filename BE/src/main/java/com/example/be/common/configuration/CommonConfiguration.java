package com.example.be.common.configuration;

import com.example.be.business.dish.domain.Dish;
import com.example.be.business.dish.repository.DishRepository;
import com.example.be.business.user.domain.User;
import com.example.be.business.user.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommonConfiguration {

    @Bean
    public DishRepository dishRepository() {
        return new DishRepository() {
            @Override
            public <S extends Dish> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Dish> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Dish> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Dish> findAll() {
                return null;
            }

            @Override
            public Iterable<Dish> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Dish entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Dish> entities) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

}
