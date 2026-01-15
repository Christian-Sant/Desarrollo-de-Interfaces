package hotel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.Writer;
import java.io.Reader;
import java.io.IOException;
import java.time.LocalDate;

public class JsonManager {

    private static final String ARCHIVO = "hotel.json";

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class,
                    (JsonSerializer<LocalDate>) (src, typeOfSrc, context) ->
                            context.serialize(src.toString()))
            .registerTypeAdapter(LocalDate.class,
                    (JsonDeserializer<LocalDate>) (json, type, context) ->
                            LocalDate.parse(json.getAsString()))
            .create();

    public static void guardar(HotelData data) {
        try (Writer writer = new FileWriter(ARCHIVO)) {
            gson.toJson(data, writer);
            System.out.println("Datos guardados correctamente en hotel.json");
        } catch (IOException e) {
            System.out.println("Error guardando datos.");
            e.printStackTrace();
        }
    }

    public static HotelData cargar() {
        try (Reader reader = new FileReader(ARCHIVO)) {
            return gson.fromJson(reader, HotelData.class);
        } catch (Exception e) {
            return new HotelData();
        }
    }
}
