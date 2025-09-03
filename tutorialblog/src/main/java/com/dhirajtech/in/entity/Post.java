package com.dhirajtech.in.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String title;
    @Column(unique = true, nullable=false)
    private String slug;
    @Lob
    private String content; // markdown or html
    private String excerpt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "post_tags",
            joinColumns = @JoinColumn(name="post_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id"))
    private Set<Tag> tags = new HashSet<>();
    private boolean published = true;
    private LocalDateTime publishedAt = LocalDateTime.now();
    private String metaTitle;
    private String metaDescription;
    private String coverImageUrl;

}