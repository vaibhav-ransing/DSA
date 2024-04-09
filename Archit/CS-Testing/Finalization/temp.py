src_location = r'C:\Users\ADMIN\OneDrive\Desktop\Development\unit-test-case-automaion\unit-test-case-automaion\src\main\java\com\UTADEMO\unittestcaseautomaion'

test_file_path = src_location.replace('src', 'test').split('test')[0] + 'test'

print(test_file_path)