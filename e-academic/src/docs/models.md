classDiagram
    People <|-- Student
    People <|-- Teacher
    People : -Date birth
    People : -String name
    People : -String user
    People : -String pass
    People : -String ra
    People : -String cpf
    People: +getBirth()
    People: +getName()
    People: +getUser()
    People: +getPass()
    People: +getRa()
    People: +getCpf()
    People: +setBirth(Date birth)
    People: +setName(String name)
    People: +setUser(String user)
    People: +setPass(String pass)
    People: +setRa(String ra)
    People: +setCpf(String cpf)
    class Student{
      -String course
      -String period
      -List<Subject> subjects
      +getCourse()
      +getPeriod()
      +getSubjects()
      +setCourse(String course)
      +setPeriod(String period)
      +setSubjects(List<Subject> subjects)
    }
    class Teacher{
      -List<String> courses
      -String period
      -List<Subject> subjects
      +getCourse()
      +getPeriod()
      +getSubjects()
      +setCourse(String course)
      +setPeriod(String period)
      +setSubjects(List<Subject> subjects)
    }
    class Subject{
      -String name;
      -List<Course> courses;
      -String description;
      +getName()
      +getCourses()
      +getDescription()
      +setName(String name)
      +setCourses(List<Course> courses)
      +setDescription(String description) 
    }
    class Course{
      -String name;
      -List<Subject> subjects;
      -String description;
      +getName()
      +getSubjects()
      +getDescription()
      +setName(String name)
      +setSubjects(List<Subject> subjects)
      +setDescription(String description) 
    }