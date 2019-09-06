package ru.bellintegrator.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.person.PersonDao;
import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.PersonView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public PersonServiceImpl(PersonDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(PersonView view) {
        Person person = new Person(view.name, view.age);
        dao.save(person);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<PersonView> persons() {
        List<Person> all = dao.all();
        return mapperFacade.mapAsList(all, PersonView.class);
    }
}
