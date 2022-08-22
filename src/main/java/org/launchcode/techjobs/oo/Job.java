package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType,
               CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }


    @Override
    public String toString()
    {
        String noJobMsg = "OOPS! This job does not seem to exist.";

        StringBuilder jobInfo = new StringBuilder( "\nID: " + getId() + "\n" );
        jobInfo.append( "Name: " );
        jobInfo.append( getName() == null || getName().length() == 0 ?
                "Data not available\n" : getName() + "\n" );

        jobInfo.append( "Employer: " );
        jobInfo.append( getEmployer() == null || getEmployer().getValue() == null || getEmployer().getValue().trim().length() == 0 ?
                "Data not available\n" : getEmployer().getValue() + "\n" );

        jobInfo.append( "Location: " );
        jobInfo.append( getLocation() == null || getLocation().getValue() == null || getLocation().getValue().trim().length() == 0 ?
                "Data not available\n" : getLocation().getValue() + "\n" );

        jobInfo.append( "Position Type: " );
        jobInfo.append( getPositionType() == null || getPositionType().getValue() == null || getPositionType().getValue().trim().length() == 0 ?
                "Data not available\n" : getPositionType().getValue() + "\n" );

        jobInfo.append( "Core Competency: " );
        jobInfo.append( getCoreCompetency() == null || getCoreCompetency().getValue() == null || getCoreCompetency().getValue().trim().length() == 0 ?
                "Data not available\n" : getCoreCompetency().getValue() + "\n" );

        String[] availCount = jobInfo.toString().split( "Data not available" );
        if ( availCount.length == 6 )
        {
            return noJobMsg;
        }

        return jobInfo.toString();
    }
}





