package ma.ehtp.hostpital.repositories;

import ma.ehtp.hostpital.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String name); //si il en a plusieurs une exception sera levée
}
