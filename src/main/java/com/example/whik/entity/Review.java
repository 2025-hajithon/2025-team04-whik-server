package com.example.whik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_id")
	private Destination destination;

	@Enumerated(EnumType.STRING)
	private Category category;

	private String content;

	private Double rating;

	@Builder(access = AccessLevel.PRIVATE)
	private Review(Member member, Destination destination, Category category, String content, Double rating) {
		this.member = member;
		this.destination = destination;
		this.category = category;
		this.content = content;
		this.rating = rating;
	}

	public static Review create(Member member, Destination destination, Category category, String content, Double rating) {
		return Review.builder()
				.member(member)
				.destination(destination)
				.category(category)
				.content(content)
				.rating(rating)
				.build();
	}
}
