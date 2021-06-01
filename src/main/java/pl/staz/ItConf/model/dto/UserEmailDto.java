package pl.staz.ItConf.model.dto;

public class UserEmailDto {

    private String email;

    public UserEmailDto(String email) {
        this.email = email;
    }

    public UserEmailDto() {
    }

    public String getEmail() {
        return email;
    }
}
