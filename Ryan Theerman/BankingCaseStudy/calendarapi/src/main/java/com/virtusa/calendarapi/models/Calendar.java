package com.virtusa.calendarapi.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Calendar")
@AllArgsConstructor
@NoArgsConstructor
public class Calendar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name = "Holiday_Id")
    private long holidayId;
    @Column(name="Event")
    private String event;
    @Column(name="Category",nullable = false)
    private String category;
    @Column(name="Date_Holiday",nullable = false)
    private String dateHoliday;

    // FK from currency?
    @Column(name="Country_Code")
    private String countryCode;

    public Calendar(String event,
                    String category,
                    String dateHoliday,
                    String countryCode) {
        this.event = event;
        this.category = category;
        this.dateHoliday = dateHoliday;
        this.countryCode = countryCode;
    }
}
