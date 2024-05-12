from pytube import YouTube
import pygame
from moviepy.editor import *
import tkinter as tk
import threading

def download_audio(youtube_url, output_path):
    try:
        yt = YouTube(youtube_url)
        audio_stream = yt.streams.filter(only_audio=True).first()
        audio_stream.download(output_path=output_path)
        return audio_stream.default_filename
    except Exception as e:
        print("Error:", e)
        return None


def convert_to_wav(input_file, output_folder):
    try:
        output_file = os.path.join(output_folder, os.path.splitext(os.path.basename(input_file))[0] + ".wav")
        audio_clip = AudioFileClip(input_file)
        audio_clip.write_audiofile(output_file)
        return output_file
    except Exception as e:
        print("Error:", e)
        return None


def play_audio(audio_file, volume):
    pygame.mixer.init()
    pygame.mixer.music.load(audio_file)
    pygame.mixer.music.set_volume(volume)
    pygame.mixer.music.play()


def main():
    youtube_link = input("Enter the YouTube link: ")

    output_folder = "audio_downloads"
    os.makedirs(output_folder, exist_ok=True)
    audio_file = download_audio(youtube_link, output_folder)

    if audio_file:
        print("Audio downloaded successfully.")
        wav_file = convert_to_wav(os.path.join(output_folder, audio_file), output_folder)
        if wav_file:
            print("Audio converted to WAV format.")
            volume = 0.05  # Adjust volume here (0.0 to 1.0)
            audio_thread = threading.Thread(target=play_audio, args=(wav_file, volume))
            audio_thread.start()
        else:
            print("Failed to convert audio to WAV format.")
    else:
        print("Failed to download audio. Please check the YouTube link.")

    root = tk.Tk()
    root.title("Circle Animation")
    width = 400
    height = 300
    CircleAnimation(root, width, height)
    root.mainloop()


if __name__ == "__main__":
    main()
