package com.dhirajtech.in.repository;

import com.dhirajtech.in.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findBySlugAndPublishedTrue(String slug);
    @Query("select p from Post p where p.published=true order by p.publishedAt desc")
    Page<Post> findPublished(Pageable pageable);
    boolean existsBySlug(String slug);
}
