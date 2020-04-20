package com.kimfri.notemanager

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    //The init block will ALWAYS run when an instance of DataManager is instantiated
    init {
        initializeCourses()
        initilizeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course) //This is what is said in the course
//        courses[course.courseId] = course  //this is the way Android studio wants it to be

        course = CourseInfo("android_async", "Android Async Programming and Services")
        courses[course.courseId] = course

        course = CourseInfo(title = "Java Fundamentals: The Java Language", courseId = "java_lang")
        courses[course.courseId] = course

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses[course.courseId] = course
    }

    private fun initilizeNotes() {
//        val note = NoteInfo(course = courseId, title = "some title", text = "some text")
        val title = "Tile - "
        val text = "Text - "
        courses.map {
            var counter = 0
            var note =  NoteInfo(it.value, "$title $counter", "$text $counter")
            notes.add(note)
            counter++
            note =  NoteInfo(it.value, "$title $counter", "$text $counter")
            notes.add(note)
        }
    }
}