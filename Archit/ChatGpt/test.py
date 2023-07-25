import re

error_message = "Make hello_world a static final constant"
regex_pattern = r"Make\s+\w+\s+a\s+static\s+final\s+constant"

if re.search(regex_pattern, error_message):
    print("The error message matches the pattern.")
else:
    print("The error message does not match the pattern.")



def remove_if_statement(file_path, line_number):
    # Read the content of the file
    with open(file_path, 'r') as file:
        lines = file.readlines()

    # Remove the line at the specified line number (if it exists)
    if 1 <= line_number <= len(lines):
        removed_line = lines.pop(line_number - 1)
        removedFirstOpenBracketFlag = False
        if "{" in removed_line:
            removedFirstOpenBracketFlag = True

        openBracketCount = 0
        # Find the corresponding closing "}" based on indentation level
        for idx, line in enumerate(lines[line_number-1:]):
            if "{" in line and removedFirstOpenBracketFlag == False:
                lines[idx + line_number - 1] = line.replace("{", "", 1)
                removedFirstOpenBracketFlag = True
            elif "{" in line:
                openBracketCount += 1
            elif "}" in line:
                openBracketCount -= 1
                if(openBracketCount == -1):
                    lines[idx + line_number - 1] = line.replace("}", "", 1)
                    break
        else:
            print("Error: Matching '}' not found for the removed 'if' statement.")

    # Write the modified content back to the file
    with open(file_path, 'w') as file:
        file.writelines(lines)

# Usage example:
file_location = r"C:\Users\ADMIN\OneDrive\Desktop\Dsa\Archit\ChatGpt\code.java"
line_number_to_remove = 1
remove_if_statement(file_location, line_number_to_remove)
