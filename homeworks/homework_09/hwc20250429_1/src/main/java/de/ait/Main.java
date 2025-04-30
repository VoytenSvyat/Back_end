package de.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;;

public class Main {
    /*
    Ваша задача написать программу, которая получает List комментариев (объекты коллекции) comments на сайте
    https://jsonplaceholder.typicode.com/
     */
    private static final String URL = "https://jsonplaceholder.typicode.com/comments";

    public static void main(String[] args) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(URL);

        // Создание RequestEntity для GET-запроса
        RequestEntity<Void> request = new RequestEntity<>(HttpMethod.GET, uri);

        // Отправка запроса и получение ответа в формате списка
        ResponseEntity<List<Comment>> response = restTemplate.exchange(
                request, new ParameterizedTypeReference<>() {});

        // Проверка статуса ответа
        System.out.println("Статус код: " + response.getStatusCode());
        System.out.println("Заголовки: " + response.getHeaders());

        // Получение тела ответа
        List<Comment> comments = response.getBody();
        if (comments != null) {
            comments.forEach(System.out::println);
        } else {
            System.out.println("Комментарии отсутствуют.");
        }
    }
}