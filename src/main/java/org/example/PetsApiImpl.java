package org.example;
import io.micronaut.core.convert.ArgumentConversionContext;
import io.micronaut.core.convert.value.MutableConvertibleValues;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;

import io.micronaut.http.annotation.PathVariable;
import io.reactivex.Single;
import io.swagger.api.PetApi;
import io.swagger.model.Pet;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class PetsApiImpl implements PetApi {

    @Override
    public Single<HttpResponse<Pet>> getPetById(@Parameter(description = "ID of pet to return") @PathVariable("petId") Long petId) {
        HttpResponse response = new HttpResponse<Pet>() {
            @Override
            public HttpStatus getStatus() {
                return HttpStatus.OK;
            }

            @Override
            public HttpHeaders getHeaders() {
                return new HttpHeaders() {
                    @Override
                    public List<String> getAll(CharSequence name) {
                        return new ArrayList<>();
                    }

                    @Override
                    public String get(CharSequence name) {
                        return "";
                    }

                    @Override
                    public Set<String> names() {
                        return new HashSet<>();
                    }

                    @Override
                    public Collection<List<String>> values() {
                        return new ArrayList<>();
                    }

                    @Override
                    public <T> Optional<T> get(CharSequence name, ArgumentConversionContext<T> conversionContext) {
                        return Optional.empty();
                    }
                };
            }

            @Override
            public MutableConvertibleValues<Object> getAttributes() {
                return null;
            }

            @Override
            public Optional getBody() {
                return Optional.of(
                        new Pet().id(1234L).name("Foo")
                );
            }
        };
        return Single.just(response);
    }
}
