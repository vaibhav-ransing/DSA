import re

def extract_variable_names_from_error_msg(error_msg):
    pattern = r'"\s*([^"]+)"\s*local variable'
    matches = re.findall(pattern, error_msg)
    print("march  ", matches)
    return matches

# Test the function
error_msg = "remove this unused \"age\" local variable"
variable_names = extract_variable_names_from_error_msg(error_msg)
if variable_names:
    print("Extracted variable names:", variable_names)
else:
    print("No variable names found in the error message.")
