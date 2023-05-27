package br.com.erudio.controller

import br.com.erudio.model.Person
import br.com.erudio.service.impl.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController{


    @Autowired
    private lateinit var personService: PersonService


    @GetMapping( "/{id}",produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable(value = "id") id: Long)
    : Person {
        return personService.findById(id)
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<Person> {
        return personService.findAll()
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: Person): Person {
        return personService.create(person)
    }

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updatePerson(@RequestBody person: Person): Person {
        return personService.update(person)
    }


    @DeleteMapping(consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*>{
        personService.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}