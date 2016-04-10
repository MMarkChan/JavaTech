package validator.cconstraints;

import javax.validation.constraints.NotNull;

/**
 * Created by Mark on 2016/1/19.
 */
public class Person {

    @NotNull
    private String name;

    public Person(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
