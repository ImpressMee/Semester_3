# -*- coding: utf-8 -*-
"""
Aufnahme kurzer akustischer Signale über die Soundkarte.
Speichern mit automatisch generiertem eindeutigen Dateinamen (numpy.save)
und Darstellung als Diagramm.
"""

import pyaudio
import numpy as np
import matplotlib.pyplot as plt
import os
import re

# Audio-Parameter
FORMAT = pyaudio.paInt16
CHANNELS = 1
FS = 44100
DURATION = 2
CHUNK = 1024

# Speicherpfad
SAVE_DIR = r"D:\KI_Fouriranalyse\Messungen\Justin"
os.makedirs(SAVE_DIR, exist_ok=True)

# PyAudio initialisieren
p = pyaudio.PyAudio()

print("Starte Aufnahme...")

stream = p.open(format=FORMAT,
                channels=CHANNELS,
                rate=FS,
                input=True,
                frames_per_buffer=CHUNK)

frames = []

# Aufnahme
for i in range(int(FS / CHUNK * DURATION)):
    data = stream.read(CHUNK)
    frames.append(np.frombuffer(data, dtype=np.int16))

print("Aufnahme beendet.")

stream.stop_stream()
stream.close()
p.terminate()

# Array erstellen
signal = np.concatenate(frames)

# Zeitachse
t = np.arange(len(signal)) / FS

# -------------------------------------------------------
# Automatisch generierter fortlaufender Dateiname
# -------------------------------------------------------
files = [f for f in os.listdir(SAVE_DIR) if f.startswith("Justin_Rechts") and f.endswith(".npy")]

nums = []
for f in files:
    m = re.search(r"Justin_Rechts(\d+)\.npy", f)
    if m:
        nums.append(int(m.group(1)))

next_num = max(nums) + 1 if nums else 0
filename = os.path.join(SAVE_DIR, f"Justin_Rechts{next_num:04d}.npy")
# -------------------------------------------------------

# Speichern
np.save(filename, signal)
print(f"Signal gespeichert als: {filename}")

# Plotten
plt.figure(figsize=(10,4))
plt.plot(t, signal)
plt.title("Aufgenommenes Sprachsignal")
plt.xlabel("Zeit [s]")
plt.ylabel("Amplitude")
plt.grid(True)
plt.tight_layout()
plt.show()

# Laden
signal = np.load(filename)
print(f"Signal geladen aus: {filename}")

# Zeitachse erneut erzeugen
t = np.arange(len(signal)) / FS

# Plotten
plt.figure(figsize=(10,4))
plt.plot(t, signal)
plt.title("Aufgenommenes Sprachsignal (geladen)")
plt.xlabel("Zeit [s]")
plt.ylabel("Amplitude")
plt.grid(True)
plt.tight_layout()
plt.show()
