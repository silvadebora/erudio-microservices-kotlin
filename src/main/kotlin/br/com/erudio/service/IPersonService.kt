package br.com.erudio.service

interface IPersonService {

    fun isNumeric(strNumber: String?): Boolean

    fun convertDouble(strNumber: String?): Double
}