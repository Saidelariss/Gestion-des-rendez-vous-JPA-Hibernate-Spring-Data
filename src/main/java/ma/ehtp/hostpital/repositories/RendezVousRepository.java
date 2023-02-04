package ma.ehtp.hostpital.repositories;

import ma.ehtp.hostpital.entites.Patient;
import ma.ehtp.hostpital.entites.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
