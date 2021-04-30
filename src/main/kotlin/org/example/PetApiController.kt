package org.example

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.reactivex.Single
import io.swagger.api.PetApi
import io.swagger.model.Pet

@Controller
class PetApiController : PetApi {
    override fun getPetById(petId: Long?): Single<HttpResponse<Pet>> {
        if (petId != null) {
            val response = HttpResponse.ok(Pet().id(petId).name("foo"))
            return Single.just(response)
        }
       return Single.just(HttpResponse.notFound())
    }
}