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
public class ToDo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, columnDefinition = "varchar(30)")
    private String name;
    @Column(nullable = false, columnDefinition = "varchar(300)")
    private String description;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isDone;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id"
    )
    Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    AppUser user;
}
