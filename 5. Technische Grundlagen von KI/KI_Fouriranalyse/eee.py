# Imports
import sys
import pandas as pd
import matplotlib.pyplot as plt
import pyaudio
import numpy as np
import os
import re

print(sys.executable)

# conv für CVS
def conv(x):
    return float(x.replace(',','.'))

# Plot functions
def plotstart():
    plt.figure(figsize=(10,4))

# Finalisiert den Plot: entfernt doppelte Legendeneinträge, setzt Titel und Achsenbeschriftungen,
# aktiviert Gitternetz, platziert die Legende oben rechts, optimiert das Layout und zeigt den Plot an.

def plotend(ueberschrift, xlabel, ylabel):
    handles, labels = plt.gca().get_legend_handles_labels()
    by_label = dict(zip(labels, handles))
    plt.legend(by_label.values(), by_label.keys())
    plt.title(f"Oszilloskop-Messung {ueberschrift}")
    plt.xlabel(f"{xlabel}")
    plt.ylabel(f"{ylabel}")
    plt.grid(True, which='both')
    plt.minorticks_on()
    plt.legend(loc='upper right')   #legende oben rechts
    plt.tight_layout()
    plt.show()

# Methode zur CSV einlesung

def readAndPlotCSV(dateiname, plot):
    data = np.genfromtxt(
        dateiname,
        delimiter=';',
        skip_header=2,
        converters={0: conv, 1: conv},
        autostrip=True
    )

    t = data[:, 0]      # Zeit in ms
    u = data[:, 1]      # Spannung in mV
    t = t - t[0]        # Verschiebt die Zeitreihe so, dass sie bei 0 beginnt
    plotstart()
    plt.plot(t[::10], u[::10])     # weniger Punkte
    plt.xlim(5, 15)                # kleinerer Bereich
    plotend("Mundharmonika", "Zeit in ms", "Spannung in mV")

    return t, u
'''
TODO: Signal Graphisch darstellen ! CHECK !
      Bestimmen von: Grundperiode (ms), Grundfrequenz (Hz), Signaldauer (s), Abtastfrequenz (Hz),  Signallänge M
      Anzahl der Abtastzeitpunkte und Abtastintervall dT (s)
'''

csvFile = "C:/Users/justi/OneDrive/Desktop/Semester 3/5. Technische Grundlagen von KI/KI_Fouriranalyse/Messungen/Harmonika/Harmonika.csv"
t, u = readAndPlotCSV(csvFile, plot=True)