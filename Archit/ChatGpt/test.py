def show_confirmation_popup(message, user_id, user_password, component_name, folder_location, branch_name):
    # Create the confirmation popup window
    confirmation_popup = tk.Toplevel(window)
    confirmation_popup.title("Confirmation")
    confirmation_popup.configure(bg="#F8F8F2")  # Light background color
    confirmation_popup.attributes("-topmost", True)

    # Center the confirmation popup window
    confirmation_popup_width = 300
    confirmation_popup_height = 200
    confirmation_popup_x = window.winfo_x() + int((window_width - confirmation_popup_width) / 2)
    confirmation_popup_y = window.winfo_y() + int((window_height - confirmation_popup_height) / 2)
    confirmation_popup.geometry(f"{confirmation_popup_width}x{confirmation_popup_height}+{confirmation_popup_x}+{confirmation_popup_y}")

    # Set custom font and size for the confirmation popup window
    confirmation_popup_custom_font = ("Arial", 12)

    # Create a frame for the content
    content_frame = tk.Frame(confirmation_popup, bg="#F8F8F2")
    content_frame.pack(pady=10)

    # Split the message into multiple lines
    message_lines = message.split("\n")

    # Create and arrange the labels with the message lines
    for line in message_lines:
        label_line = tk.Label(content_frame, text=line, bg="#F8F8F2", fg="#2E3440", font=confirmation_popup_custom_font)
        label_line.pack(pady=1)

    # Create and arrange the buttons with reduced size and spacing
    button_frame = tk.Frame(confirmation_popup, bg="#F8F8F2")  # Custom background color
    button_frame.pack(pady=10)

    def on_yes():
        # Close the confirmation popup
        confirmation_popup.destroy()

        # Create the loading popup window
        loading_popup = tk.Toplevel(window)
        loading_popup.title("Loading")
        loading_popup.configure(bg=BG_COLOR)
        loading_popup.attributes("-topmost", True)

        # Center the loading popup window
        loading_popup_width = 300
        loading_popup_height = 150
        loading_popup_x = window.winfo_x() + int((window_width - loading_popup_width) / 2)
        loading_popup_y = window.winfo_y() + int((window_height - loading_popup_height) / 2)
        loading_popup.geometry(f"{loading_popup_width}x{loading_popup_height}+{loading_popup_x}+{loading_popup_y}")

        # Set custom font for the loading popup window
        loading_popup_custom_font = ("Arial", 14)

        # Create and arrange the label with the loading message
        label_loading = tk.Label(loading_popup, text="Loading...", bg=BG_COLOR, fg=FG_COLOR, font=loading_popup_custom_font)
        label_loading.pack(pady=20)

        # Disable the main window
        window.grab_set()

        def run_sonar_script():
            try:
                sonar_script(user_id, user_password, component_name, folder_location, branch_name)
                # Enable the main window
                window.grab_release()

                # Close the loading popup
                loading_popup.destroy()

                # Show the success popup
                show_ok_popup("All the vulnerabilities are fixed \n Please check the statistic report", False)
            except Exception as e:
                show_ok_popup("Please check your credentials", True)

        # Start a new thread for running the sonar_script
        thread = threading.Thread(target=run_sonar_script)
        thread.start()

    def on_no():
        # Close the confirmation popup
        confirmation_popup.destroy()

    button_yes = tk.Button(button_frame, text="Yes", command=on_yes, bg="#6272A4", fg="#F8F8F2", font=confirmation_popup_custom_font, relief=tk.FLAT, width=8, height=1)  # Custom colors, reduced size
    button_yes.pack(side=tk.LEFT, padx=10)

    button_no = tk.Button(button_frame, text="No", command=on_no, bg="#6272A4", fg="#F8F8F2", font=confirmation_popup_custom_font, relief=tk.FLAT, width=8, height=1)  # Custom colors, reduced size
    button_no.pack(side=tk.LEFT, padx=10)

    # Center the content frame within the confirmation popup window
    content_frame.pack_configure(anchor=tk.CENTER)

    # Bring the confirmation popup window to the front and focus it
    confirmation_popup.lift()
    confirmation_popup.focus_force()

    # Make the main window inactive until the confirmation popup window is closed
    window.wait_window(confirmation_popup)
