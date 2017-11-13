package foundation.filter;


import foundation.exception.GenericException;
import foundation.utils.Counter;
import foundation.utils.CounterType;
import foundation.utils.WebUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DefenceFilter extends OncePerRequestFilter {

	private static final long LIMIT = 10;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		try {
			String ipAdress = WebUtils.getIPAddress(request);
			if (Counter.getCounter(CounterType.IP_ACCESS.name()).get(ipAdress).incrementAndGet() > LIMIT) {
				throw new GenericException(70106L);
			}
		}catch (GenericException e){
			throw e;
		} catch (Exception e){
			throw new GenericException(71001L);
		}

		filterChain.doFilter(request, response);
	}
}
