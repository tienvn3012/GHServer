package vn.com.nct.config;



import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServerletConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	

}
