package com.example.springedu.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmpVO {
	private int empno;
	private String ename;
	private String job;
	private String hiredate;
	private int sal;	
}
