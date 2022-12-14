package com.dictionary.repository.impl;

import com.dictionary.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    static  Map<String, String> map = new HashMap<>();

    static {
        map.put("red", "đỏ");
        map.put("blue", "xanh dương");
        map.put("back", "đen");
        map.put("green", "xanh");
        map.put("white", "trắng");
        map.put("gray", "xám");
        map.put("pink", "hồng");
        map.put("violet", "tím");
        map.put("orange", "cam");
    }

    @Override
    public String checkWord(String wordInput) {
        Set<String> set = map.keySet();
        for (String key : set) {
            if (key.equals(wordInput)) {
                 return map.get(key);
            }
        }
        return null;
    }
}
