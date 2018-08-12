package net.sshplendid.examples.spring.students;

public class Student {
    private long id;
    private String name;
    private long age;
    private String gender;


    public Student(long id, String name, long age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
