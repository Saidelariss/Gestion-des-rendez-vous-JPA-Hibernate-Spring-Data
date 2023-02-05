package ma.ehtp.hostpital.services;

import jakarta.transaction.Transactional;
import ma.ehtp.hostpital.entites.Consultation;
import ma.ehtp.hostpital.entites.Medecin;
import ma.ehtp.hostpital.entites.Patient;
import ma.ehtp.hostpital.entites.RendezVous;
import ma.ehtp.hostpital.repositories.ConsultationRepository;
import ma.ehtp.hostpital.repositories.MedecinRepository;
import ma.ehtp.hostpital.repositories.PatientRepository;
import ma.ehtp.hostpital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service //La logique métier
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    //injection des dépendences en utilisant un constructeur avec paramètres (ce qui est recommandé )
    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
