package org.iclass.spring_7jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.iclass.spring_7jpa.entity.TodoEntity;
import org.iclass.spring_7jpa.entity.UserAccountEntity;
import org.iclass.spring_7jpa.repository.UserAccountRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class AccountRepositoryTest {

  @Autowired
  private UserAccountRepository userAccountRepository;

  @Test
  void selectAll() {
    List<UserAccountEntity> list = userAccountRepository.findAll();
    assertEquals(list.size(), userAccountRepository.count());
  }

}
