package backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BattleQuiz {
    private Integer id;
    private Integer battleId;
    private Integer quizId;
    private Integer userId;
    private Integer userChoiceId;
}
