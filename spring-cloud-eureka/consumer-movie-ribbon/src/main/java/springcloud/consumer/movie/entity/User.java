package springcloud.consumer.movie.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 9142842922900800637L;
    private Long id;
    private String name;
    private String userName;
    private Integer age;
    private String balance;
}
