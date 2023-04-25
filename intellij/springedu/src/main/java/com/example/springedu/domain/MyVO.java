package com.example.springedu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor // 모든 멤버변수의 값을 셋팅받는 생성자를 만들어라
@ToString
public class MyVO {
	private int myNumber;
	private String myColor;	
}
