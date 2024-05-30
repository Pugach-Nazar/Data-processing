package com.example.lab5.repositories;

import com.example.lab5.entity.MachineGun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//@RepositoryRestResource
//@CrossOrigin(origins = "*")
public interface IMachineGunRepository extends JpaRepository<MachineGun, Integer> {
}
