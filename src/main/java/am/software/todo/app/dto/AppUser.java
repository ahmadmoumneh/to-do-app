package am.software.todo.app.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, columnDefinition = "varchar(30)")
    private String username;
    @Column(nullable = false, unique = true, columnDefinition = "varchar(50)")
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "varchar(100) default 'default_user_avatar.jpg'")
    private String avatar;
}
