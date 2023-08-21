package com.example.html.util;

import com.example.html.domain.UserHtml;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.catalina.User;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Locale;

@Component
public class HtmlUtil {

    private Document document;

    private final ObjectMapper mapper;

    public HtmlUtil(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void setDocument(byte[] data) throws IOException {
        ByteArrayInputStream byt = new ByteArrayInputStream(data);
        this.document = Jsoup.parse(byt, "utf-8", "");
    }

    public UserHtml getUser() throws JsonProcessingException {
        Element element = document.getElementById("user");
        UserHtml userHtml = mapper.readValue(element.text(), UserHtml.class);
        return userHtml;
    }

    public UserHtml getUserPrimitive(){
        Element userName = document.getElementById("username");
        Element password = document.getElementById("password");
        Element age = document.getElementById("age");
        Element isLive = document.getElementById("isLive");

        return UserHtml.builder()
                .username(userName.text())
                .password(password.text())
                .age(Integer.parseInt(age.text()))
                .isLive(Boolean.parseBoolean(isLive.text()))
                .build();
    }

}
