package day3.entity;

/**
 * @author yi xian
 * @description
 * @date 2023/6/8 8:31
 */
public class Course {
    private int id;
    private String name;
    private int examDuration;

    public Course() {
    }

    @Override
    public String toString() {
        return "Cousrse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", examDuration=" + examDuration +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }
}
