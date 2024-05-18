package com.example.sopkathon.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(schema = "sopkathon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uglyImage;

    private String shakingImage;

    private String shavingImage1;

    private String shavingImage2;

    private String prettyImage;

    private String question;

    private String answer;

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
