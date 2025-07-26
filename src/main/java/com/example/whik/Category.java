package com.example.whik;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
	IDYLLIC("목가적"),
	TRANQUIL("평온한"),
	FAIRYTALE_LIKE("동화같은"),
	ROMANTIC("낭만적"),
	CALM("고요한"),
	VIBRANT("활기찬"),
	MYSTERIOUS("신비로운"),
	ABUNDANT("풍요로운"),
	ENERGETIC("에너지 넘치는"),
	PICTURESQUE("그림같은"),
	SPECTACULAR("절경"),
	MODERN("초현대적"),
	TRADITIONAL("전통적"),
	ANCIENT_RELICS("고대 유적"),
	NATURE_FRIENDLY("자연친화적"),
	BEACH("해변가"),
	MOUNTAINOUS("산악"),
	DESERT("사막"),
	HOT_SPRING("온천"),
	HEALING("힐링"),
	ADVENTUROUS("모험적"),
	THRILLING("짜릿한"),
	ROMANTIC_SPOTS("로맨틱한"),
	HISTORICAL("역사적"),
	STYLISH("세련된"),
	ARTISTIC("예술적"),
	WINE_REGION("와인 산지"),
	FESTIVAL("축제"),
	FOODIE("맛집"),
	COFFEE("커피"),
	BICYCLE("자전거"),
	SHOPPING("쇼핑"),
	SUNRISE_SPOTS("해돋이 명소"),
	SUNSET_SPOTS("해넘이 명소"),
	TROPICAL_RAINFOREST("열대우림"),
	MUSEUM("박물관"),
	ART_GALLERY("미술관"),
	CASINO("카지노"),
	CHIC("세련된"),
	CUTE("아기자기한"),
	FISHING("낚시"),
	SURFING("서핑"),
	SAFARI("사파리"),
	CAVE("동굴");


	private final String value;
}
