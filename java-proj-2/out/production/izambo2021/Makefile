JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java \
	Class.java \
	Corridor.java \
	Floor.java \
	SchoolBuilding.java \
	Stair.java \
	Student.java \
	Teacher.java \
	Room.java \
	Person.java \
	JuniorClass.java \
	JuniorStudent.java \
	SeniorClass.java \
	SeniorStudent.java \
	Yard.java \


default: classes

classes: $(CLASSES:.java=.class)