package com.kraft.event.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "term_and_condition")
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class TermAndCondition extends BaseEntity {

    private String name;
    private String fileName;
    private boolean enable;
}
