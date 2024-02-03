package com.spring.security.movie;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/movie")
public class MovieController {
 private  final MovieServices movieServices;

    @Autowired
    public MovieController(MovieServices movieServices) {
        this.movieServices = movieServices;
    }
    @GetMapping("/allMovie")
    public List<BookingMovie> viewMovie(){
      return movieServices.viewMovie();
    }


    @PostMapping("addMovie")
    public ResponseEntity<Object> selectMovie(@RequestBody BookingMovie bookingMovie) {
        return this.movieServices.selectMovie(bookingMovie);
    }

    @PutMapping
    public ResponseEntity<Object> updateMovie(@RequestBody BookingMovie bookingMovie) {
        return this.movieServices.updatetMovie(bookingMovie);
    }

    @DeleteMapping (path = ("{id}"))
     public ResponseEntity<Object> deletBookingMovie(@PathVariable("id") Integer id){
        return this.movieServices.delete(id);
    }
}
