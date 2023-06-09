package day3.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yi xian
 * @description
 * @date 2023/6/8 8:37
 */
// 试卷中的题目：试题，用户答案 0 1 2 3
public class Questioninfo {
    private Question question;
    private List<Integer> userAnswers;

    public Questioninfo() {

    }

    public Questioninfo(Question question) {
        this.question = question;
        userAnswers = new ArrayList<>();
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Integer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<Integer> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
