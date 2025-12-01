# -*- coding: utf-8 -*-
"""
Created on Mon Nov 17 15:12:57 2025
@author: ni451kus
"""

import numpy as np
import matplotlib.pyplot as plt

# Datei laden
filename = "aufnahme_20251117_151716.npy"
signal = np.load(filename)
print(f"Signal geladen aus: {filename}")

# Zeitachse erzeugen (falls Samplingrate bekannt)
fs = 44100  # Beispiel
t = np.arange(len(signal)) / fs

# Plotten
plt.figure(figsize=(10,4))
plt.plot(t, signal)
plt.title("Aufgenommenes Sprachsignal")
plt.xlabel("Zeit [s]")
plt.ylabel("Amplitude")
plt.grid(True)
plt.tight_layout()
plt.show()
