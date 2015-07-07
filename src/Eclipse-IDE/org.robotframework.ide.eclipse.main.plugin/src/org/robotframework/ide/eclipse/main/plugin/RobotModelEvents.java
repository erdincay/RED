package org.robotframework.ide.eclipse.main.plugin;


public class RobotModelEvents {

    public static final String ROBOT_SUITE_FILE_ALL = "robot/model/editor/file/structural/*";

    public static final String ROBOT_SUITE_STRUCTURAL_SECTION_ALL = "robot/model/editor/file/structural/section/*";

    public static final String ROBOT_SUITE_SECTION_ADDED = "robot/model/editor/file/structural/section/added";

    public static final String ROBOT_SUITE_SECTION_REMOVED = "robot/model/editor/file/structural/section/removed";


    public static final String ROBOT_VARIABLE_STRUCTURAL_ALL = "robot/model/editor/file/structural/variable/*";

    public static final String ROBOT_VARIABLE_ADDED = "robot/model/editor/file/structural/variable/added";

    public static final String ROBOT_VARIABLE_REMOVED = "robot/model/editor/file/structural/variable/removed";

    public static final String ROBOT_VARIABLE_MOVED = "robot/model/editor/file/structural/variable/moved";

    public static final String ROBOT_VARIABLES_SORTED = "robot/model/editor/file/structural/variable/sorted";


    public static final String ROBOT_VARIABLE_DETAIL_CHANGE_ALL = "robot/model/editor/file/detail/variable/changed/*";

    public static final String ROBOT_VARIABLE_TYPE_CHANGE = "robot/model/editor/file/detail/variable/changed/type";

    public static final String ROBOT_VARIABLE_NAME_CHANGE = "robot/model/editor/file/detail/variable/changed/name";

    public static final String ROBOT_VARIABLE_VALUE_CHANGE = "robot/model/editor/file/detail/variable/changed/value";

    public static final String ROBOT_VARIABLE_COMMENT_CHANGE = "robot/model/editor/file/detail/variable/changed/comment";
    
    
    public static final String ROBOT_VARIABLE_COLLECTION_ELEMENT_MOVE_UP = "robot/model/editor/file/structural/variable/collection/move/up";
    
    public static final String ROBOT_VARIABLE_COLLECTION_ELEMENT_MOVE_DOWN = "robot/model/editor/file/structural/variable/collection/move/down";
    
    public static final String ROBOT_VARIABLE_COLLECTION_ELEMENT_INSERT = "robot/model/editor/file/structural/variable/collection/insert";
    
    public static final String ROBOT_VARIABLE_COLLECTION_ELEMENT_DELETE= "robot/model/editor/file/structural/variable/collection/delete";

    
    public static final String ROBOT_SETTINGS_STRUCTURAL_ALL = "robot/model/editor/file/structural/setting/*";

    public static final String ROBOT_SETTING_ADDED = "robot/model/editor/file/structural/setting/added";

    public static final String ROBOT_SETTING_REMOVED = "robot/model/editor/file/structural/setting/removed";


    public static final String ROBOT_KEYWORD_DEFINITION_STRUCTURAL_ALL = "robot/model/editor/file/structural/keyword/*";

    public static final String ROBOT_KEYWORD_DEFINITION_ADDED = "robot/model/editor/file/structural/keyword/added";

    public static final String ROBOT_KEYWORD_DEFINITION_REMOVED = "robot/model/editor/file/structural/keyword/removed";

    public static final String ROBOT_KEYWORD_DEFINITION_MOVED = "robot/model/editor/file/structural/keyword/moved";


    public static final String ROBOT_KEYWORD_DEFINITION_CHANGE_ALL = "robot/model/editor/file/detail/userkeyword/changed/*";

    public static final String ROBOT_KEYWORD_DEFINITION_NAME_CHANGE = "robot/model/editor/file/detail/userkeyword/changed/name";

    public static final String ROBOT_KEYWORD_DEFINITION_ARGUMENT_CHANGE = "robot/model/editor/file/detail/userkeyword/changed/argument";

    public static final String ROBOT_KEYWORD_DEFINITION_COMMENT_CHANGE = "robot/model/editor/file/detail/userkeyword/changed/comment";


    public static final String ROBOT_CASE_STRUCTURAL_ALL = "robot/model/editor/file/structural/cases/*";
    
    public static final String ROBOT_CASE_ADDED = "robot/model/editor/file/structural/cases/added";

    public static final String ROBOT_CASE_REMOVED = "robot/model/editor/file/structural/cases/removed";

    public static final String ROBOT_CASE_MOVED = "robot/model/editor/file/structural/cases/moved";


    public static final String ROBOT_CASE_DETAIL_CHANGE_ALL = "robot/model/editor/file/detail/cases/changed/*";

    public static final String ROBOT_CASE_NAME_CHANGE = "robot/model/editor/file/detail/cases/changed/argument";
    

    public static final String ROBOT_KEYWORD_CALL_STRUCTURAL_ALL = "robot/model/editor/file/structural/cases/keywords/*";

    public static final String ROBOT_KEYWORD_CALL_ADDED = "robot/model/editor/file/structural/cases/keywords/added";

    public static final String ROBOT_KEYWORD_CALL_REMOVED = "robot/model/editor/file/structural/cases/keywords/removed";

    public static final String ROBOT_KEYWORD_CALL_MOVED = "robot/model/editor/file/structural/cases/keywords/moved";
    
    
    public static final String ROBOT_KEYWORD_CALL_DETAIL_CHANGE_ALL = "robot/model/editor/file/detail/cases/keywords/changed/*";

    public static final String ROBOT_KEYWORD_CALL_NAME_CHANGE = "robot/model/editor/file/detail/cases/keywords/changed/name";

    public static final String ROBOT_KEYWORD_CALL_ARGUMENT_CHANGE = "robot/model/editor/file/detail/cases/keywords/changed/argument";

    public static final String ROBOT_KEYWORD_CALL_COMMENT_CHANGE = "robot/model/editor/file/detail/cases/keywords/changed/comment";
    

    public static final String EXTERNAL_MODEL_CHANGE = "robot/model/external";

    public static final String SUITE_MODEL_DISPOSED = "robot/model/disposed";

}
