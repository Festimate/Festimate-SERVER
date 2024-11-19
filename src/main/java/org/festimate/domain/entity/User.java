package org.festimate.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Integer age;

    @Column()
    private String school;

    @Column(nullable = false)
    private Integer height;

    @Column(nullable = false)
    private String mbti;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private List<Appearance> appearanceList;

    // 작성 날짜
    @Column
    public LocalDateTime createdAt;

    public User() {}

    public User(String username, String nickname, Integer age, String gender, String school, Integer height, String mbti, List<Appearance> appearanceList) {
        this.username = username;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.school = school;
        this.height = height;
        this.mbti = mbti;
        this.appearanceList = appearanceList;
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getNickname() { return nickname; }
    public Integer getAge() { return age; }
    public String getGender() { return gender; }
    public String getSchool() { return school; }
    public Integer getHeight() { return height; }
    public String getMbti() { return mbti; }
    public List<Appearance> getAppearanceList() { return appearanceList; }
}