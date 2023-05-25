package br.com.erudio.service.impl

import br.com.erudio.service.IMathService
import org.springframework.stereotype.Service
import kotlin.math.sqrt

@Service
class MathService : IMathService{

    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo
    fun sub(numberOne: Double, numberTwo: Double) = numberOne - numberTwo
    fun mult(numberOne: Double, numberTwo: Double) = numberOne * numberTwo
    fun div(numberOne: Double, numberTwo: Double) = numberOne / numberTwo
    fun avg(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo)/2
    fun square(number: Double) = sqrt(number)


    override fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }

    override fun convertDouble(strNumber: String?): Double {
        if(strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if(isNumeric(number)) number.toDouble() else 0.0
    }
}