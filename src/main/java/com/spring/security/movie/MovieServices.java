package com.spring.security.movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {
    HashMap<String, Object> datos = new HashMap<>();
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServices(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<BookingMovie> viewMovie() {
        return this.movieRepository.findAll();
    }

    public ResponseEntity<Object> selectMovie(BookingMovie bookingMovie) {
        Optional<BookingMovie> res = movieRepository.findProductByName(bookingMovie.getName());
        if (res.isPresent()) {
            datos.put("error", true);
            datos.put("massage", "ya reservo esta pelicula ");
            return new ResponseEntity<>(datos,
                    HttpStatus.EXPECTATION_FAILED);
        } else {
            BookingMovie savedBookingMovie = movieRepository.save(bookingMovie);
            datos.put("", "Thanks for buy");
            datos.put("BookingMovie", bookingMovie.getName());
            datos.put("funtion hour", bookingMovie.getHoraFuncion());
            datos.put("sala",bookingMovie.getAsientos());
            datos.put("chairs", bookingMovie.getAsientos());
            return new ResponseEntity<>(datos, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> updatetMovie(BookingMovie bookingMovie) {
        
        Optional<BookingMovie> res = movieRepository.findProductByName(bookingMovie.getName());
        if (res.isPresent() && bookingMovie.getId() == null) {
            datos.put("error", true);
            datos.put("message", "I already booked this bookingMovie");
            return new ResponseEntity<>(datos,
                    HttpStatus.EXPECTATION_FAILED);
        }
        datos.put("message", "Se guardó con éxito");
        if (bookingMovie.getId() !=null) {
            datos.put("message", "se actualizo la seleccion de la pelicula ");
        }
        BookingMovie savedBookingMovie = movieRepository.save(bookingMovie);
        datos.put("", "Booking bookingMovie Update Sucessfully");
        datos.put("BookingMovie", bookingMovie.getName());
        datos.put("funtion hour", bookingMovie.getHoraFuncion());
        datos.put("sala",bookingMovie.getAsientos());
        datos.put("chairs", bookingMovie.getAsientos());
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> delete(Integer id){
        boolean existing= this.movieRepository.existsById(id);
        if(!existing){
            datos.put("error", true);
            datos.put("massage","No existe esta funcion  ");
            return new ResponseEntity<>(datos,
                    HttpStatus.CONFLICT);
        }
        movieRepository.deleteById(id);
        datos.put("massage", "Booking delete sucesfully  ");
        return new ResponseEntity<>(datos,
                HttpStatus.ACCEPTED);
    }

}






