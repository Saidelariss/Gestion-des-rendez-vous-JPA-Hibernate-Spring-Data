package ma.ehtp.hostpital.services;

import ma.ehtp.hostpital.entites.Consultation;
import ma.ehtp.hostpital.entites.Medecin;
import ma.ehtp.hostpital.entites.Patient;
import ma.ehtp.hostpital.entites.RendezVous;

public interface IHospitalService {
        Patient savePatient(Patient patient);
        Medecin saveMedecin(Medecin medecin);
        RendezVous saveRendezVous(RendezVous rendezVous);
        Consultation saveConsultation(Consultation consultation);

}
