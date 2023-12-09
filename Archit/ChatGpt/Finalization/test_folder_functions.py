import re
from common_functions import get_java_files

def extract_called_methods_test_file(file_location):
    try:
        with open(file_location, 'r') as file:
            file_content = file.read()

        # Define a regular expression pattern to find method calls (.xyz())
        method_call_pattern = r'\.\s*([a-zA-Z_$][a-zA-Z\d_$]*)\('

        # Find all method calls in the file content
        method_calls = re.findall(method_call_pattern, file_content)

        # Remove duplicates and return the extracted method names
        return list(set(method_calls))
    
    except FileNotFoundError:
        print(f"File '{file_location}' not found.")
        return []

# Removes test from prefix or postfix of a string.
def remove_test_prefix_or_postfix(input_string):
    lowercase_string = input_string.lower()
    
    # Check if 'test' is at the beginning of the string (case insensitive)
    if lowercase_string.startswith('test'):
        return lowercase_string[len('test'):].lstrip('_')  # Remove 'test' and any leading underscores
    
    # Check if 'test' is at the end of the string (case insensitive)
    if lowercase_string.endswith('test'):
        return lowercase_string[:-len('test')].rstrip('_')  # Remove 'test' and any trailing underscores
    
    return lowercase_string  # Return the original string if 'test' is not found as prefix or postfix


import os

def get_called_methods_in_test_files(src_location):
    java_files = get_java_files(src_location)
    test_files_methods = {}

    for file_location in java_files:
        file_name = os.path.splitext(os.path.basename(file_location))[0]
        method_calls = extract_called_methods_test_file(file_location)
        clean_file_name = remove_test_prefix_or_postfix(file_name)
        test_files_methods[clean_file_name] = method_calls

    return test_files_methods


# src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\microservices\microservices\src\test\java\com\vaibhav\microservices'  # Replace with your source folder containing Java files
# test_methods_info = get_called_methods_in_test_files(src_location)
# print("Test file methods:")
# print(test_methods_info)

