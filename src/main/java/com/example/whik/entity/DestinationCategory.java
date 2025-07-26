package com.example.whik.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DestinationCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "destination_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id")
    private Destination destination;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Builder(access = AccessLevel.PRIVATE)
    private DestinationCategory(Destination destination, Category category) {
        this.destination = destination;
        this.category = category;
    }

    public static DestinationCategory create(Destination destination, Category category) {
        return DestinationCategory.builder()
                .destination(destination)
                .category(category).build();
    }
}
