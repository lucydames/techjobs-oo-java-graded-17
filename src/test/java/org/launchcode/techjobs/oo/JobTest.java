package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

import static org.junitAssert.assertFalse;
import static org.junitAssert.assertTrue;
import static org.junitAssert.assertEquals;
import static org.junitAssert.assertNotEquals;

public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Developer", new Employer("TechCorp"), new Location("Remote"),
                new PositionType("Full Stack"), new CoreCompetency("Java"));
        Job job2 = new Job("Developer", new Employer("TechCorp"), new Location("Remote"),
                new PositionType("Full Stack"), new CoreCompetency("Java"));

        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        String jobToString = job.toString();
        assertTrue(jobToString.startsWith(System.lineSeparator()));
        assertTrue(jobToString.endsWith(System.lineSeparator()));
    }
    public void testToStringContainsCorrectLabelsAndData() {
        String expectedString = "ID: 1\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n";
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(expectedString, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String expectedString = "ID: 1\nName: Product tester\nEmployer: Data not available\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n";
        Job job = new Job("Product tester", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(expectedString, job.toString());
    }
}

