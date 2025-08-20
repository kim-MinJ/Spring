package org.myclass.myboard;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.myclass.myboard.mapper.ComunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Transactional
@ComponentScan(basePackages = { "org.myclass" })
@MapperScan(basePackages = { "org.myclass" })
class MyboardApplicationTests {

	@Autowired
	private ComunityMapper comunityMapper;

	@Test
	void contextLoads() {
		assertNotNull(comunityMapper);
	}

}
