package com.example.gitshame.domain.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("select i from Image i where i.id = ?1 and i.data = ?2")
    List<Image> getAvatarsBy();

}