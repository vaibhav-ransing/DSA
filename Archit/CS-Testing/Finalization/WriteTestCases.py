from openai import OpenAI
import json
import os
import javalang
from pathlib import Path
import re


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

def extract_methods(class_declaration):
    methods = []
    for path, node in class_declaration:
        if isinstance(node, javalang.tree.MethodDeclaration):
            method_name = node.name
            methods.append(method_name)

    return methods


def process_java_files(src_location):
    logic_classes_dict = {}
    model_classes_dict = {}
    crs = {'controller': 0, 'repository': 0, 'service': 0, 'helper': 0, 'total': 0}
    java_files = get_java_files(src_location)
    
    for java_file in java_files:
        file_path = Path(java_file)

        with open(java_file, 'r') as file:
            code = file.read()
            tree = javalang.parse.parse(code)
            curr_file_dict = {}
            curr_methods_count = 0
            for path, node in tree:
                if isinstance(node, javalang.tree.ClassDeclaration):
                    class_name = node.name

                    current_dir = str(file_path.parent)
                    curr_file_dict = {
                        "code": code,
                        "src_location": current_dir
                    }

                    class_methods = extract_methods(node)
                    curr_methods_count = len(class_methods)

                    if 'model' in file_path.parts:
                        model_classes_dict[class_name] = curr_file_dict
                    else:
                        logic_classes_dict[class_name] = curr_file_dict

            if 'controller' in str(file_path):
                crs['controller'] += curr_methods_count
            elif 'repository' in str(file_path):
                crs['repository'] += curr_methods_count
            elif 'service' in str(file_path):
                crs['service'] += curr_methods_count
            else:
                crs['helper'] += curr_methods_count
            crs['total'] += curr_methods_count

    return logic_classes_dict, model_classes_dict, crs

# src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\SpringBasics\microservices\src\main\java\com\vaibhav\microservices'
# test_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\SpringBasics\microservices\src\test\java\com\vaibhav\microservices'
src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\unit-test-case-automaion\unit-test-case-automaion\src\main\java\com\UTADEMO\unittestcaseautomaion'
test_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\unit-test-case-automaion\unit-test-case-automaion\src\test\java\com\UTADEMO\unittestcaseautomaion'
logic_classes_dict, model_classes_dict, crs_count = process_java_files(src_location)
logic_classes_dict_test, model_classes_dict_test, crs_count_test = process_java_files(test_location)

def get_percentage(src_count, test_count):
    if src_count == 0:
        return 0
    return round((test_count / src_count) * 100, 2)

print("\n\n")
print("Application Layers Summary")
print("-" * 105)
print("\n")
print(f"{'# Layer Name': <50} | {'# Source Code Method Count': <30} | {'# Test Code Method Count': <25} | {'# Test methods covered %': <20}")
print(f"{'Controller Layer Methods (app starting point)': <50} | {crs_count['controller']: <30} | {crs_count_test['controller']: <25} | {get_percentage(crs_count['controller'], crs_count_test['controller']): <20}%")
print(f"{'Repository Layer Methods (business Logic)': <50} | {crs_count['repository']: <30} | {crs_count_test['repository']: <25} | {get_percentage(crs_count['repository'], crs_count_test['repository']): <20}%")
print(f"{'Service Layer Methods (service calls)': <50} | {crs_count['service']: <30} | {crs_count_test['service']: <25} | {get_percentage(crs_count['service'], crs_count_test['service']): <20}%")
print(f"{'Support Layers Methods (application unit methods)': <50} | {crs_count['helper']: <30} | {crs_count_test['helper']: <25} | {get_percentage(crs_count['helper'], crs_count_test['helper']): <20}%")
print(f"{'Total Count': <50} | {crs_count['total']: <30} | {crs_count_test['total']: <25} | {get_percentage(crs_count['total'], crs_count_test['total']): <20}%")
print("\n")
print("-" * 105)
print("\n")

model_classes_string = ""
for class_name, class_info in model_classes_dict.items():
    class_code = class_info['code']
    model_classes_string += f"Class: {class_name}\n"
    model_classes_string += f"Code:\n{class_code}\n\n"

# with open("modelStr.txt", 'r') as file:
#     model_str_temp = file.read()



def extract_code(completion_content):
    code_pattern = r'```(?:\s*\w+)?\n(.*?)```'
    matches = re.findall(code_pattern, completion_content, re.DOTALL)
    
    extracted_code = ""
    if matches:
        extracted_code = matches[0].strip()
    
    return extracted_code



print("Unit Test Case Generation Started \n")

for class_name, class_info in logic_classes_dict.items():
    code = class_info['code']
    src_location = class_info['src_location']
    
    # Assuming 'client' is your OpenAI client instance
    completion = client.chat.completions.create(
        model="gpt-3.5-turbo",
        messages=[
            {
                "role": "user", "content": f"Generate unit test case code for \n `{code}`, \n here are all the model classes \n `{model_classes_string}` \n note: It's maven project for java 17\n  "
             }
        ]
    )
    
    # Retrieve the completion content using methods provided by the library
    completion_content = completion.choices[0].message.content
    generated_test_cases = extract_code(completion_content)
    # generated_test_cases = completion_content

    # generated_test_cases = completion_content

    # Assuming test folder is a sibling to the src folder
    test_file_path = src_location.replace('main', 'test')
    test_file_path = os.path.join(test_file_path, f"{class_name}Test.java")

    # Create directories if they don't exist
    os.makedirs(os.path.dirname(test_file_path), exist_ok=True)

    # Save the generated test cases to the test file
    with open(test_file_path, 'w') as test_file:
        test_file.write(generated_test_cases)
    
    print("Generated testcases for class ", class_name)

print("Unit test cases generated")