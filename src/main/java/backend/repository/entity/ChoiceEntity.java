package backend.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "choices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private QuizEntity quiz;

    @Column(name = "choice_text", columnDefinition = "TEXT", nullable = false)
    private String choiceText;

    @Column(name = "is_correct", nullable = false)
    private Boolean isCorrect;

    @Column(nullable = false, length = 1)
    private String label;
}
