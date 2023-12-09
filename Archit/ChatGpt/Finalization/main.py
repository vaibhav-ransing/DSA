from test_folder_functions import get_called_methods_in_test_files
from src_folder_functions import process_java_files


src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\microservices\microservices\src\main\java\com\vaibhav\microservices\service'
src_methods_dict = process_java_files(src_location)

src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\microservices\microservices\src\test\java\com\vaibhav\microservices'  # Replace with your source folder containing Java files
test_called_methods_dict = get_called_methods_in_test_files(src_location)

for key in src_methods_dict:
    print(key, src_methods_dict[key])
print("*"*70)
for key in test_called_methods_dict:
    print(key, test_called_methods_dict[key])

common_keys = set(src_methods_dict.keys()) & set(test_called_methods_dict.keys())
print("commons_keys", common_keys)
final_dict = {key: (src_methods_dict[key], test_called_methods_dict[key]) for key in common_keys}
