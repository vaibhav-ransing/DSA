from openai import OpenAI
import json
import os
import javalang
from pathlib import Path


api_key = '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'
client = OpenAI(api_key=api_key)

def get_java_files(src_location):
    java_files = []
    for root, dirs, files in os.walk(src_location):
        for file in files:
            if file.endswith(".java"):
                file_path = os.path.join(root, file)
                java_files.append(file_path)
    return java_files

def process_java_files(src_location):
    logic_classes_dict = {}
    model_classes_dict = {}
    java_files = get_java_files(src_location)
    
    for java_file in java_files:
        file_path = Path(java_file)

        with open(java_file, 'r') as file:
            code = file.read()
            tree = javalang.parse.parse(code)
            for path, node in tree:
                if isinstance(node, javalang.tree.ClassDeclaration):
                    class_name = node.name

                    curr_file_dict = {
                        "code": code,
                        "src_location": src_location
                    }

                    if 'model' in file_path.parts:
                        model_classes_dict[class_name] = curr_file_dict
                    else:
                        logic_classes_dict[class_name] = curr_file_dict

    return logic_classes_dict, model_classes_dict

# src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\SpringBasics\microservices\src\main\java\com\vaibhav\microservices'
src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\SpringBasics\microservices\src\main\java\com\vaibhav\microservices\temp'
logic_classes_dict, model_classes_dict = process_java_files(src_location)

model_classes_string = ""
for class_name, class_info in model_classes_dict.items():
    class_code = class_info['code']
    model_classes_string += f"Class: {class_name}\n"
    model_classes_string += f"Code:\n{class_code}\n\n"

print("Started")
for class_name, class_info in logic_classes_dict.items():
    code = class_info['code']
    src_location = class_info['src_location']
    
    # Assuming 'client' is your OpenAI client instance
    completion = client.chat.completions.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "user", "content": f"Generate unit test case code for {code}, refer this model string if required {model_classes_string}"}
        ]
    )
    
    # Retrieve the completion content using methods provided by the library
    completion_content = completion.choices[0].message.content
    generated_test_cases = completion_content
    
    # Assuming test folder is a sibling to the src folder
    test_file_path = src_location.replace('main', 'test')
    test_file_path = os.path.join(test_file_path, f"{class_name}Test.java")
    print("test_file_path, ", test_file_path)
    # Create directories if they don't exist
    os.makedirs(os.path.dirname(test_file_path), exist_ok=True)

    # Save the generated test cases to the test file
    with open(test_file_path, 'w') as test_file:
        test_file.write(generated_test_cases)

print("Ended")