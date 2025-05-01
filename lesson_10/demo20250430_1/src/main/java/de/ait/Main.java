package de.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        ResponseEntity<ArrayList<CommentDto>> response = getCommentsFromServer("https://jsonplaceholder.typicode.com/comments?postId=1");
        System.out.println("Статус код: " + response.getStatusCode());
        System.out.println("Заголовки: " + response.getHeaders());

        ArrayList<CommentDto>  listAllComments = response.getBody();
        for (var comments: listAllComments){
            System.out.println(comments);
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер поста: ");
        int postId = scanner.nextInt();
        /*
        // начитка с сервера
        response = getCommentsFromServer("https://jsonplaceholder.typicode.com/comments?postId=" + postId);
        ArrayList<CommentDto> listOfComments= response.getBody();
        listOfComments.forEach(System.out::println);
         */
        List<CommentDto> listOfComments = listAllComments.stream().filter(c -> c.getPostId().equals(postId)).toList();
        listOfComments.forEach(System.out::println);


    }

    private static ResponseEntity<ArrayList<CommentDto>> getCommentsFromServer(String uriString) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://jsonplaceholder.typicode.com/comments");
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<ArrayList<CommentDto>> response =
                restTemplate.exchange(request, new ParameterizedTypeReference<ArrayList<CommentDto>>() {
                });
        return response;
    }
}