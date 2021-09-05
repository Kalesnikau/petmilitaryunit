package by.kalesnikau.petmilitaryunit.repository;

import by.kalesnikau.petmilitaryunit.model.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {
}
