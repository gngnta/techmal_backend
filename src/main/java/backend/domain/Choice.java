package backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    private Integer id;
    private Integer quizId;
    private String choiceText;
    private Boolean isCorrect;
    private String label;
}
