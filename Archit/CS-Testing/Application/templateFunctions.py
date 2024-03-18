import json
import subprocess

def run_curl_command(user_id, user_password, component_name, branch_name):
    # Build the curl command
    curl_command = [
        "curl", "-k", "-X", "GET", "-u",
        f"{user_id}:{user_password}",
        f"https://next.sonarqube.com/sonarqube/web_api/api/issues/search?componentKeys={component_name}&branch={branch_name}"
    ]

    # Execute the curl command and capture the output
    process = subprocess.Popen(curl_command, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    stdout, stderr = process.communicate()

    # Handle any errors
    if stderr:
        print("Error executing curl command:", stderr.decode())
        return None

    # Parse the JSON response
    try:
        json_response = json.loads(stdout.decode())
        return json_response
    except json.JSONDecodeError as e:
        print("Error parsing JSON response:", e)
        return None