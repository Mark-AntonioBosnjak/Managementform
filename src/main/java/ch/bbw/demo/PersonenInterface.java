package ch.bbw.demo;

import java.util.List;

import javax.persistence.Entity;


public interface PersonenInterface {
    List<Personenverwaltung> getAllStudents();

    Personenverwaltung saveStudent(Personenverwaltung personenverwaltung);

    Personenverwaltung getStudentById(Long id);

    Personenverwaltung updateStudent(Personenverwaltung personenverwaltung);

    void deleteStudentById(Long id);
}
