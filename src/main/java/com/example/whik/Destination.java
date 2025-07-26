package com.example.whik;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Destination {
    @Id
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
