package org.launchcode.techjobs.oo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Dental Hygienist", new Employer("Wildwood Dentistry"), new Location("St. Louis, MO"), new PositionType("Full Time"), new CoreCompetency("Nice Smile"));
        Job job3 = new Job("Pre-School Teacher", new Employer("Little Sunshine's Playhouse"), new Location("Chesterfield, MO"), new PositionType("Part Time"), new CoreCompetency("Patience"));

        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);

        for (Job job : jobs){
            System.out.println(job);
        }

        System.out.println(job1.hashCode());
        System.out.println(job2.hashCode());
        System.out.println(job3.hashCode());

    }

}