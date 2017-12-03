from mpl_toolkits.mplot3d import *
import matplotlib.pyplot as plt
from matplotlib import cm
import random as rd
import numpy as np
import math
f=open("output2.txt","r")
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
plt.figure(figsize=(10,6))
plt.ylim(0,100)
plt.xlim(0,20)
plt.xlabel('Overs')
plt.ylabel('HealthIndex')
plt.hold(True)
first=0
first2=0
for i in range(len(Z)):
	if Z[i]==0:
		plt.plot(X[i],Y[i],'go')	
		if(i!=0):
			if(Y[i]-Y[i-1]>15):
				first2=i		
				plt.plot(X[i],Y[i],'co',markersize=10)		
	else:
		first=i
		plt.plot(X[i],Y[i],'ro',markersize=10)
plt.plot(X[first],Y[first],'ro',label='wicket')
plt.plot(X[i],Y[i],'co',label='rise point')
line=plt.plot(X[:],Y[:],linewidth=2.0)
plt.setp(line,color='g')
plt.suptitle('Team 2 Second Innings Algorithm ', fontsize=15)
plt.legend(bbox_to_anchor=(0.8, 1.12), loc=2, borderaxespad=0.)
plt.xticks(np.arange(0, 20, 1.0))
plt.savefig("HealthIndex2");

