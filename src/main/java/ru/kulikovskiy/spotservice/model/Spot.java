package ru.kulikovskiy.spotservice.model;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "tb_spot")
public class Spot {
    /*    @Id
        @SequenceGenerator(name = "tb_spot_id_gen")
        private String id;

     */
    private String ccypair;


}
