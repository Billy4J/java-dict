package struct.filter_criteriaPattern;

import java.util.ArrayList;
import java.util.List;

public class Filter_CriteriaPattern {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList = new CriteriaMale().meetCriteria(personList);
    }
}
