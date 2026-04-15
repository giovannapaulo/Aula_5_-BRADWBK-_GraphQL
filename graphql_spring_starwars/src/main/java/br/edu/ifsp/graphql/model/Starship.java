package br.edu.ifsp.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Starship {
    private String id;   
    private String name;
    private Float length; 
}