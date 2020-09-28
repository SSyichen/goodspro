package com.luka.goodspro.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 品牌
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Brank {
    private Long id ;
    private String name;

    private String suPname;
    private String suPdetails;
    private String suPphone;
    private String suPmodel;
    private String suPlocation;
}
