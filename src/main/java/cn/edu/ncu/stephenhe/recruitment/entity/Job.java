package cn.edu.ncu.stephenhe.recruitment.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * <p>
 * 
 * </p>
 *
 * @author StephenHe
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @Column(name = "hr_id")
    private Integer hrId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "salary")
    private String salary;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "requirement")
    private String requirement;

    @Column(name = "degree")
    private String degree;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "location")
    private String location;

    @Column(name = "update_date")
    private String updateDate;

    @Column(name = "job_state")
    private Integer jobState;
//
//
//    @ManyToOne(targetEntity = Hr.class)
//    private Hr hr;
//
//
//    @ManyToOne(targetEntity = Company.class)
//    private Company company;

//    private String hrName;
//
//    private String companyName;



}
