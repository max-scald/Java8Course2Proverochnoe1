package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Person[] people = new Person[10];
        people[0] = new Person("A","Степан",25,45000);
        people[1] = new Person("B","Владимир",27,55000);
        people[2] = new Person("C","Алексей",35,50000);
        people[3] = new Person("D","Прохор",37,45000);
        people[4] = new Person("I","Иван",40,60000);
        people[5] = new Person("F","Алексей",25,40000);
        people[6] = new Person("G","Степан",20,35000);
        people[7] = new Person("H","Владимир",43,90000);
        people[8] = new Person("I","Александр",26,120000);
        people[9] = new Person("J","Иван",21,75000);

        PersonService service = new PersonService(people);
        System.out.println("sortByName============================================");
        List<Person> sortByName = new ArrayList<>();
        for (Person p:service.sortPersons(new Compatator())){
            sortByName.add(p);
        }

        for (Person p1:sortByName) {
            System.out.println(p1.toString());
        }

        System.out.println("findByAge============================================");
        List<Person> findByAge = new ArrayList<>();
        for (Person p:service.findPersonsByAge(20,30)){
            findByAge.add(p);
        }

        for (Person p1:findByAge) {
            System.out.println(p1.toString());
        }


        System.out.println("asMap============================================");

        Map<String, Person> map = service.getPersonAsMap();
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }




    }
}
