/*
* (C) Copyright 2019
* @Author BamBu_Vn
* @Date Nov 10, 2019
* @Version 1.0
*/
package teacherweb.com.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {

    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        //List<String> mappingFiles = Arrays.asList("dozer-configration-mapping.xml");

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        //dozerBean.setMappingFiles(mappingFiles);
        return dozerBean;
    }
}
