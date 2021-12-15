package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity // 엔티티로 지정
@Table(name = "Todo") // 테이블 이름 이름 지정
public class TodoEntity {
    @Id //기본키가 될 필드
    @GeneratedValue(generator="system-uuid") // id를 자동으로 생성. generator -> id를 생성하는 방식
    @GenericGenerator(name="system-uuid", strategy="uuid") // uuid를 사용하는 system-uuid라는 이름의 generator 생성
    private String id; // 오브젝트 아이디
    private String userId; // 오브젝트를 생성한 사용자의 아이디
    private String title; // Todo 타이틀
    private boolean done; // true - todo를 완료한 경우
}
