package ma.ehtp.hostpital.repositories;

import ma.ehtp.hostpital.entites.Consultation;
import ma.ehtp.hostpital.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
