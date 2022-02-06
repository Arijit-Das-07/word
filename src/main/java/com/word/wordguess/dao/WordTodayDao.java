package com.word.wordguess.dao;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import com.word.wordguess.entity.WordToday;

public interface WordTodayDao extends JpaRepository<WordToday, Long> {

	WordToday findByToday(LocalDate now);
}

