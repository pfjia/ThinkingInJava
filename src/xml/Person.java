package xml;

import nu.xom.Element;

import java.util.HashMap;

public class Person {
    private String first, last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Element getXML() {
        Element person = new Element("person");
        return person;
    }

    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }

    HashMap
}