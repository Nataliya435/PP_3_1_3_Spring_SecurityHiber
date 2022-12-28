package ru.kata.spring.boot_security.demo.DAO;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.models.Person;

import java.util.List;

public interface UserDao {

    public void add(Person person);

    public List<Person> getAllPersons();

    Person getPersonById(Long id);

    Person getPersonByLogin(String login);

    public void deletePerson(Long id);

    public void editPerson(Person person);

    public UserDetails findByLogin(String login);

    public void savePerson(Person person);
}