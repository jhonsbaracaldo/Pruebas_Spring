package com.spring.security.movie;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<BookingMovie,Integer> {

    Optional<BookingMovie> findProductByName(String name);

}
