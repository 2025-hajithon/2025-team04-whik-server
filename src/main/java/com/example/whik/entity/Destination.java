package com.example.whik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_id")
    private Long id;

    private String name;

    private String description;

    @Builder(access = AccessLevel.PRIVATE)
    private Destination(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Destination create(String name, String description) {
        return Destination.builder()
                .name(name)
                .description(description).build();
    }
}
