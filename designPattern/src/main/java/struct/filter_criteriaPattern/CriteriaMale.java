package struct.filter_criteriaPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> newPersonList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase("male")) {
                newPersonList.add(person);
            }
        }
        return newPersonList;
    }
}
