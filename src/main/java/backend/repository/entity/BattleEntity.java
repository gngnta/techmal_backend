package backend.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "battles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BattleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(name = "total_count")
    private Integer totalCount;

    @Column(name = "correct_count")
    private Integer correctCount;

    @OneToMany(mappedBy = "battle")
    private List<BattleQuizEntity> battleQuizzes;
}
