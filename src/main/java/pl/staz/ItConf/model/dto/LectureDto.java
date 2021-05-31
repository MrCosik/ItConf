package pl.staz.ItConf.model.dto;

import javax.persistence.Column;

public class LectureDto {

    private Long lectureId;
    private Long topicNumber;
    private Long appUserId;
    private String startHour;
    private String endHour;

    public LectureDto(Long lectureId, Long topicNumber, Long appUserId) {
        this.lectureId = lectureId;
        this.topicNumber = topicNumber;
        this.appUserId = appUserId;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public Long getTopicNumber() {
        return topicNumber;
    }

    public Long getAppUserId() {
        return appUserId;
    }
}
