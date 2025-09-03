package com.dhirajtech.in.repository;

import com.dhirajtech.in.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Optional<Tag> findBySlug(String slug);
}
