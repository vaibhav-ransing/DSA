def add_line_to_java(file_location, line_number, line_content):
    # Open the file in read mode
    with open(file_location, 'r') as file:
        lines = file.readlines()

    # Check if the line number is within the file's range
    if 0 < line_number <= len(lines) + 1:
        lines.insert(line_number - 1, line_content + "\n")

    # Write the updated contents back to the file
    with open(file_location, 'w') as file:
        file.writelines(lines)

# 7 8 9

path = r'C:\Users\ADMIN\OneDrive\Desktop\Dsa\Archit\ChatGpt\code.java'
line_number = 2
line_content = 'private int age = 10;'

add_line_to_java(path, line_number, line_content)
