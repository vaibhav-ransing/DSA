import os
import javalang
from pathlib import Path

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
                    curr_file_dict["code"] = code
                    curr_file_dict["src_location"] = src_location
                    classes_dict[class_name] = curr_file_dict

    return classes_dict, controller_repository_service
