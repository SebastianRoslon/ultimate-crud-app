package pl.roslon.ultimate.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.roslon.ultimate.entity.Teacher;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {

    private List<Teacher> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

}
