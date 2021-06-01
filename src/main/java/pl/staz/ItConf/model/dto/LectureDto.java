package pl.staz.ItConf.model.dto;

public class LectureDto {

    private Long lectureNumber;
    private Long topicNumber;
    private Long appUserId;
    private String startHour;
    private String endHour;

    public LectureDto(Long lectureId, Long topicNumber, Long appUserId) {
        this.lectureNumber = lectureId;
        this.topicNumber = topicNumber;
        this.appUserId = appUserId;

        switch (lectureNumber.intValue()){
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

    public String getStartHour() {
        return startHour;
    }

    public String getEndHour() {
        return endHour;
    }
}
