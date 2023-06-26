import os
import SonarFunctions as sonarFunctions

sourceCodeRoot = r"C:\Users\ADMIN\OneDrive\Desktop\Development\microservices\microservices"
filePath = "src/main/java/com/vaibhav/microservices/controller/Test.java"

absolutePath = os.path.join(sourceCodeRoot, filePath)
with open(absolutePath, 'r') as file:
    content  = file.read()
    print(content)

sonarFunctions.fix_variable_declaration(absolutePath, 12)
sonarFunctions.fix_variable_declaration(absolutePath, 13)

with open(absolutePath, 'r') as file:
    content  = file.read()
    print(content)