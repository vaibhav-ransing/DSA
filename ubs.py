import os
import re

def extract_java_methods(folder):
    method_pattern = re.compile(r'\s*(public|private|protected)?\s*\w+\s+(\w+)\s*\([^)]*\)\s*\{')  # Regex pattern for method extraction

    methods = []
    for root, _, files in os.walk(folder):
        for file_name in files:
            if file_name.endswith('.java'):
                file_path = os.path.join(root, file_name)
                with open(file_path, 'r') as file:
                    content = file.read()
                    matches = method_pattern.findall(content)
                    methods.extend([match[1] for match in matches])
    return methods

def find_untested_methods(src_folder, test_folder):
    src_methods = extract_java_methods(src_folder)
    test_methods = extract_java_methods(test_folder)

    untested_methods = [method for method in src_methods if method not in test_methods]
    return untested_methods

# Example usage:
src_folder = 'path/to/src_folder'
test_folder = 'path/to/test_folder'

untested = find_untested_methods(src_folder, test_folder)
for method in untested:
    print(method)
