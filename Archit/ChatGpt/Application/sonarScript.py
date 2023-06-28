import json
import os
import sonarFunctions
import templateFunctions as templateFunctions
from sonarFunctions import vulnerability_fixes_dict

def sonar_script(user_id, user_password, component_name, folder_location):

    json_response = templateFunctions.run_curl_command(user_id, user_password, component_name)

    if json_response:
        print(json.dumps(json_response, indent=4))
    else:
        print("Failed to execute curl command")
        return

    sourceCodeRoot = r"{}".format(folder_location)
    # filePath = "src/main/java/com/vaibhav/microservices/controller/Test.java"

    

    for entry in json_response:
        file_path = entry['file_path']
        error_message = entry['message']

        absolutePath = os.path.join(sourceCodeRoot, file_path)
        with open(absolutePath, 'r') as file:
            content  = file.read()
            print(content)

        if error_message in vulnerability_fixes_dict:
            fix_function = vulnerability_fixes_dict[error_message]
            if 'line_start' in entry and 'line_end' in entry:
                line_start = entry['line_start']
                line_end = entry['line_end']
                fix_function(absolutePath, line_start, line_end)
            elif 'line_no' in entry:
                line_no = entry['line_no']
                fix_function(absolutePath, line_no)
    else:
        print(f"No fix function found for error message: {error_message}")

    sonarFunctions.fix_variable_declaration(absolutePath, 12)
    sonarFunctions.fix_variable_declaration(absolutePath, 13)


# if __name__ == '__main__':
#     # Get the command-line arguments passed from Flask
#     user_id = sys.argv[1]
#     user_password = sys.argv[2]
#     component_name = sys.argv[3]
#     folder_location = sys.argv[4]

#     # Call the sonar_script function with the provided arguments
#     sonar_script(user_id, user_password, component_name, folder_location)
