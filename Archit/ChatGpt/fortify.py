import javalang
import os

def remove_try_catch_block(file_location, start_line):
    # Read the input Java code file
    with open(file_location, 'r') as file:
        java_code = file.read()

    # Parse the Java code
    tree = javalang.parse.parse(java_code)

    # Find and remove try-catch block based on the start line
    new_tree = []
    try_catch_depth = 0
    for path, node in tree:
        if isinstance(node, javalang.tree.TryStatement):
            if node.position[0].line == start_line:
                try_catch_depth += 1
                continue
        if try_catch_depth > 0:
            if isinstance(node, (javalang.tree.TryStatement, javalang.tree.CatchClause)):
                try_catch_depth += 1
            elif isinstance(node, javalang.tree.BlockStatement):
                try_catch_depth -= 1
        else:
            new_tree.append(node)

    # Convert the modified tree back to Java code
    modified_code = ''.join(str(node) for node in new_tree)

    # Write the modified code back to the input file
    with open(file_location, 'w') as modified_file:
        modified_file.write(modified_code)

remove_try_catch_block('test.java', 1)

#write testcase for remove_try_catch_block

def remove_try_catch_block(file_location, start_line):
    # Read the input Java code file
    with open(file_location, 'r') as file:
        java_code = file.read()
