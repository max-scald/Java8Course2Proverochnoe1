package Task1;

import java.util.*;

public class PersonService {
    Person [] people;

    public PersonService(Person[] people) {
        this.people = people;
    }

    public Person[] getPeople() {
        return people;
    }

    public List<Person> sortPersons(Compatator c){
        List<Person> newList = new ArrayList<>();
        for (Person p:people) {
            newList.add(p);
        }
        Collections.sort(newList,c);
      return newList;
    }

    public List<Person> findPersonsByAge(int fromAge, int toAge){
        List<Person> ageList = new ArrayList<>();
        for (Person p:people) {
            if(p.getAge() > fromAge && p.getAge() < toAge){
                ageList.add(p);
            }

        }
        return ageList;
    }

    public Map<String, Person> getPersonAsMap() {
        Map<String, Person> personMap = new TreeMap<>();
        for (Person p:people) {
            personMap.put(p.getId(),p);
        }
        return personMap;
    }
}
