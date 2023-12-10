import matplotlib.pyplot as plt
import numpy as np
from scipy.stats import norm

# Giá trị Z0, alpha, p1, p2
z0 = 1.645  # Giả sử z0 dương cho kiểm định hai đuôi
alpha = 0.05  # Mức ý nghĩa
p1 = 0.1901  # Phần trăm mẫu 1
p2 = 0.4296  # Phần trăm mẫu 2

# Tính p-value cho kiểm định
n1 = 142  # Kích thước mẫu 1
n2 = 142  # Kích thước mẫu 2

p = (p1 * n1 + p2 * n2) / (n1 + n2)
standard_error = np.sqrt(p * (1 - p) * (1/n1 + 1/n2))
z_stat = (p1 - p2) / standard_error
p_value = 2 * (1 - norm.cdf(abs(z_stat)))

# Tạo dãy giá trị Z để vẽ đường
z_values = np.linspace(-3, 3, 1000)
pdf_values = norm.pdf(z_values, loc=0, scale=1)  # Phân phối chuẩn

# Vẽ biểu đồ
plt.figure(figsize=(8, 6))
plt.plot(z_values, pdf_values, color='blue', label='Standard Normal Distribution')
plt.fill_between(z_values, pdf_values, where=(z_values > z0), color='gray', alpha=0.5,label='p-value Area')


# Ẩn trục OY
plt.gca().get_yaxis().set_visible(False)

# Tìm giá trị của phân phối tại z0
y_value_at_z0 = norm.pdf(-z0)

# Vẽ đường z0 từ giá trị phân phối đến trục Ox
plt.vlines(z0, 0, y_value_at_z0, color='orange', linestyle='-', label=f'z0 = {z0}')


# Đặt giới hạn mới cho trục Y để kéo đồ thị xuống dưới
plt.ylim(top=max(pdf_values+0.04), bottom=-0)

plt.xlabel('Z')
plt.title('Right-Tailed Test p-value')
plt.legend()
plt.show()
