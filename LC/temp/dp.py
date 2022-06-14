tasks = ["A","A","A","B","B","B"]
tasks2 = ["A","B","A","C","B","B"]
cooldown = 2


def procrssScheduler(tasks,cooldown):
	if cooldown == 0:
		return len(tasks)

	# key = 0
	count = 1
	i = 1

	while i < len(tasks):
		# key = tasks[i]
		for j in range(i-cooldown,i-1):
			while j >= 0:
			if tasks[j]==tasks[i]:
				count += 1
				i+= 1
			else:
				count += cooldown
				i+=1
	return count+len(tasks) 

res = procrssScheduler(tasks2,cooldown)
print (res)

