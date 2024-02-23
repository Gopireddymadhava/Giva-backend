package com.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = GivaApplication.class)
class GivaApplicationTests {
private Calculator calc=new Calculator();
	@Test
	void contextLoads() {
	}
	@Test
	public void testSum() {
		
		int expectedresult=16;
		int actualResult=calc.dosum(12,3, 2);
		
		assertThat(actualResult).isEqualTo(expectedresult);
	}

}
