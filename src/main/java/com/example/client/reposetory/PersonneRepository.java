package com.example.client.reposetory;

import com.example.client.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository  extends JpaRepository<Personne, Integer> {
    Personne findByEmailAndPassword(String email, String password);

    Personne findByEmail(String email);
}
