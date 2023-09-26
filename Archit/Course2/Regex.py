def add_quotes_to_variable(file_path, line_number, variable_name):
    try:
        with open(file_path, 'r') as file:
            lines = file.readlines()

        if line_number <= len(lines):
            line = lines[line_number - 1]
            modified_line = re.sub(r'\$' + variable_name, f'"{variable_name}"', line)
            lines[line_number - 1] = modified_line

            with open(file_path, 'w') as file:
                file.writelines(lines)
            print(f'Variable ${variable_name} in line {line_number} has been modified.')

        else:
            print(f'Line number {line_number} is out of range for the file.')

    except FileNotFoundError:
        print(f'File not found: {file_path}')

# Example usage:
file_path = 'your_file.txt'
line_number = 2  # Replace with the desired line number
variable_name = 'var'  # Replace with the desired variable name
add_quotes_to_variable(file_path, line_number, variable_name)
