package br.com.marcelodaniel.orangestack.controller

import gen.ingredientes.models.NovoIngredienteRequest
import gen.ingredientes.operations.IngredientesOperations
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class HelloController : IngredientesOperations {

    @Get
    fun helloWorld(): String {
        return "Olá Mundo!!!"
    }

    override fun cadastraIngrediente(novoIngredienteRequest: NovoIngredienteRequest): HttpResponse<Void> {
        println("Testes com openAPI")
        return HttpResponse.ok()
    }
}