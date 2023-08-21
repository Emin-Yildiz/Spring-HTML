package com.example.html.service;

import com.example.html.domain.UserHtml;
import com.example.html.repository.UserRepository;
import com.example.html.util.HtmlUtil;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    private final HtmlUtil htmlUtil;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository,HtmlUtil htmlUtil) {
        this.userRepository = userRepository;
        this.htmlUtil = htmlUtil;
    }
    public UserHtml addUsersFromHtml(MultipartFile file) throws IOException {
        htmlUtil.setDocument(file.getBytes());
        return userRepository.save(htmlUtil.getUser());
    }


    public List<UserHtml> getUsersFromDb() {
        return userRepository.findAll();
    }
}
