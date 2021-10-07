package com.project.professor.allocation.entity;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class allocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "day", nullable = false)
	private DayOfWeek day;
	
	@Temporal(value = TemporalType.TIME)
	@Column(name = "start", nullable = false)
	private Date start;
	
	@Temporal(value = TemporalType.TIME)
	@Column(name = "end", nullable = false)
	private Date end;
	
	@Column(name = "course_id", nullable = false)
	private Long courseId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", 
	insertable = false, 
	updatable = false, 
	nullable = false)
	private Course course;
	
	@Column(name = "professor_id", nullable = false)
	private Long professorId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "professor_id", 
	insertable = false, 
	updatable = false, 
	nullable = false)
	private professor professor;

	public allocation(Long id, DayOfWeek day, Date start, Date end, Long courseId, Course course, Long profesorId,
			com.project.professor.allocation.entity.professor professor) {
		super();
		this.id = id;
		this.day = day;
		this.start = start;
		this.end = end;
		this.courseId = courseId;
		this.course = course;
		this.professorId = profesorId;
		this.professor = professor;
	}

	public allocation() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getProfesorId() {
		return professorId;
	}

	public void setProfesorId(Long profesorId) {
		this.professorId = profesorId;
	}

	public professor getProfessor() {
		return professor;
	}

	public void setProfessor(professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "allocation [id=" + id + ", day=" + day + ", start=" + start + ", end=" + end + ", courseId=" + courseId
				+ ", course=" + course + ", profesorId=" + professorId + ", professor=" + professor + "]";
	}


}
