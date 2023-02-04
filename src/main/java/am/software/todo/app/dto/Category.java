package am.software.todo.app.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, columnDefinition = "varchar(50)")
    private String name;
    @Column(columnDefinition = "varchar(100) default 'default_category_avatar.jpg'")
    private String imageName;
}
