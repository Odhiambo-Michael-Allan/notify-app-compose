package com.odesa.notify_app_compose.data

import com.odesa.notify_app_compose.data.model.Note
import java.util.UUID

object LocalNotesProvider {

    val allNotes = listOf(
        Note(
            id = 1L,
            title = "From these requirements, three use cases are derived-Checkout Document",
            description = "The LIS has many other\n" +
                    "requirements and use cases besides these. A mechanism to partition a large set of\n" +
                    "use cases is needed. Use case diagrams are useful for organizing the use cases into\n" +
                    "subsystems so that each subsystem can be dealt with separately"
        ),
        Note(
            id = 2L,
            title = "Requirements change is common for many soft,vare projects.",
            description = "Change to requirements leads to change\n" +
                    "to use cases as well as to the plan to develop and deploy the use cases."
        ),
        Note(
            id = 3L,
            title = "After making\n" +
                    "these changes, the development continues with the following steps according to the\n" +
                    "changed iteration schedule",
            description = "Domain modeling is a process to discover important domain concepts. For example,\n" +
                    "important domain concepts of a library system include user, patron, phone num-\n" +
                    "ber, document, book, periodical, checkout date, checkout duration, due date, loan,\n" +
                    "librarian, and many others"
        ),
        Note(
            id = 4L,
            title = "Conduct Domain Modeling",
            description = "The domain concepts are classified into classes, attributes of the classes and\n" +
                    "relationships among the classes."
        ),
        Note(
            id = 5L,
            title = "The patron enters the call number\n" +
                    "of a document to be checked out and\n" +
                    "clicks the ' Submit· bunon.",
            description = "Actor-system interaction modeling does not specify the computation or algorithms\n" +
                    "that process the user requests."
        ),
        Note(
            id = 6L,
            title = "Perform Behavioral Modeling",
            description = "This involves background processing performed by the soft\\vare objects.\n" +
                    "Behavioral modeling describes how the objects interact with each other to process the\n" +
                    "request."
        ),
        Note(
            id = 7L,
            title = "Behavioral modeling and design produce sequence diagrams, state diagrams, and\n" +
                    "activity diagrams",
            description = "It is not convenient to implement the classes from these\n" +
                    "diagrams because a class may appear in several diagrams. For example, the Document\n" +
                    "class appears in the Checkout Document and Return Document sequence diagrams."
        ),
        Note(
            id = 8L,
            title = "The soft,vare team wants an integrated view of the design.",
            description = "The dashed arrow lines in the design class diagram represent uses or\n" +
                    "dependence relationships between the classes."
        ),
        Note(
            id = 9L,
            title = "Implementation, Integration Testing, and Deployment",
            description = "During test-driven development (TDD}, the classes that implement the use cases of\n" +
                    "the current iteration are implemented and tested."
        ),
        Note(
            id = 10L,
            title = "The classes are integrated and tested\n" +
                    "to ensure that they work with each other.",
            description = "Finally, the software system that implements\n" +
                    "the use cases of the current iteration is installed and tested in the target environment."
        )
    )
}