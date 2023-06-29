def replace_local_variable_java(file_location, line_number):
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

def remove_commented_code_java(file_location, line_start, line_end):
    try:
        # Read the Java file
        with open(file_location, 'r') as file:
            lines = file.readlines()

        # Remove commented code within the specified line range
        for line_num in range(line_start - 1, line_end):
            if '//' in lines[line_num]:
                lines[line_num] = lines[line_num].split('//')[0] + '\n'

        # Write the modified Java file
        with open(file_location, 'w') as file:
            file.writelines(lines)

        print("Commented code removed successfully.")
    except FileNotFoundError:
        print("File not found.")
    except Exception as e:
        print(f"An error occurred: {str(e)}")

def remove_unused_import(file_location, line_number):
    with open(file_location, "r") as file:
        lines = file.readlines()

    if line_number <= len(lines):
        del lines[line_number - 1]

    with open(file_location, "w") as file:
        file.writelines(lines)


vulnerability_fixes_dict = {
    "remove commented code": remove_commented_code_java,
    "replace the local variable with var": replace_local_variable_java,
    "remove the unused import" : remove_unused_import
}