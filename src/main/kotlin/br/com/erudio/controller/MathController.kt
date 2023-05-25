package br.com.erudio.controller

import br.com.erudio.exceptions.UnsupportedMathOperationException
import br.com.erudio.service.impl.MathService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
class MathController (
    @Autowired val mathService: MathService
        ){

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{

        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.sum(mathService.convertDouble(numberOne), mathService.convertDouble(numberTwo))
    }
    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{
        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.sub(mathService.convertDouble(numberOne), mathService.convertDouble(numberTwo))
    }
    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun multi(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{

        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.mult(mathService.convertDouble(numberOne), mathService.convertDouble(numberTwo))
    }
    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{
        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.div(mathService.convertDouble(numberOne), mathService.convertDouble(numberTwo))
    }
    @RequestMapping(value = ["/avg/{numberOne}/{numberTwo}"])
    fun avg(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{
        if (!mathService.isNumeric(numberOne) || !mathService.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.avg(mathService.convertDouble(numberOne), mathService.convertDouble(numberTwo))
    }
    @RequestMapping(value = ["/square/{number}"])
    fun square(@PathVariable(value = "number") number: String?)
    : Double{
        if (!mathService.isNumeric(number))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.square(mathService.convertDouble(number))
    }

}