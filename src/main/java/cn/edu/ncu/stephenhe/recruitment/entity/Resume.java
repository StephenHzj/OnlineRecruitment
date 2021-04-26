package cn.edu.ncu.stephenhe.recruitment.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

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
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer resumeId;

    @Column(name = "user_id")
    @NotNull
    private Integer userId;

    @Column(name = "real_name")
    @NotNull
    private String realName;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "university")
    private String university;

    @Column(name = "major")
    private String major;

    @Column(name = "degree")
    private String degree;

    @Column(name = "introduction")
    private String introduction;

    @Column(name = "speciality")
    private String speciality;

    @Column(name = "experience")
    private String experience;

    @Column(name = "target")
    private String target;

    @Column(name = "hope_salary")
    private String hopeSalary;

    @Column(name = "work_area")
    private String workArea;


}
