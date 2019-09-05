package com.cultivation.javaBasic;

import com.cultivation.javaBasic.showYourIntelligence.StackFrameHelper;
import com.cultivation.javaBasic.util.ClosableStateReference;
import com.cultivation.javaBasic.util.ClosableWithException;
import com.cultivation.javaBasic.util.ClosableWithoutException;
import com.cultivation.javaBasic.util.MyClosableType;
import com.cultivation.javaBasic.showYourIntelligence.StringFormatException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ExceptionTest {
    @Test
    void should_customize_exception() {
        try {
            throw new StringFormatException("the message");
        } catch (StringFormatException error) {
            assertEquals("the message", error.getMessage());
        }
    }

    @Test
    void should_customize_exception_continued() {
        Exception innerError = new Exception("inner error");

        try {
            throw new StringFormatException("the message", innerError);
        } catch (StringFormatException error) {
            assertEquals("the message", error.getMessage());
            assertEquals(innerError, error.getCause());
        }
    }

    @Test
    void should_be_careful_of_the_order_of_finally_block() {
        int confusedResult = confuse(2);

        // TODO: please modify the following code to pass the test
        // <--start
        final int expectedResult = Integer.MAX_VALUE;
        // --end-->

        assertEquals(expectedResult, confusedResult);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_use_the_try_pattern() {
        ClosableStateReference closableStateReference = new ClosableStateReference();
        try (MyClosableType closable = new MyClosableType(closableStateReference))
        {
            assertFalse(closable.isClosed());
        }

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Boolean> expected = Optional.empty();
        // --end-->

        assertEquals(expected.get(), closableStateReference.isClosed());
    }

    @SuppressWarnings({"EmptyTryBlock", "unused", "RedundantThrows"})
    @Test
    void should_call_closing_even_if_exception_throws() throws Exception {
        ArrayList<String> logger = new ArrayList<>();

        try {
            try (AutoCloseable withoutThrow = new ClosableWithoutException(logger);
                 AutoCloseable withThrow = new ClosableWithException(logger)) {
            }
        } catch (Exception e) {
            // It is okay!
        }

        // TODO: please modify the following code to pass the test
        // <--start
        final String[] expected = {};
        // --end-->

        assertArrayEquals(
            expected,
            logger.toArray());
    }

    @Test
    void should_get_method_name_in_stack_frame() {
        String methodName = StackFrameHelper.getCurrentMethodName();

        assertEquals(
            "com.cultivation.javaBasic.ExceptionTest.should_get_method_name_in_stack_frame",
            methodName);
    }

    @SuppressWarnings({"ReturnInsideFinallyBlock", "SameParameterValue"})
    private int confuse(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }
}