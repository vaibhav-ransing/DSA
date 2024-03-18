
def extract_java_code(completion_content):
    # Split the content by newlines to handle multiple messages if present
    if '```' not in completion_content:
        return completion_content
    messages = completion_content.split("\n")

    # Filter the messages for Java code
    java_code = ""
    code_started = False  # Flag to indicate if Java code block has started

    for message in messages:
        if "```" in message.lower():
            # Start of Java code block found
            code_started = True
            java_code += message.split("```")[-1].strip() + "\n"
        elif code_started:
            # Appending lines within the Java code block
            if "```" in message.lower():
                # End of Java code block found
                java_code += message.split("```")[0].strip()  # Capture last line
                break
            else:
                java_code += message.strip() + "\n"

    return java_code.strip()  # Return the extracted Java code

