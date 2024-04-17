package com.alibou.security.user;

//import com.alloMecano.crud.controller.Mecanicien;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicienService {

    private final MecanicienRepository mecanicienRepository;


 @Autowired
    public MecanicienService(MecanicienRepository mecanicienRepository) {
        this.mecanicienRepository = mecanicienRepository;
    }



   public Mecanicien addMecanicien(Mecanicien mecanicien){
     return mecanicienRepository.save(mecanicien);
   }

   public List<Mecanicien> FindAllMecanicien(){
     return mecanicienRepository.findAll();
   }
   public Mecanicien FindEmplyeById(Long id){
     return mecanicienRepository.findMecanicienById(id).orElseThrow(()-> new UserNotFoundException("user by id "+id+"was not found"));
   }
   public Mecanicien updateMecanicien(Mecanicien mecanicien){
     return mecanicienRepository.save(mecanicien);
   }
    @Transactional
   public void deleteMecanicien(Long id){
     mecanicienRepository.deleteMecanicienById(id);
   }





}
