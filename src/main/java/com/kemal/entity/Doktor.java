package com.kemal.entity;

import com.kemal.utility.enums.Brans;
import com.kemal.utility.enums.Musaitlik;
import com.kemal.utility.enums.Unvan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_doktor")
public class Doktor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    Brans brans =Brans.CILDIYE;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    Unvan unvan= Unvan.OPERATOR;

}
