import os
import javalang

def get_java_files(src_location):
    java_files = []
    for root, dirs, files in os.walk(src_location):
        for file in files:
            if file.endswith(".java"):
                java_files.append(os.path.join(root, file))
    return java_files

def extract_methods(class_declaration):
    methods = []
    for path, node in class_declaration:
        if isinstance(node, javalang.tree.MethodDeclaration):
            method_name = node.name
            methods.append(method_name)
    

    return methods

from pathlib import Path

def process_java_files(src_location):
    classes_dict = {}
    controller_repository_service = {'controller': 0, 'repository': 0, 'service': 0}
    java_files = get_java_files(src_location)
    
    for java_file in java_files:
        file_path = Path(java_file)
        with open(java_file, 'r') as file:
            code = file.read()
            tree = javalang.parse.parse(code)
            curr_file_dict = {}
            for path, node in tree:
                if isinstance(node, javalang.tree.ClassDeclaration):
                    class_name = node.name
                    class_methods = extract_methods(node)
                    curr_file_dict["methods"] = class_methods
                    # curr_file_dict["code"] = code
                    classes_dict[class_name.lower()] = curr_file_dict

        # Check if the file path belongs to controller, repository, or service
        if 'controller' in str(file_path):
            controller_repository_service['controller'] += 1
        elif 'repository' in str(file_path):
            controller_repository_service['repository'] += 1
        elif 'service' in str(file_path):
            controller_repository_service['service'] += 1

    return classes_dict, controller_repository_service

# Example usage:
# src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\microservices\microservices\src\main\java\com\vaibhav\microservices\controller'
# output = process_java_files(src_location)
# print(output)
