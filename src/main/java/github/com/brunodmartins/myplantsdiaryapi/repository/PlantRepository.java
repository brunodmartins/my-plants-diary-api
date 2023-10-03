package github.com.brunodmartins.myplantsdiaryapi.repository;

import github.com.brunodmartins.myplantsdiaryapi.domain.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
}
