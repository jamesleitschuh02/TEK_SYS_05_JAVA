package com.springboot.workspace;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TaskServiceTests.class, NoteServiceTests.class, CommentServiceTests.class, EventServiceTests.class, PostServiceTests.class, UserServiceTests.class})
public class ServiceTestSuite {

}
