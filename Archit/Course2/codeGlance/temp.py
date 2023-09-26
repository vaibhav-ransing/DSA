def multiple_variables_in_diff_lines(file_location, line_no):
    try:
        # Read the content of the file
        with open(file_location, 'r') as file:
            lines = file.readlines()

        # Split the line at the specified line number
        if 0 < line_no <= len(lines):
            line_to_split = lines[line_no - 1].strip()
            split_lines = line_to_split.split(',')

            if len(split_lines) > 1:
                # Remove the original line
                del lines[line_no - 1]
                idx = 0
                # Insert the split lines at the same position
                for split_line in reversed(split_lines):  # Reverse the order
                    # Extract access modifier and data type from the original line
                    parts = line_to_split.split()
                    access_modifier = ' '.join(parts[:-1])  # All parts except the last one
                    print("Access-mod ", access_modifier)
                    print("Parts ", parts)
                    data_type = parts[-1]
                    semicolon = ';'
                    if idx!=0:
                        access_modifier = ""
                    if idx!=len(split_lines) - 1:
                        semicolon = ''
                    # Construct the new line with the same access modifier and data type
                    new_line = f"{access_modifier} {split_line.strip()}{semicolon}\n"
                    idx += 1
                    # Insert the new line
                    lines.insert(line_no - 1, new_line)

                # Write the modified content back to the file
                with open(file_location, 'w') as file:
                    file.writelines(lines)
            else:
                print(f"No comma-separated variables found on line {line_no}. Nothing to split.")
        else:
            print(f"Line number {line_no} is out of range.")
    except Exception as e:
        print(f"An error occurred: {str(e)}")

# Usage example:
file_location = 'test.java'
line_no = 1
multiple_variables_in_diff_lines(file_location, line_no)