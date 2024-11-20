package org.festimate.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "matchings")
public class Matching {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer minHeight;

    @Column(nullable = false)
    private Integer maxHeight;

    @Column(nullable = false)
    private Integer minAge;

    @Column(nullable = false)
    private Integer maxAge;

    @Column(nullable = false)
    private String mbti;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private List<Appearance> appearanceList;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<Integer> questionList;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<String> timeList;

    @Column(nullable = false)
    private String dress;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Matching() {
    }

    public Matching(User user, Integer minHeight, Integer maxHeight, Integer minAge, Integer maxAge, String mbti,
                    List<Appearance> appearanceList, List<Integer> questionList, List<String> timeList, String dress) {
        this.user = user;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.mbti = mbti;
        this.appearanceList = appearanceList;
        this.questionList = questionList;
        this.timeList = timeList;
        this.dress = dress;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Integer getMinHeight() {
        return minHeight;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public String getMbti() {
        return mbti;
    }

    public List<Appearance> getAppearanceList() {
        return appearanceList;
    }

    public List<Integer> getQuestionList() {
        return questionList;
    }

    public List<String> getTimeList() {
        return timeList;
    }

    public String getDress() {
        return dress;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
