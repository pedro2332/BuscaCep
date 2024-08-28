package requisitions.cep.programa;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Requisitions {
    //private List<Adress> adressList = new ArrayList<>();

    public void searchCep(String cep) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                //.thenAccept(System.out::println)
                .join();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        //gson.toJson(response.body());
        AdressJson adress = gson.fromJson(response.body(), AdressJson.class);
        Adress finalAdress = new Adress(adress);
        System.out.println(finalAdress);
        //adressList.add(finalAdress);
        try {
            FileWriter file = new FileWriter("Histórico.txt", true);
            file.write(gson.toJson(finalAdress));
            file.write(System.lineSeparator());
            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cleanData() {
        try {
            new FileWriter("Histórico.txt", false).close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
