package ch.zhaw.roma.model.form;

import java.util.ArrayList;
import java.util.List;

public class Greeting {



    public static final List<String> GREETINGS = new ArrayList<String>() {{
        add("Herr");
        add("Frau");
        add("Dr.");
        add("Prof.");
    }};


    private String greetingString;


    public Greeting(String greeting) {
        this.greetingString = greeting;
    }

    public Greeting() {
    }

    public String getGreetingString() {
        return greetingString;
    }

    public void setGreetingString(String greetingString) {
        this.greetingString = greetingString;
    }



}
