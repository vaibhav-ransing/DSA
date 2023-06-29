import subprocess
import json

def fetch_issues(user_id, user_password, component_name):
    curl_command = f'curl -k -X GET -u {user_id}:{user_password} "https://next.sonarqube.com/sonarqube/web_api/api/issues/search?componentKeys={component_name}"'
    output = subprocess.check_output(curl_command, shell=True)
    json_data = json.loads(output)

    # Process the JSON response
    # ...

# Example usage
user_id = "your_user_id"
user_password = "your_user_password"
component_name = "your_component_name"

fetch_issues(user_id, user_password, component_name)
