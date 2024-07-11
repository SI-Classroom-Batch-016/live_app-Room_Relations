//
//data class UserWithBooks(
//    @Embedded val user: User,
//    @Relation(
//        parentColumn = "userId",
//        entityColumn = "userId"
//    )
//    val books: List<Book>
//)





//@Entity(primaryKeys = ["studentId", "courseId"])
//data class StudentCourseCrossRef(
//    val studentId: Int,
//    val courseId: Int
//)

//data class StudentWithCourses(
//    @Embedded val student: Student,
//    @Relation(
//        parentColumn = "studentId",
//        entityColumn = "courseId",
//        associateBy = Junction(StudentCourseCrossRef::class)
//    )
//    val courses: List<Course>
//)

