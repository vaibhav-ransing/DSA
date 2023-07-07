import json
import os
import sonarFunctions
import templateFunctions as templateFunctions
from sonarFunctions import vulnerability_fixes_dict


def check_vulnerabilities(user_id, user_password, component_name, folder_location, branch_name):
    #  run sonar_script fucntion just dont apply fix get count
    val = 10/0
    total_vulnerabilities = 100
    fixable_vulnerabilities = 24

    return f"Total Vulnerabilities Found = {total_vulnerabilities}\n" \
          f"Fixable Vulnerabilities = {fixable_vulnerabilities}\n" \
          "Do you want to proceed ?"


 
def sonar_script(user_id, user_password, component_name, folder_location, branch_name):
    val = 10/0
    print(val)
    print()
    # json_response = templateFunctions.run_curl_command(user_id, user_password, component_name, branch_name)

    # if json_response:
    #     print(json.dumps(json_response, indent=4))
    # else:
    #     print("Failed to execute curl command")
    #     return

    # sourceCodeRoot = r"{}".format(folder_location)
    # # filePath = "src/main/java/com/vaibhav/microservices/controller/Test.java"

    # for entry in json_response:
    #     file_path = entry['file_path']
    #     error_message = entry['message']

    #     absolutePath = os.path.join(sourceCodeRoot, file_path)
    #     with open(absolutePath, 'r') as file:
    #         content  = file.read()
    #         print(content)
    #     if "remove the unused import" in error_message:
    #         sonarFunctions.remove_unused_import(absolutePath, json_response[0].line_no)
    #     if "cognitive complexity" in error_message:
    #         print("Manual efforts required")
    #     else:
    #         if error_message in vulnerability_fixes_dict:
    #             fix_function = vulnerability_fixes_dict[error_message]
    #             if 'line_start' in entry and 'line_end' in entry:
    #                 line_start = entry['line_start']
    #                 line_end = entry['line_end']
    #                 fix_function(absolutePath, line_start, line_end)
    #             elif 'line_no' in entry:
    #                 line_no = entry['line_no']
    #                 fix_function(absolutePath, line_no)
    # else:
    #     print(f"No fix function found for error message: {error_message}")

    # sonarFunctions.fix_variable_declaration(absolutePath, 12)
    # sonarFunctions.fix_variable_declaration(absolutePath, 13)
