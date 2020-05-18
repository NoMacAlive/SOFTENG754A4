import java.util.*;

public class Course {
	private Database db;
	private int id;

    public Course(){

    }

	public Course(Database db) {
		this.db = db;
	}

	public Course(Database db, int course_id) {
		this.db = db;
    	this.id = course_id;
    }

    public Boolean isValidForConcession() {
        return true;
    }

	public String getCourseDescription() {
		if (this.id != -1) {
			return this.db.getDescription(this.id);
		} else {
			throw new RuntimeException("Course is not exist");
		}
	}

	public boolean create(String description,int capacity,boolean concession,List<String> compulsory_program,List<String> prerequisite,List<String> timeslots,String location,String status) {
		if (description == null || description.equals("")) {
			throw new RuntimeException("Course description is empty");
		} else if (capacity <= 0) {
			throw new RuntimeException("Course capacity is invalid");
		} else if (timeslots == null || timeslots.size() <= 0) {
			throw new RuntimeException("Course timeslots is empty");
		} else if (location == null || location.equals("")) {
			throw new RuntimeException("Course location is empty");
		} else if (status == null || status.equals("")) {
			throw new RuntimeException("Course status is empty");
		} else {
			return this.db.createCourse(description,capacity,concession,compulsory_program,prerequisite,timeslots,location,status);
		}
	}
}
