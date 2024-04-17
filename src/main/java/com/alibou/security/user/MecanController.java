package com.alibou.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/Mecanicien")
public class MecanController {

    @Autowired
    private final MecanicienService mecanicienService;

//    @Autowired
//    private final  user;
    @Autowired
    public MecanController(MecanicienService mecanicienService){
        this.mecanicienService = mecanicienService;

    }


    @GetMapping("/all")
    public ResponseEntity<List<Mecanicien>> getALLMecaniciens(){
        List<Mecanicien> mecaniciens =mecanicienService.FindAllMecanicien();
        return new ResponseEntity<>(mecaniciens, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Mecanicien> getALLMecanicienById(@PathVariable("id") Long id ){
        Mecanicien mecaniciens =mecanicienService.FindEmplyeById(id);
        return new ResponseEntity<>(mecaniciens, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Mecanicien> addMecanicien(@RequestBody Mecanicien mecanicien){
        Mecanicien newMecanicien=mecanicienService.addMecanicien(mecanicien);
        return new ResponseEntity<>(newMecanicien, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Mecanicien> updateMecanicien(@RequestBody Mecanicien mecanicien){
        Mecanicien updateMecanicien=mecanicienService.updateMecanicien(mecanicien);
        return new ResponseEntity<>(updateMecanicien, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMecanicien(@PathVariable("id") Long id){
        mecanicienService.deleteMecanicien(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
