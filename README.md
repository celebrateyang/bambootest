# bambootest
一个干净的xml版 springmvc+springsecurity项目
DefaultLoginPageGeneratingFilter
FilterSecurityInterceptor
怎么加载过滤器链?
DelegatingFilterProxy->initDelegate 注入全局的ApplicationContext,通过它取得springSecurityFilterChain, 
FilterChainProxy->doFilterInternal方法中的filters中看到当前的过滤器链
实现类 DefaultSecurityFilterChain 封装了过滤器链
BasicAuthenticationFilter 身份校验 