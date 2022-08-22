package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void emptyTest(){
        assertEquals(10,10,.001);
    }

    @Test
    public void testSettingJobId(){
        Job job1= new Job();
        Job job2= new Job();
        assertNotEquals(job1.getId(),job2.getId(),.001);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3= new Job("Product tester",new Employer("ACME"),new Location("Desert"),
                new PositionType("Quality control"),new CoreCompetency("Persistence"));


        assertTrue(job3.getName() != null);
        assertTrue(job3.getEmployer() != null);
        assertTrue(job3.getLocation() != null);
        assertTrue(job3.getPositionType() != null);
        assertTrue(job3.getCoreCompetency() != null);

        assertEquals("Product tester",job3.getName());
        assertEquals("ACME",job3.getEmployer().getValue());
        assertEquals("Desert",job3.getLocation().getValue());
        assertEquals("Quality control",job3.getPositionType().getValue());
        assertEquals("Persistence",job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Software Engineer", new Employer("Comcast"), new Location("Philadelphia"),
                new PositionType("Engineer 1"), new CoreCompetency("Teamwork"));
        Job job5 = new Job("Software Engineer", new Employer("Comcast"), new Location("Philadelphia"),
                new PositionType("Engineer 1"), new CoreCompetency("Teamwork"));
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job6=new Job("Software Engineer", new Employer("Comcast"), new Location("Philadelphia"),
                new PositionType("Engineer 1"), new CoreCompetency("Teamwork"));
        String returnString=job6.toString();
        assertEquals('\n',returnString.charAt(0));
        assertEquals('\n',returnString.charAt(returnString.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job7=new Job("Software Engineer", new Employer("Comcast"), new Location("Philadelphia"),
                new PositionType("Engineer 1"), new CoreCompetency("Teamwork"));
        String job7String=("\nID: "+job7.getId()+"\nName: "+job7.getName()+"\nEmployer: "+job7.getEmployer()+
                "\nLocation: "+job7.getLocation()+"\nPosition Type: "+job7.getPositionType()+
                "\nCore Competency: "+job7.getCoreCompetency()+"\n");
        assertEquals(job7String,job7.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job8=new Job("", new Employer("Comcast"), new Location(""),
                new PositionType(""), new CoreCompetency("Teamwork"));
        String job8String=("\nID: "+job8.getId()+"\nName: "+"Data not available"+"\nEmployer: "+job8.getEmployer()+
                "\nLocation: "+"Data not available"+"\nPosition Type: "+"Data not available"+
                "\nCore Competency: "+job8.getCoreCompetency()+"\n");
        assertEquals(job8String,job8.toString());
    }
}