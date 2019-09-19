package com.cultivation.javaBasic;

import com.cultivation.javaBasic.showYourIntelligence.PersonForEquals;
import com.cultivation.javaBasic.util.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InheritanceTest {

    @Test
    void should_be_derived_from_object_class() {
        // TODO: please modify the following code to pass the test
        // <--start
        final Class<?> expectedSuperClass = SimpleEmptyClass.class.getSuperclass();
        // --end-->

        assertEquals(expectedSuperClass, SimpleEmptyClass.class.getSuperclass());
    }

    @Test
    void should_call_super_class_constructor() {
        DerivedFromSuperClassWithDefaultConstructor instance = new DerivedFromSuperClassWithDefaultConstructor();

        // TODO: please modify the following code to pass the test
        // <--start
        final String[] expected = {"SuperClassWithDefaultConstructor.constructor()", "DerivedFromSuperClassWithDefaultConstructor.constructor()"};
        // --end-->

        String[] logs = instance.getLogs();

        assertArrayEquals(expected, logs);
    }

    @Test
    void should_call_super_class_constructor_continued() {
        DerivedFromSuperClassWithDefaultConstructor instance = new DerivedFromSuperClassWithDefaultConstructor(42);

        // TODO: please modify the following code to pass the test
        // <--start
        final String[] expected = {"SuperClassWithDefaultConstructor.constructor()", "DerivedFromSuperClassWithDefaultConstructor.constructor()", "DerivedFromSuperClassWithDefaultConstructor.constructor(int)", };
        // --end-->

        String[] logs = instance.getLogs();

        assertArrayEquals(expected, logs);
    }

    @Test
    void should_call_super_class_constructor_more() {
        DerivedFromSuperClassWithDefaultConstructor instance = new DerivedFromSuperClassWithDefaultConstructor("God");

        // TODO: please modify the following code to pass the test
        // <--start
        final String[] expected = {"SuperClassWithDefaultConstructor.constructor(String)", "DerivedFromSuperClassWithDefaultConstructor.constructor(String)"};
        // --end-->

        String[] logs = instance.getLogs();

        assertArrayEquals(expected, logs);
    }

    @Test
    void should_call_most_derived_methods() {
        BaseClassForOverriding instance = new DerivedFromBaseClassForOverriding();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expectedName = instance.getName();
        // --end-->

        assertEquals(expectedName, instance.getName());
    }

    @Test
    void should_call_super_class_methods() {
        DerivedFromBaseClassForOverridingCallingSuper instance = new DerivedFromBaseClassForOverridingCallingSuper();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expectedName = instance.getName();
        // --end-->

        assertEquals(expectedName, instance.getName());
    }

    @SuppressWarnings({"ConstantConditions", "RedundantCast", "UnnecessaryLocalVariable"})
    @Test
    void should_use_caution_when_dealing_with_array_type() {
        DerivedFromSuperClassWithDefaultConstructor[] array = new DerivedFromSuperClassWithDefaultConstructor[4];
        SuperClassWithDefaultConstructor[] arrayWithBaseType = (SuperClassWithDefaultConstructor[])array;

        boolean willThrow = false;

        try {
            arrayWithBaseType[arrayWithBaseType.length - 1] = new SuperClassWithDefaultConstructor();
        } catch (Exception error) {
            willThrow = true;
        }

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Boolean> expected = Optional.of(willThrow);
        // --end-->

        assertEquals(expected.get(), willThrow);
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @Test
    void should_not_make_you_confused() {
        NestedDerivedClassWithName nested = new NestedDerivedClassWithName();
        DerivedFromBaseClassWithName derived = nested;

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = nested.getName();
        // --end-->

        assertEquals(expected, derived.getName());
    }

    @Test
    void should_not_make_you_confused_2() {
        DerivedFromBaseClassWithName derived = new DerivedFromBaseClassWithName();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = derived.getName();
        // --end-->

        assertEquals(expected, derived.getName());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_use_instance_of_to_determine_inheritance_relationship() {
        NestedDerivedClassWithName nested = new NestedDerivedClassWithName();

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Boolean> expectedResult1 = Optional.of(nested instanceof NestedDerivedClassWithName);
        final Optional<Boolean> expectedResult2 = Optional.of(nested instanceof DerivedFromBaseClassWithName);
        final Optional<Boolean> expectedResult3 = Optional.of(nested instanceof BaseClassWithName);
        // --end-->

        assertEquals(expectedResult1.get(), nested instanceof NestedDerivedClassWithName);
        assertEquals(expectedResult2.get(), nested instanceof DerivedFromBaseClassWithName);
        assertEquals(expectedResult3.get(), nested instanceof BaseClassWithName);
    }

    @SuppressWarnings({"ConstantConditions", "UnnecessaryBoxing"})
    @Test
    void should_use_instance_of_only_in_inheritance_relationship() {
        final Object integer = new Integer(42);  // the magic of life

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Boolean> expectedResult1 = Optional.of(integer instanceof Integer);
        final Optional<Boolean> expectedResult2 = Optional.of(integer instanceof Long);
        // --end-->

        assertEquals(expectedResult1.get(), integer instanceof Integer );
        assertEquals(expectedResult2.get(), integer instanceof Long );
    }

    @SuppressWarnings({"SimplifiableJUnitAssertion", "EqualsWithItself"})
    @Test
    void should_write_perfect_equals_1() {
        PersonForEquals person = new PersonForEquals("James", (short) 1990);

        assertTrue(person.equals(person));
    }

    @SuppressWarnings("SimplifiableJUnitAssertion")
    @Test
    void should_write_perfect_equals_2() {
        PersonForEquals person = new PersonForEquals("James", (short) 1990);
        PersonForEquals samePerson = new PersonForEquals("James", (short) 1990);

        assertTrue(person.equals(samePerson));
        assertTrue(samePerson.equals(person));
    }

    @SuppressWarnings("SimplifiableJUnitAssertion")
    @Test
    void should_write_perfect_equals_3() {
        PersonForEquals person = new PersonForEquals("James", (short) 1990);
        PersonForEquals samePerson = new PersonForEquals("James", (short) 1990);
        PersonForEquals stillTheSamePerson = new PersonForEquals("James", (short) 1990);

        assertTrue(person.equals(samePerson));
        assertTrue(samePerson.equals(stillTheSamePerson));
        assertTrue(person.equals(stillTheSamePerson));
    }

    @SuppressWarnings({"ConstantConditions", "ObjectEqualsNull", "SimplifiableJUnitAssertion"})
    @Test
    void should_write_perfect_equals_4() {
        PersonForEquals person = new PersonForEquals("James", (short) 1990);

        assertFalse(person.equals(null));
    }

    @SuppressWarnings({"EqualsBetweenInconvertibleTypes", "SimplifiableJUnitAssertion", "UnnecessaryBoxing"})
    @Test
    void should_write_perfect_equals_5() {
        PersonForEquals person = new PersonForEquals("James", (short) 1990);
        Integer instanceWithOtherType = new Integer(1990);

        assertFalse(person.equals(instanceWithOtherType));
    }

    @SuppressWarnings("SimplifiableJUnitAssertion")
    @Test
    void should_write_perfect_equals_6() {
        PersonForEquals person = new PersonForEquals("James", (short) 1990);
        PersonForEquals different = new PersonForEquals("James", (short) 1991);

        assertFalse(person.equals(different));
        assertFalse(different.equals(person));
    }

    @Test
    void should_write_perfect_equals_7() {
        PersonForEquals person = new PersonForEquals("James", (short) 1990);
        PersonForEquals different1 = new PersonForEquals("James", (short) 1991);
        PersonForEquals different2 = new PersonForEquals("Harry", (short) 1990);
        PersonForEquals samePerson = new PersonForEquals("James", (short) 1990);

        assertNotEquals(person.hashCode(), different1.hashCode());
        assertNotEquals(person.hashCode(), different2.hashCode());
        assertEquals(person.hashCode(), samePerson.hashCode());
    }
}