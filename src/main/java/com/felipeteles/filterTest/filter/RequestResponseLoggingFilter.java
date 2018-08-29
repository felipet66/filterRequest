package com.felipeteles.filterTest.filter;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.felipeteles.filterTest.domain.Log;
import com.felipeteles.filterTest.repository.LogRepository;

@Component
@Order(2)
public class RequestResponseLoggingFilter implements Filter {

	private final static Logger LOG = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);
	
	@Autowired
	private LogRepository repo;

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		LOG.info("Initializing filter RequestResponseLoggingFilter:{}", this);
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		LOG.info("Logging Request: ", req.getMethod(), req.getRequestURI());
		chain.doFilter(request, response);
		LocalDate date = LocalDate.now();
		Log log = new Log(null, res.getContentType(), ""+res.getHeaderNames(), date+"");
		repo.save(log);
		LOG.info("Logging Response: ", res.getContentType() + " Headers: " +res.getHeaderNames());
	}

	@Override
	public void destroy() {
		LOG.warn("Destructing filter: ", this);
	}
}