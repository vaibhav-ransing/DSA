import sys
import os
import SonarFunctions as sonarFunctions

def sonar_script(user_id, user_password, component_name, folder_location):
    # Your script logic goes here
    # Use the provided arguments to perform SonarQube analysis or any other operations

    # Example: Printing the arguments
    # print(f"User ID: {user_id}")
    # print(f"User Password: {user_password}")
    # print(f"Component Name: {component_name}")
    # print(f"Folder Location: {folder_location}")

    # sourceCodeRoot = r"C:\Users\ADMIN\OneDrive\Desktop\Development\microservices\microservices"
    sourceCodeRoot = r"{}".format(folder_location)
    filePath = "src/main/java/com/vaibhav/microservices/controller/Test.java"

    absolutePath = os.path.join(sourceCodeRoot, filePath)
    with open(absolutePath, 'r') as file:
        content  = file.read()
        print(content)

    sonarFunctions.fix_variable_declaration(absolutePath, 12)
    sonarFunctions.fix_variable_declaration(absolutePath, 13)

if __name__ == '__main__':
    # Get the command-line arguments passed from Flask
    user_id = sys.argv[1]
    user_password = sys.argv[2]
    component_name = sys.argv[3]
    folder_location = sys.argv[4]

    # Call the sonar_script function with the provided arguments
    sonar_script(user_id, user_password, component_name, folder_location)
