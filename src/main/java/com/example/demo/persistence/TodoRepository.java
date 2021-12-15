package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 스프링이 관리하는 클래스
public interface TodoRepository extends JpaRepository<TodoEntity, String> { // TodoEntity: 테이블에 매핑될 엔티티 클래스, String: 기본 키 id의 타입
}
