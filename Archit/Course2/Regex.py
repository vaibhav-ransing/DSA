import re

def add_quotes_to_variable(file_path, line_number):
    try:
        with open(file_path, 'r') as file:
            lines = file.readlines()

        if line_number <= len(lines):
            line = lines[line_number - 1]
            match = re.search(r'\$[a-zA-Z_]\w*', line)

            if match:
                variable = match.group()
                modified_line = line.replace(variable, f'"{variable}"')
                lines[line_number - 1] = modified_line

                with open(file_path, 'w') as file:
                    file.writelines(lines)
                print(f'Variable in line {line_number} has been modified.')

            else:
                print(f'No variable found in line {line_number}.')

        else:
            print(f'Line number {line_number} is out of range for the file.')

    except FileNotFoundError:
        print(f'File not found: {file_path}')

# Example usage:
file_path = 'test.java'
line_number = 1  # Replace with the desired line number
add_quotes_to_variable(file_path, line_number)
