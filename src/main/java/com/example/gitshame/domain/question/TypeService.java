package com.example.gitshame.domain.question;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    @Resource
    private TypeRepository typeRepository;

    public Type getType(Integer typeId) {
        return typeRepository.getReferenceById(typeId);
    }
}
