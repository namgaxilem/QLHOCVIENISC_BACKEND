package vn.team06.qlhocvienisc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;


import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class QlHocVienIscqtApplication {

	@Bean
    public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("5120KB");
        factory.setMaxRequestSize("5120KB");
        return factory.createMultipartConfig();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(QlHocVienIscqtApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<QlHocVienIscqtApplication> applicationClass = QlHocVienIscqtApplication.class;

}
