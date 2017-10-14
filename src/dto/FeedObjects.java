package dto;

public class FeedObjects {
	
	private String firstname;
	private String lastname;
	private String url;
	private String hours;
	private String proffesion;
	private String group_id;
	private String id;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return firstname;
	}
	/**
	 * @param firstname the title to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the description
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the description to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the url
	 */
	public String getHours() {
		return hours;
	}
	/**
	 * @param hours the url to set
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}

    public String getProffesion() { return proffesion;  }

    public void setProffesion(String proffesion) {
	    this.proffesion = proffesion;
    }


    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
