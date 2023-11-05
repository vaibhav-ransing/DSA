import re

# Input string
input_string = "if( a == b){}"

# Define the regular expression pattern to match "a==b"
pattern = r'(\w+)\s*==\s*(\w+)'

# Replacement string
replacement = r'\1.equals(\2)'

# Use re.sub to replace the matched pattern
output_string = re.sub(pattern, replacement, input_string)

print(output_string)
