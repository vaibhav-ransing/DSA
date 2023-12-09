import javalang

# Function to extract methods and their child methods from a class declaration
def extract_methods(class_declaration):
    methods = {}
    for member in class_declaration.members:
        if isinstance(member, javalang.tree.MethodDeclaration):
            method_name = member.name
            child_methods = []
            # Extract child methods if available (assuming method body exists)
            if member.body is not None:
                for path, node in member.filter(javalang.tree.MethodInvocation):
                    child_methods.append(node.member)
            methods[method_name] = child_methods
    return methods

# Function to process Java code files
def process_java_files(src_location):
    result = []
    # Iterate through Java files in the source location
    # Here you'd ideally traverse your directory structure to locate and read Java files
    # For the sake of example, let's assume 'src_location' contains Java files
    java_files = ['file1.java', 'file2.java']  # List of Java files
    for java_file in java_files:
        with open(src_location + java_file, 'r') as file:
            code = file.read()
            tree = javalang.parse.parse(code)
            class_info = {}
            for path, node in tree.filter(javalang.tree.ClassDeclaration):
                class_name = node.name
                class_methods = extract_methods(node)
                class_info[class_name] = class_methods
            result.append(class_info)
    return result

# Example usage:
src_location = '/path/to/java/code/'
output = process_java_files(src_location)
print(output)
