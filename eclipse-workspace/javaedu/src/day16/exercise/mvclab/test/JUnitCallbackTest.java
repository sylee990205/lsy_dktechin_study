package day16.exercise.mvclab.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitCallbackTest {
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("모든 테스트 메서드 수행전 최초로 수행~~");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("모든 테스트 메서드 수행후 마지막 수행~~");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("테스트 메서드가 수행될 때마다 먼저 수행~~");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("테스트 메서드가 수행될 때마다 이후 수행~~");
	}

	@Test
	void test1() {
		assertEquals(1, Integer.parseInt("1"));
		System.out.println("테스트 메서드(1) 수행~~");
	}
	
	@Test
	void test2() {
		assertEquals(2, Integer.parseInt("2"));
		System.out.println("테스트 메서드(2) 수행~~");
	}
	
	@Test
	void test3() {
		assertEquals(3, Integer.parseInt("3"));
		System.out.println("테스트 메서드(3) 수행~~");
	}
}
