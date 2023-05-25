package br.com.erudio.controller

import br.com.erudio.exceptions.ExceptionResponse
import br.com.erudio.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()



    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return convertDouble(numberOne) + convertDouble(numberTwo)
    }
    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun sub(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return convertDouble(numberOne) - convertDouble(numberTwo)
    }
    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun multi(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return convertDouble(numberOne) * convertDouble(numberTwo)
    }
    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun div(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return convertDouble(numberOne) * convertDouble(numberTwo)
    }
    @RequestMapping(value = ["/avg/{numberOne}/{numberTwo}"])
    fun avg(@PathVariable(value = "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?)
    : Double{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return (convertDouble(numberOne) + convertDouble(numberTwo)) / 2
    }
    @RequestMapping(value = ["/square/{number}"])
    fun square(@PathVariable(value = "number") number: String?)
    : Double{
        if (!isNumeric(number))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return sqrt(convertDouble(number))
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }

    private fun convertDouble(strNumber: String?): Double {
        if(strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if(isNumeric(number)) number.toDouble() else 0.0        
    }
}