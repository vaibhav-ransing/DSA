from flask import Flask, jsonify, request
import subprocess
import os
import SonarFunctions as sonarFunctions
app = Flask(__name__)

arr = ["initial"]

@app.route('/')
def home():
    return 'Hello, Flask!'

@app.route('/data')
def display_data():
    return jsonify(arr)

@app.route('/fix_sonar', methods=['POST'])
def fix_sonar():
    data = request.json
    
    user_id = data.get('user_id')
    user_password = data.get('user_password')
    component_name = data.get('component_name')
    folder_location = data.get('folder_location')
    
    temp = user_id +" "+user_password+" "+component_name
    arr.append(temp)

    # sourceCodeRoot = r"{}".format(folder_location)
    # filePath = "src/main/java/com/vaibhav/microservices/controller/Test.java"

    # absolutePath = os.path.join(sourceCodeRoot, filePath)
    # with open(absolutePath, 'r') as file:
    #     content  = file.read()
    #     print(content)

    # sonarFunctions.fix_variable_declaration(absolutePath, 12)
    # sonarFunctions.fix_variable_declaration(absolutePath, 13)

    # Call the sonarScript.py file with the arguments
    command = ['python', 'sonarScript.py', user_id, user_password, component_name, folder_location]
    process = subprocess.Popen(command, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    stdout, stderr = process.communicate()

    # Handle the output and error
    if stderr:
        return jsonify({'error': str(stderr.decode())})
    else:
        return jsonify({'output': str(stdout.decode())})

if __name__ == '__main__':
    app.run()
