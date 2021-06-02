package pl.staz.ItConf.model.dao;

public class LectureDao {

    private final Long topicNumber;
    private final Long lectureNumber;
    private Long appUserId;
    private int numberOfAttendees;
    private String startHour;
    private String endHour;

    public LectureDao(Long lectureNumber, Long topicNumber, int numberOfAttendees) {
        this.topicNumber = topicNumber;
        this.lectureNumber = lectureNumber;
        this.numberOfAttendees = numberOfAttendees;

        //lecture numbers are changed to strings of time for easier read
        switch (lectureNumber.intValue()) {
            case 1:
                startHour = "10:00";
                endHour = "11:45";
                break;
            case 2:
                startHour = "12:00";
                endHour = "13:45";
                break;
            case 3:
                startHour = "14:00";
                endHour = "15:45";
                break;

        }
    }

    public Long getLectureNumber() {
        return lectureNumber;
    }

    public Long getTopicNumber() {
        return topicNumber;
    }

    public Long getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(Long appUserId) {
        this.appUserId = appUserId;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
}
