package fr.mouktar_hassan.jee.ProjetEJB;

import static org.junit.Assert.assertNotNull;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

}