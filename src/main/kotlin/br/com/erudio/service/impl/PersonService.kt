package br.com.erudio.service.impl

import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.model.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person{
        logger.info("Finding one person!")

        return personRepository.findById(id)
            .orElseThrow{ResourceNotFoundException("No records found for this id!")}
    }
    fun findAll(): List<Person>{
        logger.info("Finding all person!")

        return personRepository.findAll();
    }

    fun create(person: Person): Person {
        logger.info("Create one person with name ${person.firstName}!")

        return personRepository.save(person)
    }

    fun update(person: Person) :Person{
        logger.info("Update one person with id ${person.id}!")

        val entity = personRepository.findById(person.id)
            .orElseThrow{ResourceNotFoundException("No records found for this id!")}

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return personRepository.save(entity)
    }

    fun delete(id: Long){
        logger.info("Delete one person with id $id!")

        val entity = personRepository.findById(id)
            .orElseThrow{ResourceNotFoundException("No records found for this id!")}
        personRepository.delete(entity)
    }
}