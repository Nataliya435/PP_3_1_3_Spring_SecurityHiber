package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.DAO.UserDao;
import ru.kata.spring.boot_security.demo.models.Person;
import ru.kata.spring.boot_security.demo.repositories.PersonRepository;


@Service
public class PersonDetailsService implements UserDetailsService {
   // private final PersonRepository personRepository;
    private final UserDao userDAO;


    @Autowired
    public PersonDetailsService(UserDao userdao) {
       // this.personRepository = personRepository;
        this.userDAO = userdao;
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Person person = personRepository.findByLogin(s);
//        if (person==null)
//            throw new UsernameNotFoundException("Такого пользователя нет");
//        return person;
//    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Person person = (Person) userDAO.findByLogin(s); //метод getUser
        person.getRoles().size();
        return person;
    }



}

