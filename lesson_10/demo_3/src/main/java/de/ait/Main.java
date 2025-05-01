package de.ait;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class Main {
    /*
    # 1
Ваша задача написать используя API https://api.imagga.com эндпоинт /text написать программу которая распознает текст на картинке. Для тестирования можно использовать
картинку https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg
Результат для этой картинки строка: "ОТВЕЧАЮ В СПРИНГЕ ЭТО УЖЕ ЕСТЬ"

     */
    public static void main(String[] args) {
        String imgUrl = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
        String lang = "de,en,ru";
        String token = "Basic YWNjXzBhNzgxMDNkNzMwMWIzOTplYzEzYjA1ODQ4YzNiMDM1MDExZmRmMWQ3NThkOWNjZA==";
        String url = "https://api.imagga.com/v2/tags/text";

        RestTemplate restTemplate = new RestTemplate();

        // Установить http-заголовки
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        // получить uri строку
        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("image_url", imgUrl)
                .queryParam("language", lang)
                .build()
                .toUri();

        // создали RequestEntity
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);

        //визвали restTemplate
        ResponseEntity<TagsResponseDto> response = restTemplate.exchange(request, TagsResponseDto.class);

        response.getBody().getResult().getTags().forEach(System.out::println);

    }
}