import os

def get_java_files(src_location):
    java_files = []
    for root, dirs, files in os.walk(src_location):
        for file in files:
            if file.endswith(".java"):
                java_files.append(os.path.join(root, file))
    return java_files

def filter_source_methods(src_method_list, test_method_list):
    # Convert lists to sets
    src_set = set(src_method_list)
    test_set = set(test_method_list)
    print("#"*100)
    print(src_set)
    print(test_set)
    print("#"*100)
    # Get the difference between the sets
    filtered_set = src_set.difference(test_set)
    print(filtered_set)
    # Convert the result back to a list
    filtered_src_method = list(filtered_set)
    
    return filtered_src_method