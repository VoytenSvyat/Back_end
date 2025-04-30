package de.ait;

import lombok.Data;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    Ваша задача написать программу, которая получает List комментариев (объекты коллекции) comments на сайте
    https://jsonplaceholder.typicode.com/
     */
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/comments?postId=";

    public static void main(String[] args) throws URISyntaxException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID поста: ");
        int postId = scanner.nextInt();

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(BASE_URL + postId);

        // Создание запроса
        RequestEntity<Void> request = new RequestEntity<>(HttpMethod.GET, uri);

        // Отправка запроса и получение ответа
        ResponseEntity<List<Comment>> response = restTemplate.exchange(
                request, new ParameterizedTypeReference<>() {});

        // Проверка статуса
        System.out.println("Статус код: " + response.getStatusCode());

        // Получение комментариев
        List<Comment> comments = response.getBody();
        if (comments != null && !comments.isEmpty()) {
            comments.forEach(System.out::println);
        } else {
            System.out.println("Комментариев для поста с ID " + postId + " не найдено.");
        }
    }
}