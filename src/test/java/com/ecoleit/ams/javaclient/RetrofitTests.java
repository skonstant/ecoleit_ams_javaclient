package com.ecoleit.ams.javaclient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RetrofitTests {

    static RetrofitInterface service = null;

    @BeforeAll
    static void setup() {
        var retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(RetrofitInterface.class);
    }

    @Test
    void getGreeting() throws IOException {
        var greeting = service.getGreeting("myname").execute().body();
        assertNotNull(greeting);
        assertEquals("myname", greeting.content());
    }

}
