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
    for _, node in class_declaration:
        if isinstance(node, javalang.tree.MethodDeclaration):
            method_name = node.name
            child_methods = []
            if node.body is not None:
                for _, child_node in node.body.filter(javalang.tree.MethodInvocation):
                    child_methods.append(child_node.member)
            methods[method_name] = child_methods
    return methods

def process_java_files(src_location):
    result = []
    java_files = get_java_files(src_location)
    for java_file in java_files:
        with open(java_file, 'r') as file:
            code = file.read()
            tree = javalang.parse.parse(code)
            class_info = {}
            for _, node in tree:
                if isinstance(node, javalang.tree.ClassDeclaration):
                    class_name = node.name
                    class_methods = extract_methods(node.body)
                    class_info[class_name] = class_methods
            result.append(class_info)
    return result

# Example usage:
src_location = '/path/to/java/code/'
output = process_java_files(src_location)
print(output)
