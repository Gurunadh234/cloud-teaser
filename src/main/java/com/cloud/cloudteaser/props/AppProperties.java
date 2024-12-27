package com.cloud.cloudteaser.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class AppProperties {
    @Value("${default.questionCount}")
    private int questionCount;
}
