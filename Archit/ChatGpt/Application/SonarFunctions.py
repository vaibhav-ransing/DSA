def fix_variable_declaration(file_location, line_number):
    # Open the file in read mode
    with open(file_location, 'r') as file:
        lines = file.readlines()

    # Check if the line number is within the file's range
    if 0 < line_number <= len(lines):
        line = lines[line_number - 1]

        # List of variable types to replace
        variable_types = ['String', 'int', 'MyClass']

        # Replace variable types with 'var'
        for variable_type in variable_types:
            line = line.replace(variable_type + ' ', 'var ')

        # Update the line in the lines list
        lines[line_number - 1] = line

    # Write the updated contents back to the file
    with open(file_location, 'w') as file:
        file.writelines(lines)