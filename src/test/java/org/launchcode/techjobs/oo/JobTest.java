package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    // Test 1: if IDs are not equal
    @Test
    public void testSettingJobId(){
        Job job1 = new Job("Software Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Part Time"), new CoreCompetency("Energetic"));
        Job job2 = new Job("Slay Queen", new Employer("Mother Earth"), new Location("Remote"), new PositionType("Full Time"), new CoreCompetency("Slay Attitude"));
        assertNotEquals(job1.getId(), job2.getId());
    }

    // Test 2: job values assigned
    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }

    /* Test 3: Test the equals method that compares IDs, which should be different
    despite the Job class having all the same fields otherwise */
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    // Test 4: line spacing
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job1 = new Job("Funeral director", new Employer("Tabscott and Co."), new Location("Brookline, MA"), new PositionType("Experience Required"), new CoreCompetency("Positivity"));
        assertEquals(System.lineSeparator(), job1.toString().substring(0,1));
        assertEquals(System.lineSeparator(), job1.toString().substring(job1.toString().length() - 1));
    }

    // Test 5: correct labels and data
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job1 = new Job("Funeral Director", new Employer("Tabscott and Co."), new Location("Brookline, MA"), new PositionType("Experience Required"), new CoreCompetency("Positivity"));

        String idLabel = "ID";
        String nameLabel = "Name:";
        String employerLabel = "Employer:";
        String locationLabel = "Location";
        String positionTypeLabel = "Position Type:";
        String coreCompetencyLabel = "Core Competency:";


        int idValue = job1.getId();
        String nameValue = "Funeral Director";
        String employerValue = "Tabscott and Co.";
        String locationValue = "Brookline, MA";
        String positionTypeValue = "Experience Required";
        String coreCompetencyValue = "Positivity";

        // testing
        assertTrue(job1.toString().contains(idLabel));
        assertTrue(job1.toString().contains(String.valueOf(idValue)));
        assertTrue(job1.toString().contains(nameLabel));
        assertTrue(job1.toString().contains(nameValue));
        assertTrue(job1.toString().contains(employerLabel));
        assertTrue(job1.toString().contains(employerValue));
        assertTrue(job1.toString().contains(locationLabel));
        assertTrue(job1.toString().contains(locationValue));
        assertTrue(job1.toString().contains(positionTypeLabel));
        assertTrue(job1.toString().contains(positionTypeValue));
        assertTrue(job1.toString().contains(coreCompetencyLabel));
        assertTrue(job1.toString().contains(coreCompetencyValue));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("Funeral Director", new Employer("Brookline, MA"), new Location(null), new PositionType("Entry Level"), new CoreCompetency("Flexibility"));
        Job job2 = new Job("Funeral Director", new Employer("Brookline, MA"), new Location(""), new PositionType("Entry Level"), new CoreCompetency("Flexibility"));
        String message = "Data not available";
        assertTrue(job1.toString().contains(message));
        assertTrue(job2.toString().contains(message));
    }
}