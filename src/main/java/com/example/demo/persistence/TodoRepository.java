package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 스프링이 관리하는 클래
public interface TodoRepository extends JpaRepository<TodoEntity, String> { // TodoEntity: 테이블에 매핑될 엔티티 클래스, String: 기본 키 id의 타입
    // 메서드 이름: 쿼리
    // 매개변수: 쿼리의 where에 들거갈 값
    List<TodoEntity> findByUserId(String userId);
}
