package backend.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Battle {
    private Integer id;
    private Integer userId;
    private Integer categoryId;
    private Integer totalCount;
    private Integer correctCount;
    private List<BattleQuiz> battleQuiz;
}
