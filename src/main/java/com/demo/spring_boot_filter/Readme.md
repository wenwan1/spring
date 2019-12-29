
 * WebFilter类相当于该文件下的另两个类，只不过该类需要和 @ServletComponentScan注解一块用，
 见Application类
 * 通过运行我们可以发现，利用@WebFilter注解方法建立的过滤器相比于第一种方法
 初始化init方法和执行doFilter方法以及销毁方法都要晚些。
 