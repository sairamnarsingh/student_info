package com.spring.courses.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long bookid;
	private String bookname;
	private long price;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Courses > courses;
	/*
	 * @OneToOne(fetch = FetchType.LAZY, optional = false, cascade =
	 * CascadeType.ALL) private Author author;
	 */
}
