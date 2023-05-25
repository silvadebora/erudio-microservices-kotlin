package br.com.erudio.service

interface IMathService {

    fun isNumeric(strNumber: String?): Boolean

    fun convertDouble(strNumber: String?): Double
}