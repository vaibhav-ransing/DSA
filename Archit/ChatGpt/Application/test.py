import requests

def fetch_issues(user_id, user_password, component_name):
    url = f"https://next.sonarqube.com/sonarqube/web_api/api/issues/search?componentKeys={component_name}"
    response = requests.get(url, auth=(user_id, user_password))
    if response.status_code == 200:
        json_data = response.json()
        # Process the JSON response
        # ...
    else:
        print(f"Request failed with status code: {response.status_code}")

# Example usage
user_id = "your_user_id"
user_password = "your_user_password"
component_name = "your_component_name"

fetch_issues(user_id, user_password, component_name)
