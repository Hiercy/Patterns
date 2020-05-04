package com.mike.patterns.behavioral.Iterator.entity;

import com.mike.patterns.behavioral.Iterator.entity.iterator.Collection;
import com.mike.patterns.behavioral.Iterator.entity.iterator.Iterator;

import java.util.List;
import java.util.Objects;


public class User implements Collection {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private UserRole userRole;
    private List<Skills> skills;


    public User() {
    }

    public User(Long id, String name, String password, String email, String phone, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userRole = userRole;
    }

    public User(Long id, String name, String password, String email, String phone, UserRole userRole, List<Skills> skills) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userRole = userRole;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                name.equals(user.name) &&
                password.equals(user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, email, phone, userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userRole=" + userRole +
                ", skills=" + skills +
                '}';
    }

    @Override
    public Iterator getIterator() {
        return new SkillIterator();
    }

    private class SkillIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < skills.size();
        }

        @Override
        public Object next() {
            return skills.get(index++);
        }
    }
}
