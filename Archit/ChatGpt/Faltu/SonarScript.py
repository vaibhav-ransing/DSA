import tkinter as tk
from tkinter import ttk
import threading
import time

def show_loading_popup(user_id, user_password, component_name, folder_location, branch_name):
    loading_popup = tk.Toplevel(window)
    loading_popup.title("Loading")
    loading_popup.configure(bg="#F8F8F2")  # Light background color
    loading_popup.attributes("-topmost", True)

    loading_popup_width = 300
    loading_popup_height = 150
    loading_popup_x = window.winfo_x() + int((window_width - loading_popup_width) / 2)
    loading_popup_y = window.winfo_y() + int((window_height - loading_popup_height) / 2)
    loading_popup.geometry(f"{loading_popup_width}x{loading_popup_height}+{loading_popup_x}+{loading_popup_y}")

    loading_custom_font = ("Arial", 14)

    # Create a frame for the content
    content_frame = tk.Frame(loading_popup, bg="#F8F8F2")  # Custom background color
    content_frame.pack(pady=10)

    # Create and place the label with the loading message
    label_loading = tk.Label(content_frame, text="Please wait, fixing vulnerabilities", bg="#F8F8F2", fg="#2E3440", font=loading_custom_font)  # Custom colors
    label_loading.pack()

    # Create a frame for the progress bar and timer
    progress_frame = tk.Frame(loading_popup, bg="#F8F8F2")  # Custom background color
    progress_frame.pack(pady=10)

    # Create a progress bar widget
    progress = ttk.Progressbar(progress_frame, orient="horizontal", length=200, mode="indeterminate")
    progress.pack()

    # Create a label for displaying the timer
    timer_label = tk.Label(progress_frame, text="Time: 0 seconds", bg="#F8F8F2", fg="#2E3440", font=loading_custom_font)
    timer_label.pack()

    # Start the progress bar animation
    progress.start()

    # Disable the main window
    window.attributes("-disabled", True)

    start_time = time.time()

    def update_timer():
        elapsed_time = int(time.time() - start_time)
        timer_label.config(text=f"Time: {elapsed_time} seconds")
        loading_popup.after(1000, update_timer)

    def simulate_loading():
        try:
            # Call the sonar_script function with the provided arguments
            sonar_script(user_id, user_password, component_name, folder_location, branch_name)
            time.sleep(5)

            # Enable the main window
            window.attributes("-disabled", False)

            # Close the loading popup
            loading_popup.destroy()

            # Show a completion message
            show_ok_popup("All the vulnerabilities are fixed\nPlease check the statistic report", False)
        except Exception as e:
            show_ok_popup("Please check your credentials", True)

    # Start the timer
    update_timer()

    # Start a new thread for simulating the loading
    thread = threading.Thread(target=simulate_loading)
    thread.start()

# Call the show_loading_popup function where appropriate in your code, based on your application's flow,
# and provide the necessary arguments: user_id, user_password, component_name, folder_location, branch_name.
