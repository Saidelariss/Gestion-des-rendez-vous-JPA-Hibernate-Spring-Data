package ma.ehtp.hostpital.repositories;

import ma.ehtp.hostpital.entites.Medecin;
import ma.ehtp.hostpital.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);
}
