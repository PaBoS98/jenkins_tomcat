package service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Data
@Getter
@Setter
@ToString
public class UserDto {

    private long id;
    private String name;
    private String email;
    private String password;

    public UserDto(Builder userDto) {
        this.id = userDto.id;
        this.name = userDto.name;
        this.email = userDto.email;
        this.password = userDto.password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id == userDto.id && Objects.equals(name, userDto.name) && Objects.equals(email, userDto.email) && Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    public static class Builder {

        private long id;
        private String name;
        private String email;
        private String password;

        public Builder() {
        }

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}
