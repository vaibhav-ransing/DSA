def show_confirmation_popup(message, user_id, user_password, component_name, folder_location, branch_name):
    def on_yes():
        confirmation_popup.destroy()
        show_loading_popup(user_id, user_password, component_name, folder_location, branch_name)

    def on_no():
        confirmation_popup.destroy()

    confirmation_popup = tk.Toplevel(window)
    confirmation_popup.title("Confirmation")
    confirmation_popup.configure(bg="#F8F8F2")  # Light background color
    confirmation_popup.attributes("-topmost", True)

    confirmation_popup_width = 300
    confirmation_popup_height = 200
    confirmation_popup_x = window.winfo_x() + int((window_width - confirmation_popup_width) / 2)
    confirmation_popup_y = window.winfo_y() + int((window_height - confirmation_popup_height) / 2)
    confirmation_popup.geometry(f"{confirmation_popup_width}x{confirmation_popup_height}+{confirmation_popup_x}+{confirmation_popup_y}")

    confirmation_custom_font = ("Arial", 12)

    # Create a frame for the content
    content_frame = tk.Frame(confirmation_popup, bg="#F8F8F2")  # Custom background color
    content_frame.pack(pady=10)

    message_lines = message.split("\n")
    for line in message_lines:
        label_line = tk.Label(content_frame, text=line, bg="#F8F8F2", fg="#2E3440", font=confirmation_custom_font)  # Custom colors
        label_line.pack(pady=1)

    button_frame = tk.Frame(confirmation_popup, bg="#F8F8F2")  # Custom background color
    button_frame.pack(pady=10)

    button_yes = tk.Button(button_frame, text="Yes", command=on_yes, bg="#6272A4", fg="#F8F8F2", font=confirmation_custom_font, relief=tk.FLAT, width=8, height=1)  # Custom colors
    button_yes.pack(side=tk.LEFT, padx=10)

    button_no = tk.Button(button_frame, text="No", command=on_no, bg="#6272A4", fg="#F8F8F2", font=confirmation_custom_font, relief=tk.FLAT, width=8, height=1)  # Custom colors
    button_no.pack(side=tk.LEFT, padx=10)

    content_frame.pack_configure(anchor=tk.CENTER)
    confirmation_popup.lift()
    confirmation_popup.focus_force()
    window.wait_window(confirmation_popup)
