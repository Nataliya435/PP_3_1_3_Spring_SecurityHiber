package ru.kata.spring.boot_security.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.DAO.UserDao;
import ru.kata.spring.boot_security.demo.models.Person;


import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final UserDao userDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonServiceImpl(UserDao userdao, @Lazy PasswordEncoder passwordEncoder) {
        this.userDAO = userdao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional  //(readOnly = true)
    public List<Person> getAllPersons() {
        return userDAO.getAllPersons();
    }

    @Override
    @Transactional
    public Person getPersonById(Long id) {
        return userDAO.getPersonById(id);
    }

    @Override
    @Transactional
    public Person getPersonByLogin(String login) {
        return userDAO.getPersonByLogin(login);
    }


    @Override
    @Transactional
    public void savePerson(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        userDAO.savePerson(person);
    }


    @Override
    @Transactional
    public void updatePerson(Person updatePerson) {
        updatePerson.setPassword(passwordEncoder.encode(updatePerson.getPassword()));
        userDAO.savePerson(updatePerson);
    }


    @Override
    @Transactional
    public void deletePerson(Long id) {userDAO.deletePerson(id);
    }


}
