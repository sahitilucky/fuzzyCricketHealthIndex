from mpl_toolkits.mplot3d import *
import matplotlib.pyplot as plt
from matplotlib import cm
import random as rd
import math
import numpy as np
import time
f=open("output1.txt","r")
line=f.readline()
X=[]
Y=[]
Z=[]
plt.ylim(0,100)
plt.xlim(0,20)
plt.xlabel('Overs')
plt.ylabel('HealthIndex')
#plt.hold(True)
while line:
	line=line.split(" ")
	X=X+[float(line[0])]
	Y=Y+[float(line[1])]
	Z=Z+[float(line[2])]	
	line=f.readline()
first=0
for i in range(len(Z)):
	if Z[i]==0:
		plt.plot(X[i],Y[i],'bo')
	else:
		first=i
		plt.plot(X[i],Y[i],'ro',markersize=10)
plt.plot(X[first],Y[first],'ro',label='wicket')

plt.plot(X[:],Y[:],linewidth=2.0)
plt.suptitle('Team 1 First Innings Algorithm', fontsize=15)
plt.xticks(np.arange(0, 20, 1.0))
plt.legend()
print X
print Y




plt.savefig("HealthIndex1");

