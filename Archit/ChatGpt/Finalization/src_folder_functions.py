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
    methods = {}
    for path, node in class_declaration:
        if isinstance(node, javalang.tree.MethodDeclaration):
            method_name = node.name
            child_methods = []
            if node.body is not None:
                try:
                    for _, statement in node.body:
                        if isinstance(statement, javalang.tree.MethodInvocation):
                            child_methods.append(statement.member)
                except ValueError:
                    pass  # Handle the case where node.body is not a list of pairs
            methods[method_name] = child_methods
    return methods

def process_java_files(src_location):
    classes_dict = {}
    java_files = get_java_files(src_location)
    for java_file in java_files:
        with open(java_file, 'r') as file:
            code = file.read()
            tree = javalang.parse.parse(code)
            for path, node in tree:
                if isinstance(node, javalang.tree.ClassDeclaration):
                    class_name = node.name
                    class_methods = extract_methods(node)
                    classes_dict[class_name.lower()] = class_methods
    return classes_dict

# Example usage:
# src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\microservices\microservices\src\main\java\com\vaibhav\microservices\controller'
# output = process_java_files(src_location)
# print(output)
