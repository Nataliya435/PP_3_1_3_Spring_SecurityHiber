package ru.kata.spring.boot_security.demo.DAO;

import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.models.Person;

import java.util.List;

public interface UserDao {

    public void add(Person person);
    public List<Person> getList();
    public Person getUser(Long id);

    public void deletePerson(Long id);
    public void editUser(Person person);

    public UserDetails findByLogin(String login);

}
