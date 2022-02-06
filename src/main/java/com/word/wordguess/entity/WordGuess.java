package com.word.wordguess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="word_details")
public class WordGuess {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable= false,name="id")
	private Long id;
	
	@Column(nullable = false,name="word",unique=true)
	private String word;
	
	@Column(nullable = false,name="count")
	private int count = 0;

	public Long getId() {
		return id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

}