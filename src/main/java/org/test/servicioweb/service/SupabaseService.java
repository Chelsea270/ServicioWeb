package org.test.servicioweb.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.test.servicioweb.config.Supabaseconfig;
import org.test.servicioweb.model.SupabaseModel;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SupabaseService {

    public List<SupabaseModel> obtenerDatos() throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();

        String apiKey = Supabaseconfig.getApiKey();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Supabaseconfig.getUrl()))
                .header("apikey", apiKey)
                .header("Authorization", "Bearer " + apiKey)
                .timeout(Duration.ofSeconds(15))
                .GET()
                .build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error al obtener los datos: " + response.statusCode());
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode datos = mapper.readTree(response.body());

        if (!datos.isArray()) {
            throw new RuntimeException("La respuesta no es una lista");
        }

        List<SupabaseModel> lista = new ArrayList<>();

        for (JsonNode dato : datos) {
            SupabaseModel s = new SupabaseModel();
            s.setId(dato.path("id").asInt());
            s.setNombre(dato.path("first_name").asText());
            s.setApellido(dato.path("last_name").asText());
            s.setEmail(dato.path("email").asText());
            s.setTelefono(dato.path("phone").asText());
            s.setFechaNacimiento(dato.path("date_of_birth").asText());
            s.setPais(dato.path("country").asText());
            s.setCiudad(dato.path("city").asText());
            s.setDireccion(dato.path("address").asText());
            s.setIngresoAnual(dato.path("annual_income").asDouble());
            s.setPuntajeCredito(dato.path("credit_score").asInt());
            s.setTieneDeuda(dato.path("has_unpaid_debt").asBoolean());
            s.setMontoDeuda(dato.path("unpaid_debt_amount").asDouble());
            s.setEstado(dato.path("status").asText());
            s.setFechaCreacion(dato.path("created_at").asText());
            s.setFechaActualizacion(dato.path("updated_at").asText());
            lista.add(s);
        }

        return lista;
    }
}