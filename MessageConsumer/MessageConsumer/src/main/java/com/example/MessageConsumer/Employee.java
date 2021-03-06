package com.example.MessageConsumer;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Employee 
{

	private Long id;
	private String name;
	private int age;
	private int salary;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary
				+ ", id=" + id + "]";
	}
	
	
}
