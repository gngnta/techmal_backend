package backend.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    private Integer id;
    private Integer categoryId;
    private String question;
    private String explanation;
    private Integer level;
    private List<Choice> choices;
}
