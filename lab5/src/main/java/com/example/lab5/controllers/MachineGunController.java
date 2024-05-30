package com.example.lab5.controllers;


import com.example.lab5.entity.MachineGun;
import com.example.lab5.repositories.IMachineGunRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MachineGunController {

    private IMachineGunRepository repo;

    MachineGunController(IMachineGunRepository repository){
        this.repo = repository;
    }

   @GetMapping("/machineGuns")
    List<MachineGun> getMachineGuns(){
        return (List<MachineGun>) repo.findAll();
   }

    @PostMapping("/machineGuns")
    MachineGun createMachineGuns(@RequestBody MachineGun machineGun){
        return repo.save(machineGun);
    }

    @PutMapping("/machineGuns/{id}")
    MachineGun updateMachineGun(@RequestBody MachineGun updatedMachineGun, @PathVariable int id){
        return repo.findById(id)
                .map(machineGun -> {
                    machineGun.setName(updatedMachineGun.getName());
                    machineGun.setDescription(updatedMachineGun.getDescription());
                    machineGun.setAmount(updatedMachineGun.getAmount());
                    machineGun.setPhotoUrl(updatedMachineGun.getPhotoUrl());
                    return repo.save(machineGun);
                }).orElseGet(()->{
                    updatedMachineGun.setId(id);
                    return repo.save(updatedMachineGun);
                });
    }

    @DeleteMapping("/machineGuns/{id}")
    void deleteMachineGun(@PathVariable int id){
        repo.deleteById(id);
    }
}
