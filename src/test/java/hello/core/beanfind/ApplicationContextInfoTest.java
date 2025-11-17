package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {


    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 출력하기")
    // 해당 메서드는 등록한 bean 외에도 내부 라이브러리에서 등록된 bean 등이 보인다.
    void findAllbean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // iter 치고 tap 하면 자동으로 for문이 완성된다.
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            // sout 치고 enter 하면 자동 println문 완성
            System.out.println("bean = " + beanDefinitionName + " object = " + bean);

        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // iter 치고 tap 하면 자동으로 for문이 완성된다.
        for (String beanDefinitionName : beanDefinitionNames) {
            // getBeanDefinition() -> Bean에 대한 메타 정보,
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            // getRole() -> 내가 애플리케이션을 만들기 위해 등록한 Bean 혹은 외부 라이브러리


            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION ) {
                Object bean = ac.getBean(beanDefinitionName);
                // sout 치고 enter 하면 자동 println문 완성
                System.out.println("bean = " + beanDefinitionName + " object = " + bean);
            }
        }

    }
}
