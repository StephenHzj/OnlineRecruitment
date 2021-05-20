package cn.edu.ncu.stephenhe.recruitment.entity;


import io.swagger.annotations.ApiModel;
import lombok.Cleanup;
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
@Table(name = "application")
public class Application{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer applicationId;

    @Column(name = "job_id")
    @NotNull
    private Integer jobId;

    @Column(name = "resume_id")
    @NotNull
    private Integer resumeId;

    @Column(name = "user_id")
    @NotNull
    private Integer userId;

    @Column(name = "deal_hr_id")
    @NotNull
    private Integer dealHrId;

    @Column(name = "application_date")
    private String applicationDate;

    @Column(name = "application_state")
    private Integer applicationState;

}
