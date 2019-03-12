package com.myapp.food.delivery.orderservice.web;



import org.springframework.stereotype.Component;

@Component
//@Order(TraceWebServletAutoConfiguration.TRACING_FILTER_ORDER + 1)
class TraceIdResponseFilter /*extends GenericFilterBean*/ {

//  private final Tracer tracer;
//
//  public TraceIdResponseFilter(Tracer tracer) {
//    this.tracer = tracer;
//  }

//  @Override public void doFilter(ServletRequest request, ServletResponse response,
//                                 FilterChain chain) throws IOException, ServletException {
//    Span currentSpan = this.tracer.currentSpan();
//    if (currentSpan != null) {
//      ((HttpServletResponse) response)
//              .addHeader("ZIPKIN-TRACE-ID",
//                      currentSpan.context().traceIdString());
//    }
//    chain.doFilter(request, response);
//  }
}