package aa.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {

    @Getter
    @Setter
    @Value("${com.aa.blog.name}")
    private String name;

    @Getter
    @Setter
    @Value("${com.aa.blog.title}")
    private String title;
}
