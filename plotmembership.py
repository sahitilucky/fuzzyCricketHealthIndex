from mpl_toolkits.mplot3d import *
import matplotlib.pyplot as plt
from matplotlib import cm
import random as rd
import math
import time

import sys

f=open(str(sys.argv[1]),"r")
line=f.readline()
X=[]
Y=[]
Z=[]

plt.figure(figsize=(5,4))
plt.ylim(0,2)
plt.xlabel('RequiredrrPresentrr')
plt.ylabel('Membershipvalue')
plt.hold(True)
colors=['b','r','g','y','b']
legends=['verylow','low','medium','high','veryhigh']
i=0
while line:
	line=line.split(" ")
	print line
	if(line[0]=='#\n'):
		line=plt.plot(X[:],Y[:],linewidth=2.0,label=legends[i])
		plt.setp(line,color=colors[i])
		i+=1
		X=[]
		Y=[]
	else:	
		X=X+[float(line[0])]
		Y=Y+[float(line[1])]
	line=f.readline()

plt.legend()
print X
print Y


plt.savefig(str(sys.argv[2]));

