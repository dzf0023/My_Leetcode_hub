
import numpy as np
import matplotlib.pyplot as plt



ARand_nDCG_MSLR = np.array([0.3084, 0.3377, 0.3609, 0.3807, 0.4176])
# 0.4176

ARank_DCG1_MSLR = np.array([0.2386, 0.2529, 0.2652, 0.2758, 0.2957])


ARank_DCG2_MSLR = np.array([0.2267, 0.244, 0.2579, 0.2695,0.293])


ARank_DCG3_MSLR = np.array([0.2449, 0.253, 0.2648, 0.2756, 0.2964])



#average
nDCG_mean = np.mean(ARand_nDCG_MSLR)
print(nDCG_mean)


DCG1_mean = np.mean(ARank_DCG1_MSLR)

DCG2_mean = np.mean(ARank_DCG2_MSLR)

DCG3_mean = np.mean(ARank_DCG3_MSLR)



#standard deviation
nDCG_std = np.std(ARand_nDCG_MSLR)

print(nDCG_std)

DCG1_std = np.std(ARank_DCG1_MSLR)

DCG2_std = np.std(ARank_DCG2_MSLR)

DCG3_std = np.std(ARank_DCG3_MSLR)


metrics = ['nDCG', 'DCG_v1', 'DCG_V2', ' DCG_V3']

x_pos = np.arange(len(metrics))

CTEs = [nDCG_mean, DCG1_mean, DCG2_mean, DCG3_mean]

error = [nDCG_std, DCG1_std, DCG2_std, DCG3_std]



#build the plot
fig, ax = plt.subplots()
# ax.bar(x_pos, CTEs, yerr=error , align='center', alpha=0.5, ecolor='black', capsize=10)
ax.errorbar(x_pos, CTEs, yerr=error , fmt = '*', ecolor='black', capsize=10)

ax.set_ylabel('Average value and Std')
ax.set_xticks(x_pos)
ax.set_xticklabels(metrics)
ax.set_title('eight LETOR methods ')
ax.yaxis.grid(True)




plt.tight_layout()
# plt.savefig('bar_plot_with_error_bars.png')
plt.show()














