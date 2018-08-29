package com.felipeteles.filterTest.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document(collection="user")
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@NotNull(message = "Field \"name\" can not be emptys.")
	private String name;
	
	@NotNull(message = "Field \"age\" can not be emptys.")
	private int age;
	
	public User() {
		
	}
	
	public User(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
}
