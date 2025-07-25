package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository repository;

//	@Autowired
//	private CourseJpaRepository repository;

	private final CourseSpringDataJpaRepository repository;

	public CourseCommandLineRunner(CourseSpringDataJpaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... args) {
		repository.save(new Course(1, "Learn AWS Jpa!", "in28minutes"));
		repository.save(new Course(2, "Learn Azure Jpa!", "in28minutes"));
		repository.save(new Course(3, "Learn DevOps Jpa!", "in28minutes"));
		
		repository.deleteById(1L);
		
		System.out.println(repository.findById(2L));
		System.out.println(repository.findById(3L));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByAuthor(""));

		System.out.println(repository.findByName("Learn AWS Jpa!"));
		System.out.println(repository.findByName("Learn DevOps Jpa!"));

		
	}

}
