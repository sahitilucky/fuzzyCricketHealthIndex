from mpl_toolkits.mplot3d import *
import matplotlib.pyplot as plt
from matplotlib import cm
import random as rd
import numpy as np
import math
f=open("output3.txt","r")
line=f.readline()
X=[]
Y=[]
Z=[]
while line:
	line=line.split(" ")
	X=X+[float(line[0])]
	Y=Y+[float(line[1])]	
	Z=Z+[float(line[2])]	
	line=f.readline()

print X
print Y
plt.ylim(0,100)
plt.xlim(0,20)
plt.xlabel('Overs')
plt.ylabel('HealthIndex')
plt.hold(True)
first=0
for i in range(len(Z)):
	if Z[i]==0:
		plt.plot(X[i],Y[i],'ro')
	else:
		first=i
		plt.plot(X[i],Y[i],'go',markersize=10)
plt.plot(X[first],Y[first],'go',label='wicket')
line=plt.plot(X[:],Y[:],linewidth=2.0)
plt.setp(line,color='r')
plt.suptitle('Team 2 First Innings Algorithm', fontsize=15)
plt.legend()
plt.xticks(np.arange(0, 20, 1.0))
plt.savefig("HealthIndex3");

