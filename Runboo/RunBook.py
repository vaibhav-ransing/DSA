from docx import Document


def read_docx(filename):
    doc = Document(filename)
    test = ""
    full_text_arr = []
    for para in doc.paragraphs:
        full_text_arr.append(para.text)
        test+=para.text +"\n"
    
    print("*"*12)
    print(test)
    print("*"*12)
    return full_text_arr


pre_req_words = ["Prerequisite", "prereq", "pre-req"]
deploy_words = ["deploy"] # , "install"
post_release_words = ["Post Release", "post-release"]
rollback_words = ["Rollback", "rollback"]


def find_word(line, words_arr):
    for word in words_arr:
        if word in line:
            return True
    return False


def lines_in_range(doc_text_lines, start, end):
    temp_str = ""
    for idx in range(start, end):
        temp_str += (doc_text_lines[idx] + "\n")
    return temp_str


def get_string(word_type, doc_text_lines, start, end, pre_req_final_str, deploy_final_str, post_release_final_str, role_back_final_str):
    curr_line = lines_in_range(doc_text_lines, start, end)
    if word_type == 'pre_req':
        pre_req_final_str += curr_line
    elif word_type == 'deploy':
        deploy_final_str += curr_line
    elif word_type == 'post_rel':
        post_release_final_str += curr_line
    elif word_type == 'roleback':
        role_back_final_str += curr_line
    return pre_req_final_str, deploy_final_str, post_release_final_str, role_back_final_str


filename = 'test-runbook.docx'
doc_text_lines = read_docx(filename)
# print("*doc txt "*12)
# print(doc_text_lines)
# print("*"*12)

def get_segregated_strings(doc_text_lines):
    start_idx = 0
    end_idx = 0
    prev_word_type = ""  # pre_req, deploy, post_rel
    pre_req_final_str = ""
    deploy_final_str = ""
    post_release_final_str = ""
    role_back_final_str = ""

    for index, line in enumerate(doc_text_lines):

        if find_word(line, pre_req_words):
            pre_req_final_str, deploy_final_str, post_release_final_str, role_back_final_str = get_string(
                prev_word_type, doc_text_lines, start_idx, end_idx, pre_req_final_str, deploy_final_str, post_release_final_str, role_back_final_str)

            # print("Pre_req " + str(start_idx) + " " + str(end_idx)+ " pre-word= ", prev_word_type)
            prev_word_type = "pre_req"
            start_idx = index
            end_idx = index+1

        elif find_word(line, deploy_words):

            pre_req_final_str, deploy_final_str, post_release_final_str, role_back_final_str = get_string(
                prev_word_type, doc_text_lines, start_idx, end_idx, pre_req_final_str, deploy_final_str, post_release_final_str, role_back_final_str)

            prev_word_type = "deploy"
            # print("deploy " + str(start_idx) + " "+str(end_idx))
            start_idx = index
            end_idx = index+1

        elif find_word(line, post_release_words):

            pre_req_final_str, deploy_final_str, post_release_final_str, role_back_final_str = get_string(
                prev_word_type, doc_text_lines, start_idx, end_idx, pre_req_final_str, deploy_final_str, post_release_final_str, role_back_final_str)

            prev_word_type = "post_rel"
            # print("post_rel " + str(start_idx) + " " + str(end_idx))
            start_idx = index
            end_idx = index+1

        elif find_word(line, rollback_words):
            end_idx = end_idx + 1

        else:
            end_idx = end_idx + 1
    # print("----------------------")
    # print(pre_req_final_str)
    # print("----------------------")
    # print(deploy_final_str)
    # print("----------------------")
    # print(post_release_final_str)
    # print("----------------------")
    # print(role_back_final_str)
    

get_segregated_strings(doc_text_lines)
