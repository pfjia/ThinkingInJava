package xml;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

import java.util.ArrayList;

/**
 * Created by pfjia on 2017/4/27 0027.
 */
public class People extends ArrayList<Person> {
    public People(String fileName) throws Exception {
        Document doc = new Builder().build(fileName);
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws Exception {
        People p = new People("Person.xml");
        System.out.println(p);
    }
}
