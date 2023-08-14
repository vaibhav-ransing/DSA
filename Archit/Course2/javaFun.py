def remove_unused_variable_from_line(file_location, line_no, unused_variable_name):
    # Open the file and read its lines
    with open(file_location, 'r') as file:
        lines = file.readlines()

    # Check if the line number is within the file's range
    if 0 < line_no <= len(lines):
        line = lines[line_no - 1]
        
        # Split the line into individual variable declarations
        variable_declarations = line.split(';')

        # Filter out the unused variable
        updated_declarations = [decl.strip() for decl in variable_declarations if unused_variable_name not in decl]

        # Join the updated declarations back into a line
        updated_line = '; '.join(updated_declarations) + ';'

        # Update the line in the lines list
        lines[line_no - 1] = updated_line + '\n'

        # Write the updated contents back to the file
        with open(file_location, 'w') as file:
            file.writelines(lines)

# Test the function
file_location = 'test.java'
line_no = 1
unused_variable_name = 'name'
remove_unused_variable_from_line(file_location, line_no, unused_variable_name)
