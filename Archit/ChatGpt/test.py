def replace_local_variable_java(file_location, line_number):
    # Open the file in read mode
    with open(file_location, 'r') as file:
        lines = file.readlines()

    # Check if the line number is within the file's range
    if 0 < line_number <= len(lines):
        line = lines[line_number - 1]

        # List of variable types to replace
        variable_types = ['StringBuilder', 'String', 'int', 'MyClass']

        # Replace the first occurrence of variable types with 'var'
        for variable_type in variable_types:
            if variable_type in line:
                line = line.replace(variable_type, 'var', 1)
                break

        # Update the line in the lines list
        lines[line_number - 1] = line

    # Write the updated contents back to the file
    with open(file_location, 'w') as file:
        file.writelines(lines)


# 7 8 9

path = r'C:\Users\ADMIN\OneDrive\Desktop\Dsa\Archit\ChatGpt\code.java'
replace_local_variable_java(path, 7)
replace_local_variable_java(path, 8)
replace_local_variable_java(path, 9)