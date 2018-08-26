package x3.benjamin.playground.apiserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Configuration
//TODO 02- Stereotype annotation 으로 선언된 클래스를 component-scan 해서 ApplicationContext 에 bean 으로 등록한다.
//TODO 02- Stereotype annotationで宣言されたクラスをcomponent-scanしてApplicationContextにbeanに登録する。
@ComponentScan(basePackages = {"x3.benjamin.playground.apiserver.repository"})
public class RootApplicationContextConfig {
}
