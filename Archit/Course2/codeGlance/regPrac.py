import re

# Input string containing a number followed by a word
input_string = "12345 apple"

# Define a regex pattern with two capturing groups
pattern = r"(\d+)\s+(\w+)"

# Search for the pattern in the input string
match = re.search(pattern, input_string)

if match:
    # match.group(0) returns the entire matched text
    entire_match = match.group(0)
    print(f"Entire match: {entire_match}")

    # match.group(1) returns the text matched by the first capturing group (\d+)
    group_1_text = match.group(1)
    print(f"Text matched by group 1: {group_1_text}")

    # match.group(2) returns the text matched by the second capturing group (\w+)
    group_2_text = match.group(2)
    print(f"Text matched by group 2: {group_2_text}")
else:
    print("No match found.")
