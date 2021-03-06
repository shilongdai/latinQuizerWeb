package net.viperfish.latinQuiz;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Order(3)
public class AdditionalFilterBootStrap implements WebApplicationInitializer {

	public AdditionalFilterBootStrap() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onStartup(ServletContext servletContext) {

		FilterRegistration.Dynamic method = servletContext
				.addFilter("hiddenMethod", new HiddenHttpMethodFilter());
		method.addMappingForUrlPatterns(null, false, "/latinQuizer/*");
	}

}
