package com.example.msppj.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "package")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Package extends BaseEntity{

    private String name;
    private String detail;
}
