
import pandas as pd
import numpy as np
from sklearn import preprocessing
from sklearn.preprocessing import OneHotEncoder
from sklearn.preprocessing import LabelEncoder
from sklearn.preprocessing import LabelBinarizer
from sklearn.preprocessing import MultiLabelBinarizer



# columns = ['pet','age','salary']
# data = pd.DataFrame([['cat','dog','dog','fish'],[4,6,3,3],[4,5,1,1]])


# print (data.shape[1])    # shape[0] return  the number of row,  shape[1] return the number of coloum
# print("===========================")

# data = data.T		# zhuan zhi 
# print (data)

# print("===========================")


# data.columns = columns
# print (data)


# c = np.array([[ 0,  1,  2,  3],
#        [ 4,  5,  6,  7],
#        [ 8,  9, 10, 11],
#        [12, 13, 14, 15],
#        [16, 17, 18, 19]])

# print (c.shape[1]) 

# one = pd.DataFrame({
#    'Name': ['Alex', 'Amy', 'Allen', 'Alice', 'Ayoung'],
#    'subject_id':['sub1','sub2','sub3','sub4','sub5'],
#    'Marks_scored':[98,90,87,69,78]},
#    index=[1,2,3,4,5])

# two = pd.DataFrame({
#    'Name': ['Billy', 'Brian', 'Bran', 'Bryce', 'Betty'],
#    'subject_id':['sub2','sub4','sub3','sub6','sub5'],
#    'Marks_scored':[89,80,79,97,88]},
#    index=[1,2,3,4,5])

# print (one)
# print ("=============================")

# print(one.iloc[:,2])      # iloc[:,i] print i+1 coloum,   iloc[:2] print the first two rows 
# print (two)
# print ("=================")

# print pd.concat([one,two])


# list1 = [1,2,3,4,5]
# list2 = [6,7,8,9,10]
# for i,(n,m) in enumerate(zip(list1,list2)):
# 	print (i, (n,m))

# print ('{:*^20}'.format(' model_kmeans'))    #*********************** model_kmeans************************

# result = pd.read_csv('/Users/dongjifeng/Desktop/march_01_2019.txt')
# print (result)


# index1 = ['1','2','3','4','5']
# index2 = ['a','b','c','d','e']
# result1 = zip(index1,index2)
# result2 = dict(result1)
# print (result1)
# print(result2)

# print(result2.keys())

# mul_pd_mat_2 = pd.DataFrame(np.zeros((len(result2.keys()),3))) # if  columns == init, only 1 column, if no columns, default could be anything
# print mul_pd_mat_2

# matrix = pd.DataFrame([[1,2,3],[4,5,6],[7,8,9]])
# print matrix.iloc[:]
# print matrix.iloc[1,:]      #iloc[:,:-2] first column,  iloc[:,-1] last colum

# data = pd.DataFrame(np.zeros((3,2)))
# print (data)

dictDel = {}
a = [{'repost': 1, 'january': 1, 'good': 1, 'fit': 1, 'title': 1},{'repost': 1, 'january': 1, 'good': 1, 'fit': 1, 'title': 1},{'repost': 1, 'january': 1, 'good': 1, 'fit': 1, 'title': 1}]

# print(a[0].keys())
for i in range(0, len(a)):
	for key in a[i].keys():
		if  len(key)  <= 3 :
			dictDel[i] = key


# print(a)
# print(dictDel)
# del a[0]['repost']
# print(a)
for key in dictDel.keys():
	val = dictDel[key]
	del a[key][val]
# print(a)


