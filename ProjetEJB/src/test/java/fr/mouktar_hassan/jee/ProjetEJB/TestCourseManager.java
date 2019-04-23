package fr.mouktar_hassan.jee.ProjetEJB;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import monapp.Course;
import monapp.CourseManager;

public class TestCourseManager {

    @EJB
    CourseManager cm;

    @Before
    public void setUp() throws Exception {
        EJBContainer.createEJBContainer().getContext().bind("inject", this);
    }

    @After
    public void tearDown() throws Exception {
        EJBContainer.createEJBContainer().close();
    }

    @Test
    public void testFindCourses() {
        assertNotNull(cm.findCourses());
    }
    
    @Test
    public void testSaveCourses() {
         Course course=new Course();
         course.setName("Java EE");
         course.setDescription("Programmation distribué");
         course.setLevel("6");
         course.setHours(6);
         cm.saveCourse(course);
         
         assertNotNull(cm);
    }
    
    @Ignore
    @Test
    public void testFindCourse() {
    	Course course=new Course();
        course.setName("Java EE");
        course.setDescription("Programmation distribué");
        course.setLevel("6");
        course.setHours(6);
        cm.saveCourse(course);
        
        List<Course> courses=(List<Course>) cm.findCourse((long)1);
        Assert.assertEquals(1,courses.size());        
    	
    }
    
    @Test
    public void testDeleteCourse() {
    	Course course=new Course();
        course.setName("Cloud computing");
        course.setDescription("Virtualisation par les services AWS");
        course.setLevel("2");
        course.setHours(10);
        cm.saveCourse(course);
        long id=course.getId();
        cm.deleteCourse(course);
        Assert.assertNull(cm.findCourse(id));
        
    }

}