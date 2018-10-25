package x3.benjamin.playground.apiserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Configuration
@ComponentScan(basePackages = {
        "x3.benjamin.playground.apiserver.repository",
        "" //TODO - 05 - Bean 클래스를 작성했으니 적절하게 ComponentScan 의 값을 바꾸면 됩니다.
        	// TODO - 05 - Beanクラスを作成したので、適切なComponentScanの値を変更するとします。

})
public class RootApplicationContextConfig {
}
