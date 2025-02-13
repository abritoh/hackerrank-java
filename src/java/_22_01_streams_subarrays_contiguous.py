import matplotlib.pyplot as plt
import numpy as np

array3D = [
    [[0], [1], [2], [3], [4], [5], [6], [7], [8], [9]],
    [[0, 1], [1, 2], [2, 3], [3, 4], [4, 5], [5, 6], [6, 7], [7, 8], [8, 9]],
    [[0, 1, 2], [1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8], [7, 8, 9]],
    [[0, 1, 2, 3], [1, 2, 3, 4], [2, 3, 4, 5], [3, 4, 5, 6], [4, 5, 6, 7], [5, 6, 7, 8], [6, 7, 8, 9]],
    [[0, 1, 2, 3, 4], [1, 2, 3, 4, 5], [2, 3, 4, 5, 6], [3, 4, 5, 6, 7], [4, 5, 6, 7, 8], [5, 6, 7, 8, 9]],
    [[0, 1, 2, 3, 4, 5], [1, 2, 3, 4, 5, 6], [2, 3, 4, 5, 6, 7], [3, 4, 5, 6, 7, 8], [4, 5, 6, 7, 8, 9]],
    [[0, 1, 2, 3, 4, 5, 6], [1, 2, 3, 4, 5, 6, 7], [2, 3, 4, 5, 6, 7, 8], [3, 4, 5, 6, 7, 8, 9]],
    [[0, 1, 2, 3, 4, 5, 6, 7], [1, 2, 3, 4, 5, 6, 7, 8], [2, 3, 4, 5, 6, 7, 8, 9]],
    [[0, 1, 2, 3, 4, 5, 6, 7, 8], [1, 2, 3, 4, 5, 6, 7, 8, 9]],
    [[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]]
]

fig = plt.figure(figsize=(20, 16))
ax = fig.add_subplot(111, projection='3d')

colors = ['b', 'g', 'r', 'c', 'm', 'y', 'k', '#7f7f7f', '#ff7f0e', '#2ca02c']

for d in range(len(array3D)):
    color = colors[d % len(colors)]
    for i in range(len(array3D[d])):
        xs = [d] * len(array3D[d][i])
        ys = [i] * len(array3D[d][i])
        zs = array3D[d][i]
        ax.bar(xs, zs, zs=ys, zdir='y', edgecolor='k', color=color, alpha=0.8)

ax.set_xlabel('Depth (d)')
ax.set_ylabel('Row Index (i)')
ax.set_zlabel('Value')

ax.set_xticks(np.arange(0, 11, 1))
ax.set_yticks(np.arange(0, 10, 1))

ax.grid(True)

plt.show()
