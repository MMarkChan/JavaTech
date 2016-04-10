package sqlmapperusingxml.mappers;

import getstarted.installandconfigure.model.Tutor;

public interface TutorMapper{
    Tutor findTutorById(int tutorId);
}