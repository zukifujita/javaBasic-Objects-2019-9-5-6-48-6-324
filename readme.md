# Overview

This repository is a part of the Java language training plan. Please read the following guidelines before start.

# Getting Start

## Basic Principals

Each repository contains a gradle java project with a number of unit tests. The initial state of all unit tests are *FAILED*. So the aim is to correct the failed test. Please follow the following steps to get the best experience:

* Read the test code and try to understand what it says.
* Trying to fix the test **WITHOUT RUNNING**. This is very important. Because once you run the test, you may find the failure message of the test telling you the expected result. That means you may lose the chance to figure it out by yourself. Note that you should **ONLY** be able to modify code within the **TODO AREA**. The code outside the **TODO AREA** is **NOT** changable.
* Run the test to examine if the fix is correct.
* Answer the following 4 questions after the test is passed.

The 4 questions are:

1. What is the knowledge point of the test? Where is the offical document to the knowledge point?
1. Why the test failed at first?
1. Why you corrected the test that way?
1. Do you have further questions on this knowledge point?

## Example

Let's take a look at an example:

```java
@Test
void should_pass_by_value() {
  int value = 5;

  tryingToUpdateValue(value);

  // TODO: please modify the following code to pass the test
  // <--start
  final int expected = 0;
  // --end-->

  assertEquals(expected, value);
}
```

First, read the test. From the title and code we can know that the test what to examine the behavior when passing an argument. We are not sure what `tryingToUpdateValue` does, so we can jump into its implementation:

```java
private static void tryingToUpdateValue(int value) {
  value += 2;
}
```

Now we have got the full context of the test. The argument is passed by value so the integer will be copied when passing into `tryingToUpdateValue`. Thus the value from the caller site will not change.

Notice that the todo area is in the test method. So we can modify codes within the todo area to pass the test:

```java
  // TODO: please modify the following code to pass the test
  // <--start
  final int expected = 5;
  // --end-->
```

Please note that not all todo areas are located in test method. And some todo area may have further restrictions, for example:

```java
  // TODO: You should not write concrete number here. Please find a property or constant instead.
  // <!--start
  final int maximumSymbol = 0;
  final int minimumSymbol = 0;
  // --end-->
```

The hint indicates that we should not write concrete number here. So I should not write `3` or `0xffffffff`, but write symbol (e.g. `Integer.MAX_VALUE`).

## Running Test

You could run unit tests with the help of IntelliJ. But it is also possible to run unit test via command line: `./gradlew build`.

If you just want to build your code without running test. Please use `./gradlew build -x test
`

- ANSWERS

1. What is the knowledge point of the test? Where is the official document to the knowledge point?

* 1. ExceptionTest
    * should_customize_exception - To modify the exception handling.
    * should_customize_exception_continued - To modify the exception handler with an instantiated object.
    * should_be_careful_of_the_order_of_finally_block - To get the result depending on what handling is being done from the method.
    * should_call_closing_even_if_exception_throws - To call the method from the other object.
    * should_get_method_name_in_stack_frame - To get the method name from the other object.

* 1. InheritanceTest
    * should_be_derived_from_object_class - To get what is the return values from the super class.
    * should_call_super_class_constructor - To get what are the constructors from the super class.
    * should_call_super_class_constructor_continued - To get what are the constructors from the super class with an integer argument.
    * should_call_super_class_constructor_more - To get what are the constructors from the super class with a string argument.
    * should_call_most_derived_methods - To get what is the override value in a constructor from the super class.
    * should_call_super_class_methods - To call the methods from the super class.
    * should_use_caution_when_dealing_with_array_type - To handle exception when the index of an array is not equal to how many indices are in the super class.
    * should_not_make_you_confused - To know how to initialize an object to another object, and calls the method from the super class.
    * should_not_make_you_confused_2 - Instantiate a class, and calls the method from the super class.
    * should_use_instance_of_to_determine_inheritance_relationship - To determine what are the relationship of the classes.
    * should_use_instance_of_only_in_inheritance_relationship - Inherit methods from a constructor with an integer argument.
    * should_write_perfect_equals_1-3 - To determine if the name and birth year is the same
    * should_write_perfect_equals_4 - To determine if the person name is equal to null.
    * should_write_perfect_equals_5 - To determine if the person name is equal to an instantiated variable.
    * should_write_perfect_equals_6 - To determine if the values of the instantiated variable is equal to another values of an instantiated variable.
    * should_write_perfect_equals_7 - To make use of hashCode to determine if the values of an instantiated variables are equal.

* 1. ObjectTest
    * should_point_to_the_same_object - To know how to point if the instantiated objects are the same.
    * should_point_to_different_object - To know how to point if the instantiated objects are different.
    * should_initialized_to_default_value - To know how to initialize to default value from the instantiated class.
    * should_pass_by_value - To know how to pass a value to the method.
    * should_pass_by_value_continued - To know how to pass a value to the method, and place the new value to a variable.
    * should_modify_internal_state - To know how to modify a value using the passed object.
    * should_choose_method_at_compile_time - To know how to choose a method with an argument.
    * should_choose_the_most_specific_overload - To know how to choose a specific method with some arguments.
    * should_calling_another_constructor - To know how to get the values from the constructor.
    * should_get_initialization_ordering - To know how many logs are being returned from the instance.
    * should_get_message_of_var_length_parameters & 2 - To know how to get the length of the parameters.

1. Why the test failed at first?

    * The expected values does not have any values, and no implemented classes.

1. Why you corrected the test that way?

* 1. ExceptionTest
    * should_customize_exception - Modified the exception handling.
    * should_customize_exception_continued - Modified exception handling with an instantiated object.
    * should_be_careful_of_the_order_of_finally_block - Put some handling on a method that is being used.
    * should_call_closing_even_if_exception_throws - Calling the method from the other object, and see what are the logs that are being returned.
    * should_get_method_name_in_stack_frame - Calling the method name from stack frame, and see what are the logs that are being returned.

* 1. InheritanceTest
    * should_be_derived_from_object_class - Depending on what is result from the super class.
    * should_call_super_class_constructor - The initialized class is only in the specific class. The super class is not being called.
    * should_call_super_class_constructor_continued -  Getting the values of the constructors from the super class.
    * should_call_super_class_constructor_more - Getting the values of the constructors from the super class, which have the string argument.
    * should_call_most_derived_methods - Overrides the methods from the super class.
    * should_call_super_class_methods - Calling the methods from the super class.
    * should_use_caution_when_dealing_with_array_type - Expected value should be what exception is thrown, since the array index is not equal to the indices of the class.
    * should_not_make_you_confused - Overrides the return value from DerivedFromBaseClassWithName to NestedDerivedClassWithName.
    * should_not_make_you_confused_2 - Return values from DerivedFromBaseClassWithName.
    * should_use_instance_of_to_determine_inheritance_relationship - NestedDerivedClassWithName is only instantiated, since it extends the DerivedFromBaseClassWithName and DerivedFromBaseClassWithName.
    * should_use_instance_of_only_in_inheritance_relationship - The object was initialized by Integer, and Long is an instance of Integer.
    * should_write_perfect_equals_1-6 - Put some conditions in a function that is being used, depending on what should be the values are equal to, and what is the return value.
    * should_write_perfect_equals_7 - Searched some functions of hashCode, and tried Objects.hashCode() method.

* 1. ObjectTest
    * should_point_to_the_same_object - Same reference object.
    * should_point_to_different_object - Instantiated object are not the same.
    * should_initialized_to_default_value - The initialized variable are null.
    * should_pass_by_value - Passed the value to a method, and return the value.
    * should_pass_by_value_continued - Passed the value to a method, and instantiate to a new variable, and return the value.
    * should_modify_internal_state - Modified the value using the object that is being passed.
    * should_choose_method_at_compile_time - Chose a method, depending if it has an argument
    * should_choose_the_most_specific_overload - Chose a method, depending if it has a different arguments.
    * should_calling_another_constructor - Getting the values from a constructor.
    * should_get_initialization_ordering - Check the logs that are being returned, and place it in an array variable.
    * should_get_message_of_var_length_parameters & 2 - The parameters only have numbers, so it can be the same.

1. Do you have further questions on this knowledge point?
    * None.
