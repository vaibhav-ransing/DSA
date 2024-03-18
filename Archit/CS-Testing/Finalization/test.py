def extract_java_code(completion_content):
    # Split the content by newlines to handle multiple messages if present
    messages = completion_content.split("\n")

    # Filter the messages for Java code
    java_code = ""
    code_started = False  # Flag to indicate if Java code block has started

    for message in messages:
        if "java" in message.lower() and "```" in message.lower():
            # Start of Java code block found
            code_started = True
            java_code += message.split("```java")[-1].strip() + "\n"
        elif code_started:
            # Appending lines within the Java code block
            if "```" in message.lower():
                # End of Java code block found
                java_code += message.split("```")[0].strip()  # Capture last line
                break
            else:
                java_code += message.strip() + "\n"

    return java_code.strip()  # Return the extracted Java code


# Example usage:
completion_content = """
To generate unit test case code for the EmpController class, you can use a testing framework like JUnit. Here's an example of how the test cases can be written:

```java
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpControllerTest {

    @Test
    public void testDeleteEmployeeById() {
        // Mock the deleteEmployeeById method of the employeeService
        when(employeeService.deleteEmployeeById("1")).thenReturn("Employee deleted successfully");

        // Invoke the deleteEmployeeById method of the EmpController
        String result = empController.deleteEmployeeById("1");

        // Verify the result
        assertEquals("Employee deleted successfully", result);
        verify(employeeService, times(1)).deleteEmployeeById("1");
    }
}
```

Note: Make sure to add the required dependencies for testing frameworks like JUnit and Mockito in your project's build file."""

print(extract_java_code(completion_content))