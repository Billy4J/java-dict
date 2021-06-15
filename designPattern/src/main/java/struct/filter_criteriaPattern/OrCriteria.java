package struct.filter_criteriaPattern;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.List;

public class OrCriteria implements Criteria {
    private Criteria criteria1;
    private Criteria criteria2;

    public OrCriteria(Criteria criteria1, Criteria criteria2) {
        this.criteria1 = criteria1;
        this.criteria2 = criteria2;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> res1 = criteria1.meetCriteria(personList);
        List<Person> res2 = criteria2.meetCriteria(personList);
        for (Person person : res2) {
            if (!res1.contains(person)) {
                res1.add(person);
            }
        }
        return res1;
    }
}
