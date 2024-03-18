from flask import Flask, render_template, request
import os

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/submit', methods=['POST'])
def submit():
    user_id = request.form.get('user_id')
    user_pass = request.form.get('user_pass')
    component_name = request.form.get('component_name')
    folder_path = request.form.get('folder_path')
    
    # Do something with the obtained information
    print("User ID:", user_id)
    print("User Password:", user_pass)
    print("Component Name:", component_name)
    print("Folder Path:", folder_path)
    
    return render_template('index.html', message="Form submitted successfully.")

@app.route('/browse')
def browse():
    return render_template('browse.html')

if __name__ == '__main__':
    app.run()
