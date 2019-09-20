package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
public class PersonForEquals {
    private final String name;
    private final short yearOfBirth;

    public PersonForEquals(String name, short yearOfBirth) {
        if (name == null) {
            throw new IllegalArgumentException("name is mandatory.");
        }

        if (yearOfBirth <= 1900 || yearOfBirth >= 2019) {
            throw new IllegalArgumentException("year of birth is out of range.");
        }

        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }


    public String getName() {
        return name;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    @SuppressWarnings("Contract")
    @Override
    public boolean equals(Object obj) {
        // TODO: please modify the following code to pass the test
        // <--start
        if (obj == null) {
            return false;
        } else if (!obj.equals(null)) {
            if (!obj.equals(getYearOfBirth())) {
                return false;
            } else {
                return true;
            }
        }

        throw new NotImplementedException();
        // --end-->
    }

    @Override
    public int hashCode() {
        // TODO: please modify the following code to pass the test
        // <--start

        if (name == null) {
            return 0;
        } else if (!name.equals(null)) {
            if (yearOfBirth != getYearOfBirth()) {
                return 0;
            } else {
                return Objects.hash(name, yearOfBirth);
            }
        }

        throw new NotImplementedException();

//        throw new NotImplementedException();
        // --end-->
    }
}
