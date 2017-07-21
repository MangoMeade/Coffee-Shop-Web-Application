package com.test.POJOs;

import java.util.Arrays;

/*
Aaron Board

7/20/2017
 */
public class Person {
    private String name;
    private int age;
    private long phone;
    private String email;
    private String sex;
    private String[] coffeePrefs;

    public Person() {
    }

    public String[] getCoffeePrefs() {
        return coffeePrefs;
    }

    public void setCoffeePrefs(String[] coffeePrefs) {
        this.coffeePrefs = coffeePrefs;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", coffeePrefs=" + Arrays.toString(coffeePrefs) +
                '}';
    }
}
