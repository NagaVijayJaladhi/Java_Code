package com.jaladhi.entity;


@Data
@NoArgsConstructor
@AllArgConstructor
@Builder
@Entity
@Table(name = "Student")
public class Student {
	
	@Id
	private long id;
	private String name;
	private String mobile;
	private String email;
	private String location;
	
	
}