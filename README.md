# spring-boot-filter-interceptor
## Summary：主要在spring-boot中整合自定义filter和interceptor，并自定义注解实现拦截后的处理逻辑
## 1.在controller方法上添加了自定义了注解，用拦截器剥离出带注解的请求方法，判断方法是否在检查范围内，并作出相应处理
## 2.filter只在请求和响应头做了一些属性的修改，未实现其他逻辑
