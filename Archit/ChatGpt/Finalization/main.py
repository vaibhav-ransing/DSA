from test_folder_functions import get_called_methods_in_test_files
from src_folder_functions import process_java_files
from common_functions import filter_source_methods

src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\SpringBasics\microservices\src\main\java\com\vaibhav\microservices\service'
src_methods_dict = process_java_files(src_location)

test_locaiton = r'C:\Users\ADMIN\OneDrive\Desktop\Development\SpringBasics\microservices\src\test\java\com\vaibhav\microservices\serviceTest'  # Replace with your source folder containing Java files
test_called_methods_dict = get_called_methods_in_test_files(test_locaiton)

for key in src_methods_dict:
    print(key, src_methods_dict[key])
print("*"*70)
for key in test_called_methods_dict:
    print(key, test_called_methods_dict[key])
print(src_methods_dict)

print("*"*70)

print(test_called_methods_dict)

print("#"*100)

common_classes = set(src_methods_dict.keys()) & set(test_called_methods_dict.keys())
final_dict = {key: (src_methods_dict[key], test_called_methods_dict[key]) for key in common_classes}

print("*"*100)

for file_name in final_dict:
    print("hello")
    src_method_list = src_methods_dict[file_name]['methods']
    test_method_list = test_called_methods_dict[file_name]
    filtered_src_list = filter_source_methods(src_method_list, test_method_list)
    src_methods_dict[file_name]['methods'] = filtered_src_list

print("#"*100)

print(src_methods_dict)