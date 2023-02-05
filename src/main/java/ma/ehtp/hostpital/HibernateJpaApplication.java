package ma.ehtp.hostpital;

import ma.ehtp.hostpital.entites.*;
import ma.ehtp.hostpital.repositories.ConsultationRepository;
import ma.ehtp.hostpital.repositories.MedecinRepository;
import ma.ehtp.hostpital.repositories.PatientRepository;
import ma.ehtp.hostpital.repositories.RendezVousRepository;
import ma.ehtp.hostpital.services.HospitalServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HibernateJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner start(HospitalServiceImpl hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository){
        return args -> {
            //Patient patient = new Patient(null,"said",new Date(),false,null);
            Stream.of("mohammed","said","khalid")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);

                    });
            Stream.of("medecin1","medecin2","medecin3")
                    .forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);

                    });
            Patient patient=patientRepository.findByNom("said");
            Medecin medecin=medecinRepository.findByNom(("medecin1"));

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.saveRendezVous(rendezVous);

           // RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
           RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation");
            hospitalService.saveConsultation(consultation);



        };
    }

}
