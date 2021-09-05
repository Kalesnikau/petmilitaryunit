package by.kalesnikau.petmilitaryunit.repository;

import by.kalesnikau.petmilitaryunit.model.DonutEntity;
import by.kalesnikau.petmilitaryunit.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonutRepository extends JpaRepository<DonutEntity, Long> {
    DonutEntity findByName(String name);
}
