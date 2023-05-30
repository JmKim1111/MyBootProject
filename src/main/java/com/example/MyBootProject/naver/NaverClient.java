package com.example.MyBootProject.naver;


import com.example.MyBootProject.naver.dto.SearchLocalReq;
import com.example.MyBootProject.naver.dto.SearchLocalRes;
import com.example.MyBootProject.naver.dto.SearchimageReq;
import com.example.MyBootProject.naver.dto.SearchimageRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverClient {

    @Value("${naver.client.id}")
    String NaverClientId;

    @Value("${naver.client.sercret}")
    String NaverClientSecret;

    @Value("${naver.url.search.local}")
    String NaverlocalSearchURL;

    @Value("${naver.url.search.image}")
    String NaverImageSearchURL;

    public SearchLocalRes localSearch(SearchLocalReq searchLocalReq){
        var uri = UriComponentsBuilder.fromUriString(NaverlocalSearchURL)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",NaverClientId);
        headers.set("X-Naver-Client-Secret", NaverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>(){};


        var responseEntity = new RestTemplate().exchange(
          uri,
          HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();

    }

    public SearchimageRes searchimageRes(SearchimageReq searchimageReq){
        var uri = UriComponentsBuilder.fromUriString(NaverImageSearchURL)
                .queryParams(searchimageReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        var headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",NaverClientId);
        headers.set("X-Naver-Client-Secret", NaverClientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchimageRes>(){};


        var responseEntity = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
        );
        return responseEntity.getBody();

    }

}
