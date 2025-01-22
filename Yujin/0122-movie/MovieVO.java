package day11;

public class MovieVO {
    private String title;
    private String openDay;
    private String actor;
    private String genre;
    private String runningtime;
    private String grade;

    public MovieVO(){}
    //생성자
    public MovieVO(String title,String openDay,String actor,String genre,String runningtime,String grade){
        this.title = title;
        this.openDay = openDay;
        this.actor = actor;
        this.genre = genre;
        this.runningtime =runningtime;
        this.grade = grade;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpenDay() {
        return openDay;
    }

    public void setOpenDay(String openDay) {
        this.openDay = openDay;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRunningtime() {
        return runningtime;
    }

    public void setRunningtime(String runningtime) {
        this.runningtime = runningtime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "MovieVO{" +
                "title='" + title + '\'' +
                ", openDay='" + openDay + '\'' +
                ", actor='" + actor + '\'' +
                ", genre='" + genre + '\'' +
                ", runningtime='" + runningtime + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
