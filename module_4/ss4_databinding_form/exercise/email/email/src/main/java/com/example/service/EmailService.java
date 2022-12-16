package com.example.service;

import com.example.model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    static List<Email> emailList = new ArrayList<>();
    static List<String> languageList = new ArrayList<>();
    static List<Integer> pageSizeList = new ArrayList<>();


    static {
        emailList.add(new Email(1, "English", 10, true, "Thor King..."));
        emailList.add(new Email(2, "Vietnamese", 100, false, "Thor King..."));
        emailList.add(new Email(3, "Japanese", 5, false, "Thor King..."));
        emailList.add(new Email(4, "Chinese", 15, true, "Thor King..."));
        emailList.add(new Email(5, "Vietnamese", 25, true, "Thor King..."));
    }


    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }


    static {
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    public List<String> languageList() {
        return languageList;
    }

    public List<Integer> pageSizeList() {
        return pageSizeList;
    }

    public List<Email> emailList() {
        return emailList;
    }


    public void edit(Email email) {
        for (int i = 0; i < emailList.size(); i++) {
            if (emailList.get(i).getId() == email.getId()) {
                emailList.set(i, email);
            }
        }
    }


    public Email findById(int id) {
        for (Email email : emailList) {
            if (email.getId() == id) {
                return email;
            }
        }
        return null;
    }

}
