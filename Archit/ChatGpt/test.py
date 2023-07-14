import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
import threading

BG_COLOR = "#2E3440"  # Background color
FG_COLOR = "#F8F8F2"  # Foreground color

def show_confirmation_popup(message, user_id, user_password, component_name, folder_location, branch_name):
    def on_yes():
        confirmation_popup.destroy()
        show_loading_popup(user_id, user_password, component_name, folder_location, branch_name)

    def on_no():
        confirmation_popup.destroy()

    confirmation_popup = tk.Toplevel(window)
    confirmation_popup.title("Confirmation")
    confirmation_popup.configure(bg=BG_COLOR)
    confirmation_popup.attributes("-topmost", True)

    confirmation_popup_width = 300
    confirmation_popup_height = 200
    confirmation_popup_x = window.winfo_x() + int((window_width - confirmation_popup_width) / 2)
    confirmation_popup_y = window.winfo_y() + int((window_height - confirmation_popup_height) / 2)
    confirmation_popup.geometry(f"{confirmation_popup_width}x{confirmation_popup_height}+{confirmation_popup_x}+{confirmation_popup_y}")

    confirmation_custom_font = ("Arial", 12)

    content_frame = tk.Frame(confirmation_popup, bg=BG_COLOR)
    content_frame.pack(pady=10)

    message_lines = message.split("\n")
    for line in message_lines:
        label_line = tk.Label(content_frame, text=line, bg=BG_COLOR, fg=FG_COLOR, font=confirmation_custom_font)
        label_line.pack(pady=1)

    button_frame = tk.Frame(confirmation_popup, bg=BG_COLOR)
    button_frame.pack(pady=10)

    button_yes = tk.Button(button_frame, text="Yes", command=on_yes, bg="#6272A4", fg=FG_COLOR, font=confirmation_custom_font, relief=tk.FLAT, width=8, height=1)
    button_yes.pack(side=tk.LEFT, padx=10)

    button_no = tk.Button(button_frame, text="No", command=on_no, bg="#6272A4", fg=FG_COLOR, font=confirmation_custom_font, relief=tk.FLAT, width=8, height=1)
    button_no.pack(side=tk.LEFT, padx=10)

    content_frame.pack_configure(anchor=tk.CENTER)
    confirmation_popup.lift()
    confirmation_popup.focus_force()
    window.wait_window(confirmation_popup)


def show_loading_popup(user_id, user_password, component_name, folder_location, branch_name):
    loading_popup = tk.Toplevel(window)
    loading_popup.title("Loading")
    loading_popup.configure(bg=BG_COLOR)
    loading_popup.attributes("-topmost", True)

    loading_popup_width = 300
    loading_popup_height = 150
    loading_popup_x = window.winfo_x() + int((window_width - loading_popup_width) / 2)
    loading_popup_y = window.winfo_y() + int((window_height - loading_popup_height) / 2)
    loading_popup.geometry(f"{loading_popup_width}x{loading_popup_height}+{loading_popup_x}+{loading_popup_y}")

    loading_custom_font = ("Arial", 14)

    label_loading = tk.Label(loading_popup, text="Loading...", bg=BG_COLOR, fg=FG_COLOR, font=loading_custom_font)
    label_loading.pack(pady=20)

    window.config(state="disabled")
    window.update()

    def run_sonar_script():
        try:
            # Simulating a long-running task
            import time
            time.sleep(5)

            window.config(state="normal")
            loading_popup.destroy()
            show_ok_popup("All the vulnerabilities are fixed\nPlease check the statistic report", False)
        except Exception as e:
            show_ok_popup("Please check your credentials", True)

    thread = threading.Thread(target=run_sonar_script)
    thread.start()

def show_ok_popup(message, falseCreds):
    popup_window = tk.Toplevel(window)
    popup_window.title("Success")
    popup_window.configure(bg=BG_COLOR)
    popup_window.attributes("-topmost", True)

    popup_window_width = 300
    popup_window_height = 150
    popup_x = window.winfo_x() + int((window_width - popup_window_width) / 2)
    popup_y = window.winfo_y() + int((window_height - popup_window_height) / 2)
    popup_window.geometry(f"{popup_window_width}x{popup_window_height}+{popup_x}+{popup_y}")

    popup_custom_font = ("Arial", 12)

    content_frame = tk.Frame(popup_window, bg=BG_COLOR)
    content_frame.pack(pady=20)

    message_lines = message.split("\n")
    for line in message_lines:
        label_line = tk.Label(content_frame, text=line, bg=BG_COLOR, fg=FG_COLOR, font=popup_custom_font, wraplength=250)
        label_line.pack()

    button_frame = tk.Frame(popup_window, bg=BG_COLOR)
    button_frame.pack(pady=10)

    def close_window():
        popup_window.destroy()
        if falseCreds == False:
            window.destroy()

    button_ok = tk.Button(button_frame
