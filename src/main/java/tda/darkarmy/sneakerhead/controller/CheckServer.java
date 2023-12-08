package tda.darkarmy.sneakerhead.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/check")
public class CheckServer {
    @GetMapping
    public ResponseEntity<?> checkServer(){
        return status(200).body("Server is up");
    }
}
