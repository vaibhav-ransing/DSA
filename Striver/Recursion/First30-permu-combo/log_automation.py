import re
import os

def extract_method_counts(log_file_path):
    method_counts = {}
    
    # Define regular expressions to match class names in Java logs
    class_pattern = re.compile(r'\b(\w+)\s*:\s*(.*)\s*;')

    with open(log_file_path, 'r') as file:
        for line in file:
            # Extract class names
            match = re.search(class_pattern, line)
            if match:
                class_name = match.group(1)
                method_counts[class_name] = method_counts.get(class_name, 0) + 1
                        
    return method_counts

def process_log_files(log_folder_path):
    method_counts = {}

    # Loop through all files in the log folder
    for filename in os.listdir(log_folder_path):
        file_path = os.path.join(log_folder_path, filename)
        file_method_counts = extract_method_counts(file_path)

        # Merge counts from the current file into the overall counts
        for method, count in file_method_counts.items():
            method_counts[method] = method_counts.get(method, 0) + count

    return method_counts

if __name__ == "__main__":
    log_folder_path = r"C:\Users\ADMIN\OneDrive\Desktop\Log_Files"
    result = process_log_files(log_folder_path)

    # Print the counts
    for method, count in result.items():
        print(f"{method}: {count}")