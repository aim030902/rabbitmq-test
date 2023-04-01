package uz.aim.rabbitmqtest.dtos;

import lombok.*;

/**
 * @author : Abbosbek Murodov
 * @since : 01/04/23 / 15:51
 * Project : rabbitmq-test / IntelliJ IDEA
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {
    private Integer id;
    private String fullName;
    private String username;
    private String password;
}
