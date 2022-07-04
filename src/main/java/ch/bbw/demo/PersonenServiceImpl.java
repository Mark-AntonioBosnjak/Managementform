package ch.bbw.demo;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class PersonenServiceImpl implements PersonenInterface {

    private PersonenRespository personenRespository;

    public PersonenServiceImpl(PersonenRespository personenRespository) {
        super();
        this.personenRespository = personenRespository;
    }

    @Override
    public List<Personenverwaltung> getAllStudents() {
        return personenRespository.findAll();
    }

    @Override
    public Personenverwaltung saveStudent(Personenverwaltung personenverwaltung) {
        return personenRespository.save(personenverwaltung);
    }

    @Override
    public Personenverwaltung getStudentById(Long id) {
        return personenRespository.findById(id).get();
    }

    @Override
    public Personenverwaltung updateStudent(Personenverwaltung personenverwaltung) {
        return personenRespository.save(personenverwaltung);
    }

    @Override
    public void deleteStudentById(Long id) {
        personenRespository.deleteById(id);
    }

}

